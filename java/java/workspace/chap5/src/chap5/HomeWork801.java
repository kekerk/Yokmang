package chap5;

import java.util.Scanner;

public class HomeWork801 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1.  다음은 주어진 문자열(value)이 숫자인지를 판별하는  프로그램을 작성하시오.
//		  String 함수 charAt(i), length() 을 사용함.
		/*
		  System.out.println("아무거나 입력하시오"); Scanner scan = new Scanner(System.in);
		  String ar = scan.nextLine();
		  
		  int a = 0;
		  
		  for (int i = 0; i < ar.length(); i++) {
		  
		  if ((ar.charAt(i) < '0') || (ar.charAt(i) > '9')) {
		  System.out.println("숫자열이 아닙니다.");
		  
		  }
		  
		  else { a++; }
		  
		  } if (a == ar.length()) System.out.println("숫자열입니다.");
		  
		  // 2. 숫자 맞추기 게임 프로그램을 작성하기 // 컴퓨터는 1과 100사이의 값을 저장하고 있고, 사용자는 반복적으로 숫자를 입력해서
		  // 컴퓨터가 생각한 값을 맞추면 게임이 끝난다.
		  
		  System.out.println("컴퓨터 숫자 생각중"); int num = (int) (Math.random() * 100) + 1;
		  System.out.println("숫자를 입력하세요"); Scanner scan1 = new Scanner(System.in); int
		  i = scan1.nextInt(); int cnt = 1; do {
		  
		  if (i < num) { System.out.println("작아!!! 다시 입력");
		  
		  i = scan1.nextInt(); } else if (i > num) { System.out.println("커!!! 다시 입력");
		  
		  i = scan1.nextInt(); } else { break; } cnt++; } while (i != num);
		  
		  System.out.println("정답 짝짝짝"); System.out.println(cnt + "회 만에 맞추셨습니다.");
		 */
//      3. 다음은 회문수를 구하는 프로그램을 작성하기
//        회문수란 숫자를 거꾸로 읽어도 앞으로 읽는 것과  같은 수를 말한다.
//        12321 : 회문수
//        12345 : 회문수 아님

		System.out.println(" 숫자를 입력하시오");
		Scanner scan2 = new Scanner(System.in);
		String arr = scan2.nextLine();
		int c = 0, d = 0;

		if (arr.length() % 2 == 0) {

			for (int t = 0; t <= arr.length() / 2; t++) {
				if (arr.charAt(t) == arr.charAt(arr.length() - t)) {
					c++;
				}
				if (c == (arr.length() / 2)) {
					System.out.println("회문수입니다.");

				} else {
					System.out.println("회문수가 아닙니다.");
				}
			}

		} else if (arr.length() % 2 == 1) {

			for (int t = 0; t <= (arr.length() / 2) + 1; t++) {
				if (arr.charAt(t) == arr.charAt(arr.length() - (t + 1))) {
					d++;
				}
				if (d == (arr.length() / 2) + 1) {
					System.out.println("회문수입니다.");

				} else {
					System.out.println("회문수가 아닙니다.");
				}
			}

		}

	}
}
