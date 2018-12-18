package chap16;
/*
 * Thread �켱 ���� �����ϱ� : �����ٷ����� ���� ������ ���� �� �ִ�.
 *    ��, �켱������ ���ٰ� ������ ������ �Ǵ� ���� �ƴ�. ���� Ȯ���� ���� ��.
 */

class ThreadPriority extends Thread{
	
	ThreadPriority(String name, int p){
		super(name);
		setPriority(p);//�켱���� ���� �޼���.
	}
	public void run() {
		try {
			sleep(20);			
		}catch(InterruptedException e) {}
		for(int i=0;i<50;i++) {
			System.out.println(this);
		/*
		 * Thread[second,1,main]
		 * second : �̸�(name)
		 * 1	  : �켱����
		 * main	  : ������ �׷�
		 */
		}
	}
	
}
public class ThreadEx9 {
	public static void main(String[] args) {//main ��ü�� Thread�� ����.
	System.out.println("���� ���� �켱����: "+Thread.MAX_PRIORITY); //10
	System.out.println("���� ���� �켱����: "+Thread.MIN_PRIORITY); //1
	System.out.println("�⺻�켱����: "+Thread.NORM_PRIORITY); //5
	System.out.println(Thread.currentThread());
	Thread t1 = new ThreadPriority("first",5);
	Thread t2 = new ThreadPriority("second",1);
	Thread t3 = new ThreadPriority("Third",10);
	t1.start();t2.start();t3.start();
	}
}
