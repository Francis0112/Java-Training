package src;

public class Teacher {

	private String name;
	private long contact_number;
	private String email;
	private int age;
	private String school;
	private int years_of_service;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public long getContact_number() {
		return contact_number;
	}
	public void setContact_number(long contact_number) {
		this.contact_number=contact_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public int getYears_of_service() {
		return years_of_service;
	}
	public void setYears_of_service(int years_of_service) {
		this.years_of_service = years_of_service;
	}
}
