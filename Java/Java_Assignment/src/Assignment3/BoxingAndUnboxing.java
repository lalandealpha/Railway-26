package Assignment3;

public class BoxingAndUnboxing {

	public static void main(String[] args) {
		// Question 1:
		System.out.println("-------Question 1-------");
		Integer salary = 5000;
		float salaryFloat =  salary.floatValue();
		System.out.printf("Result: %.2f %n", salary.floatValue());
		System.out.println("");
		
		// Question 2:
		System.out.println("-------Question 2-------");
		String s = "1234567";
		int i = Integer.parseInt(s);
		System.out.println("Result: " + i);
		System.out.println("");
		
		// Question 3:
		System.out.println("-------Question 3-------");
		Integer a = new Integer(1234567);
		int b = a.intValue();
		System.out.println("Result: " + b);
	}

}
