package src;

public class OOP_training3 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		just_a_method();
		
	}
	
	static void just_a_method() {
		Planet p1 = new Planet("nice bread", "nice sauce", "nice cheese", "nice toppings");
		System.out.println("your pizza #1:");
		System.out.println(p1.bread);
		System.out.println(p1.cheese);
		System.out.println(p1.sauce);
		System.out.println(p1.toppings+"\n");
		
		Planet p2 = new Planet("very nice bread", "very nice sauce", "very nice cheese");
		System.out.println("your pizza #2");
		System.out.println(p2.bread);
		System.out.println(p2.sauce);
		System.out.println(p2.cheese+"\n");
		
		Planet p3 = new Planet("hello", "world", "java","training");
		System.out.println(p3.toString());
		
		Food food1 = new Food("Burger steak");
		Food food2 = new Food("Fries");
		Food food3 = new Food("Coke");
		
		Food[] ref = {food1,food2,food3};
		System.out.println(ref[0].food+"\n"+ref[1].food+"\n"+ref[2].food+"\n");
		
		// This is inheritance
		Car toyota = new Car("Toyota");
		Car BMW = new Car("BMW");
		Garage gar = new Garage();
		gar.park(toyota);
		gar.park(BMW);
		
		System.out.println();
		// this is polymorphism
		Bike bike = new Bike();
		Boat boat = new Boat();
		Plane plane = new Plane();
		
		Vehicle[] rides = {bike,boat,plane};
		
		for (Vehicle v : rides) {
			v.go();
		}
		
		
	}
}
