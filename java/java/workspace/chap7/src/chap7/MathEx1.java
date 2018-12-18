package chap7;
/*
 * 메서드 예제
 * 메서드 구성 
 * [접근제어자] 리턴타입 메서드명 (매개변수 목록) => 선언부
 * {             ...                } => 구현부(몸통,body)
 * 
 * 리턴타입 : 메서드가 종료되면 전달할 값의 자료형 지정
 * 			void 라면 전달 할 값이 없음.
 * 매개변수목록 : 메서드가 호출될 때, 전달되는 값의 자료형과 변수명.
 * 			   매개변수는 해당 메서드이 지역변수임. 호출될 때 초기화 됨. 
 * return : 메서드의 구현부에 작성됨.
 * 			메서드 종료.
 * 			리턴타입이 void인 경우 생략이 가능.
 * 			리턴타입이 void가 아닌 경우 반드시 return을 작성해야함.
 * 			이 때 값은 리턴타입과 동일하거나, 리턴타입으로 자동형변환이 되는 자료형이어야 한다.
 */
class Math1 {
	int add1(int a, int b) { //선언부
		return a + b; //구현부 { }
	}

	long add2(int a, int b) {
		return a + b; // 메서드 종료
	}

	double add3(int a, int b) {
		return a + b; //int는 double로 자동 형변환되어서 return됨.
	}
}

public class MathEx1 {

	public static void main(String[] args) { //static이 없으면 main 메서드로서의 기능을 수행하지 못함. 객체화 시켜야 이용 가능.
		Math1 m = new Math1();
		System.out.println(m.add1(10, 20));
		System.out.println(m.add2(10, 20));
		System.out.println(m.add3(10, 20));
	}
}
