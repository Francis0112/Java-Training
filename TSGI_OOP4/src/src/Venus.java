package src;

public class Venus extends Planet {
	
	final double gravity = 0.91;
	final double earthdays = 224.68;
	double mass;
	double space_age;
	String unit;
	int weight;
	int age;
	
	public Venus(int a, int b, String c) {
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
		System.out.println("-Thick clouds containing sulfuric acid hide the rocky surface of Earth's sister planet. The atmosphere of Venus is mostly carbon dioxide, which traps heat — causing the surface temperatures to be about 450° C (840° F).");
	}
}
