package chap3;

public class VarEx6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b1 = 10;
		short s1 = 20;
		int i1 =30;
		long l1 = 40;
		i1 = b1; // i1 = (int) b1. �ڵ� ����ȯ. 1byte�� 4byte�� ��ȯ�ǹǷ� �ڷ��� ���� ����. 30�� ������� 10�� ����
		s1 = (short) l1; // ����ȯ ������(short)�� �̿��Ͽ� ���� ���ǵǴ� ���� ����. ���������ȯ 
		float f = l1; // float > long Ÿ�Ժ��� ū �ڷ�����. �ڵ�����ȯ
		System.out.println(i1);
		System.out.println(s1);
		byte b2 = (byte) 300;
		System.out.println("b2="+b2); //44
		short s2 =65;
		char c1= (char) s2;
		System.out.println("c1="+c1);
		
		System.out.println("\"�ȳ�\"");
		System.out.println("�ȳ�");
		char single = '\\';
		String qoato = "Hello\"ȫ�浿 \"";
		String root = "c:\\";
		System.out.println(single);
		System.out.println(qoato);
		System.out.println(root);
		System.out.println("����\f�뱸\f�λ�"); //tap ��� �ο�
		System.out.println("�ȳ��ϼ��� \n�̺κ��� �����ٿ�"); // enter ��� �ο�
		System.out.println("\uD64D\uAE38\uB3D9"); // �����ڵ�� ���ڴٶ�� ��.
		// TODO Auto-generated method stub

	}

}
