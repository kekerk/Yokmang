package chap14;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/*
 * TreeSet : Set 구현 클래스. 중복 불가, 정렬됨.
 * SortedSet 인터페이스 : Set 인터페이스의 하위 인터페이스
 * 
 * Comparator 인터페이스 : TreeSet 객체시 Comparator 객체를 설정하면
 * 						Comparator 객체에서 지정된 방식으로 정렬 가능.
 * 	int compare(Object  o1, Object o2)
 * 		결과 양수 : o2 앞
 * 		결과 음수 : o1 앞
 */
public class SetEx3 {
	public static void main(String[] args) {
		//TreeSet 클래스는 SortedSet의 구현 클래스.
		SortedSet<String> set = new TreeSet<String>();
		String from = "bat";
		String to = "d";
		set.add("abc"); set.add("alien");
		set.add("bat"); set.add("azz");
		set.add("car"); set.add("Car");
		set.add("disco"); set.add("dance");
		set.add("dZZZZ"); set.add("dzzzz");
		set.add("elevator"); set.add("fan");
		set.add("flower");
		
		System.out.println(set);
		//.subSet은 SortedSet의 기능. 정렬이 되었을 때 사용 가능한 기능.
		System.out.println("from:"+from+",to:"+to);
		System.out.println(set.subSet(from, to));
		System.out.println("from:"+from+",to:"+to+"zzzz");
		System.out.println(set.subSet(from, to+"zzzz"));
		
		
		
		System.out.println("역순으로 정렬하기");
//		set  = new TreeSet<String>(new Descending());
		set = new TreeSet<String>(new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				Comparable c1 = (Comparable) o1;
				Comparable c2 = (Comparable) o2;
				
				//c1.compareTo(c2) 오름차순 인데 *(-1)을 하면 내림차순으로 변경.
				return c1.compareTo(c2)*(-1);
			}
			
		});
		set.add("abc"); set.add("alien");
		set.add("bat"); set.add("azz");
		set.add("car"); set.add("Car");
		set.add("disco"); set.add("dance");
		set.add("dZZZZ"); set.add("dzzzz");
		set.add("elevator"); set.add("fan");
		set.add("flower");
		System.out.println(set);
		System.out.println("from:"+to+",to:"+from);
		System.out.println(set.subSet(to, from));
		System.out.println("from:"+to+"zzzz"+",to:"+from);
		System.out.println(set.subSet(to+"zzzz", from));
		
		
	}
}
//Descending 클래스의 객체화는 Comparator의 객체화도 이루어지므로 Comparator의 compare 메서드를 사용함.
//class Descending implements Comparator{
//
//	@Override
//	public int compare(Object o1, Object o2) {
//		Comparable c1 = (Comparable) o1;
//		Comparable c2 = (Comparable) o2;
//		
//		//c1.compareTo(c2) 오름차순 인데 *(-1)을 하면 내림차순으로 변경.
//		return c1.compareTo(c2)*(-1);
//	}
//	
//}
