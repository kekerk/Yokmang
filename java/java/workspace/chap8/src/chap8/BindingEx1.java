package chap8;
/*
 * �θ�Ŭ������ �ڼ�Ŭ������ ������ ����� �����ϰ� ���� ��. 
 * 
 * ��������� ���������� Ÿ�Կ� ������, 
 * ����޼���� ��ü�� ���� �������̵��� �޼��尡 ȣ��ȴ�.
 */
class Parent3{
	int x =10;
	void method() {
		System.out.println("Parent �޼���");
	}
}

class Child3 extends Parent3 {
	int x = 20;
	void method() {
		System.out.println("Child �޼���");
	}
}
public class BindingEx1 {
	public static void main(String[] args) {
		Parent3 p = new Child3(); 
		System.out.println(p.x); //10
		p.method();
		Child3 c = (Child3) p;
		System.out.println(c.x); //20
		c.method();
	}
}
