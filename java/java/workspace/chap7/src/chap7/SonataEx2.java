package chap7;

// 예제 7-6 : 클래스 변수 사용 예제
class Sonata2 {
	String color;
	int number;
	int serialNo;
	static int sno;  //기본값 1?   
	static int width = 250;
	static int height = 150;
	//객체를 문자열화하는 메서드임.
	public String toString() { //main문에서 syso(변수명);
		return "자동차 고유번호:" + serialNo + "," + color + ":" + number + "(" + width + "," + height + ":자동차 생산번호=" + sno
				+ ")";
	}
}

public class SonataEx2 {

	public static void main(String[] args) {
		Sonata2 car1 = new Sonata2();
		car1.color = "white";
		car1.number = 1234;
		car1.serialNo = ++car1.sno;   //Sonata2 클래스에서 int sno로 선언하면 
 		Sonata2 car2 = new Sonata2();
		car2.color = "black";
		car2.number =2345;
		car2.serialNo = ++car2.sno;
		System.out.println(car1); // car1.toString() 이 호출됨.
		System.out.println(car2);
		Sonata2 car3 = new Sonata2();
		car3.color = "red";
		car3.number =3456;
		car3.serialNo = ++car3.sno;
		Sonata2 car4 = car3;
		System.out.println(car3);
		System.out.println(car4);
	}

}
