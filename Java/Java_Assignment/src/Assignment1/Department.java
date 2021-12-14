package Assignment1;

public class Department {
	public byte id;
	public String name;
	public Student[] students;
	public Teacher[] teachers;
	
	@Override
	public String toString() {
		return 	"ID: " + id + "\n" +
					"Name: " + name;
	}
	
	@Override
	public boolean equals(Object obj) {
		Department deparmentX = (Department) obj;
		if(id == deparmentX.id && name.equals(deparmentX.name)) {
			return true;
		} else {
			return false;
		}
	}
	
}
