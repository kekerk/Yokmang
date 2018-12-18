package chap14;

import java.util.HashSet;
import java.util.Set;

class Student {

	 String no,name,dept;

	 Student(String no, String name, String dept) {

	  this.no = no;

	  this.name = name;

	  this.dept = dept;

	 }

	 @Override

	 public String toString() {

	  return "("+no+","+name+","+dept+")";

	 }

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return name.hashCode()+no.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student s = (Student) obj;
			return name.equals(s.name)&& no.equals(s.no) ;
		} else {
			return false;
		}
		
	}

	 
	}


public class Q0817 {

	public static void main(String[] args) {
		 Set<Student> set = new HashSet<Student>();

		  set.add(new Student("1234","ȫ�浿","�濵"));

		  set.add(new Student("2345","ȫ���","�濵"));

		  set.add(new Student("1234","ȫ�浿","�İ�"));

		  set.add(new Student("2345","ȫ���","�İ�"));

		  set.add(new Student("3456","��浿","�İ�"));

		  System.out.println("��ϵ� �л���:"+set.size());

		 //Collection ��ü�� ������ for������ ��� �� �� �ִ�.

		  for(Student s : set) {
			 
		   System.out.println(s);    

		  }

	}

}
