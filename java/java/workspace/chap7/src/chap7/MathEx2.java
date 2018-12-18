package chap7;
/*
 * 클래스 메서드 : static 예약어 존재
 * 			   클래스 정보가 로드되면 바로 메서드의 호출이 가능
 * 			  클래스명.메서드면() 호출됨
 * 
 *  인스턴스 메서드 : 객체화가 되어야 메서드의 호출이 가능.
 *  			 참조변수명.메서드명() 호출됨.
 */
class Math2{
	long a,b;
	long add1() {
		return a+b;
	}
	static long add2(int a, int b) {
		return a+b;
	}
	
}
public class MathEx2 {

	public static void main(String[] args) {
	//System.out.println(Math2.add1(10,20)); //오류. 객체화를 한 뒤 해야한다.
		Math2 m = new Math2();
		m.a=10;
		m.b=20;
		System.out.println(m.add1());
	System.out.println(Math2.add2(10, 20));
	}

}
