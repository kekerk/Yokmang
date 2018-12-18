package chap14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * 화면에서 여러개의 자연수를 입력받아 이들 중 홀수인 자연수들을 모두 골라 그 합을 구하고, 홀수 중 최대값과 최소값을 찾는 프로그램을 작성하기.
 */
public class Exam3 {

	public static void main(String[] args) {
		int sum=0;
		Scanner scan = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>(); //ArrayList나 Vector등 상관이 없다.
		System.out.println("입력받을 자연수의 개수를 결정하시오.");
		int num = scan.nextInt();
		System.out.println(num+"개의 숫자를 입력하시오.");
		for (int i = 0; i < num; i++) {
			int score = scan.nextInt();
			if (score % 2 != 0) {
				list.add(score);
				sum+=score;
			}

		}
		System.out.println("입력된 홀수: "+list);
		
		System.out.println("홀수인 수의 합: "+sum);
		
		//리스트 순서대로 재정렬.
//		Collections.sort(list);
		
		System.out.println("홀수인 수들 중 최대값: "+Collections.max(list));
		System.out.println("홀수인 수들 중 최대값의 인덱스: "+list.indexOf(Collections.max(list)));
		System.out.println("홀수인 수들 중 최소값: "+Collections.min(list));
		System.out.println("홀수인 수들 중 최소값의 인덱스: "+list.indexOf(Collections.min(list)));
	}

}
