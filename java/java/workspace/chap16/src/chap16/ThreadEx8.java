package chap16;
/*
 *  생산자 Thread, 소비자 Thread 예제
 *  
 *  엄마와 아들은 하나의 계좌를 공유
 *  계좌의 잔액이 0이면 아들은 wait() 상태로  변경, 엄마한테 입금을 요구.
 *  엄마는 잔액이 0인 경우만, 입금을 10000,20000,30000 중 한개만 입금.
 *  계좌에 잔액이 있으면 wait() 한다.
 *  
 *  엄마는 0 ~3000 동안 sleep
 *  아들은 0 ~1000 동안 sleep.
 *  
 *  wait(),notify(),notifyAll() 메서드 예제.
 *  1. 동기화 영역(동기화 블럭(lock), 동기화 메서드)에서만 호출 가능.
 *  2. Object클래스의 멤버 메서드. => 모든 객체는 wait(),notify(),notifyAll() 호출 가능.
 *  3. wait() : 현재 실행중인 Thread 를 대기상태로 변환. lock 해제.
 *  4.			notify(),notifyAll() 메서드로만 Runnable 상태로 변환됨.
 *  			sleep는 시간이 지난 후에  
 *  			join은 다 끝나고 난 후.
 *  5.notify() : wait() 상태인 Thread 중 한개만 Runnable 상태로 변환함. 개발자가 지정 못함.
 *  6.notifyAll() : wait() 상태인 Thread 모두를 Runnable 상태로 변환함. 개발자가 지정 못함.
 *  
 */

class Account {
	//시작은 mother, 끝은 son
	int money;
	synchronized void output() {
		while(money == 0) {
			try {
				wait(); //son이 대기상태가 됨.
			}catch(InterruptedException e) {}
		}
		notifyAll();//mother Thread가 wait 상태에서 살아남.
		System.out.println(Thread.currentThread().getName()+money+"원 출금");
		money =0;
	}
	
	synchronized void input() {
		while(money > 0) {
			try {
				wait();//mother가 대기상태가 됨.
			}catch(InterruptedException e) {}
		}
		money = ((int)(Math.random()*3)+1)*10000;
		notifyAll();//son Thread가 wait 상태에서  살아남.
		System.out.println(Thread.currentThread().getName()+money+"원 입금");
	}
}


class Mother extends Thread {
	Account account;
	Mother(Account account){
		super("엄마");
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
		super("아들");
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
