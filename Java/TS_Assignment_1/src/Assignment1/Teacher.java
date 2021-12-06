package Assignment1;
import java.time.LocalDate;

public class Teacher {
	public int id;
	public String email;
	public String userName;
	public String fullName;
	public Gender gender;
	public Department department;
	public Class[] inChargeOfs;
	public Exam[] createdExams;
	public LocalDate createDate;
	
	public Teacher() {
	}

	void goToWork() {
		System.out.println("I am going to work....");
	}
	
	void markExam() {
		System.out.println("I am marking Exam: ");
	}
}
