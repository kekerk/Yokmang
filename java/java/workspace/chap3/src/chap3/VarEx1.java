package chap3;

public class VarEx1 {

	public static void main(String[] args) {
		//������ : �Ҽ��� ���� ���� �Ұ�
		// �ڷ����� ���� ������ ���� �� ����
		byte b1 = -22; //1����Ʈ b1 ���� �����ϰ�, -22���� ����
		short s1 = -220; //2����Ʈ s1 ���� �����ϰ�, -220���� ����
		int i1 = 100; //4����Ʈ i1 ���� �����ϰ�, 100���� ����
		long l1 = 1000; //8����Ʈ l1 ���� �����ϰ�, 1000���� ����
		System.out.println("b1="+b1);
		System.out.println("s1="+s1); //��¹�
		System.out.println("i1="+i1);
		System.out.println("l1="+l1);
		//�Ǽ��� : �Ҽ��� ���� ���� ����
		// �Ǽ� ���ͳ��� �⺻���� double
		float f1 = 0.1f;//�ڿ� f�� �ٿ���� error�� ���� ���� -> ���̻� f
		double d1 = 10.5d;
		System.out.println("f1="+f1);
		System.out.println("d1="+d1);
		/*
		 * ������ ���ͳο� �ٴ� �ڷ��� ���̻�
		 * F,f : float �� ���ͳ�
		 * D,d : double �� ���ͳ�
		 * L,l : long �� ���ͳ�
		 */
	}

}
