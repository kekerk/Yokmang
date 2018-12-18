package test;

import java.util.Scanner;

/*
 * switch 구문을 이용하여 시스템과 가위바위보 게임하기.
 * 임의의 수를 구하여 1인 경우 가위, 2인 경우 바위, 3인 경우 보
 * 저장된 임의의 수와 사용자가 입력한 수를 비교하여
 * 시스템이 승리한 경우 컴퓨터 승리, 내가 승리한 경우  당신이 승리
 * 비긴경우는 비김.
 */
public class Test2 {
	public static void main(String[] args) {
		int comn = (int) (Math.random() * 3) + 1;
		System.out.println("컴퓨터가 낸거는"+comn);
		Scanner scan = new Scanner(System.in);
		System.out.println("가위(1), 바위(2), 보(3) 중 니가 낼 꺼는?");
		int num = scan.nextInt();
		switch (comn) {
		case 1:
			if (num == 2) {
				System.out.println("당신이 승리");
				break;
			} else if (num == comn) {
				System.out.println("비김");
				break;
			} else {
				System.out.println("컴퓨터 승리");
				break;
			}

		case 2:
			if (num == 1) {
				System.out.println("컴퓨터 승리");
				break;
			} else if (num == comn) {
				System.out.println("비김");
				break;
			} else {
				System.out.println("내가 승리");
				break;
			}
		case 3:
			if (num == 1) {
				System.out.println("당신이 승리");
				break;
			} else if (num == 2) {
				System.out.println("컴퓨터 승리");
				break;
			} else {
				System.out.println("비김");
				break;
			}
		}

	}
}
