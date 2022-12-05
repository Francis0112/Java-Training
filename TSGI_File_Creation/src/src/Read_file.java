package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Read_file {

	public String get_file(String f) {
		File file = new File(f);
		char[] contents = null;
		BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(file));
				contents = new char[(int) file.length()];
				int i = 0;
				int c = br.read();
				while (c != -1) {
					contents[i++] = (char) c;
					c = br.read();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new String(contents);
	}
}
