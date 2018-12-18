package chap14;

import java.util.Vector;

/*
 * Vector 예제 : List 구현 클래스. 단 Collection 이전 버전에서 사용된 클래스
 * 		  	   List의 메서드와 이전에 사용되던 메서드가 혼합되어 있음.
 */
public class ListEx2 {
	public static void main(String[] args) {
		// Vector : list 객체
		Vector <Double> list = new Vector<Double>();
		list.add(0.3); // list 멤버 메서드
		list.add(Math.PI);
		list.addElement(5.0); // Vector 멤버 메서드
		System.out.println(list);
		for (Double o : list) { // 개선된 for문 사용 가능.
			System.out.println(o);
		}
		double num = 5.0;
		int index = list.indexOf(num); //num 값이 몇번쨰 인덱스인지 리턴.
		if (index >= 0) {
			System.out.println(num + "의 위치:" + index);
		} else {
			System.out.println(num + "은 list에 없습니다.");
		}
		num = 0.3;
		if(list.contains(num)) { 
			list.removeElement(num);
			System.out.println(num+"삭제됨");
		}
		System.out.println(list.indexOf(num));
		System.out.println(list);
		System.out.println(list.get(2));
	}
}
