package src;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class The_Timer {

	public void Oz() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
		int counter = 10;	
			
			@Override
			public void run() {
				if (counter>0) {
					// TODO Auto-generated method stub
					System.out.println(counter--+" Second");
				}
				else {
					System.out.println("Task is complete");
					timer.cancel();
				}
			}
		};
		Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR, 2022);
		date.set(Calendar.MONTH, Calendar.DECEMBER);
		date.set(Calendar.DAY_OF_MONTH, 12);
		date.set(Calendar.HOUR, 1);
		date.set(Calendar.MINUTE, 11);
		date.set(Calendar.SECOND, 0);
		date.set(Calendar.MILLISECOND, 0);
		//timer.schedule(task, 3000);
		//timer.schedule(task, date.getTime());
		timer.scheduleAtFixedRate(task, date.getTime(), 1000);
	}
}
