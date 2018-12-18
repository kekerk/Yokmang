package chap18;


@FunctionalInterface
interface LambdaInterface2{
	void method(int x); //리턴타입 없고, 매개변수 있음.
	
}
public class LambdaEx2 {
	public static void main(String[] args) {
		LambdaInterface2 f2;
		// 리턴 타입은 없으나 매개변수가 있는 경우.
		f2 = (x) -> {
			System.out.println(x);
		};
		f2.method(2);
		f2.method(20);
		// 매개변수가 1개인 경우 () 생략 가능.
		// 매개변수가 없는 경우 () 생략 불가능.
		// 실행 할 구문이 한개인 경우 {} 생략 가능.
		f2 = x -> System.out.println(x*100);
		f2.method(2); // 200
		f2.method(20); // 2000
		System.out.println();
		//람다식을 이용하여 매개변수의 값(인자)까지의 합을 구하기.
		f2 = x -> {
			int sum = 0;
			for(int i=0;i<=x;i++) {
				sum+=i;
			}
			System.out.println(sum);
		};
		f2.method(100); // 1~100까지의 합.
		f2.method(10); // 1~10까지의 합
		
		
	}
}
