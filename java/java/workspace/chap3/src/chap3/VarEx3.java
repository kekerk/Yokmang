package chap3;
//����ȯ���� casting
//�⺻�ڷ��� 8���� �� boolean�� ������ 7������ ����ȯ�� �����ϴ�.
// ũ��� ����
// byte < short,char < int < long < float < double ū�ʿ��� ���� ������ �� ���� ���������ȯ, ����ȯ ������ ����ؾ� ��.
//char
public class VarEx3 {

	public static void main(String[] args) {
		byte b1 = 10;
		short s1 = 20;
		int i1 =30;
		long l1 = 40;
		i1 = b1; // i1 = (int) b1. �ڵ� ����ȯ. 1byte�� 4byte�� ��ȯ�ǹǷ� �ڷ��� ���� ����.
		s1 = (short) l1; // ����ȯ ������(short)�� �̿��Ͽ� ���� ���ǵǴ� ���� ����. ���������ȯ
		float f = l1; // float > long Ÿ�Ժ��� ū �ڷ�����. �ڵ�����ȯ
		byte b2 = (byte) 300;
		System.out.println("b2="+b2); //44
		short s2 =65;
		char c1= (char) s2;
		System.out.println("c1="+c1);
		// TODO Auto-generated method stub

	}

}
