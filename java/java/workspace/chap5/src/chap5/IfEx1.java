package chap5;

/*
 *  if 구문 예제
 *  if(조건문) {
 *   실행문1 => 조건문의 결과가 참인 경우 실행 되는 부분
 *   	   => 실행되는 문장이 1개인 경우 {} 생략이 가능하다.
 *  } else if(조건문) {
 *   실행문2 => else if(조건문)의 결과가참인 경우 실행 되는 부분  
 *  }else {
 *   실행문3 => 조건문의 결과가 거짓인 경우 실행되는 부분 
 *  }
 * 
 */
import java.util.Scanner;

public class IfEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("점수를 입력하시오");
		Scanner scan = new Scanner(System.in);
		int score = scan.nextInt();
		/*
		 * if(score>=60) { System.out.println("합격을 축하합니다."); } else
		 * System.out.println("너는 불합격이다.");
		 */
		String grade = null;

		if (score >= 90) {
			if (score >= 95)
				grade = "A+";
			else
				grade = "A0";
			// System.out.println("A 학점");
		} else if (score >= 80) {
			if (score >= 85)
				grade = "B+";
			else
				grade = "B0";
			// System.out.println("B 학점");
		} else if (score >= 70) {
			if (score >= 75)
				grade = "C+";
			else
				grade = "C0";
			// System.out.println("C 학점");
		} else if (score >= 60) {
			if (score >= 65)
				grade = "D+";
			else
				grade = "D0";
			// System.out.println("D 학점");
		} else {
			grade = "F";
			// System.out.println("F 학점");
		}
		System.out.println("당신의 학점은 " + grade);

	}

}
