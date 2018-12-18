package chap14;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*
 * Iterator 인터페이스 : 반복자. Collection 객체는 Iterator 객체로 변환 가능.
 *  멤버 메서드 
 *  	hasNext() : 조회대상 요소가 존재하는지? 있으면 true
 *  	next()    : 객체 조회.
 *  	remove()  : 조회된 객체를 삭제. next() 메서드 이후에 사용 가능.
 *  	모든 Collection 개체에 다 쓸수 있다.
 *  
 *  Enumeration 인터페이스 : Collection 이전에 사용되던 반복자.
 *  					  Vector, Hashtable 객체만 반복가능.
 *  	hasMoreElements() : 조회 대상 요사가 존재하는지. 맞다면 true
 *  	nextElement()	  : 객체 조회.
 *  
 *  ListIterator : Iterator  인터페이스의 하위 인터페이스
 *  			   Iterator : next 방향만 가능
 *  			   ListIterator : next, previous 양방향 가능.
 *								   추가 및 수정도 가능.  
 */
public class IteratorEx1 {
	public static void main(String[] args) {
		Iterator it = null;
		List list = new ArrayList();
		Set set = new HashSet();
		for(int i=1;i<=5;i++) {
			list.add(i*10);
			set.add(i);
		}
		System.out.println(list);
		System.out.println(set);
		it = list.iterator();
		print(it);
		it = set.iterator();
		print(it);
		System.out.println(list);
		System.out.println(set);
	}
	private static void print (Iterator it) {
		while(it.hasNext()) {
			System.out.println(it.next());
			it.remove();
		}
	}
}
