package chap10;
/*
 * 열거형:
 */


public class EnumEx1 {
	public enum Car{
		AVANTE,SONATA,GRANDURE,SM3
	}
	public static void main(String[] args) {
		Car car = Car.AVANTE;
		System.out.println("My Car :"+car);
		System.out.println("소나타:"+Car.SONATA);
		car = Car.GRANDURE;
		System.out.println("My Car :"+car);
		car = Car.SM3;
		// Car 객체임
		if(car instanceof Object) {
			System.out.println(car.toString());
			System.out.println(car.getClass().getName());
		}
		
		 Car[] cars = Car.values();  // Car 객체들을 모두 넘겨주는 것.
		 for(Car c : cars) {
			 System.out.println(c+":"+c.ordinal());//ordinal() : 객체에 담긴 값들을 순서를 매김.
		 }
	}

}
