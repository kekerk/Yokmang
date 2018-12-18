package chap9;
/*
 *  jdk8.0 ���Ŀ� �߰��� ����
 *  ���� �������� �������̽��� �߻�޼���� ����� ����� ���� �� �־���.
 *  ����Ʈ �޼����  static �޼��尡 �߰� ��.
 *  -> �������̽� ������ �޼��忡 �����ΰ� �߰���.
 */
interface MyInterface1 { 
	default void method1() { //method1() ����
		System.out.println("MyInterface1�� ����Ʈ �޼��� : method1()");
	}
	default void method() {
		System.out.println("MyInterface1�� ����Ʈ �޼��� : method()");
	}
	static void staticMethod() {
		System.out.println("MyInterface1�� static �޼��� : staticMethod()");
	}
}

interface MyInterface2 {
	default void method1() { //method1() ����
		System.out.println("MyInterface2�� ����Ʈ �޼��� : method1()");
	}
	
	

	static void staticMethod() {
		System.out.println("MyInterface2�� static �޼��� : staticMethod()");
	}
}

class Parent4 {
	public void method2() {
		System.out.println("Parent Ŭ������ ��� �޼��� : method1() ");
	}
}

class Child4 extends Parent4 implements MyInterface1, MyInterface2 {
	@Override //������̼�.
	public void method1() { //������ �������̽��� method1()�� �����Ƿ� 
		System.out.println("Child4 Ŭ������ ��� �޼��� : method1()");

		MyInterface1.super.method1();
		MyInterface2.super.method1();
	}
}

public class MyInterfaceEx1 {
	public static void main(String[] args) {
		Child4 c = new Child4(); //Child4 �� ���� ��ü ����.
//		c.method();
		c.method1();
		c.method2();
		MyInterface1.staticMethod(); //�������̽���.�޼����(); ���� �������̽��� ����� �ٷ� ȣ�� ����. (Ŭ���� ���)
		MyInterface2.staticMethod(); 
	}

}
