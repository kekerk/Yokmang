package chap8;
/*
 * 부모클래스와 자손클래스가 동일한 멤버를 소유하고 있을 때. 
 * 
 * 멤버변수는 참조변수의 타입에 따르고, 
 * 멤버메서드는 객체에 최종 오버라이딩된 메서드가 호출된다.
 */
class Parent3{
	int x =10;
	void method() {
		System.out.println("Parent 메서드");
	}
}

class Child3 extends Parent3 {
	int x = 20;
	void method() {
		System.out.println("Child 메서드");
	}
}
public class BindingEx1 {
	public static void main(String[] args) {
		Parent3 p = new Child3(); 
		System.out.println(p.x); //10
		p.method();
		Child3 c = (Child3) p;
		System.out.println(c.x); //20
		c.method();
	}
}
