package chap8;
/*
 *  ������ ���� : �������� ���������� ����ȯ
 *  		  �θ�Ÿ���� ���������� �ڼ�Ÿ���� ��ü�� ������ �� �ִ�.
 *  		 ��ü�� ���������� Ÿ�Ը�ŭ�� ����� ������ �����ϴ�.
 *  		 
 * 	Object Ŭ������ ��� Ŭ������ �θ� Ŭ������.
 *  ��� Ŭ������ ��ü ���ο��� Object Ŭ������ ��ü�� �����Ѵ�.
 *  
 *  ��� Ŭ������ ��ü�� Object Ŭ���� ���� ���������� ������ �����ϴ�.
 *  ��� Ŭ������ ��ü�� Object Ŭ������ ����� ������ �� �ִ�. 
 */

class Bike2{
	int wheel;
	Bike2(int wheel){
		this.wheel = wheel;
		
	}
	void drive() {
		System.out.println("�����δ�.");
	}
	void stop() {
		System.out.println("�����.");
	}
}

class AutoBike2 extends Bike2{
	boolean power;
	AutoBike2(int wheel){
		super(wheel);
	}
	void power() {
		power = !power;
		if(power) {
			System.out.println("������ �������ϴ�.");
		}
		else {
			System.out.println("������ �������ϴ�.");
		}
	}
}
public class BikeEx2 {
	public static void main(String[] args) {
		AutoBike2 auto1 = new AutoBike2(2);
		AutoBike2 auto2;
		Bike2 bike;
		auto1.power();
		auto1.drive();
		System.out.println("����"+auto1.wheel+"���� ��������.");
		auto1.stop();
		bike = auto1;
//		bike.power(); // ���� power() ����� Bike2 Ÿ���� ����� �ƴϴ�.
		bike.drive();
		auto2 = (AutoBike2)bike;
		auto2.power();
		auto2.drive();
		auto2.stop();
		Object obj = auto1; //autobike2�� bike2�� ��� ������ �̿��� �� ����.

	}
}
