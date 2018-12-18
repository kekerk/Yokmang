package chap10;
/*
 * ���� Ŭ���� Ư¡
 * 1. Ŭ���� ���ο� �����ϴ� Ŭ����(��øŬ������� ��)
 * 2. �����ڷ���, ��üȭ ����. Object Ŭ������ ���� Ŭ����.
 *    ���(����, �޼���, ������) ������. 
 * 3. �ܺ�Ŭ������ �����. �ܺ�Ŭ������ private ����� ���� ����.
 * 
 * ����Ŭ���� ����
 * 1. static ���� Ŭ���� : static ��� ���� ����.
 * 2. �ν��Ͻ� ���� Ŭ���� : static ��� ���� �Ұ���. �� ��� ����.
 * 3. ���� ���� Ŭ���� : �޼��� ���ο� ����� Ŭ����. �޼��� ���ο����� Ŭ������ �ȴ�. �ٸ� �������� �� �� ����.
 * 4. ������ ���� Ŭ���� : ��ȸ�� ��ü.
 */
class Outer1 {
	//�ν��Ͻ� ���� Ŭ����
	class InstanceInner {  // �ڷ����� Outer1.InstanceInner 
		int iv = 100;
		// static int cv = 10; //Ŭ���� ����� ������ �� ����.
		final static int MAX = 200; //�� ����� ����. 
	}
	// static ���� Ŭ����
	static class StaticInner { 
		int iv = 300; //�ν��Ͻ� ���
		static int cv = 400; //Ŭ���� ���
		final static int MAX = 500; // ���
	}

	void method() {
		//���� ���� Ŭ����
		class LocalInner { 
			int iv = 600;
//			static int cv = 700; //Ŭ���� ����� ������ �� ����.
			final static int MAX = 700; //��� ����.
		}
		LocalInner lc = new LocalInner(); //��üȭ
		System.out.println(lc.iv); //600
		System.out.println(lc.MAX); //700
		System.out.println(LocalInner.MAX);
	}
	void method2() { 
//		LocalInner lc  = new LocalInner();
		// ���� ���� Ŭ������ ����� �޼��� ���ο����� ��� ����.
	}
	
}

public class InnerEx1 {
	public static void main(String[] args) {
	Outer1.StaticInner si = new Outer1.StaticInner(); //��üȭ
	System.out.println(si.iv);
	System.out.println(Outer1.StaticInner.cv);
	System.out.println(Outer1.StaticInner.MAX);
//	Outer1.InstanceInner ii = new Outer1.InstanceInner(); //���� �߻�. Outer1�� ��üȭ �Ͽ��� InstanceInner�� Ŭ����ȭ ��ų �� �ִ�.
//	Outer1.InstanceInner ii = new Outer1().new InstanceInner(); //Outer1�� ��üȭ�� ���� �� ��, ���� Ŭ���� ��üȭ	
	Outer1 out = new Outer1();
	Outer1.InstanceInner ii = out. new InstanceInner();
	System.out.println(ii.iv);
	System.out.println(Outer1.InstanceInner.MAX);
	out.method();
	}
}
