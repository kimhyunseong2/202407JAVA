package thread3;

import java.time.LocalTime;

public class Time implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i< 10; i++) {
			LocalTime localtime = LocalTime.now();
			System.out.printf("%d:%d:%d\n",
					localtime.getHour(),localtime.getMinute(),localtime.getSecond());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
