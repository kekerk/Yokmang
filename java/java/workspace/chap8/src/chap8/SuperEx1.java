package chap8;
/*
 *  super : �θ�ü�� ����� �����ϴ� ��������.
 *  super() : �θ�Ŭ������ �����ڸ� ȣ��.
 */
class Parent {
	int x = 10;
}

class Child extends Parent {
	int x = 20;

	void method() {
		int x = 30;
		System.out.println(x); // 30
		System.out.println(this.x); // 20
		System.out.println(super.x); // 10. �θ�Ŭ������
	}
}

public class SuperEx1 {
	public static void main(String[] args) {
		Child c = new Child();
		/*
		 * new ������
		 * 1. �θ�Ŭ������ ��ü�� ���� ���� ����
		 * 2. �ڼ�Ŭ������ ��ü�� ����
		 * 3. �⺻������ �ʱ�ȭ
		 * 4. �θ�Ŭ������ ������ ���� : super()
		 * 5. �ڼ�Ŭ������ ������ ����
		 */
		c.method();
	}
}
