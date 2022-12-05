package src;

import java.util.Scanner;

public class OOP_training2 {


	public static void main(String[] args) {
		
		print_details();

		

	}
	
	public static void print_details() {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Registration\nPlease choose:\n- Student\n- Teacher\n- Programmer\n");
		int choice = Integer.parseInt(scan.nextLine());
		
		switch (choice) {
		case 1: {
			System.out.println("Choice: Student");
			Student s = new Student();
			
			System.out.println("Enter the following data:");
			System.out.print("Name:");
			String name = scan.nextLine();
			s.setName(name);
			System.out.print("contact number:");
			long contact = Long.parseLong(scan.nextLine());
			s.setContact_number(contact);
			System.out.print("Email:");
			String email = scan.nextLine();
			s.setEmail(email);
			System.out.print("Age:");
			int age = Integer.parseInt(scan.nextLine());
			s.setAge(age);
			System.out.print("School attended:");
			String school = scan.nextLine();
			s.setSchool_attended(school);
			System.out.print("Grade level:");
			String grade = scan.nextLine();
			s.setGrade_level(grade);
			
			System.out.println();
			System.out.println("Processing...\n\nYou have registered the following:\nStudent Name: "+s.getName()+"\nContact number: "+s.getContact_number()+"\nEmail: "+s.getEmail()+"\nAge: "+s.getAge()+"\nSchool attended: "+s.getSchool_attended()+"\nGrade level: "+s.getGrade_level());
			
			break;
		}
		case 2: {
			System.out.println("Choice: Teacher");
			Teacher t = new Teacher();
			
			System.out.println("Enter the following data:");
			System.out.print("Name:");
			String name = scan.nextLine();
			t.setName(name);
			System.out.print("contact number:");
			long contact = Long.parseLong(scan.nextLine());
			t.setContact_number(contact);
			System.out.print("Email:");
			String email = scan.nextLine();
			t.setEmail(email);
			System.out.print("Age:");
			int age = Integer.parseInt(scan.nextLine());
			t.setAge(age);
			System.out.print("School:");
			String school = scan.nextLine();
			t.setSchool(school);
			System.out.print("years of service:");
			int years =Integer.parseInt(scan.nextLine());
			t.setYears_of_service(years);
			
			System.out.println();
			System.out.println("Processing...\n\nYou have registered the following:\nTeacher's Name: "+t.getName()+"\nContact number: "+t.getContact_number()+"\nEmail: "+t.getEmail()+"\nAge: "+t.getAge()+"\nSchool: "+t.getSchool()+"\nYears of Service: "+t.getYears_of_service());
			
			break;
		}
		case 3: {
			System.out.println("Choice: Programmer");
			Programmer p = new Programmer();
			
			System.out.println("Enter the following data:");
			System.out.print("Name:");
			String name = scan.nextLine();
			p.setName(name);
			System.out.print("contact number:");
			long contact = Long.parseLong(scan.nextLine());
			p.setContact_number(contact);
			System.out.print("Email:");
			String email = scan.nextLine();
			p.setEmail(email);
			System.out.print("Age:");
			int age = Integer.parseInt(scan.nextLine());
			p.setAge(age);
			System.out.print("Company:");
			String compay = scan.nextLine();
			p.setCompany(compay);
			System.out.print("Programming Language:");
			String language = scan.nextLine();
			p.setProgramming_language(language);
			
			System.out.println();
			System.out.println("Processing...\n\nYou have registered the following:\nProgrammer's Name: "+p.getName()+"\nContact number: "+p.getContact_number()+"\nEmail: "+p.getEmail()+"\nAge: "+p.getAge()+"\nCompany: "+p.getCompany()+"\nProgramming Language: "+p.getProgramming_language());
			
			break;
		}
		default:
			System.out.println("invalid bro.");
		}
		scan.close();
	}
	
	
}
