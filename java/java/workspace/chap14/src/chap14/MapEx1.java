package chap14;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Map 인터페이스 : (key, 객체) 쌍인 객체들의 모임.
 * 				  key는 중복되면안된다. 유일해야함.
 * 			      
 * 구현 클래스 
 *   HashMap, Hashtable, TreeMap
 *   
 */
public class MapEx1 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String[] names = {"홍길동","김삿갓","이몽룡","임꺽정","김삿갓"};
		int[] nums = {1234,4567,2350,9870,2345};
		for(int i=0;i<names.length;i++) {
			map.put(names[i], nums[i]);
			
		}
		System.out.println(map);
		System.out.println("홍길동 번호: "+map.get("홍길동"));
		System.out.println("이몽룡 번호: "+map.get("이몽룡"));
		System.out.println("김삿갓 번호: "+map.get("김삿갓"));
		System.out.println("임꺽정 번호: "+map.get("임꺽정"));
		//Map 객체 중에서 Key값만 조회하기.
		//key는 중복이 되지 않기 떄문에 Set의 객체로 전달.
		Set<String> keys = map.keySet(); //key 목록만 가져오는 기능.
		for(String k : keys) {
			System.out.println(k+"="+map.get(k)); // k:String "홍길동 등"
												  // map.get(k) name에 대한 value값 리턴.
		}
		
		//Map 객체 중에서 Value 값들만 조회하기.
		//중복이 될 수도 있고, 순서는 상관하지 않으니, Collection
		Collection<Integer> values = map.values(); //values 목록만 가져오는 기능.
		for(Integer i : values) {
			//객체들만 가져온다.
			System.out.println(i);
		}
/////////////////////////////////////////////////////////////////////////////////
		
		//values Iterator 가능 ? True. values가 Collection으로 선언되었기 때문에.
		Iterator i = values.iterator();
		while(i.hasNext()) { 
			System.out.println(i.next());
		}
	///////////////////////////////////////////////////////////////////
		
		//Map 객체에서 (Key,value) 쌍인 객체 조회하기.
		Set<Map.Entry<String, Integer>> entry = map.entrySet(); //key 값이 다르니 Set(중복방지)
		for(Map.Entry<String, Integer> m : entry) {
			System.out.println(m.getKey()+"="+m.getValue());  //.getKey() : key 값만 리턴
			System.out.println(m);							  //.getValue() : value 값만 리턴.
		}
		
	}
}
