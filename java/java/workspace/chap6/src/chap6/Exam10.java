package chap6;

import java.util.Scanner;

/*
 * 야구 게임
 * 
 */
public class Exam10 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] ar = new int[4];
		int[] t = new int[4];
		Scanner scan = new Scanner(System.in);
		int s = 0;
		int b = 0;
		int c = 0;

		// 랜덤으로 4자리 숫자 생성 뒤 각 자리의 수 순서대로 저장
		System.out.println("컴퓨터 네자리 숫자 생각중");
		for (int i = 0; i < 1000; i++) {
			int t1 = (int) ((Math.random() * 10));
			int t2 = (int) ((Math.random() * 10));
			int a = arr[t1];
			arr[t1] = arr[t2];
			arr[t2] = a;
		}

		System.out.print("횟수 확인를 위한 예시 : ");
		for (int i = 0; i < ar.length; i++) {
			ar[i] = arr[i];
			System.out.print(ar[i]);
		}
		System.out.println();
		/////////////////////////////////////////
		do {
			System.out.println("네자리 숫자를 입력하시오.");
			int num = scan.nextInt();
			int tmp = num;

			// 입력한 네자리 수를 순서대로 저장 (10진법을 2진법으로 바꾸는 연습에서 활용)
			int index = 3; // 네 자리 숫자중 앞의 수부터 차례대로 넣기위해 역순으로 지정
			while (tmp != 0) {
				t[index--] = tmp % 10;
				tmp /= 10;
			}
			// 같은 자리에 같은 수가 있으면 스트라이크 처리
			s = 0;
			for (int i = 0; i < 4; i++) {

				if (ar[i] == t[i]) {
					s++;
				}
			}
			// 자리는 다르나 네 개의 숫자중 서로 겹치는 숫자가 있으면 볼 처리
			b = 0;
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (i != j) { //같은 자리가 아닌데
						if (ar[i] == t[j]) { //숫자가 겹친다면

							b++; //볼 처리

						}
					}
				}
			}

			System.out.println("스트라이크 :" + s);

			System.out.println("볼 :" + b);
			c++;
		} while (s != 4);
		System.out.println(c + "번째만에 수를 맞혔습니다.");
		System.out.println();
	}
}
