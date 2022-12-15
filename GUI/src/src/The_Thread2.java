package src;

public class The_Thread2 extends Thread {	
	

	@Override
	public void run() {
		try {
				System.out.print("Design ");
				sleep(2000);
				System.out.print("Engineer ");
				sleep(2000);
				System.out.print("Java");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.run();
	}
}
