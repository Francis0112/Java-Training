package src;

public class Mercury extends Planet {

	final double gravity = 0.38;
	final double earthdays = 87.96;
	double mass;
	double space_age;
	String unit;
	int weight;
	int age;
	
	public Mercury(int a, int b, String c) {
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
		System.out.println("-Temperature variations on Mercury are the most extreme in the solar system ranging from –170º C (–270º F) to 430º C (800º F). Its solid surface is covered with craters and it has almost no atmosphere. There is evidence of ice in the protected shadows of c");
	}
	
}
