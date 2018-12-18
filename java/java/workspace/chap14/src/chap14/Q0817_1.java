package chap14;

import java.util.HashSet;
import java.util.Set;

class Student1 {

	 String no,name,dept;

	 Student1(String no, String name, String dept) {

	  this.no = no;

	  this.name = name;

	  this.dept = dept;

	 }
//  no, name �� ���� ��� ���� hashCode ���� ����.
	@Override
	public int hashCode() {
	
		return no.hashCode()+name.hashCode();
	}
//no, name �� ������ true�� ����.
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student s = (Student) obj;
			return name.equals(s.name) && no.equals(s.no);
		} else {
			return false;
		}
		
	}
	 
	 
	 
}
public class Q0817_1 {
	public static void main(String[] args) {
		Set<Student1> set = new HashSet<Student1>();

		  set.add(new Student1("1234","ȫ�浿","�濵"));

		  set.add(new Student1("2345","ȫ���","�濵"));

		  set.add(new Student1("1234","ȫ�浿","�İ�"));

		  set.add(new Student1("2345","ȫ���","�İ�"));

		  set.add(new Student1("3456","��浿","�İ�"));

		  System.out.println("��ϵ� �л���:"+set.size());

		 //Collection ��ü�� ������ for������ ��� �� �� �ִ�.

		  for(Student1 s : set) {
			 
		   System.out.println(s);    

		  }
		
		
		
	}
}
