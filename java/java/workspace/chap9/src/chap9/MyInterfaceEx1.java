package chap9;
/*
 *  jdk8.0 이후에 추가된 내용
 *  이전 버전에서 인터페이스는 추상메서드와 상수를 멤버로 가질 수 있었음.
 *  디폴트 메서드와  static 메서드가 추가 됨.
 *  -> 인터페이스 내부의 메서드에 구현부가 추가됨.
 */
interface MyInterface1 { 
	default void method1() { //method1() 존재
		System.out.println("MyInterface1의 디폴트 메서드 : method1()");
	}
	default void method() {
		System.out.println("MyInterface1의 디폴트 메서드 : method()");
	}
	static void staticMethod() {
		System.out.println("MyInterface1의 static 메서드 : staticMethod()");
	}
}

interface MyInterface2 {
	default void method1() { //method1() 존재
		System.out.println("MyInterface2의 디폴트 메서드 : method1()");
	}
	
	

	static void staticMethod() {
		System.out.println("MyInterface2의 static 메서드 : staticMethod()");
	}
}

class Parent4 {
	public void method2() {
		System.out.println("Parent 클래스의 멤버 메서드 : method1() ");
	}
}

class Child4 extends Parent4 implements MyInterface1, MyInterface2 {
	@Override //어노테이션.
	public void method1() { //각각의 인터페이스에 method1()이 있으므로 
		System.out.println("Child4 클래스의 멤버 메서드 : method1()");

		MyInterface1.super.method1();
		MyInterface2.super.method1();
	}
}

public class MyInterfaceEx1 {
	public static void main(String[] args) {
		Child4 c = new Child4(); //Child4 에 대한 객체 생성.
//		c.method();
		c.method1();
		c.method2();
		MyInterface1.staticMethod(); //인터페이스명.메서드명(); 으로 인터페이스의 멤버를 바로 호출 가능. (클래스 멤버)
		MyInterface2.staticMethod(); 
	}

}
