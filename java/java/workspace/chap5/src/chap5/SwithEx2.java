package chap5;

public class SwithEx2 {

	public static void main(String[] args) {
		/*
		 * Math.random() : ����(�����Ǽ�)�߻��� ---->> ���� �Ұ�. ��÷ ��� �� 0 <= Math.random() < 1.0 0
		 * <= Math.random()*10 < 10.0 0 <= (int)(Math.random()*10) <= 9 1 <=
		 * (int)(Math.random()*10)+1 <= 10------------------> 1 <= num <= 10
		 */
		int num = (int) (Math.random() * 10) + 1; // ������ �ڵ� �Է�??
		switch (num) {
		case 1:
			System.out.println("������ ��÷");
			break;
		case 2:
			System.out.println("�ζ��� ��÷");
			break;
		case 3:
			System.out.println("USB ��÷");
			break;
		default:
			System.out.println("������ȸ��....");
			break; // 70�ۼ�Ʈ�� Ȯ��
		}
		// TODO Auto-generated method stub

		// ��� switch ������ if �������� ���� ����
		// ��� if ������ switch �������� ������ �� ����.

		if (num == 1)
			System.out.println("������ ��÷");
		else if (num == 2)
			System.out.println("�ζ��� ��÷");
		else if (num == 3)
			System.out.println("USB ��÷");
		else
			System.out.println("������ȸ��....");

	}

}
