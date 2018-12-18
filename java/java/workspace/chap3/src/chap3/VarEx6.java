package chap3;

public class VarEx6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b1 = 10;
		short s1 = 20;
		int i1 =30;
		long l1 = 40;
		i1 = b1; // i1 = (int) b1. 자동 형변환. 1byte가 4byte로 변환되므로 자료형 생략 가능. 30이 사라지고 10이 저장
		s1 = (short) l1; // 형변환 연산자(short)를 이용하여 값이 유실되는 것을 방지. 명시적형변환 
		float f = l1; // float > long 타입보다 큰 자료형임. 자동형변환
		System.out.println(i1);
		System.out.println(s1);
		byte b2 = (byte) 300;
		System.out.println("b2="+b2); //44
		short s2 =65;
		char c1= (char) s2;
		System.out.println("c1="+c1);
		
		System.out.println("\"안녕\"");
		System.out.println("안녕");
		char single = '\\';
		String qoato = "Hello\"홍길동 \"";
		String root = "c:\\";
		System.out.println(single);
		System.out.println(qoato);
		System.out.println(root);
		System.out.println("서울\f대구\f부산"); //tap 기능 부여
		System.out.println("안녕하세요 \n이부분은 다음줄에"); // enter 기능 부여
		System.out.println("\uD64D\uAE38\uB3D9"); // 유니코드로 쓰겠다라는 뜻.
		// TODO Auto-generated method stub

	}

}
