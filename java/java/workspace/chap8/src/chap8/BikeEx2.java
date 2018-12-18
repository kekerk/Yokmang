package chap8;
/*
 *  다형성 예제 : 다형성은 참조변수의 형변환
 *  		  부모타입의 참조변수로 자손타입의 객체를 참조할 수 있다.
 *  		 객체는 참조변수의 타입만큼의 멤버만 접근이 가능하다.
 *  		 
 * 	Object 클래스는 모든 클래스의 부모 클래스다.
 *  모든 클래스의 객체 내부에는 Object 클래스의 객체를 포함한다.
 *  
 *  모든 클래스의 객체는 Object 클래스 형의 참조변수로 참조가 가능하다.
 *  모든 클래스의 객체는 Object 클래스의 멤버에 접근할 수 있다. 
 */

class Bike2{
	int wheel;
	Bike2(int wheel){
		this.wheel = wheel;
		
	}
	void drive() {
		System.out.println("움직인다.");
	}
	void stop() {
		System.out.println("멈춘다.");
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
			System.out.println("전원이 켜졌습니다.");
		}
		else {
			System.out.println("전원이 꺼졌습니다.");
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
		System.out.println("바퀴"+auto1.wheel+"개가 굴러간다.");
		auto1.stop();
		bike = auto1;
//		bike.power(); // 오류 power() 멤버는 Bike2 타입의 멤버가 아니다.
		bike.drive();
		auto2 = (AutoBike2)bike;
		auto2.power();
		auto2.drive();
		auto2.stop();
		Object obj = auto1; //autobike2와 bike2의 멤버 변수를 이용할 수 없다.

	}
}
