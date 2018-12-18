package chap16;
/*
 *  동기화 예제 2 : synchronized 예약어를 사용.
 *  	동기화 블럭    : synchronized(lock) 사용 
 *  				lock으로 사용되는 객체는 반드시 한개만 존재해야 한다.
 *  
 *  	동기화 메서드 : 접근제어자 synchronized 리턴타입 메서드명 (매개변수 목록) ..... (TreadEx5 예제)
 */
class PrintThread3 extends Thread{
	Printer prt;
	char ch;
	public PrintThread3(Printer prt,char ch) {
		this.prt = prt;
		this.ch =ch;
	}
	public void run() {
		for(int i=0;i<20;i++) {
			prt.printChar(ch);
		}
	}
}
// 보통  동기화 메서드를 따로 클래스를 만들어 사용한다.
class Printer{ //공유객체. 동기화 메서드는 공유객체에 존재해야 한다.
	//메서드 자체에 synchronized를 붙인다.
	synchronized void printChar(char ch) {//동기화 메서드. 임계(동기화) 영역.
		for(int i=0;i<80;i++) {
			System.out.print(ch);
		}
		System.out.println();
	}//동기화 풀림.
}

public class ThreadEx5 {
	public static void main(String[] args) {
		Printer prt = new Printer(); //하나 만듬.
		Thread t1 = new PrintThread3(prt,'A');
		Thread t2 = new PrintThread3(prt,'B');
		Thread t3 = new PrintThread3(prt,'C');
		t1.start();t2.start();t3.start();
	}
}
