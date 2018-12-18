package chap6;

import java.util.Scanner;

/*
 * 
 */
public class BaseBall {

	public static void main(String[] args) {
		int numarr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int answer[] = new int[4];
		// 1. 시스템의 수를 지정 (random 함수 사용) 중복문제
		for (int i = 0; i < 1000; i++) {
			int f = (int) (Math.random() * 10);
			int t = (int) (Math.random() * 10);
			// (0,1,2,3,4,5,6,7,8,9)
			int temp = numarr[f];
			numarr[f] = numarr[t];
			numarr[t] = temp;
		}

		for (int i = 0; i < 4; i++) { // 앞의 네자리를 가져오는 for문
			answer[i] = numarr[i];
		}
		System.out.print("횟수 파악을 위한 임의의 수: ");
		for (int s = 0; s < answer.length; s++) {
			System.out.print(answer[s]); 
		}
			System.out.println();
		// 2. 화면으로부터 4자리 정수를 입력
		Scanner scan = new Scanner(System.in);
		int[] rcvNum = new int[4];
		int cnt = 0; // 몇번이나 입력했는지 알아보기 위해
		while (true) {
			System.out.println("서로 다른 4자리 정수를 입력하세요");  //2345
			int num = scan.nextInt();
			cnt++;
			rcvNum[0] = num / 1000; // 1000의 자리 : 2
			rcvNum[1] = (num % 1000) / 100; // 100의 자리 : 3
			rcvNum[2] = (num % 100) / 10; // 10의 자리 : 4
			rcvNum[3] = num % 10; // 1의 자리 : 5
			// 3. strike 와 ball 결정
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
			// 4. 4스트라이크가 될 때까지 2,3을 계속 실행.
			if (strike == 4) {
				System.out.println(String.format("%04d", num) + " 정답입니다.");
				System.out.println(cnt + "번만에 맞히셨습니다. 게임을 종료합니다.");
				break;
			}
			else {
				System.out.println("스트라이크: "+ strike);
				System.out.println("볼: "+ ball);
			}
		}
	}

}
