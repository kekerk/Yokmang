package chap16;
/*
 *  동기화 예제 1 : synchronized 예약어를 사용.
 *  	동기화 블럭    : synchronized(lock) 사용 (TreadEx4 예제)
 *  				lock으로 사용되는 객체는 반드시 한개만 존재해야 한다.
 *  
 *  	동기화 메서드 : 접근제어자 synchronized 리턴타입 메서드명 (매개변수 목록) .....
 */

class PrintThread2 extends Thread {
	char ch;
	PrintThread2(char ch) {
		this.ch = ch;
	}
	// static을 떼면 lock은 각 객체에 전부 들어가게 된다.-> 동기화 효과가 사라짐.
	// 기본자료형으로 lock을 선언할 수 없다.
	static Object lock = new Object(); //lock은 객체만 가능.
	public void run() {
		for (int i = 0; i < 20; i++) {
			synchronized (lock) { //임계영역.(개수 제한)
				for (int j = 0; j < 80; j++) {
					System.out.print(ch);
				}
				System.out.println();
			} // 동기화 종료 : 대기상태의 스레드가 Runnable 상태로 변경.
		}
	}
}

public class ThreadEx4 {
	public static void main(String[] args) {
		Thread t1 = new PrintThread2('A');//r(first)
		Thread t2 = new PrintThread2('B');//들어오려고해도 lock이 걸려서 대기상태로 된다.
		Thread t3 = new PrintThread2('C');
		t1.start(); t2.start(); t3.start();
	}
}
