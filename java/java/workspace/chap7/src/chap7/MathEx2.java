package chap7;
/*
 * Ŭ���� �޼��� : static ����� ����
 * 			   Ŭ���� ������ �ε�Ǹ� �ٷ� �޼����� ȣ���� ����
 * 			  Ŭ������.�޼����() ȣ���
 * 
 *  �ν��Ͻ� �޼��� : ��üȭ�� �Ǿ�� �޼����� ȣ���� ����.
 *  			 ����������.�޼����() ȣ���.
 */
class Math2{
	long a,b;
	long add1() {
		return a+b;
	}
	static long add2(int a, int b) {
		return a+b;
	}
	
}
public class MathEx2 {

	public static void main(String[] args) {
	//System.out.println(Math2.add1(10,20)); //����. ��üȭ�� �� �� �ؾ��Ѵ�.
		Math2 m = new Math2();
		m.a=10;
		m.b=20;
		System.out.println(m.add1());
	System.out.println(Math2.add2(10, 20));
	}

}
