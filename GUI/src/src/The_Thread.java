package src;

public class The_Thread extends Thread {
	
	char[] name = {'F','R','A','N','C','I','S',' ','E','A','R','L',' ','D','E','Q','U','I','T','O'};
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for (int i = 0; i < name.length; i++) {
				System.out.println(name[i]);
				sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.run();
	}
	
}
