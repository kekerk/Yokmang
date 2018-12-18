package chap6;

//�� ���� ������� ���� ���ϴ� ���α׷�
import java.util.Scanner;

public class Exam8 {

	public static void main(String[] args) {

		System.out.println("�ΰ��� ���� �Է��Ͻÿ�");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		// �� ���� ���� ���� �ּҰ� ����
		int min = (a < b) ? a : b;
		// ������� ������� �迭 ����
		int[] gcd = new int[30]; /// �߿�
		int index = 0; /// �߿�
		// �� ���� �� �Էµ� ���� ����� �Ѵ� �������� 0�� �� ��� �� ���� gcd�� �Է�
		for (int i = 1; i <= min; i++) {
			if (a % i == 0 && b % i == 0) {
				gcd[index++] = i;
			}
		}
		System.out.print(a + "�� " + b + "�� ����� : ");
		for (int i = 0; i < index; i++) {
			System.out.print(gcd[i] + ((i == index - 1) ? " " : ",")); // i�� ���� ���� �����ϸ� ����, �ƴϸ� ��ǥ
		}
		System.out.println();
	}

}
