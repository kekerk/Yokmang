package chap7;

/*
 * this 예약어 
 * this 생성자 : 동일 클래스의 다른 생성자 호출 시 사용함
 * 			    반드시 생성자의 첫줄에 작성해야 한다.
 * 			  
 * this 참조변수 : 자기참조변수. 현재 객체를 참조한 참조변수.
 * 				인스턴스 메서드에 지역변수로 생성됨.
 * 		        인스턴스메서드 내부에서만 사용이 가능함.
 */			
class Car2 {
	String color;
	int number;

	Car2(String color, int number) {
		this.color = color;
		this.number = number;
	}
	Car2(String c) {
		// this 이전에 다른 것을 넣으면 this 실행이 안됨. 반드시 첫줄에 작성.
		this(c, 1);
	}
	Car2(int n) {
		this("white", n);
	}
	Car2(Car2 c) {
		this(c.color, c.number);
	}
	Car2() {
		this("white", 1);
	}
	public String toString() {
		return color + "," + number;
	}
}

public class ThisEx1 {

	public static void main(String[] args) {
		Car2 c1 = new Car2();
		Car2 c2 = new Car2("blue", 1234);
		Car2 c3 = new Car2("red");
		Car2 c4 = new Car2(2);
		Car2 c5 = new Car2(c1);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		
	

	}

}
