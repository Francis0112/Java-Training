package hello_world;

public class Sphere {
	double volume;
	double surface_area;
	
	public Sphere(double x) {
		volume = (4.0/3.0)*Math.PI*(x*x*x);
		surface_area = 4*Math.PI*(x*x);
	}
}
