package chap10;
/*
 * �̸� ���� ���� Ŭ���� ����
 */
interface I {
	void test();
}

abstract class Abs{
	int  x;
	abstract void testmethod();
	
}
public class InnerEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		I i = new I() {  // ��ȸ�� ��ü. �̸����� ���� Ŭ���� ����.
			public void test() {
				System.out.println("I �������̽��� test �޼��� ������.");
			}
		};
		i.test();
		Abs a = new Abs() {  //�ٸ� Ÿ������ ������ �� ����.
			void testmethod() {
				System.out.println("Abs �߻� Ŭ������ testnethod �޼��� ������. x="+x);
			}
		};   //�߻�޼��� ����. �߰�ȣ ���� �����ݷ� ���� ��.
		
		
		a.testmethod();
		Object o = (Object) i; //����ȯ ������. �ڵ� ����ȯ.
	//	o.test(); // test()�� Object�� ����� �ƴ϶� ȣ���� �ȵ�.
		o =a;
		
		
		
	}

}
