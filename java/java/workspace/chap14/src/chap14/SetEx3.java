package chap14;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/*
 * TreeSet : Set ���� Ŭ����. �ߺ� �Ұ�, ���ĵ�.
 * SortedSet �������̽� : Set �������̽��� ���� �������̽�
 * 
 * Comparator �������̽� : TreeSet ��ü�� Comparator ��ü�� �����ϸ�
 * 						Comparator ��ü���� ������ ������� ���� ����.
 * 	int compare(Object  o1, Object o2)
 * 		��� ��� : o2 ��
 * 		��� ���� : o1 ��
 */
public class SetEx3 {
	public static void main(String[] args) {
		//TreeSet Ŭ������ SortedSet�� ���� Ŭ����.
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
		//.subSet�� SortedSet�� ���. ������ �Ǿ��� �� ��� ������ ���.
		System.out.println("from:"+from+",to:"+to);
		System.out.println(set.subSet(from, to));
		System.out.println("from:"+from+",to:"+to+"zzzz");
		System.out.println(set.subSet(from, to+"zzzz"));
		
		
		
		System.out.println("�������� �����ϱ�");
//		set  = new TreeSet<String>(new Descending());
		set = new TreeSet<String>(new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				Comparable c1 = (Comparable) o1;
				Comparable c2 = (Comparable) o2;
				
				//c1.compareTo(c2) �������� �ε� *(-1)�� �ϸ� ������������ ����.
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
//Descending Ŭ������ ��üȭ�� Comparator�� ��üȭ�� �̷�����Ƿ� Comparator�� compare �޼��带 �����.
//class Descending implements Comparator{
//
//	@Override
//	public int compare(Object o1, Object o2) {
//		Comparable c1 = (Comparable) o1;
//		Comparable c2 = (Comparable) o2;
//		
//		//c1.compareTo(c2) �������� �ε� *(-1)�� �ϸ� ������������ ����.
//		return c1.compareTo(c2)*(-1);
//	}
//	
//}
