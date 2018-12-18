package chap7;
class Phone{
	String color; //String의 기본값 null
	boolean power; // boolean의 기본값 false
	String no;
	/*
	 * 세 개의 멤버변수(속성) : color, power, no //인스턴스 변수
	 * 세 개의 멤버 메서드(기능) 인스턴스 메서드
	 * power() : 파워를 키거나 끄는 동작
	 * send() : 
	 * receive() :
	 */
	
	
	void power() {power = !power;}
	void send(String no) {
		// no : 매개변수, 지역변수.
		//      지역변수와 멤버변수가 같은 이름이 가능함.
		//      지역변수 우선.
		System.out.println(no+ "로 전화 송신 중");  
	}
	void receive(String no) {
		System.out.println(no+"로부터 전화 수신 중");
	}
}
//구동 클래스 : main 메서드를 가지고 있는 클래스  ex: 구동 클래스를 만들어라.
public class PhoneEx1 {
	public static void main(String[] args) {
		Phone p1 =  new Phone(); //객체화, 인스턴스화  
		/*
		 *  new 연산자 : 객체의 할당 기능
		 *  1. 힙영역에 메모리 할당.
		 *  2. 기본값으로 초기화
		 *  	참조변수 : null
		 *   	boolean: false
		 *   	숫자 : 0
		 *   	문자 : \u0000
		 *  3. 생성자 호출
		 *  
		 *  p1 : 참조변수,  참조된 주소에 저장된 메모리 안의 값들을 가져온다.
		 */
		p1.color = "검정";
		p1.power = true;
		p1.no = "01012341234";
		System.out.println(p1.color+","+p1.power+","+p1.no);
		p1.send("01012345678");
		p1.receive("01012345678");
		Phone p2 = new Phone();
		System.out.println(p1.color+","+p1.power+","+p1.no);
		System.out.println(p2.color+","+p2.power+","+p2.no);
		p2 = p1;  //2개의 참조변수가 하나의 객체를 잡고 있다.
		System.out.println(p2.color+","+p2.power+","+p2.no);
		p1.power();
		System.out.println(p2.color+","+p2.power+","+p2.no);
		System.out.println(p1.color+","+p1.power+","+p1.no);
		p2 = new Phone();
		System.out.println(p2.color+","+p2.power+","+p2.no);
	}

}
