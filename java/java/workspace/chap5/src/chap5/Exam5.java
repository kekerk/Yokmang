package chap5;

/*
 * ���ڷ� �̷���� ���ڿ� a�� ���� �� ������ �ڸ����� ���� ���ϱ�.
 * 
 * a.length(),a.charAt()
 * for ���� �̿�.
 */
public class Exam5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "123456"; // 1�� chatAt(0), 2�� chatAt(1), 3�� chatAt(2), 4�� chatAt(3), 5�� chatAt(4) >>> �̷���
		int sum = 0;
		// for�� �ȿ����� int i�� ����������� �Ѵ�. 
		for (int i = 0; i < a.length(); i++) { // a.length()�� ���ڿ� a�� ���̸� ��Ÿ��.
			sum += a.charAt(i) - '0'; // a.charAt(i)�� �� �ڸ��� ���� ��Ÿ��. ���� �� ���ں��� charAt(0),charAt(1),......
									  // '1'�� �������� �ƽ�Ű ������ ���������δ� 49�� ��Ÿ��. �׷��� ���������� �Ϸ��� '0'�� ������Ѵ�.
			 					       
		}
		System.out.println("���ڷ� �̷���� ���ڿ� �� �ڸ��� ���� " + sum);
	}

}
