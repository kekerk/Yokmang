package chap4;

import java.util.Scanner;

// 입력한 세자리 정수에서 1의 자리를 1로 바꾸기.
public class Exam3 {

	public static void main(String[] args) {
		System.out.println("계산할 세자리 정수를 입력하세요");
		Scanner scan = new Scanner(System.in); // system.in 시스템으로 입력 , scanner 입력받은 값 복사
		int num = scan.nextInt(); //다음 스캔받은 값을 정수형으로 num에 저장
//		int ans = (num-(num%10)) + 1;
		int ans = ((num/10)*10) + 1; //1자리를 바꾸기 위해 10으로 나눈 몫에 다시 곱하기 10 한 뒤 +1
		System.out.println("값:"+ans);
		
	}

}
