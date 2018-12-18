package chap3;

public class VarEx1 {

	public static void main(String[] args) {
		//정수형 : 소수점 이하 저장 불가
		// 자료형의 저장 범위를 넘을 수 없다
		byte b1 = -22; //1바이트 b1 변수 선언하고, -22값을 저장
		short s1 = -220; //2바이트 s1 변수 선언하고, -220값을 저장
		int i1 = 100; //4바이트 i1 변수 선언하고, 100값을 저장
		long l1 = 1000; //8바이트 l1 변수 선언하고, 1000값을 저장
		System.out.println("b1="+b1);
		System.out.println("s1="+s1); //출력문
		System.out.println("i1="+i1);
		System.out.println("l1="+l1);
		//실수형 : 소숫점 이하 저장 가능
		// 실수 리터널은 기본형이 double
		float f1 = 0.1f;//뒤에 f를 붙여줘야 error가 나지 않음 -> 접미사 f
		double d1 = 10.5d;
		System.out.println("f1="+f1);
		System.out.println("d1="+d1);
		/*
		 * 숫자형 리터널에 붙는 자료형 접미사
		 * F,f : float 형 리터널
		 * D,d : double 형 리터널
		 * L,l : long 형 리터널
		 */
	}

}
