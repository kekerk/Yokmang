package chap16;

import java.util.ArrayList;
import java.util.List;

/*
 * 1부터 500까지의 합을 구하기.
 * t1 : 1부터 100까지의 합
 * t2 : 101부터 200까지의 합.
 * t3 : 201부터 300까지의 합.
 * t4 : 301부터 400까지의 합.
 * t5 : 401부터 500까지의 합.
 * main Thread : t1.join();t2.join();t3.join();t4.join();t5.join();
 * 				 join() : t1 Thread가 종료할 때까지 main Thread 대기 상태.
 * 						  모든 스레드의 합을 더해서 1~ 500까지의 합 출력하기.
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
		System.out.println(begin +"부터 " + end +"까지의 합: "+sum);
		try {
			sleep(1000);
		} catch (InterruptedException e) { }
	}
}
public class Exam1 {
	public static void main(String[] args) throws Exception {
	System.out.println("main Thread 시작");
	sumThread t1 = new sumThread(1,100);
	sumThread t2 = new sumThread(101,200);
	sumThread t3 = new sumThread(201,300);
	sumThread t4 = new sumThread(301,400);
	sumThread t5 = new sumThread(401,500);
	//.start() : 병렬환경으로 만들기.
	t1.start();	t1.join();
	t2.start();	t2.join();
	t3.start();	t3.join();
	t4.start();	t4.join();
	t5.start();	t5.join();
	System.out.print("계산 중");
	for(int i=0;i<5;i++) {
		Thread.sleep(700);
		System.out.print('.'+((i==4)?"\n":""));
	}
	System.out.println("1부터 500까지의 합은 " +(t1.sum+t2.sum+t3.sum+t4.sum+t5.sum));
	Thread.sleep(1000);
	System.out.println("main Thread 종료");
	}
}
