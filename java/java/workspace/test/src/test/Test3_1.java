package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test3_1 {
	public static void main(String[] args) {
	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	
	for(int i=1;i<=10;i++) {
		map.put(i, i);
		}
	
	List<Integer> list1 = (List<Integer>) map.keySet();
	List<Integer> list2 = (List<Integer>) map.values();
	
	for(int i=0;i<list1.size();i++) {
		for(int j=0;j<list2.size();j++) {
			if((2*list1.get(i))+(2*list2.get(j))==10) {
				System.out.println("x:"+list1.get(i)+",y:"+list2.get(j));
			}
		}
	}

	}

}
