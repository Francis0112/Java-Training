package src;

public class Saturn extends Planet {

	final double gravity = 1.08;
	final double earthdays = 29.456;
	double mass;
	double space_age;
	String unit;
	int weight;
	int age;
	
	public Saturn(int a, int b, String c) {
		// TODO Auto-generated constructor stub
		this.weight=a;
		this.age=b;
		this.unit=c;
	}
	
	public double get_mass() {
		mass = weight*gravity;
		return mass;
	}
	
	public double get_space_age() {
		space_age = age/earthdays;
		return space_age;
	}
	
	@Override
	public void facts(){
		System.out.println("-Saturn has more than 50 moons, 35 of which are named and the rest of which were recently discovered.");
	}
}
