package hello_world;

public class Rectangle {
	double length;
	double width;
	double area;
	double perimeter;
	String name;
	
	public Rectangle(double x, double y, String z) {
		name = z;
		length = x;
		width = y;
		area = width*length;
		perimeter = 2*(length+width);
	}
}
