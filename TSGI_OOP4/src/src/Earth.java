package src;

public class Earth extends Planet {

	final double gravity = 1;
	final double earthdays = 365.26;
	double mass;
	double space_age;
	String unit;
	int weight;
	int age;
	
	public Earth(int a, int b, String c) {
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
		return age;
	}
	
	
	@Override
	public void facts(){
		System.out.println("-Earth is the only planet to have liquid water on its surface. Liquid water covers 71% of the surface. Its atmosphere is 77% nitrogen and 21% oxygen, with traces of other gases. White clouds of water vapor hide much of Earth's surface.");
	}
}
