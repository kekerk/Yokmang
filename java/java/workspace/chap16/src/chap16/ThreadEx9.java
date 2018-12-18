package chap16;
/*
 * Thread 우선 순위 설정하기 : 스케줄러에게 빠른 선택을 받을 수 있다.
 *    단, 우선순위가 높다고 무조건 선택이 되는 것은 아님. 단지 확률이 높을 뿐.
 */

class ThreadPriority extends Thread{
	
	ThreadPriority(String name, int p){
		super(name);
		setPriority(p);//우선순위 설정 메서드.
	}
	public void run() {
		try {
			sleep(20);			
		}catch(InterruptedException e) {}
		for(int i=0;i<50;i++) {
			System.out.println(this);
		/*
		 * Thread[second,1,main]
		 * second : 이름(name)
		 * 1	  : 우선순위
		 * main	  : 스레드 그룹
		 */
		}
	}
	
}
public class ThreadEx9 {
	public static void main(String[] args) {//main 자체를 Thread로 본다.
	System.out.println("가장 높은 우선순위: "+Thread.MAX_PRIORITY); //10
	System.out.println("가장 낮은 우선순위: "+Thread.MIN_PRIORITY); //1
	System.out.println("기본우선순위: "+Thread.NORM_PRIORITY); //5
	System.out.println(Thread.currentThread());
	Thread t1 = new ThreadPriority("first",5);
	Thread t2 = new ThreadPriority("second",1);
	Thread t3 = new ThreadPriority("Third",10);
	t1.start();t2.start();t3.start();
	}
}
