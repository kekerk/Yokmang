package chap14;

import java.util.Comparator;
import java.util.TreeSet;

/*
 * 다음의 결과가 나오도록 프로그램 완성하기.
 * [결과]
 * set1:[10,20,30,40,50]
 * set2:[50,40,30,20,10]
 */

public class Exam5 {

	public static void main(String[] args) {
		int[] score = {30,50,10,20,40};
		
//		TreeSet<Integer> set1 = new TreeSet<Integer>(new Comparator() {
//
//			@Override
//			public int compare(Object o1, Object o2) {
//				Comparable c1 = (Comparable) o1;
//				Comparable c2 = (Comparable) o2;
//				return c1.compareTo(c2);
//			}
//			
//		});
//		for(int i=0;i<score.length;i++) {
//			set1.add(score[i]);
//			}
//		
//		TreeSet<Integer> set2 = new TreeSet<Integer>(new Comparator() {
//
//			@Override
//			public int compare(Object o1, Object o2) {
//				Comparable c1 = (Comparable) o1;
//				Comparable c2 = (Comparable) o2;
//				return c2.compareTo(c1);
//			}
//			
//		});
//		
//		for(int i=0;i<score.length;i++) {
//			set2.add(score[i]);
//			}
		TreeSet<Integer> set1 = new TreeSet<Integer>(); //TreeSet<Integer>으로 인한 기본 오름차순 정렬.
		TreeSet<Integer> set2 = new TreeSet<Integer>(new Comparator() {
			
						@Override
						public int compare(Object o1, Object o2) {
//							int c1 = (Integer) o1; 
//							int c2 = (Integer) o2;
//							return c2-c1; //내림차순 정렬.
							
							Integer c1 = (Integer) o1;
							Integer c2 = (Integer) o2;
							return c2.compareTo(c1);
						}
					
					});
	
		for( int s : score) {
			set1.add(s);
			set2.add(s);
		}
		System.out.println("set1:"+set1);
		System.out.println("set2:"+set2);
	}

}
