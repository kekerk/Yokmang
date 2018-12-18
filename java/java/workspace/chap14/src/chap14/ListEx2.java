package chap14;

import java.util.Vector;

/*
 * Vector ���� : List ���� Ŭ����. �� Collection ���� �������� ���� Ŭ����
 * 		  	   List�� �޼���� ������ ���Ǵ� �޼��尡 ȥ�յǾ� ����.
 */
public class ListEx2 {
	public static void main(String[] args) {
		// Vector : list ��ü
		Vector <Double> list = new Vector<Double>();
		list.add(0.3); // list ��� �޼���
		list.add(Math.PI);
		list.addElement(5.0); // Vector ��� �޼���
		System.out.println(list);
		for (Double o : list) { // ������ for�� ��� ����.
			System.out.println(o);
		}
		double num = 5.0;
		int index = list.indexOf(num); //num ���� ����� �ε������� ����.
		if (index >= 0) {
			System.out.println(num + "�� ��ġ:" + index);
		} else {
			System.out.println(num + "�� list�� �����ϴ�.");
		}
		num = 0.3;
		if(list.contains(num)) { 
			list.removeElement(num);
			System.out.println(num+"������");
		}
		System.out.println(list.indexOf(num));
		System.out.println(list);
		System.out.println(list.get(2));
	}
}
