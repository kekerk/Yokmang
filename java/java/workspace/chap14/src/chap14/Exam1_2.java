package chap14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exam1_2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count;
		//홀수개 입력받는 while문 , 홀수개가 아니면 다시 입력. 홀수개가 될때까지 입력
		while(true) {
		System.out.println("입력할 숫자의 갯수를 홀수개로 입력하시오.");
		count = scan.nextInt();
		if(count%2==0) continue;
		else break;
		}
		//값 입력 및 
		List<Integer> list = new ArrayList<Integer>();
		int sum = 0;
		for(int i=0;i<count;i++) {
			int input = scan.nextInt();
			sum+= input;
			list.add(input);
		}
		//
		Collections.sort(list);
		
		System.out.println("평균값:"+(double)sum/count);
		System.out.println("중간값:"+list.get(count/2));
		System.out.println("최대값:"+Collections.max(list));
		System.out.println("최소값:"+Collections.min(list));
	}
}
