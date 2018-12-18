package chap16;

import java.util.ArrayList;
import java.util.List;

/*
 * 1���� 500������ ���� ���ϱ�.
 * t1 : 1���� 100������ ��
 * t2 : 101���� 200������ ��.
 * t3 : 201���� 300������ ��.
 * t4 : 301���� 400������ ��.
 * t5 : 401���� 500������ ��.
 * main Thread : t1.join();t2.join();t3.join();t4.join();t5.join();
 * 				 join() : t1 Thread�� ������ ������ main Thread ��� ����.
 * 						  ��� �������� ���� ���ؼ� 1~ 500������ �� ����ϱ�.
 */

class sumThread extends Thread {
	int begin,end,sum;
	public sumThread(int begin, int end) {
		this.begin = begin;
		this.end = end;
	}
	
	public void run() {
		for(int i=begin;i<=end;i++) {
			sum+=i;
			
		}
		System.out.println(begin +"���� " + end +"������ ��: "+sum);
		try {
			sleep(1000);
		} catch (InterruptedException e) { }
	}
}
public class Exam1 {
	public static void main(String[] args) throws Exception {
	System.out.println("main Thread ����");
	sumThread t1 = new sumThread(1,100);
	sumThread t2 = new sumThread(101,200);
	sumThread t3 = new sumThread(201,300);
	sumThread t4 = new sumThread(301,400);
	sumThread t5 = new sumThread(401,500);
	//.start() : ����ȯ������ �����.
	t1.start();	t1.join();
	t2.start();	t2.join();
	t3.start();	t3.join();
	t4.start();	t4.join();
	t5.start();	t5.join();
	System.out.print("��� ��");
	for(int i=0;i<5;i++) {
		Thread.sleep(700);
		System.out.print('.'+((i==4)?"\n":""));
	}
	System.out.println("1���� 500������ ���� " +(t1.sum+t2.sum+t3.sum+t4.sum+t5.sum));
	Thread.sleep(1000);
	System.out.println("main Thread ����");
	}
}
