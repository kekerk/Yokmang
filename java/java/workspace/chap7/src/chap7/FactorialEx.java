package chap7;
// 예제 7-3 : 재귀함수 연습
//재귀함수란 자신의 메서드를 다시 호출하는 함수를 말한다.
public class FactorialEx {
	
	public static void main(String[] args) {
	System.out.println("4!="+ new FactorialEx().factorial(4));
	}
	private int factorial(int i) {
		return (i==1)? 1: factorial(i-1)*i;
	}

}
