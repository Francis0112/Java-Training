package src;

import java.util.Scanner;

public class OOP_training3_Planets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		our_planets();	
	}
	
	static void our_planets() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please Input the following:\nPlanet name:\nYour Weight:\nUnit:\nAge:\n");
		String plant_name = scan.nextLine();
		int weight = Integer.parseInt(scan.nextLine());
		String unit = scan.nextLine();
		int age = Integer.parseInt(scan.nextLine());
		System.out.println();
		scan.close();
		Planet p = new Planet();
		
		
		if (plant_name.equalsIgnoreCase("sun")) {
			p = new Sun(weight,unit);
			System.out.println("in "+ plant_name+", your weight would be "+p.get_mass()+" "+unit+".\n"+"Did you know?");
			p.facts();
		}
		else if (plant_name.equalsIgnoreCase("moon")) {
			p = new Moon(weight, unit);
			System.out.println("in "+ plant_name+", your weight would be "+p.get_mass()+" "+unit+".\n"+"Did you know?");
			p.facts();
		}
		else if (plant_name.equalsIgnoreCase("mercury")) {
			p = new Mercury(weight, age, unit);
			System.out.println("in "+ plant_name+", your weight would be "+p.get_mass()+" "+unit+".\nYour age would be "+p.get_space_age()+" years old."+"\n"+"Did you know?");
			p.facts();
			
		}
		else if (plant_name.equalsIgnoreCase("venus")) {
			p = new Venus(weight, age, unit);
			System.out.println("in "+ plant_name+", your weight would be "+p.get_mass()+" "+unit+".\nYour age would be "+p.get_space_age()+" years old."+"\n"+"Did you know?");
			p.facts();
		}
		else if (plant_name.equalsIgnoreCase("earth")) {
			p = new Earth(weight, age, unit);
			System.out.println("in "+ plant_name+", your weight would be "+p.get_mass()+" "+unit+".\nYour age would be "+p.get_space_age()+" years old."+"\n"+"Did you know?");
			p.facts();
		}
		else if (plant_name.equalsIgnoreCase("mars")) {
			p = new Mars(weight, age, unit);
			System.out.println("in "+ plant_name+", your weight would be "+p.get_mass()+" "+unit+".\nYour age would be "+p.get_space_age()+" years old."+"\n"+"Did you know?");
			p.facts();
		}
		else if (plant_name.equalsIgnoreCase("jupiter")) {
			p = new Jupiter(weight, age, unit);
			System.out.println("in "+ plant_name+", your weight would be "+p.get_mass()+" "+unit+".\nYour age would be "+p.get_space_age()+" years old."+"\n"+"Did you know?");
			p.facts();
		}
		else if (plant_name.equalsIgnoreCase("saturn")) {
			p = new Saturn(weight, age, unit);
			System.out.println("in "+ plant_name+", your weight would be "+p.get_mass()+" "+unit+".\nYour age would be "+p.get_space_age()+" years old."+"\n"+"Did you know?");
			p.facts();
		}
		else if (plant_name.equalsIgnoreCase("neptune")) {
			p = new Neptune(weight, age, unit);
			System.out.println("in "+ plant_name+", your weight would be "+p.get_mass()+" "+unit+".\nYour age would be "+p.get_space_age()+" years old."+"\n"+"Did you know?");
			p.facts();
		}
		else if (plant_name.equalsIgnoreCase("uranus")) {
			p = new Uranus(weight, age, unit);
			System.out.println("in "+ plant_name+", your weight would be "+p.get_mass()+" "+unit+".\nYour age would be "+p.get_space_age()+" years old."+"\n"+"Did you know?");
			p.facts();
		}
		else {
			System.out.println("Please select a planet...");
		}
	}
}
