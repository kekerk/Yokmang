package chap14;

import java.util.ArrayList;
import java.util.LinkedHashSet;

/*
 * LinkedHashSet :  순서유지, 중복불가
 * Random
 * new ArrayList(Set) : Set 객체를 List 객체로 생성.
 */
public class Q0820_2 {
	public static void main(String[] args) {
		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
		// set.size()가 6이 되면 끝
		while(set.size()<6) {
			if(set.size()==0) {
				System.out.println("3등 복권 추첨합니다.");
			}else if(set.size()==3) {
				System.out.println("2등 복권 추첨합니다.");
			}else if(set.size()==5) {
				System.out.println("1등 복권 추첨합니다.");
			}
			
			int num = (int)(Math.random()*1000)+1;
			if(set.add(num)) {
				System.out.println(num);
			}
			
		}
		System.out.println("***복권 추첨 결과***");
		//첨자 쓰기 위해 ArrayList 씀
		ArrayList<Integer> list = new ArrayList<Integer>(set);
		System.out.println("1등:"+list.get(5));
		System.out.print("2등:");
		for(int i=4;i>=3;i--) {
			System.out.print(list.get(i)+",");
		}
		System.out.println();
		System.out.print("3등:");
		for(int i=2;i>=0;i--) {
			System.out.print(list.get(i)+",");
		}
		System.out.println();
		System.out.println("1등:"+list.subList(5, 6));
		System.out.println("2등:"+list.subList(3, 5));
		System.out.println("3등:"+list.subList(0, 3));
		
		
		
	}
}
