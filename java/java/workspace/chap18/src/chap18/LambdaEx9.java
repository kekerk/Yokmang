package chap18;

import java.util.function.IntBinaryOperator;

/*
 * Operator 인터페이스 예제
 * 매개변수, 리턴값 존재.
 * IntBinaryOperator : 매개변수 int 2개, int 리턴 타입.
 * 
 * 
 */
public class LambdaEx9 {
	private static int[] score = {92,95,87,100,50,60};
	private static int maxOrmin(IntBinaryOperator op) { // System.out.println(maxOrmin((a,b)->	(a<=b)? a:b	)); op 객체는 두 수중 작은 값을 전달해주는 기능으로 바뀜.
		//result = 92
		int result = score[0];
		for(int s : score) {
			result = op.applyAsInt(result, s);
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.print("최대점수:");
//		System.out.println(maxOrmin((a,b)->{
//			if(a>=b) return a;
//			else return b;
//		}));
		
		IntBinaryOperator op = (a,b) -> {
			if(a>=b) return a;
			else return b;
		};
		
		int max = maxOrmin(op);
		System.out.println(max);
		System.out.print("최소점수");
		System.out.println(maxOrmin((a,b)->	(a<=b)? a:b	));
	}
}
