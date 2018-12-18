package chap16;
/*
 * Thread ���� ����
 *  1. Thread Ŭ������ ���.
 *  2. Runnable �������̽��� �����Ͽ� Thread ��ü�� �Է��ϱ�. <= ���� 
 *     - Runnable �������̽� ���� Ŭ���� ����.
 *     - run() �޼��� �������̵�.
 *     - Thread ��ü ������ �����ڿ� Runnable ��ü�� ����.
 *       => Runnable ��ü�� run() �޼��� ȣ��.
 */
//Runnable �������̽��� ����Ŭ������.
class Runnable1 implements Runnable { //Thread ��ü�� �ƴ�.

	@Override
	public void run() {
		//Thread.currentThread() : ���� ���� ���� Thread ��ü�� ����.
		for(int i=0;i<5;i++) {
			System.out.println(i+"="+Thread.currentThread().getName());
			try {
				//getName() �� sleep();�� Thread�� ��ü��. Runnable�� ��ü�� �ƴ�. 
				Thread.sleep(1000);
				}catch(InterruptedException e) {}
		}
	}
}
public class ThreadEx2 {
	public static void main(String[] args) {
		System.out.println("main Thread ����");
		Runnable1 r = new Runnable1(); //Thread ��ü�� �ƴ�.  run() ȣ����.
		Thread t1 = new Thread(r,"first"); // new ����.
		Thread t2 = new Thread(r,"second");// new ����.
		t1.start(); t2.start();
		/*
		 * start() �޼��� ���.
		 * 1. stack ����ȭ
		 * 2. r.run() �޼��� ȣ��. 
		 */

		System.out.println("main Thread ����");
		// start() �޼���� ���� stack�� 3���� ����ȭ �ǰ� , main Thread�� 
	}
}
