package hello_world;
public class Circle {
	double radius;
	double area;
	double circumference;
	double diameter;
	String name;

	public Circle(double x, String y) {
		name = y;
		radius = x;
		area = Math.PI*(radius*radius);
		circumference = 2*Math.PI*radius;
		diameter = 2*radius;
	}
		
}
