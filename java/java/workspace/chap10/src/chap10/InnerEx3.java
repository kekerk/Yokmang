package chap10;
/*
 * ����Ŭ�������� ���Ǵ� this�� ����Ŭ������ ��ü�� ���Ѵ�.
 */

class Outer3 {
	int iv = 10;
	int iv2= 20;
	class InstanceInner{
		int iv = 100;
		void method1() {
			int iv = 200;
			System.out.println("iv="+iv); //200
			System.out.println("iv="+this.iv); //100
			//�ܺ� Ŭ������ ��� ���� ȣ��
	     	System.out.println("Outer3.this.iv="+Outer3.this.iv); //�ܺ�Ŭ������.this.�������  10
		}
	}
}
public class InnerEx3 {
	public static void main(String[] args) {
		Outer3 out = new Outer3();
		Outer3.InstanceInner ii = out.new InstanceInner();
//		Outer3.InstanceInner ii = new Outer3().new InstanceInner();
		ii.method1();
		
		
	}
}
