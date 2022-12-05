package src;

public class Moon extends Planet {

	final double gravity = 0.17;
	double mass;
	String unit;
	int weight;
	
	public Moon(int a, String b) {
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
		System.out.println("The Moon has no atmosphere or magnetic field. Most rocks on the surface of the Moon seem to be between 4.5 and 3 billion years old, older than those usually found on Earth. Thus the Moon provides evidence about the early history of our solar system.");
	}
}
