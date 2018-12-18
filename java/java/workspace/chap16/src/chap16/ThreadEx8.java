package chap16;
/*
 *  ������ Thread, �Һ��� Thread ����
 *  
 *  ������ �Ƶ��� �ϳ��� ���¸� ����
 *  ������ �ܾ��� 0�̸� �Ƶ��� wait() ���·�  ����, �������� �Ա��� �䱸.
 *  ������ �ܾ��� 0�� ��츸, �Ա��� 10000,20000,30000 �� �Ѱ��� �Ա�.
 *  ���¿� �ܾ��� ������ wait() �Ѵ�.
 *  
 *  ������ 0 ~3000 ���� sleep
 *  �Ƶ��� 0 ~1000 ���� sleep.
 *  
 *  wait(),notify(),notifyAll() �޼��� ����.
 *  1. ����ȭ ����(����ȭ ��(lock), ����ȭ �޼���)������ ȣ�� ����.
 *  2. ObjectŬ������ ��� �޼���. => ��� ��ü�� wait(),notify(),notifyAll() ȣ�� ����.
 *  3. wait() : ���� �������� Thread �� �����·� ��ȯ. lock ����.
 *  4.			notify(),notifyAll() �޼���θ� Runnable ���·� ��ȯ��.
 *  			sleep�� �ð��� ���� �Ŀ�  
 *  			join�� �� ������ �� ��.
 *  5.notify() : wait() ������ Thread �� �Ѱ��� Runnable ���·� ��ȯ��. �����ڰ� ���� ����.
 *  6.notifyAll() : wait() ������ Thread ��θ� Runnable ���·� ��ȯ��. �����ڰ� ���� ����.
 *  
 */

class Account {
	//������ mother, ���� son
	int money;
	synchronized void output() {
		while(money == 0) {
			try {
				wait(); //son�� �����°� ��.
			}catch(InterruptedException e) {}
		}
		notifyAll();//mother Thread�� wait ���¿��� ��Ƴ�.
		System.out.println(Thread.currentThread().getName()+money+"�� ���");
		money =0;
	}
	
	synchronized void input() {
		while(money > 0) {
			try {
				wait();//mother�� �����°� ��.
			}catch(InterruptedException e) {}
		}
		money = ((int)(Math.random()*3)+1)*10000;
		notifyAll();//son Thread�� wait ���¿���  ��Ƴ�.
		System.out.println(Thread.currentThread().getName()+money+"�� �Ա�");
	}
}


class Mother extends Thread {
	Account account;
	Mother(Account account){
		super("����");
		this.account = account;
	}
	public void run() {
		for(int i=0;i<20;i++) {
			account.input();
			try {
				sleep((int)(Math.random()*3000));
				
			}catch(InterruptedException e) {}
		}
	}
	
}

class Son extends Thread {
	Account account;
	Son(Account account){
		super("�Ƶ�");
		this.account = account;
	}
	public void run() {
		for(int i=0;i<20;i++) {
			account.output();
			try {
				sleep((int)(Math.random()*2000));
				
			}catch(InterruptedException e) {}
		}
	}
	
}
public class ThreadEx8 {

	public static void main(String[] args) {
	 Account acc = new Account();
	 Thread mother = new Mother(acc);
	 Thread son = new Son(acc);
	 mother.start(); son.start();
	 

	}

}
