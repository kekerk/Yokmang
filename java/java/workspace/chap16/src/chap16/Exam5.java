package chap16;

import java.util.ArrayList;
import java.util.List;

/*
 *  ������ Thread, �Һ��� Thread ����
 *  CarMarket Ŭ���� : �ڵ��� �Ǹ� ������. (���� ��ü)
 *  	��� ���� : List<String> carList;
 *  	��� �޼��� : 
 *  		String getCar() : ������ �ڵ����� �����Ͽ� ����.
 *  		synchronized String push() : carList������ ����.
 *  		synchronized String pop() : carList�������� ù��° �ڵ��� ����. �� ����.
 * 		
 * 	Seller Ŭ���� : �Ǹſ�. Thread ���.
 * 		����޼��� : run() 
 * 			       carList�� ��ü�� �����ϸ� pop �޼��� ȣ���ϱ�.
 * 				   carList�� ��ü�� ������ wait()
 * 					0~2�ʵ��� ���Ƿ� sleep()
 * 
 *  Producer Ŭ���� : �ڵ��� ������. Thread ���.
 *  	����޼��� : run() 
 *                 push() �޼��� ȣ���Ͽ� carList�� ��ü�� add��.
 *                 carList�� ��ü�� �����ϸ� notifyAll() ��.
 *                 0~5�ʵ��� ���Ƿ� sleep()
 *  
 */
class CarMarket { //���� ��ü
	List<String> carList = new ArrayList<String>();
	// ������ �ڵ����� �����Ͽ� ����.
	String getCar() {
		String[] car = { "�ҳ�Ÿ", "�ƹݶ�", "�׷���", "��Ÿ��", "���׽ý�" };
		return car[(int) (Math.random() * car.length)];
	}
	// carList ������ ����.
	synchronized String push() {
		String car = getCar();
		carList.add(car);
		notifyAll();
		System.out.println(Thread.currentThread().getName() + ":" + car + "�԰��.");
		return car;
	}
	// carList�������� ù��° �ڵ��� ���� �� ����.
	synchronized String pop() {
		while (carList.size() == 0) {
			try {
				wait();// wait: 
			} catch (InterruptedException e) {
			}
		}
		System.out.println(Thread.currentThread().getName() + ":" + carList.get(0) + "�ڵ����� �Ǹŵ�.");
		return carList.remove(0);
	}
}
class Seller extends Thread {
	CarMarket market;
	Seller(CarMarket market) {
		super("�Ǹſ� Thread");
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
		super("�ڵ��� ������ Thread");
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
