package src;

public class Uranus extends Planet {
	
	final double gravity = 0.91;
	final double earthdays = 84.07;
	double mass;
	double space_age;
	String unit;
	int weight;
	int age;
	
	public Uranus(int a, int b, String c) {
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
		System.out.println("-Uranus spins on an axis that is tilted so far it looks like a top spinning on its side. The blue-green color of the planet is due to methane in the atmosphere.");
	}

}
