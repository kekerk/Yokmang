package chap16;
/*
 * sleep() ���� Thread �����.
 */
class InterruptThread extends Thread {
	public void run() {
		System.out.println("���ݺ��� �߲���. ����������");
		try {
			sleep(10000000);
			}catch(InterruptedException e) { //RuntimeException �� ���� Ŭ������ �ƴ϶� ���� ó�� ������ �� �� ����.
				System.out.println("?���� ����?");
			}
		System.out.println("run �޼��� ����");
	}
}
public class ThreadEx12 {
	public static void main(String[] args) throws InterruptedException {
	Thread t = new InterruptThread();
	t.start();
	Thread.sleep(2000); // 2�� sleep
	t.interrupt(); // t �����带 �����. t �����忡 InterruptedException ���� �߻�.
	System.out.println("main Thread ����");
	}
}
