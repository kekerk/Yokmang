package chap6;

/*
 * command line���� �Ķ���Ͱ� �Է� �ޱ�.
 */
public class ArrayEx6 {
	public static void main(String[] args) { // return Ÿ���� void : ������ �������� ���� ����. ���ϰ��� ������ ����.
		if (args.length == 0) {
			System.out.println("Ŀ�ǵ� ���ο� �Ķ���͸� �Է��ϼ���");
			System.out.println("java ArrayEx6 ȫ�浿 ���");
			return; // �޼��� ����
		}
		for (int i = 0; i < args.length; i++) {
			System.out.println("args[" + i + "]=" + args[i]);
		}

	}// �޼��� ����

}
