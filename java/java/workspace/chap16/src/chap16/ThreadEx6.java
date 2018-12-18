package chap16;
//동기화 예제 : wait(), notify(), notifyAll() 사용 안함.
class Atm implements Runnable{
	private long  money = 100000;

	@Override
	public void run() {
		synchronized (this) {
			for(int i=0;i<10;i++) {
				if(money <= 0) {
					System.out.println("잔액부족");
					break;
				}
				withdraw(10000);
				try {
					Thread.sleep((int)(Math.random()*100));
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
public class ThreadEx6 {
	public static void main(String[] args) {
		Atm atm = new Atm();
		Thread mother = new Thread(atm,"mother");
		Thread son = new Thread(atm,"son");
		mother.start(); son.start();
		
		
	}
}
