package hello_world;

import java.util.Scanner;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class cat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//hundred();
		//hundred1();
		//addoreven();
		//leap();
		//say();
		//sum();
		geekwatch();
		//times();
		//grains();
	}
	
	
	public static void hundred() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please Enter your name:");
		String name = scan.nextLine();
		for (int i = 0; i < 100; i++) {
			System.out.print(" "+name);
		}
		scan.close();
	}
	
	public static void hundred1() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please Enter your name:");
		String name = scan.nextLine();
		for (int i = 0; i < 100; i++) {
			if (i%8==0) {
				System.out.println("");
			}
			System.out.print(name+" ");
		}
		scan.close();
	}
	
	public static void addoreven() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please Enter a number:");
		String b = scan.nextLine();
		int x = Integer.parseInt(b);
		if (x%2==0) {
			System.out.println("even");
		} else {
			System.out.println("odd");
		}
		scan.close();

	}
	
	public static void leap() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a year: ");
		int year = scan.nextInt();
		if (year%4==0) {
			System.out.println("leap year");
		}
		else if(year%100==0) {
			System.out.println("leap year");
		}
		else if(year%400==0) {
			System.out.println("leap year");

		}
		else {
			System.out.println("not a leap year.");
		}
		scan.close();
	}
	
	public static void say() {

		Scanner scan = new Scanner(System.in);
		String num[] = {
				"zero","one","two","three","four","five","six","seven","eight","nine","ten",
				"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eigthteen","nineteen","twenty",
				"twenty-one","twenty-two","twenty-three","twenty-four","twenty-five","twenty-six","twenty-seven","twenty-eigtht","twenty-nine","thirthy",
				"thirthy-one","thirthy-two","thirthy-three","thirthy-four","thirthy-five","thirthy-six","thirthy-seven","thirthy-eight","thirthy-nine","fourthy",
				"thirthy-one","thirthy-two","thirthy-three","thirthy-four","thirthy-five","thirthy-six","thirthy-seven","thirthy-eight","thirthy-nine","fifthy",
				"thirthy-one","thirthy-two","thirthy-three","thirthy-four","thirthy-five","thirthy-six","thirthy-seven","thirthy-eight","thirthy-nine","sixthy",
				"thirthy-one","thirthy-two","thirthy-three","thirthy-four","thirthy-five","thirthy-six","thirthy-seven","thirthy-eight","thirthy-nine","seventhy",
				"seventhy-one","seventhy-two","seventhy-three","seventhy-four","seventhy-five","seventhy-six","seventhy-seven","seventhy-eight","seventhy-nine","eigthy",
				"eigthy-one","eigthy-two","eigthy-three","eigthy-four","eigthy-five","eigthy-six","eigthy-seven","eigthy-eight","eigthy-nine","ninethy",
				"ninethy-one","ninethy-two","ninethy-three","ninethy-four","ninethy-five","ninethy-six","ninethy-seven","ninethy-eight","ninethy-nine",
		};
		System.out.println("Please Enter a number:");
		int a = scan.nextInt();
		try {
			System.out.println(num[a]);
		} catch (Exception e) {
			System.out.println("values out of range");
		}
		scan.close();
	}
	
	public static void times() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Type: 'Times' to see the table.");
		String a = scan.nextLine();
		if (a.equals("Times")) {
			for (int y = 0; y < 10; ++y) {
			      for (int x = 0; x < 10; ++x) {
			        System.out.printf("%4d", y*x);
			      }
			      System.out.println();
			    }
		}
		else
		{
			System.out.println("Error. please type: 'Times' again.");
		}
		scan.close();
	}
	
	static String leftText(String s, int a) {
		while (s.length() < a) {
			s += " ";
			
		}
		return s;
	}
	
	public static void grains() {
		long a = 1;
		for (int i = 1; i < 64; i++) {
			System.out.println("Square "+i+" : "+a+" grains");
			a*=2;
		}
	}
	
	public static void sum() {

		double sum = 0;
		for (int i = 1; i <=1000; i++) {
			sum+=0.1;
		}
		System.out.println(sum);
		if (sum!=100) {
			
			System.out.println("not equal to 100");
		}
		else {
			System.out.println("equal to 100");
		}
	}
	
	public static void geekwatch() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please Enter code here:");
		int a = scan.nextInt();
		
		Date date = new Date();
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		
		Instant instant = Instant.now();		
		long epoch = instant.getEpochSecond();
		scan.close();
		
		
		switch (a) {
		case 0: {
			System.out.println("milliseconds since January 1, 1970: "+ date.getTime());
			break;
		}
		case 1: {
			System.out.println("seconds since January 1, 1970: "+ epoch);
			break;
		}
		case 2: {
			System.out.println("days since January 1, 1970: "+ LocalDate.now().toEpochDay());
			break;
		}
		case 3: {
			System.out.println("current date and time: "+ dtf.format(currentDateTime));
			break;
		}
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + a);
		}
		
	}	
	
}


