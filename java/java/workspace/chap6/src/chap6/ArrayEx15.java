package chap6;

/*
 *  ������ for ���� ����
 *  �迭�� ����� ����� �ڷ����� ǥ�õǾ� �Ѵ�.
 *  ÷�� ����� �ȵȴ�. 
 *  ÷�ڸ� ����Ϸ��� �Ϲ����� for������ �̿��ؾ� �Ѵ�.
 *  
 */
public class ArrayEx15 {
	public static void main(String[] args) {
		String[] strarr = new String[5];
		strarr[0] = "ȫ�浿";
		strarr[1] = "���";
		strarr[2] = "�̸���";
		//// strarr[3] = null; ������Ͻ� null�� �Ǿ�����.
		//// strarr[4] = null;
		for (String s : strarr) {
			System.out.println(s);
		}
		// �Ϲ� for �������� �����ϱ�
		System.out.println();

		for (int i = 0; i < strarr.length; i++) {
			System.out.println(strarr[i]);
		}
		System.out.println();
		double[] darr = { 0.1, 0.2, 0.3, 0.4, 0.5 };
		for (double d : darr) {
			System.out.println(d);
		}
		System.out.println();
		// �Ϲ� for �������� �����ϱ�
		for (int j = 0; j < darr.length; j++) {
			System.out.println(darr[j]);
		}
	}

}
