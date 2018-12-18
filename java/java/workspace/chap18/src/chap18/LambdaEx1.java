package chap18;
/*
 *  람다식 예제 : jdk 8.0 이후 버전에서 추가됨.
 *  FunctionalInterface : 인터페이스의 멤버가 추상메서드가 한개인 인터페이스
 *  
 *  매개변수도 없고, 리턴타입도 없는 경우.
 *  
 */

@FunctionalInterface
interface LambdaInterface1{
	void method(); //리턴타입 없음. 매개변수 없음.
	
}
public class LambdaEx1 {
	public static void main(String[] args) {
		LambdaInterface1 f1;
		// 매개변수도 없고 리턴타입도 없는 경우.
		f1 = () -> { //내부클래스와 같은 형태로 쓴다.
			String str = "method call (1)";
			System.out.println(str);
		};
		
		f1.method();
		/////////////////////////////////////////////////
		
		f1 = () -> {		
			System.out.println("method call (2)");
		};
		f1.method();
		
		execute(f1); // f1.method()를 실행한다.
		execute(()-> {System.out.println("method call (3)");}); //f1 대신 그 뒷 부분을 집어넣는다.
		execute(()-> {System.out.println("method call (4)");});
	}
	// f1 = () -> {                   } 이므로 f1대신  ()-> { 조건문 }; 을 집어넣을 수 있다.
	static void execute(LambdaInterface1 f) {
		f.method();
	}
}
