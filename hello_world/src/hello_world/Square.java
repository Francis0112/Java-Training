package hello_world;

public class Square {
	double side;
	double area;
	double perimeter;
	String name;
	
	public Square(double x, String y) {
		side = x;
		name = y;
		area = side*side;
		perimeter = 4*side;
	}

}
