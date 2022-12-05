package hello_world;

import java.util.Scanner;

public class OOP_training {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter type of parameters:\nRadius: ");
		double a = Double.parseDouble(scan.nextLine());
		System.out.println("Circle name:");
		String cname = scan.nextLine();
		
		
		System.out.println("Side:");
		double b = Double.parseDouble(scan.nextLine());
		System.out.println("Square name:");
		String sqr_name = scan.nextLine();
		
		System.out.println("Length:");
		double ln = Double.parseDouble(scan.nextLine());
		System.out.println("Width:");
		double wd = Double.parseDouble(scan.nextLine());
		System.out.println("Rectangle name:");
		String rec_name = scan.nextLine();
		
		System.out.println("");
		
		Circle c = new Circle(a,cname);
		System.out.printf("Circle: %s\n************************************************\nRaduis: %f\nArea: %f\nCircumference: %f\nDiamter: %f\n************************************************\n",c.name,c.radius, c.area, c.circumference, c.diameter);
		

		Square sqr = new Square(b, sqr_name);
		System.out.printf("Square: %s\n************************************************\nSide: %f\nPerimeter: %f\nArea: %f\n************************************************\n",sqr.name,sqr.side,sqr.perimeter,sqr.area);
		
		
		Rectangle rec = new Rectangle(ln, wd, rec_name);
		System.out.printf("Rectangle:%s\n************************************************\nLength: %f\nWidth: %f\nPerimeter: %f\nArea: %f\n************************************************\n",rec.name,rec.length,rec.width,rec.perimeter,rec.area);
		
		
		Sphere sp = new Sphere(c.radius);
		System.out.printf("Sphere:\n************************************************\nVolume: %f\nSurface_area: %f\n************************************************",sp.volume, sp.surface_area);
		
		scan.close();
	}
	
}


