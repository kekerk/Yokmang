package chap14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exam1_1 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		int input;
		int count = 0;
		System.out.println("홀수개의 숫자를 입력하세요");
		while (true) {
			if (count % 2 != 0) {
				System.out.println("숫자를 더 입력하시겠습니까");
				String yn = scan.next();
				if (!yn.equals("y")) {
					break;
				}
			}
			input = scan.nextInt();
			count++;
			list.add(input);
		}
		System.out.println(list);
		int sum = 0;
		for(int i=0;i<list.size();i++) {
			sum+= list.get(i);
			
		}
		System.out.println("평균값: "+(double) sum/list.size());
		Collections.sort(list);
		System.out.println(list);
		System.out.println("중간값: "+list.get(list.size()/2));
	}
}
