package chap18;

import java.util.function.IntBinaryOperator;

/*
 * Operator �������̽� ����
 * �Ű�����, ���ϰ� ����.
 * IntBinaryOperator : �Ű����� int 2��, int ���� Ÿ��.
 * 
 * 
 */
public class LambdaEx9 {
	private static int[] score = {92,95,87,100,50,60};
	private static int maxOrmin(IntBinaryOperator op) { // System.out.println(maxOrmin((a,b)->	(a<=b)? a:b	)); op ��ü�� �� ���� ���� ���� �������ִ� ������� �ٲ�.
		//result = 92
		int result = score[0];
		for(int s : score) {
			result = op.applyAsInt(result, s);
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.print("�ִ�����:");
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
		System.out.print("�ּ�����");
		System.out.println(maxOrmin((a,b)->	(a<=b)? a:b	));
	}
}
