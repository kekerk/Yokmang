package chap3;
//형변환예제 casting
//기본자료형 8가지 중 boolean을 제외한 7가지는 형변환이 가능하다.
// 크기순 나열
// byte < short,char < int < long < float < double 큰쪽에서 작은 쪽으로 들어갈 때는 명시적형변환, 형변환 연산자 사용해야 함.
//char
public class VarEx3 {

	public static void main(String[] args) {
		byte b1 = 10;
		short s1 = 20;
		int i1 =30;
		long l1 = 40;
		i1 = b1; // i1 = (int) b1. 자동 형변환. 1byte가 4byte로 변환되므로 자료형 생략 가능.
		s1 = (short) l1; // 형변환 연산자(short)를 이용하여 값이 유실되는 것을 방지. 명시적형변환
		float f = l1; // float > long 타입보다 큰 자료형임. 자동형변환
		byte b2 = (byte) 300;
		System.out.println("b2="+b2); //44
		short s2 =65;
		char c1= (char) s2;
		System.out.println("c1="+c1);
		// TODO Auto-generated method stub

	}

}
