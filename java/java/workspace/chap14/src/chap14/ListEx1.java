package chap14;
//List�� ArrayList�� import
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListEx1 {

	public static void main(String[] args) {
		//
		List<Integer> list = new ArrayList<Integer>();
		//
		list.add(1);list.add(2);list.add(5); //1�̶�� ���� �ڵ����� boxing
		list.add(4);list.add(3);list.add(0);
		list.add(0);
		System.out.println(list); //list�� toString() �������̵� �Ǿ�����.
		//
		for(int i=0;i<list.size();i++) {
			System.out.println(i+":"+list.get(i)); //
		}
		//list.subList(1, 4) : list ��ü���� ÷�ڰ� 1���� 4 �ձ���(3����)�� ��Ҹ� ����.
		List<Integer> list2= new ArrayList<Integer>(list.subList(1, 4));
		System.out.println(list2); // 2, 5, 4
		// Collection : �������̽�
		// Collections : Ŭ���� 
		Collections.sort(list2); //list2�� �����Ͽ� ���ġ.
		System.out.println(list2); // 2, 4, 5
		Collections.sort(list); // list�� �����Ͽ� ���ġ.
		System.out.println(list);
	}

}
