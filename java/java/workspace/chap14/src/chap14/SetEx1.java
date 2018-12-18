package chap14;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*
 * set 예제 : 같은 객체를 두번 저장 하지 않음. 중복불가. 순서유지가 안됨.
 * 구현클래스 : HashSet : 순서 알수없음.
 *           TreeSet : 정렬되는 순서.
 */
public class SetEx1 {
	public static void main(String[] args) {
		Object arr[] = { "홍길동", 1, "1", "김삿갓", "이몽룡", "홍길동", "성춘향", "향단이", "홍길동", "김삿갓" };

		Set<Object> set1 = new HashSet<Object>();
		Set<Object> set2 = new HashSet<Object>();
		Set<Object> set3 = new HashSet<Object>();
		for (int i = 0; i < arr.length; i++) {
			
			if (!set1.add(arr[i])) { //이미 추가된게 있으면 추가가 안되고 set2로 넘어간다.
				if (!set2.add(arr[i])) { // 
					set3.add(arr[i]);
				}
			}
		}
		
		
		System.out.println(set1);
		System.out.println(set2);
		System.out.println(set3);

	}
}
