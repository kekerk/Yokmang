package test;

import java.util.Scanner;

/*
 * �ﰢ���� ���� n�� ���� m�� 
�Է¹��� �� ������ ���� �ﰢ�� 
���·� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
���� 1                  ���� 2             ���� 3
 *                    *****                *
 **                   ****                ***
 ***                  ***                *****
 ****                 **                *******
 *****                *                *********

�ﰢ���� ũ�� n(n�� ������ 100 ������ �ڿ���)�� ���� m(m�� 1���� 3������ �ڿ���)�� �Է¹޴´�
 */
public class Q2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("�ﰢ���� ���̸� �Է��ϼ���");
		int height = scan.nextInt();
		System.out.println("�ﰢ���� ������ �Է��ϼ���");
		int type = scan.nextInt();
		switch (type) {
		case 1:
			for (int i = 1; i <= height; i++) {
				for (int j = 1; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 2:
			for (int i = 1; i <= height; i++) {
				for (int j = 1; j <= height + 1 - i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 3:
			for (int i = 1; i <= height; i++) {
				for(int j=1;j<=(height*2)-1;j++) {
					if(j >= (height-(i-1)) && j <= (height+(i-1))) {
						System.out.print("*");
					}else {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
			break;
		}
	}
}
