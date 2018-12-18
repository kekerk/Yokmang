package chap18;
/*
 * ���� ��ü ������ this, �������� ó��.
 * ���� ��ü�� ���� Ŭ������ ��ü�̹Ƿ� this�� ���ٰ�ü�� �ǹ��ϰ�,
 *          �ܺ� Ŭ������ ��� ���ٽ� �ܺ�Ŭ������.this.������.
 */
interface LambdaInterface4 {
	void method();
}
public class LambdaEx5 {
	public int iv = 10;
	void method() {
		LambdaInterface4 f4 = () -> {
			int iv = 100; //��������
			// �Լ� ��ü���� �ܺ�Ŭ������ ��� ������ �����ϱ�:
			// 1. �ܺ�Ŭ������.this.�����
			// 2. this.�����
			System.out.println("LambdaEx5.this.iv: " + LambdaEx5.this.iv);  //10
			System.out.println("this.iv: "+this.iv); // �Լ���ü�̱� ������ �ٸ� ����� ����.  //10
			System.out.println("iv: "+iv);//100
		};
		f4.method();
	}
	void method(int pv) {
		// �Լ� ��ü���� �ܺ� �޼����� ���������� �����ϱ� ���ؼ��� ���������� ���ȭ �Ǿ�� �Ѵ�.
		// pv += 200;
		int pv1= pv; 
		LambdaInterface4 f4 = () -> { //���� ������ ���ȭ��Ű�� ������ ���� Ŭ������ ���� �� �� ����.
			System.out.println("LambdaEx5.this.iv: " + LambdaEx5.this.iv); //10
			System.out.println("this.iv: "+this.iv); //10
			System.out.println("iv: "+iv); //10
			System.out.println("pv: "+pv1); //200
		};
		f4.method();
	}
	public static void main(String[] args) {
		LambdaEx5 lb = new LambdaEx5();
		lb.method();
		lb.method(200);

	}
}
