package chap16;
//동기화 예제 : wait(), notify(), notifyAll() 사용 
class Atm2 implements Runnable{ //유일한 객체, 공유객체, Runnable 객체.
	private long  money = 100000;

	@Override
	public void run() {
		// this를 lock 객체로 이용한다.
		synchronized (this) { //son -> mother lock 획득.
			for(int i=0;i<10;i++) {
				if(money <= 0) {
					System.out.println("잔액부족");
					notify();
					break;
				}
				withdraw(10000);
				if(money%20000==0) {
					try {		// money=80000원 son 대기상태. money=60000원 mother 대기상태.
						wait(); // 80000원이면 wait() 걸리고 현재 실행중인 Thread가 대기 상태. lock도 해제.
					}catch(InterruptedException e) {}
				}else {
					notify(); // 현재 대기중인 Thread 중 한개를 Runnable 상태로 변경.
				}
				try {
					Thread.sleep((int)(Math.random()*100)); // 0~ 99 밀리초.
				} catch(InterruptedException e) {}
			}
		}
	}
	
	private void withdraw(int m) {
		if(money <= 0) return;
		money-= m;
		System.out.print(Thread.currentThread().getName()+m+"월 출금");
		System.out.println(", 잔액:"+money);
		
	}
	
}
public class ThreadEx7 {

	public static void main(String[] args) {
		Atm2 atm = new Atm2(); //Atm2는 Runnable 인터페이스를 구현한 구현 객체.
		Thread mother = new Thread(atm,"mother");
		Thread son = new Thread(atm,"son");
		mother.start(); son.start();

	}

}
