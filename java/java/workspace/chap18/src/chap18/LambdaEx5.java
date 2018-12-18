package chap18;
/*
 * 람다 객체 내부의 this, 지역변수 처리.
 * 람다 객체는 내부 클래스의 객체이므로 this는 람다객체를 의미하고,
 *          외부 클래스의 멤버 접근시 외부클래스명.this.변수명.
 */
interface LambdaInterface4 {
	void method();
}
public class LambdaEx5 {
	public int iv = 10;
	void method() {
		LambdaInterface4 f4 = () -> {
			int iv = 100; //지역변수
			// 함수 객체에서 외부클래스의 멤버 변수에 접근하기:
			// 1. 외부클래스명.this.멤버명
			// 2. this.멤버명
			System.out.println("LambdaEx5.this.iv: " + LambdaEx5.this.iv);  //10
			System.out.println("this.iv: "+this.iv); // 함수객체이기 때문에 다른 멤버가 없다.  //10
			System.out.println("iv: "+iv);//100
		};
		f4.method();
	}
	void method(int pv) {
		// 함수 객체에서 외부 메서드의 지역변수에 접근하기 위해서는 지역변수가 상수화 되어야 한다.
		// pv += 200;
		int pv1= pv; 
		LambdaInterface4 f4 = () -> { //지역 변수를 상수화시키지 않으면 내부 클래스에 접근 할 수 없다.
			System.out.println("LambdaEx5.this.iv: " + LambdaEx5.this.iv); //10
			System.out.println("this.iv: "+this.iv); //10
			System.out.println("iv: "+iv); //10
			System.out.println("pv: "+pv1); //200
		};
		f4.method();
	}
	public static void main(String[] args) {
		LambdaEx5 lb = new LambdaEx5();
		lb.method();
		lb.method(200);

	}
}
