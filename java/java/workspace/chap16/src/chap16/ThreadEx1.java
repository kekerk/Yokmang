package chap16;
/*
 * Thread 생성 예제
 *   1. Thread 클래스를 상속. <= 예제
 *   	run() 메서드를 오버라이딩. => Thread가 실행할 기능을 담당하는 메서드.
 *   2. Runnable 인터페이스를 구현해서 thread객체에 입력.
 */

class Thread1 extends Thread {
	Thread1(String name){
		super(name); //Thread 이름 성정하기.
	}
	// run() 오버라이딩.
	public void run() { // Running 상태 : run() 메서드 실행중. 프로그래머가 관여할 수 없음.
		for(int i=0;i<5;i++) {
			System.out.println(i+"="+getName()); //설정된 이름대로 getName()으로 실행.
			try {
				sleep(1000); //대기상태. 1000밀리초= 1초
				
			}catch(InterruptedException e) {}
		}
	} // Dead 상태.
}
// 총 3개의 Thread : main Thread, t1, t2
public class ThreadEx1 {
	//main도 하나의 Thread이다. (main Thread)
	public static void main(String[] args) {
		System.out.println("main 메서드 시작");
		Thread t1 = new Thread1("First"); // new 상태
		Thread t2 = new Thread1("second"); // new 상태
		//실행할 때마다 결과가 다르게 나타난다.
		t1.start();	t2.start(); //Runnable 상태
	/*
	 * start 메서드의 기능.
	 *  1. stack을 병렬화함.
	 *  2. 현재 자신의 객체 안에 있는 run()이라는 메서드를 병렬된 stack 안에 호출. 
	 */
	 //	t1.run(); t2.run(); //Thread 상태가 아님.
		System.out.println("메서드 종료.");

	}
}
