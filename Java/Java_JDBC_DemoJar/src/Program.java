import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) throws SQLException {
		String dbName = "Testing_System_Assignment_1";
		String dbUrl = "jdbc:mysql://localhost:3306/" + dbName;
		
		// credential
		String user = "root";
		String password = "rootpass";
		
		// init the connection
		Connection myConnection = DriverManager.getConnection(dbUrl, user, password);
		
		// usage here
		if (myConnection.isValid(1)) {
			System.err.println("Connected!");
		}
		
		// insert query
		Statement statement = myConnection.createStatement();
//		statement.executeUpdate("INSERT INTO Department (DepartmentName) VALUES ('CTO')");
		String updateQuery = "INSERT INTO Department (DepartmentName) VALUES ( ? )";
		PreparedStatement preparedStatement = myConnection.prepareStatement(updateQuery);
		
		// input from scanner
		System.out.println("Please enter the department name: ");
		Scanner scanner = new Scanner(System.in);
		String departmentName = scanner.nextLine();
		scanner.close();
		
		// put the input into preparedStatement
		preparedStatement.setString(1, departmentName);
		
		// execute and check affected row
		int affectedRow = preparedStatement.executeUpdate();
		System.err.println("Affected row: " + affectedRow);
		
		// check execute
		ResultSet resultSet = statement.executeQuery("SELECT * FROM Testing_System_Assignment_1.Department;");
		while (resultSet.next()) {
			System.out.println(resultSet.getString(2));
		}
		
		// after use, close
		myConnection.close();
		if (myConnection.isClosed()) {
			System.err.println("Connection closed");
		}
		
		System.gc();

}
}

