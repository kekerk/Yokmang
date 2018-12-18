package chap16;
/*
 *  Thread 그룹 예제 : 관련 있는 Thread 객체를 그룹화하여 처리할 수 있다.
 *  논리적으로 Thread의 제한이 없다.
 */
class MyThread extends Thread{
	MyThread(ThreadGroup tg, String name){
		super(tg,name);
	}
	//try-catch 구문만 써야한다. Throws ~Exception 은 오버라이딩 조건에 맞지 않아 쓸 수 없다.
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
		ThreadGroup tg = new ThreadGroup("Group1"); //t1,t2,t3는 Group1에 포함되어있음.
		Thread t1 = new MyThread(tg,"first");
		Thread t2 = new MyThread(tg,"second");
		Thread t3 = new MyThread(tg,"third");
		Thread t4 = new MyThread(Thread.currentThread().getThreadGroup(),"Fourth");//t4만 main Thread에 포함되어있음.
		t1.start();t2.start();t3.start();t4.start();
		Thread.sleep(2000);
		tg.stop(); //stop() : Thread 강제 종료. 가운데 줄이 그어진 것은 쓰지 말라는 것을 권장하는 표시.
                   //		  Group1 Thread 그룹에 속한 모든 스레드 강제 종료.
	}
}
