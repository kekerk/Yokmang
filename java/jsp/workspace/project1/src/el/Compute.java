package el;

public class Compute {
	public static int add(String x, String y) {
		try {
			// a : x�Ķ���͸� ������ ��ȯ�� ��
			int a = Integer.parseInt(x);
			// b : y�Ķ���͸� ������ ��ȯ�� ��
			int b = Integer.parseInt(y);
			return a+b;
		}catch(Exception e) {}
		return 0; // �ٸ� �͵��� �ԷµǸ� ��� 0 ó��
	}
}
