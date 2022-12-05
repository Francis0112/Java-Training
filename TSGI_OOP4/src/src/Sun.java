package src;

public class Sun extends Planet {

	final double gravity = 27.9;
	double mass;
	String unit;
	int weight;
	
	
	public Sun(int a, String b) {
		// TODO Auto-generated constructor stub
		this.weight=a;
		this.unit=b;
	}
	
	public double get_mass() {
		mass = weight*gravity;
		return mass;
	}
	
	
	@Override
	public void facts(){
		System.out.println("Our solar system is on the edge of a spiral arm called Orion's Arm, and is one-half to two-thirds of the way (28,000 light-years) from the center of our Milky Way galaxy.");
	}

}