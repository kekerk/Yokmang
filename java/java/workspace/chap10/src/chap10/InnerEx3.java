package chap10;
/*
 * 내부클래스에서 사용되는 this는 내부클래스의 객체를 말한다.
 */

class Outer3 {
	int iv = 10;
	int iv2= 20;
	class InstanceInner{
		int iv = 100;
		void method1() {
			int iv = 200;
			System.out.println("iv="+iv); //200
			System.out.println("iv="+this.iv); //100
			//외부 클래스의 멤버 변수 호출
	     	System.out.println("Outer3.this.iv="+Outer3.this.iv); //외부클래스명.this.멤버변수  10
		}
	}
}
public class InnerEx3 {
	public static void main(String[] args) {
		Outer3 out = new Outer3();
		Outer3.InstanceInner ii = out.new InstanceInner();
//		Outer3.InstanceInner ii = new Outer3().new InstanceInner();
		ii.method1();
		
		
	}
}
