package chap16;
/*
 *  ����ȭ ���� 1 : synchronized ���� ���.
 *  	����ȭ ��    : synchronized(lock) ��� (TreadEx4 ����)
 *  				lock���� ���Ǵ� ��ü�� �ݵ�� �Ѱ��� �����ؾ� �Ѵ�.
 *  
 *  	����ȭ �޼��� : ���������� synchronized ����Ÿ�� �޼���� (�Ű����� ���) .....
 */

class PrintThread2 extends Thread {
	char ch;
	PrintThread2(char ch) {
		this.ch = ch;
	}
	// static�� ���� lock�� �� ��ü�� ���� ���� �ȴ�.-> ����ȭ ȿ���� �����.
	// �⺻�ڷ������� lock�� ������ �� ����.
	static Object lock = new Object(); //lock�� ��ü�� ����.
	public void run() {
		for (int i = 0; i < 20; i++) {
			synchronized (lock) { //�Ӱ迵��.(���� ����)
				for (int j = 0; j < 80; j++) {
					System.out.print(ch);
				}
				System.out.println();
			} // ����ȭ ���� : �������� �����尡 Runnable ���·� ����.
		}
	}
}

public class ThreadEx4 {
	public static void main(String[] args) {
		Thread t1 = new PrintThread2('A');//r(first)
		Thread t2 = new PrintThread2('B');//���������ص� lock�� �ɷ��� �����·� �ȴ�.
		Thread t3 = new PrintThread2('C');
		t1.start(); t2.start(); t3.start();
	}
}
