package chap7;
/*
 * �޼��� ����
 * �޼��� ���� 
 * [����������] ����Ÿ�� �޼���� (�Ű����� ���) => �����
 * {             ...                } => ������(����,body)
 * 
 * ����Ÿ�� : �޼��尡 ����Ǹ� ������ ���� �ڷ��� ����
 * 			void ��� ���� �� ���� ����.
 * �Ű�������� : �޼��尡 ȣ��� ��, ���޵Ǵ� ���� �ڷ����� ������.
 * 			   �Ű������� �ش� �޼����� ����������. ȣ��� �� �ʱ�ȭ ��. 
 * return : �޼����� �����ο� �ۼ���.
 * 			�޼��� ����.
 * 			����Ÿ���� void�� ��� ������ ����.
 * 			����Ÿ���� void�� �ƴ� ��� �ݵ�� return�� �ۼ��ؾ���.
 * 			�� �� ���� ����Ÿ�԰� �����ϰų�, ����Ÿ������ �ڵ�����ȯ�� �Ǵ� �ڷ����̾�� �Ѵ�.
 */
class Math1 {
	int add1(int a, int b) { //�����
		return a + b; //������ { }
	}

	long add2(int a, int b) {
		return a + b; // �޼��� ����
	}

	double add3(int a, int b) {
		return a + b; //int�� double�� �ڵ� ����ȯ�Ǿ return��.
	}
}

public class MathEx1 {

	public static void main(String[] args) { //static�� ������ main �޼���μ��� ����� �������� ����. ��üȭ ���Ѿ� �̿� ����.
		Math1 m = new Math1();
		System.out.println(m.add1(10, 20));
		System.out.println(m.add2(10, 20));
		System.out.println(m.add3(10, 20));
	}
}
