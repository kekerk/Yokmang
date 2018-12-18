package chap8;

/*
 * package 란 : 클래스의 모임.
 * 클래스의 이름은 패키지명을 포함한다.
 * package 설정은 파일의 처음에 한번만 가능하다. => 하나의 파일에 있는 모든 클래스는 같은 패키지에 속한 클래스다.
 * import : 패키지명을 생략할 수 있도록 미리 사용될 클래스의 패키지를 먼저 선언해주는 기능.
 * 
 * 클래스 사용 시 패키지명을 생략할 수 있는 경우.
 * 1. 같은 패키지에 속한 클래스는 패키지 명 생략할 수 있다.
 * 2. java.lang 패키지에 속한 클래스는 패키지명을 생략해도 된다.
 * 		ex) String, System 등등.
 * 3. import로 선언된 클래스는 패키지명을 생략해도 된다.
 * 
 * 접근 제어자 : private < (default) < protected < public
 * 
 * 멤버변수, 멤버 메서드(생성자) : private, (default), protected, public
 * 		                  클래스      : (default),public 
 */
import chap8.packtest.Pack1;

class Pack2 extends Pack1 { // chap8.Pack2 왜냐 chap8에 속해있기 때문
	private int v1 = 100; // 동일 클래스 내에서만 가능. 가장 좁은 범위.
	int v2 = 100; // 동일 패키지 내에서는 접근을 허용함.

	public void method() { // 오버라이딩되어 있어서 접근제어자도 부모클래스의 메서드와 범위보다 같거나 크게 해주어야한다.
		System.out.println("chap8.Pack2 클래스의 method() 임"); // java.lang.System. ~~~
		System.out.println("v1=" + v1);
		System.out.println("v2=" + v2);
		System.out.println("v3=" + v3);
		System.out.println("v4=" + v4);
	}
}

public class PackageEx1 { // chap8.PackageEx1

	public static void main(String[] args) {
		// chap8.packtest.Pack1 p2 = new chap8.packtest.Pack1();
		Pack1 p1 = new Pack1(); // 객체화
		p1.method();
		Pack2 p2 = new Pack2(); // 같은 패키지 안에 있는 클래스라 생략 가능
		p2.method();
		p2.v2 = 200; //같은 클래스에 속해있어서 에러가 나지 않는다.
//		p2.v3 = 200; //다른 패키지에 속하는데 상속관계가 아니라서 에러가 난다.  다른 패키지에 속한 클래스의 멤버 접근 안됨.
		p2.v4 = 200;
		// p2.v1 = 200; //private 멤버는 다른 클래스에서 접근 안됨.
		
		
//		Math m = new Math(); //Math 클래스의 생성자의 접근제어자가 private임.
							 // 객체 생성 불가. 이유 : 모든 멤버가 static임.

	}

}
