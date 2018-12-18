package chap6;

import java.util.Scanner;

/*
 * 
 */
public class BaseBall {

	public static void main(String[] args) {
		int numarr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int answer[] = new int[4];
		// 1. �ý����� ���� ���� (random �Լ� ���) �ߺ�����
		for (int i = 0; i < 1000; i++) {
			int f = (int) (Math.random() * 10);
			int t = (int) (Math.random() * 10);
			// (0,1,2,3,4,5,6,7,8,9)
			int temp = numarr[f];
			numarr[f] = numarr[t];
			numarr[t] = temp;
		}

		for (int i = 0; i < 4; i++) { // ���� ���ڸ��� �������� for��
			answer[i] = numarr[i];
		}
		System.out.print("Ƚ�� �ľ��� ���� ������ ��: ");
		for (int s = 0; s < answer.length; s++) {
			System.out.print(answer[s]); 
		}
			System.out.println();
		// 2. ȭ�����κ��� 4�ڸ� ������ �Է�
		Scanner scan = new Scanner(System.in);
		int[] rcvNum = new int[4];
		int cnt = 0; // ����̳� �Է��ߴ��� �˾ƺ��� ����
		while (true) {
			System.out.println("���� �ٸ� 4�ڸ� ������ �Է��ϼ���");  //2345
			int num = scan.nextInt();
			cnt++;
			rcvNum[0] = num / 1000; // 1000�� �ڸ� : 2
			rcvNum[1] = (num % 1000) / 100; // 100�� �ڸ� : 3
			rcvNum[2] = (num % 100) / 10; // 10�� �ڸ� : 4
			rcvNum[3] = num % 10; // 1�� �ڸ� : 5
			// 3. strike �� ball ����
			int strike = 0;
			int ball = 0;
			for (int i = 0; i < answer.length; i++) {
				for (int j = 0; j < rcvNum.length; j++) {
					if (answer[i] == rcvNum[j]) {
						if (i == j)
							strike++;
						else
							ball++;
						break;
					}
				}
			}
			// 4. 4��Ʈ����ũ�� �� ������ 2,3�� ��� ����.
			if (strike == 4) {
				System.out.println(String.format("%04d", num) + " �����Դϴ�.");
				System.out.println(cnt + "������ �����̽��ϴ�. ������ �����մϴ�.");
				break;
			}
			else {
				System.out.println("��Ʈ����ũ: "+ strike);
				System.out.println("��: "+ ball);
			}
		}
	}

}
