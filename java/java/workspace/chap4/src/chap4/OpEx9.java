package chap4;

import java.util.Scanner;

import javax.sound.midi.Synthesizer;

/*
 * 조건연산자(삼항연산자) : (조건식) ? 참 : 거짓
 */
public class OpEx9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("점수를 입력하세요(0~100)");
		Scanner scan = new Scanner(System.in);
		int score = scan.nextInt();
		String result = (score >=60)? "합격":"불합격";
		System.out.println(score+":"+result);
		//스코어가 짝수인지 홀수인지 출력하기
		System.out.println(score+":"+((score%2==0)?"짝수":"홀수"));
	}

}
