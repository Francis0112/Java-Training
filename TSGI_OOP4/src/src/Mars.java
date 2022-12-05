package src;

public class Mars extends Planet {
	
	final double gravity = 0.38;
	final double earthdays = 686.98;
	double mass;
	double space_age;
	String unit;
	int weight;
	int age;
	
	public Mars(int a, int b, String c) {
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
		space_age = (age*365)/earthdays;
		return space_age;
	}
	
	@Override
	public void facts(){
		System.out.println("-Mars has two moons: Deimos and Phobos.");
	}
}
