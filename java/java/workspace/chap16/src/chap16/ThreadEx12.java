package chap16;
/*
 * sleep() 중인 Thread 깨우기.
 */
class InterruptThread extends Thread {
	public void run() {
		System.out.println("지금부터 잘꺼임. 깨우지마셈");
		try {
			sleep(10000000);
			}catch(InterruptedException e) { //RuntimeException 의 하위 클래스가 아니라서 예외 처리 생략을 할 수 없음.
				System.out.println("?누가 깨움?");
			}
		System.out.println("run 메서드 종료");
	}
}
public class ThreadEx12 {
	public static void main(String[] args) throws InterruptedException {
	Thread t = new InterruptThread();
	t.start();
	Thread.sleep(2000); // 2초 sleep
	t.interrupt(); // t 스레드를 깨우기. t 스레드에 InterruptedException 예외 발생.
	System.out.println("main Thread 종료");
	}
}
