package src;

public class Planet {
	
	String bread;
	String sauce;
	String cheese;
	String toppings;
	
	public Planet(String a, String b, String c, String d) {
		// TODO Auto-generated constructor stub
		bread = a;
		sauce = b;
		cheese = c;
		toppings = d;
	}
	
	public Planet(String a, String b, String c) {
		// TODO Auto-generated constructor stub
		bread = a;
		sauce = b;
		cheese = c;
	}
	
	public String toString() {
		return bread+"\n"+sauce+"\n"+cheese+"\n"+toppings+"\n";
	}
}
