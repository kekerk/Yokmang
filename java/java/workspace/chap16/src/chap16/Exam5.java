package chap16;

import java.util.ArrayList;
import java.util.List;

/*
 *  생산자 Thread, 소비자 Thread 문제
 *  CarMarket 클래스 : 자동차 판매 영업소. (공유 객체)
 *  	멤버 변수 : List<String> carList;
 *  	멤버 메서드 : 
 *  		String getCar() : 임의의 자동차를 선택하여 리턴.
 *  		synchronized String push() : carList변수에 저장.
 *  		synchronized String pop() : carList변수에서 첫번째 자동차 리턴. 및 제거.
 * 		
 * 	Seller 클래스 : 판매원. Thread 상속.
 * 		멤버메서드 : run() 
 * 			       carList에 객체가 존재하면 pop 메서드 호출하기.
 * 				   carList에 객체가 없으면 wait()
 * 					0~2초동안 임의로 sleep()
 * 
 *  Producer 클래스 : 자동차 공급자. Thread 상속.
 *  	멤버메서드 : run() 
 *                 push() 메서드 호출하여 carList에 객체를 add함.
 *                 carList에 객체가 존재하면 notifyAll() 함.
 *                 0~5초동안 임의로 sleep()
 *  
 */
class CarMarket { //공유 객체
	List<String> carList = new ArrayList<String>();
	// 임의의 자동차를 선택하여 리턴.
	String getCar() {
		String[] car = { "소나타", "아반떼", "그랜저", "산타페", "제네시스" };
		return car[(int) (Math.random() * car.length)];
	}
	// carList 변수에 저장.
	synchronized String push() {
		String car = getCar();
		carList.add(car);
		notifyAll();
		System.out.println(Thread.currentThread().getName() + ":" + car + "입고됨.");
		return car;
	}
	// carList변수에서 첫번째 자동차 리턴 및 제거.
	synchronized String pop() {
		while (carList.size() == 0) {
			try {
				wait();// wait: 
			} catch (InterruptedException e) {
			}
		}
		System.out.println(Thread.currentThread().getName() + ":" + carList.get(0) + "자동차가 판매됨.");
		return carList.remove(0);
	}
}
class Seller extends Thread {
	CarMarket market;
	Seller(CarMarket market) {
		super("판매원 Thread");
		this.market = market;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			market.pop();
			try {
				sleep((int) (Math.random() * 2000));
			} catch (InterruptedException e) {
			}
		}
	}
}

class Producer extends Thread {
	CarMarket market;
	Producer(CarMarket market) {
		super("자동차 공급자 Thread");
		this.market = market;
	}
	public void run() {
		for (int i = 0; i < 10; i++) {
			market.push();
			try {
				sleep((int) (Math.random() * 3000));
			} catch (InterruptedException e) {

			}
		}
	}
}
public class Exam5 {
	public static void main(String[] args) {
	CarMarket m1 = new CarMarket();
	Thread t1 = new Seller(m1);
	Thread t2 = new Producer(m1);
	t1.start();
	t2.start();
	}
}
