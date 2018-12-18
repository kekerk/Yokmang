package chap8;

/*
 * package �� : Ŭ������ ����.
 * Ŭ������ �̸��� ��Ű������ �����Ѵ�.
 * package ������ ������ ó���� �ѹ��� �����ϴ�. => �ϳ��� ���Ͽ� �ִ� ��� Ŭ������ ���� ��Ű���� ���� Ŭ������.
 * import : ��Ű������ ������ �� �ֵ��� �̸� ���� Ŭ������ ��Ű���� ���� �������ִ� ���.
 * 
 * Ŭ���� ��� �� ��Ű������ ������ �� �ִ� ���.
 * 1. ���� ��Ű���� ���� Ŭ������ ��Ű�� �� ������ �� �ִ�.
 * 2. java.lang ��Ű���� ���� Ŭ������ ��Ű������ �����ص� �ȴ�.
 * 		ex) String, System ���.
 * 3. import�� ����� Ŭ������ ��Ű������ �����ص� �ȴ�.
 * 
 * ���� ������ : private < (default) < protected < public
 * 
 * �������, ��� �޼���(������) : private, (default), protected, public
 * 		                  Ŭ����      : (default),public 
 */
import chap8.packtest.Pack1;

class Pack2 extends Pack1 { // chap8.Pack2 �ֳ� chap8�� �����ֱ� ����
	private int v1 = 100; // ���� Ŭ���� �������� ����. ���� ���� ����.
	int v2 = 100; // ���� ��Ű�� �������� ������ �����.

	public void method() { // �������̵��Ǿ� �־ ���������ڵ� �θ�Ŭ������ �޼���� �������� ���ų� ũ�� ���־���Ѵ�.
		System.out.println("chap8.Pack2 Ŭ������ method() ��"); // java.lang.System. ~~~
		System.out.println("v1=" + v1);
		System.out.println("v2=" + v2);
		System.out.println("v3=" + v3);
		System.out.println("v4=" + v4);
	}
}

public class PackageEx1 { // chap8.PackageEx1

	public static void main(String[] args) {
		// chap8.packtest.Pack1 p2 = new chap8.packtest.Pack1();
		Pack1 p1 = new Pack1(); // ��üȭ
		p1.method();
		Pack2 p2 = new Pack2(); // ���� ��Ű�� �ȿ� �ִ� Ŭ������ ���� ����
		p2.method();
		p2.v2 = 200; //���� Ŭ������ �����־ ������ ���� �ʴ´�.
//		p2.v3 = 200; //�ٸ� ��Ű���� ���ϴµ� ��Ӱ��谡 �ƴ϶� ������ ����.  �ٸ� ��Ű���� ���� Ŭ������ ��� ���� �ȵ�.
		p2.v4 = 200;
		// p2.v1 = 200; //private ����� �ٸ� Ŭ�������� ���� �ȵ�.
		
		
//		Math m = new Math(); //Math Ŭ������ �������� ���������ڰ� private��.
							 // ��ü ���� �Ұ�. ���� : ��� ����� static��.

	}

}
