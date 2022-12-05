package src;

public class Jupiter extends Planet {

	final double gravity = 2.54;
	final double earthdays = 11.862;
	double mass;
	double space_age;
	String unit;
	int weight;
	int age;
	
	public Jupiter(int a, int b, String c) {
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
		System.out.println("-Jupiter has more than 60 moons. Four are called Galilean moons, 12 are smaller, named moons, and the rest are small, recently-discovered moons.");
	}
}
