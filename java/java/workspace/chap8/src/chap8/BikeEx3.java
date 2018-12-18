package chap8;

public class BikeEx3 {

	public static void main(String[] args) {
//		Bike2 bike = new Bike2(2);
		Bike2 bike = new AutoBike2(2);
//		AutoBike2 auto = (AutoBike2)bike; //실행오류
//		auto.power();
//		auto.drive();
		
		
		/*
		 * instanceof 연산자 : 참조변수와 객체와의 관계를 알려주는 연산자
		 */
		
		if(bike instanceof Bike2) {
			System.out.println("bike가 참조하고 있는 객체는 Bike2 객체임");
		}
		if(bike instanceof AutoBike2) {
			System.out.println("bike가 참조하고 있는 객체는 AutoBike2 객체임");
		}
		if(bike instanceof Object) {
			System.out.println("bike가 참조하고 있는 객체는 Object 객체임");
		}

	}

}
