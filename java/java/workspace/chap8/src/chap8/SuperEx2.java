package chap8;

/*
 * super ������ : �θ� Ŭ������ �����ڸ� ȣ����.
 * 			 	�ڼ� Ŭ���� ��ü ���� �� �θ� Ŭ������ ��ü�� ���� ������.
 * 				�ڼջ����ڿ��� �θ�Ŭ������ ������ ȣ���Ѵ�.
 * 			 	���� �θ�Ŭ������ ������ �� �Ű������� �ִ� �����ڸ� �ִٸ�
 * 			  	�ڼ�Ŭ������ �����ڿ��� super() �����ڸ� �̿��Ͽ� �θ� Ŭ������ �����ڸ� ȣ���ؾ� �Ѵ�.
 * 
 * 		 		
 *  
 *  */			

//class A {   -----> �⺻ ������ ����.
//	super();
//}

class Parent2 {
	int x;

	Parent2(int x) { // ������ : Parent2 Ŭ������ ��ü ������ �ݵ�� �������� �Է��ؾ߸� ��.
		this.x = x;
	}
	// ��ü ���� : Parent2 p = new Parent2();   <-()�ȿ� ������ �������� �־���Ѵ�.
}

class Child2 extends Parent2 { //�⺻ ������ : 
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
