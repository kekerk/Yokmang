package chap10;
/*
 * ����Ŭ������ �ܺ�Ŭ������ ��� �� �ϳ���.
 * �ܺ�Ŭ������ private ����� ���� ����.
 */
class Outer2{
	private int outeriv = 10;
	private static int outercv = 20;
	class InstanceInner{
		int iiv = outeriv;
		int iiv2 = outercv;
	}
	static class StaticInner{ //Ŭ���� ��� - Ŭ����ȭ�� ��Ȯ�� �Ǿ�� �ϹǷ� outeriv�� ���� ��Ȯ�� �ʱ�ȭ�Ͽ����Ѵ�.
//		int siv = outeriv; ����
		int siv = new Outer2().outeriv; 
		static int scv = outercv;
	}
	
	static StaticInner cv = new StaticInner();
	InstanceInner iv = new InstanceInner();
//	static InstanceInner cv2 = new InstanceInner(); ����
	static InstanceInner cv2 = new Outer2().new InstanceInner();
	
	//�ܺ� Ŭ������ ��� �޼���
	void method(int pv) {
     	// pv = 100;
		final int num = 100; //���ȭ.
		class LocalInner { // ���� ���� Ŭ����
			int liv = outeriv;
			int liv2 = outercv;
			void method() { //���� ���� Ŭ������ ��� �޼���
				/*
				 *  �ܺ� �޼����� ���������� ���� ����Ŭ�������� �����Ϸ��� ���ȭ�Ǿ�� �Ѵ�.
				 *  ���ȭ : ����Ǹ� �ȵ�. final�� �ٿ� �����ϰ� �ʱ�ȭ��Ų��.
				 */
				System.out.println("pv="+pv);
				System.out.println("num="+num);
				System.out.println(liv+","+liv2);
				System.out.println(outeriv+","+outercv); //outercv :�ܺ� Ŭ������ private ���
			}
		}
		LocalInner li = new LocalInner();
		li.method();
	}
	
}
public class InnerEx2 {
	public static void main(String[] args) {
		Outer2 outer = new Outer2(); //�ܺ� Ŭ������ ��ü ���� �� �ʱ�ȭ.
		outer.method(1);
		// 1. InstanceInner Ŭ������ ��ü �����ϰ�, ��� ���� ����ϱ�.
		Outer2.InstanceInner ii = outer.new InstanceInner();
		System.out.println(ii.iiv);
		System.out.println(ii.iiv2);
		// 2. StaticInner Ŭ������ ��ü �����ϰ�, ��� ���� ����ϱ�.
		Outer2.StaticInner si = new Outer2.StaticInner();
		System.out.println(si.siv);
		System.out.println(si.scv);
		
		
	}
}
