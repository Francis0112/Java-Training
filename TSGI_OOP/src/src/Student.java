package src;

public class Student {
	
	private String name;
	private long contact_number;
	private String email;
	private int age;
	private String school_attended;
	private String grade_level;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getContact_number() {
		return contact_number;
	}
	public void setContact_number(long contact_number) {
		this.contact_number = contact_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSchool_attended() {
		return school_attended;
	}
	public void setSchool_attended(String school_attended) {
		this.school_attended = school_attended;
	}
	public String getGrade_level() {
		return grade_level;
	}
	public void setGrade_level(String grade_level) {
		this.grade_level = grade_level;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


}
