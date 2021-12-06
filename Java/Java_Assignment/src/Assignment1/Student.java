package Assignment1;
import java.time.LocalDate;

public class Student {
	public int id;
	public String email;
	public String userName;
	public String fullName;
	public Gender gender;
	public Department department;
	public Position position;
	public Class[] studyIns;
	public LocalDate createDate;
	
	void takeAnExamination() {
		System.out.println("I am taking Exam: ");
	}
	
	void goToSchool () {
		System.out.println("I am going to school...");
	}
	
}
