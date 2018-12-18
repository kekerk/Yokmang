package chap16;
/*
 * Thread 생성 예제
 *  1. Thread 클래스를 상속.
 *  2. Runnable 인터페이스를 구현하여 Thread 격체에 입력하기. <= 에제 
 *     - Runnable 인터페이스 구현 클래스 생성.
 *     - run() 메서드 오버라이딩.
 *     - Thread 객체 생성시 생성자에 Runnable 객체를 전달.
 *       => Runnable 객체의 run() 메서드 호출.
 */
//Runnable 인터페이스의 구현클래스임.
class Runnable1 implements Runnable { //Thread 객체가 아님.

	@Override
	public void run() {
		//Thread.currentThread() : 현재 실행 중인 Thread 객체를 리턴.
		for(int i=0;i<5;i++) {
			System.out.println(i+"="+Thread.currentThread().getName());
			try {
				//getName() 과 sleep();는 Thread의 객체임. Runnable의 객체가 아님. 
				Thread.sleep(1000);
				}catch(InterruptedException e) {}
		}
	}
}
public class ThreadEx2 {
	public static void main(String[] args) {
		System.out.println("main Thread 시작");
		Runnable1 r = new Runnable1(); //Thread 객체가 아님.  run() 호출함.
		Thread t1 = new Thread(r,"first"); // new 상태.
		Thread t2 = new Thread(r,"second");// new 상태.
		t1.start(); t2.start();
		/*
		 * start() 메서드 기능.
		 * 1. stack 병렬화
		 * 2. r.run() 메서드 호출. 
		 */

		System.out.println("main Thread 종료");
		// start() 메서드로 인해 stack은 3개로 병렬화 되고 , main Thread는 
	}
}
