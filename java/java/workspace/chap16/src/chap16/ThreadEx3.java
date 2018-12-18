package chap16;

/*
 * 동기화 되지 않는 경우.
 * 
 */
class PrintThread extends Thread {
	char ch;
	PrintThread(char ch) {
		this.ch = ch;
	}
	public void run() {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 80; j++) {
				System.out.print(ch);
			}
			System.out.println();
		}
	}
}
/*  동기화 하기. (내일)  */
public class ThreadEx3 {
	public static void main(String[] args) throws Exception {
		Thread t1 = new PrintThread('A');
		Thread t2 = new PrintThread('B');
		Thread t3 = new PrintThread('C');
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
		t3.join();
		System.out.println("룰루");
	}
}
