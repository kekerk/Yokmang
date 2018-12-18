package chap6;

import java.util.Scanner;

/*
 * 정수 n을 입력받고,
 * 정수 n과 서로소인 1 이상 n 미만의 정수와 갯수를 출력하는 프로그램 구현하기
 * 여기서 임의의 정수 n의 서로소란, n과의 공약수가 1밖에 없는 숫자를 뜻한다.
 * [결과]
 * 숫자를 입력하세요
 * 20
 * 20과 소인수 : 1,3,7,9,11,13,17,19
 * 서로소인 숫자의 갯수 : 8
 */
public class Seoroso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("숫자를 입력하세요");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int cnt = 0; //num과 서로소인 수의 개수
		System.out.print(num+"와 서로소인 수: ");
		for(int i=0;i<num;i++) {
			int index=0;
			for(int j=1;j<=i;j++) {
				if(num%j==0 && i%j==0) {
					index++;
				}
			}
			if(index==1) { //공약수가 1인 것만 모두 걸러내고 출력.
				cnt++;
				System.out.println(i+",");
			}
		}
		System.out.println();
		System.out.println(num+"과 서로소인 수의 갯수: "+cnt);
	}

}
