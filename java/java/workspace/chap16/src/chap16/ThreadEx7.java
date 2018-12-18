package chap16;
//����ȭ ���� : wait(), notify(), notifyAll() ��� 
class Atm2 implements Runnable{ //������ ��ü, ������ü, Runnable ��ü.
	private long  money = 100000;

	@Override
	public void run() {
		// this�� lock ��ü�� �̿��Ѵ�.
		synchronized (this) { //son -> mother lock ȹ��.
			for(int i=0;i<10;i++) {
				if(money <= 0) {
					System.out.println("�ܾ׺���");
					notify();
					break;
				}
				withdraw(10000);
				if(money%20000==0) {
					try {		// money=80000�� son ������. money=60000�� mother ������.
						wait(); // 80000���̸� wait() �ɸ��� ���� �������� Thread�� ��� ����. lock�� ����.
					}catch(InterruptedException e) {}
				}else {
					notify(); // ���� ������� Thread �� �Ѱ��� Runnable ���·� ����.
				}
				try {
					Thread.sleep((int)(Math.random()*100)); // 0~ 99 �и���.
				} catch(InterruptedException e) {}
			}
		}
	}
	
	private void withdraw(int m) {
		if(money <= 0) return;
		money-= m;
		System.out.print(Thread.currentThread().getName()+m+"�� ���");
		System.out.println(", �ܾ�:"+money);
		
	}
	
}
public class ThreadEx7 {

	public static void main(String[] args) {
		Atm2 atm = new Atm2(); //Atm2�� Runnable �������̽��� ������ ���� ��ü.
		Thread mother = new Thread(atm,"mother");
		Thread son = new Thread(atm,"son");
		mother.start(); son.start();

	}

}
