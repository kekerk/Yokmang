package chap16;
/*
 * 데몬 Thread : 일반 Thread의 보조 역할 기능의 Thread로 사용됨.
 *              일반 Thread가 모두 종료되면 데몬 Thread도 자동 종료됨.
 */

class DaemonThread extends Thread {
	public void run() {
		while(true) {
			System.out.println(this);
			try {
				sleep(200-100);
			}catch(InterruptedException e) {}
		}
	}
}
public class ThreadEx11 {
	public static void main(String[] args) throws Exception {
		Thread t1 = new DaemonThread();
		Thread t2 = new DaemonThread();
		t1.setDaemon(true); //daemon Thread로 성정. 설정한다.(True). 반드시 new 상태에서 설정해야함.
		t2.setDaemon(true);
		//daemon Thread를 설정하려면 new 상태에서 .setdaemon(true)로 설정한뒤 .start()를 설정한다.
		t1.start();t2.start();
		Thread.sleep(2000);
		System.out.println("Thread 종료");
	}
}
