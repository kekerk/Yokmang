package chap16;
/*
 *  Thread �׷� ���� : ���� �ִ� Thread ��ü�� �׷�ȭ�Ͽ� ó���� �� �ִ�.
 *  �������� Thread�� ������ ����.
 */
class MyThread extends Thread{
	MyThread(ThreadGroup tg, String name){
		super(tg,name);
	}
	//try-catch ������ ����Ѵ�. Throws ~Exception �� �������̵� ���ǿ� ���� �ʾ� �� �� ����.
	public void run() {
		while(true) {
			try {
				sleep(500);
			}catch(InterruptedException e) {}
			System.out.println(this +"=>" + this.getThreadGroup().getName());
		}
	}
}
public class ThreadEx10 {
	public static void main(String[] args) throws Exception {
		ThreadGroup tg = new ThreadGroup("Group1"); //t1,t2,t3�� Group1�� ���ԵǾ�����.
		Thread t1 = new MyThread(tg,"first");
		Thread t2 = new MyThread(tg,"second");
		Thread t3 = new MyThread(tg,"third");
		Thread t4 = new MyThread(Thread.currentThread().getThreadGroup(),"Fourth");//t4�� main Thread�� ���ԵǾ�����.
		t1.start();t2.start();t3.start();t4.start();
		Thread.sleep(2000);
		tg.stop(); //stop() : Thread ���� ����. ��� ���� �׾��� ���� ���� ����� ���� �����ϴ� ǥ��.
                   //		  Group1 Thread �׷쿡 ���� ��� ������ ���� ����.
	}
}
