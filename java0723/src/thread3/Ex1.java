package thread3;

public class Ex1 {

	public static void main(String[] args) {
		Thread thread = new Thread(new Time());
//		Time time = new Time();
		thread.start();
		
		for (int i = 0; i< 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
