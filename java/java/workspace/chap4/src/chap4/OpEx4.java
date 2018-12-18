package chap4;
//부호연산자: +,-값의 부호 지정하는 연산자
// + : 피연산자의 부호 유지
// - : 피연산자의 부호 반대
public class OpEx4 {

	public static void main(String[] args) {
		int x = -8;
		System.out.println("x="+ +x); // -8
		System.out.println("x="+ -x); // 8
		x = 8;
		System.out.println("x="+ +x); // 8
		System.out.println("x="+ -x); // -8
		

	}

}
