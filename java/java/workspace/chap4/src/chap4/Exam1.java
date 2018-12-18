package chap4;

import java.util.Scanner;//

//초를 화면에서 입력받아 계산하기
public class Exam1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int a = 12345;
		System.out.println("계산할 초를 입력하시오");
		//System.in : 표준 입력 (키보드로부터 입력)
		// Scanner : 표준 입력 스트링을 통하여 데이터를 입력받는 클래스
		Scanner scan = new Scanner(System.in); 
		int a = scan.nextInt();//입력받은 문자를 정수형으로 바꾸는 것
		int h = (int)(a/3600);
		int m = (int)(a%3600) / 60;
		int s = (int)(a%3600) % 60;
		System.out.println("현재시각:"+h+"시"+m+"분"+s+"초");
	}

}
