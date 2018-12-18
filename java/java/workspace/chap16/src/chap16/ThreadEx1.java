package chap16;
/*
 * Thread ���� ����
 *   1. Thread Ŭ������ ���. <= ����
 *   	run() �޼��带 �������̵�. => Thread�� ������ ����� ����ϴ� �޼���.
 *   2. Runnable �������̽��� �����ؼ� thread��ü�� �Է�.
 */

class Thread1 extends Thread {
	Thread1(String name){
		super(name); //Thread �̸� �����ϱ�.
	}
	// run() �������̵�.
	public void run() { // Running ���� : run() �޼��� ������. ���α׷��Ӱ� ������ �� ����.
		for(int i=0;i<5;i++) {
			System.out.println(i+"="+getName()); //������ �̸���� getName()���� ����.
			try {
				sleep(1000); //������. 1000�и���= 1��
				
			}catch(InterruptedException e) {}
		}
	} // Dead ����.
}
// �� 3���� Thread : main Thread, t1, t2
public class ThreadEx1 {
	//main�� �ϳ��� Thread�̴�. (main Thread)
	public static void main(String[] args) {
		System.out.println("main �޼��� ����");
		Thread t1 = new Thread1("First"); // new ����
		Thread t2 = new Thread1("second"); // new ����
		//������ ������ ����� �ٸ��� ��Ÿ����.
		t1.start();	t2.start(); //Runnable ����
	/*
	 * start �޼����� ���.
	 *  1. stack�� ����ȭ��.
	 *  2. ���� �ڽ��� ��ü �ȿ� �ִ� run()�̶�� �޼��带 ���ĵ� stack �ȿ� ȣ��. 
	 */
	 //	t1.run(); t2.run(); //Thread ���°� �ƴ�.
		System.out.println("�޼��� ����.");

	}
}
