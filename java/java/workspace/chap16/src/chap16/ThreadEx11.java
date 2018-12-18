package chap16;
/*
 * ���� Thread : �Ϲ� Thread�� ���� ���� ����� Thread�� ����.
 *              �Ϲ� Thread�� ��� ����Ǹ� ���� Thread�� �ڵ� �����.
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
		t1.setDaemon(true); //daemon Thread�� ����. �����Ѵ�.(True). �ݵ�� new ���¿��� �����ؾ���.
		t2.setDaemon(true);
		//daemon Thread�� �����Ϸ��� new ���¿��� .setdaemon(true)�� �����ѵ� .start()�� �����Ѵ�.
		t1.start();t2.start();
		Thread.sleep(2000);
		System.out.println("Thread ����");
	}
}
