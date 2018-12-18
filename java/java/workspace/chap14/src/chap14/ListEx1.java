package chap14;
//List와 ArrayList를 import
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListEx1 {

	public static void main(String[] args) {
		//
		List<Integer> list = new ArrayList<Integer>();
		//
		list.add(1);list.add(2);list.add(5); //1이라는 값이 자동으로 boxing
		list.add(4);list.add(3);list.add(0);
		list.add(0);
		System.out.println(list); //list는 toString() 오버라이딩 되어있음.
		//
		for(int i=0;i<list.size();i++) {
			System.out.println(i+":"+list.get(i)); //
		}
		//list.subList(1, 4) : list 객체에서 첨자가 1부터 4 앞까지(3까지)의 요소만 리턴.
		List<Integer> list2= new ArrayList<Integer>(list.subList(1, 4));
		System.out.println(list2); // 2, 5, 4
		// Collection : 인터페이스
		// Collections : 클래스 
		Collections.sort(list2); //list2를 정렬하여 재배치.
		System.out.println(list2); // 2, 4, 5
		Collections.sort(list); // list를 정렬하여 재배치.
		System.out.println(list);
	}

}
