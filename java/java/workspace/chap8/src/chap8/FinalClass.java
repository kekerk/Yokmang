package chap8;
/*
 * final : ��������, ���� �Ұ��� �ǹ̸� ������.
 * final class : ��� �Ұ� Ŭ����, �ٸ� Ŭ������ �θ� �� �� ����.\
 * 				 String, Math Ŭ������ final class. 
 * 
 * final method : ������ �Ұ� �޼���. �������̵� �Ұ� �޼���� ����.
 * final value : ����Ұ� ����. ���.
 * 				 ����� �ʱ�ȭ�� �Ǿ� ���� ���� ���, ��� ������ �����ڿ��� �ѹ� ������ ������.
 */

public final class FinalClass {
}

class sub extends FinalClass {
}

class FinalMethod {
	 final void finalmethod() { //�θ��� �޼��� �������̵� �Ұ�.  (�޼��� - �������̵�)
		System.out.println("final method : �������̵� �Ұ� �޼���");

	}

}

class Sub2 extends FinalMethod {
	void finalmethod() {
		System.out.println("�� �޼���� ���� �߻���");
	}
}