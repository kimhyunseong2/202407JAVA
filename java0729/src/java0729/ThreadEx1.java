package java0729;

public class ThreadEx1 {

	public static void main(String[] args) {
		Thread mThread = Thread.currentThread();
		System.out.println(mThread.getName());
		
		ThreadA threadA = new ThreadA();
		threadA.start();
		
		//스레드B는 익명 자식 객체 생성으로
		Thread threadB = new Thread() {

			public void run() {
				for (int i=0; i<2; i++) {
					System.out.println(this.getName());
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		threadB.setName("ThreadB");
		threadB.start();
		
		//스레드C는 Runnable 구현 객체 생성으로
		
		Thread threadC = new Thread(new Runnable() {

			public void run() {
				for (int i=0; i<2; i++) {
					System.out.println("ThreadC");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		threadC.setName("ThreadC");
		threadC.start();
	}

}
