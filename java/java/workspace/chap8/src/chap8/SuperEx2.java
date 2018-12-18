package chap8;

/*
 * super 생성자 : 부모 클래스의 생성자를 호출함.
 * 			 	자손 클래스 객체 생성 시 부모 클래스의 객체를 먼저 생성함.
 * 				자손생성자에서 부모클래스의 생성자 호출한다.
 * 			 	만약 부모클래스의 생성자 중 매개변수가 있는 생성자만 있다면
 * 			  	자손클래스의 생성자에서 super() 생성자를 이용하여 부모 클래스의 생성자를 호출해야 한다.
 * 
 * 		 		
 *  
 *  */			

//class A {   -----> 기본 생성자 형태.
//	super();
//}

class Parent2 {
	int x;

	Parent2(int x) { // 생성자 : Parent2 클래스의 객체 생성시 반드시 정수값을 입력해야만 함.
		this.x = x;
	}
	// 객체 생성 : Parent2 p = new Parent2();   <-()안에 무조건 정수값을 넣어야한다.
}

class Child2 extends Parent2 { //기본 생성자 : 
	int x = 20;
	 Child2() {
		super(10);
	}

	void method() {
		int x = 30;
		System.out.println(x);
		System.out.println(this.x);
		System.out.println(super.x);
	}
}

public class SuperEx2 {
	public static void main(String[] args) {
		Child2 c = new Child2(); //
		c.method();
	}

}
