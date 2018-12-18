package chap7;
/*	선언 위치에 따른 변수의 종류
 *   		  선언위치		  선언방법			메모리할당위치       메모리생성시기
 * 클래스 변수   클래스 내부  static int cv		 클래스영역          클래스정보 로드 시
 *   ->  객체화 필요 없음, 클래스정보 로드시 클래스 영역에 메모리 할당.
 *   	 클래스명.변수명 사용.   ex) Sonata.width
 *  	 해당 클래스의 모든 객체의 공통 변수로 사용.
 * 인스턴스 변수 클래스 내부        int iv			 힙영역               객체화 시
 *   ->  객체화시 힙 영역에 메모리 할당.
 * 		 참조변수명.변수명 사용됨.
 * 		 객체별로 다른 메모리영역으로 할당됨. ex) car1.color, car2.color 
 * 지역변수       메서드 내부	 int ㅣv  		 스택영역  		  선언문실행시     (매개변수 포함)
 *   ->  매개변수도 지역변수임.
 * 		 선언된 메서드에서만 사용이 가능하다.
 * 		 메서드 종료시 함께 변수영역도 소멸됨.
 * 		 반드시 초기화 되어야 함.
 */
class Sonata {
	String color; //인스턴스 변수
	int number; //인스턴스 변수
	static int width = 250; //클래스 변수
	static int height = 150; //클래스 변수
	public String toString() {
		return color + ":" + number + "(" + width + "," + height+")";
	}
}
public class SonataEx1 {

	public static void main(String[] args) {
		System.out.println("자동차의 크기: "+ Sonata.width + ","+ Sonata.height);
		Sonata car1 = new Sonata(); //
		car1.color = "white";
		car1.number = 1234;
		System.out.println("car1="+car1);
		Sonata car2 = new Sonata();
		car2.color = "black";
		car2.number = 3456;
		System.out.println("car2="+car2);
		
//		car1.width = 50;
//		car1.height = 30;
		Sonata.width = 50;
		Sonata.height = 30;  // 모든 Sonata 객체가 영향을 받는다.
		System.out.println("car1="+car1);
		System.out.println("car2="+car2);

	}

}
