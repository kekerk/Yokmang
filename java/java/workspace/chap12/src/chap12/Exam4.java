package chap12;

/*
 * hey boys, hey girls, hey anybody who will listen to me
 * ���� �� a~z ���ڰ� ���� � �����ϴ��� ����ϱ�.
 * 
 */
public class Exam4 {
	public static void main(String[] args) {
		String msg = "hey boys, hey girls, hey anybody who will" + "listen to me";

		int arr[] = new int[26];

		for (int i = 0; i < msg.length(); i++) {
			if (msg.charAt(i) >= 'a' && msg.charAt(i) <= 'z') {
				arr[msg.charAt(i) - 'a']++;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(((char) (i + 'a')) + ":" + arr[i]);
		}

	}

}
