package src;

public class Neptune extends Planet {
	
	final double gravity = 1.19;
	final double earthdays = 164.81;
	double mass;
	double space_age;
	String unit;
	int weight;
	int age;
	
	public Neptune(int a, int b, String c) {
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
		System.out.println("-Neptune has more than 10 moons. Its largest moon, Triton, is almost as large as Earth's moon.");
	}
}
