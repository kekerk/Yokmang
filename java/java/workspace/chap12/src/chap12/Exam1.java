package chap12;

/*
 * count �޼��� �����ϱ�.
 * �Ű����� : String str1, String str2
 * ��� : str1���ڿ� �� str2 ���ڿ��� ��� �����ϴ��� ����.
 * ���� Ÿ�� int 
 */
public class Exam1 {

	public static void main(String[] args) {

		System.out.println(count("12345AB12AB345AB", "12")); // 2
		System.out.println(count("12345AB12AB345AB", "AB")); // 3
		System.out.println(count("12345", "6"));
	}

	public static int count(String str1, String str2)//�޼��� ���� (�����)
	{ 												 //�޼��� ���� (�����)
		int num = 0, count = 0;
		while (true) {

			num = str1.indexOf(str2, num);
			if (num >= 0) { //str1�� str2���ڿ��� ����.
				num++;
				count++;
			} else { //num�� -1�� �Ǹ� break; �ɸ���.
				break;
			}
		}
		return count;
	}

}
