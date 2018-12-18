package chap14;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Map �������̽� : (key, ��ü) ���� ��ü���� ����.
 * 				  key�� �ߺ��Ǹ�ȵȴ�. �����ؾ���.
 * 			      
 * ���� Ŭ���� 
 *   HashMap, Hashtable, TreeMap
 *   
 */
public class MapEx1 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String[] names = {"ȫ�浿","���","�̸���","�Ӳ���","���"};
		int[] nums = {1234,4567,2350,9870,2345};
		for(int i=0;i<names.length;i++) {
			map.put(names[i], nums[i]);
			
		}
		System.out.println(map);
		System.out.println("ȫ�浿 ��ȣ: "+map.get("ȫ�浿"));
		System.out.println("�̸��� ��ȣ: "+map.get("�̸���"));
		System.out.println("��� ��ȣ: "+map.get("���"));
		System.out.println("�Ӳ��� ��ȣ: "+map.get("�Ӳ���"));
		//Map ��ü �߿��� Key���� ��ȸ�ϱ�.
		//key�� �ߺ��� ���� �ʱ� ������ Set�� ��ü�� ����.
		Set<String> keys = map.keySet(); //key ��ϸ� �������� ���.
		for(String k : keys) {
			System.out.println(k+"="+map.get(k)); // k:String "ȫ�浿 ��"
												  // map.get(k) name�� ���� value�� ����.
		}
		
		//Map ��ü �߿��� Value ���鸸 ��ȸ�ϱ�.
		//�ߺ��� �� ���� �ְ�, ������ ������� ������, Collection
		Collection<Integer> values = map.values(); //values ��ϸ� �������� ���.
		for(Integer i : values) {
			//��ü�鸸 �����´�.
			System.out.println(i);
		}
/////////////////////////////////////////////////////////////////////////////////
		
		//values Iterator ���� ? True. values�� Collection���� ����Ǿ��� ������.
		Iterator i = values.iterator();
		while(i.hasNext()) { 
			System.out.println(i.next());
		}
	///////////////////////////////////////////////////////////////////
		
		//Map ��ü���� (Key,value) ���� ��ü ��ȸ�ϱ�.
		Set<Map.Entry<String, Integer>> entry = map.entrySet(); //key ���� �ٸ��� Set(�ߺ�����)
		for(Map.Entry<String, Integer> m : entry) {
			System.out.println(m.getKey()+"="+m.getValue());  //.getKey() : key ���� ����
			System.out.println(m);							  //.getValue() : value ���� ����.
		}
		
	}
}
