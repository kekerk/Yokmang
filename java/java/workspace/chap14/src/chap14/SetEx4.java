package chap14;

import java.util.Comparator;
import java.util.TreeSet;

/*
 * TreeSet ���� : MyClass�� �����ϱ�.
 * 				TreeSet ��ü�� �߰��� MyClass�� �ݵ�� Comparable �������̽��� �����ؾ���.
 * 				���������� Comparator�� Comparable�� �����ϱ⶧���� �������̽��� implements ������� �Ѵ�.
 * 
 *���������� Comparator�� ����� ���� �Ѵ�.
 */
class Phone implements Comparable{
	String name;
	int number;
	public Phone(String name, int number) {
		super();
		this.name = name;
		this.number = number;
	}
	@Override
	public String toString() {
		return "Phone [name=" + name + ", number=" + number + "]";
	}
	
	
// Ŭ������ Comparable�� ������Ű��. compareTo ����� �������̵�.
	//Phone Ŭ������ �⺻���Ĺ���� �̸��� ������������ ������.
	@Override
	public int compareTo(Object o) {
		Phone p = (Phone) o;
		return name.compareTo(p.name);
		
	}
	
}
//Phone�� Comparable�� ����ȯ�� �ȵ�.
public class SetEx4 {
	public static void main(String[] args) {
		TreeSet<Phone> set = new TreeSet<Phone>();
		set.add(new Phone("ȫ�浿",1234));
		set.add(new Phone("���",3456));
		set.add(new Phone("�̸���",5678));
		System.out.println("�̸��� ������������ ����");
		System.out.println(set);
		for(Phone p : set) {
			System.out.println(p);
		}
		
		System.out.println("��ȭ��ȣ�� ������������ ����");
		set = new TreeSet<Phone>(new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				Phone p1 = (Phone)o1;
				Phone p2 = (Phone)o2;
				//������� ���� : o1�� ������ ��.
				//������� ��� : o2�� ������ ��.
				return p1.number - p2.number;
			}
		});
		set.add(new Phone("ȫ�浿",1234));
		set.add(new Phone("���",3456));
		set.add(new Phone("�̸���",5678));
		for(Phone s : set) {
			System.out.println(s);
		}
		System.out.println("�̸��� ������������ ����");
		set = new TreeSet<Phone>(new NameDesc());
		set.add(new Phone("ȫ�浿",1234));
		set.add(new Phone("���",3456));
		set.add(new Phone("�̸���",5678));
		for(Phone s : set) {
			System.out.println(s);
		}
		System.out.println("��ȭ��ȣ�� ������������ ����");
		set = new TreeSet<Phone>(new NumberDesc());
		set.add(new Phone("ȫ�浿",1234));
		set.add(new Phone("���",3456));
		set.add(new Phone("�̸���",5678));
		for(Phone s : set) {
			System.out.println(s);
		}
	}
}


class NameDesc implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Phone p1 = (Phone) o1;
		Phone p2 = (Phone) o2;
//		return p1.compareTo(p2)*(-1);
		return p2.compareTo(p1);
	}
	
}
//������ �������� ���� : p1.�������� - p2.��������
class NumberDesc implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Phone p1 = (Phone) o1;
		Phone p2 = (Phone) o2;
		return (p1.number - p2.number)*(-1);
//		return p2.number-p1.number;
	}
	
}
