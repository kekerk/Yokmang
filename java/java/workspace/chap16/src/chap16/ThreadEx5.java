package chap16;
/*
 *  ����ȭ ���� 2 : synchronized ���� ���.
 *  	����ȭ ��    : synchronized(lock) ��� 
 *  				lock���� ���Ǵ� ��ü�� �ݵ�� �Ѱ��� �����ؾ� �Ѵ�.
 *  
 *  	����ȭ �޼��� : ���������� synchronized ����Ÿ�� �޼���� (�Ű����� ���) ..... (TreadEx5 ����)
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
// ����  ����ȭ �޼��带 ���� Ŭ������ ����� ����Ѵ�.
class Printer{ //������ü. ����ȭ �޼���� ������ü�� �����ؾ� �Ѵ�.
	//�޼��� ��ü�� synchronized�� ���δ�.
	synchronized void printChar(char ch) {//����ȭ �޼���. �Ӱ�(����ȭ) ����.
		for(int i=0;i<80;i++) {
			System.out.print(ch);
		}
		System.out.println();
	}//����ȭ Ǯ��.
}

public class ThreadEx5 {
	public static void main(String[] args) {
		Printer prt = new Printer(); //�ϳ� ����.
		Thread t1 = new PrintThread3(prt,'A');
		Thread t2 = new PrintThread3(prt,'B');
		Thread t3 = new PrintThread3(prt,'C');
		t1.start();t2.start();t3.start();
	}
}
