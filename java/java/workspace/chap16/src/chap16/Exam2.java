package chap16;
/*
 * Exam1.java의 Thread Runnable 인터페이스 구현 방식으로 변경하기.
 */

class Runnable2 implements Runnable {
	int begin, end, sum;

	Runnable2(int begin, int end) {
		this.begin = begin;
		this.end = end;
	}

	@Override
	public void run() {
		for (int i = begin; i <= end; i++) {
			sum += i;
		}
	}

}

public class Exam2 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("main Thread 시작");
		//배열로 만들기.
		Runnable2 r1 = new Runnable2(1,100);
		Runnable2 r2 = new Runnable2(101,200);
		Runnable2 r3 = new Runnable2(201,300);
		Runnable2 r4 = new Runnable2(301,400);
		Runnable2 r5 = new Runnable2(401,500);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		Thread t4 = new Thread(r4);
		Thread t5 = new Thread(r5);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		t5.join();
		System.out.println("1에서 500까지의 합:" +(r1.sum+r2.sum+r3.sum+r4.sum+r5.sum));
		System.out.println("main Thread 종료");
		
		
	}

}
