package src;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TaskNumber5 {

	public static void main(String[] args) throws IOException {
		
		remove_comments();
		
	}
	
	public static void remove_comments() {
		Scanner scan = new Scanner(System.in);
		int a = 0;
		while (a!=1) {
			System.out.println("Enter File location: or type 'exit' to close:");
			String path = scan.nextLine();
			File file = new File(path);
			if (path.equalsIgnoreCase("exit")) {
				System.out.println("Thank you and bye..");
				break;
			}
			if (file.exists()) {
				Read_file rd = new Read_file();
				System.out.println(rd.get_file(path).replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)", ""));
				break;
			} else {
				System.out.println("File Dose not exists. try again.");
			}
		}
		scan.close();
	}
}
