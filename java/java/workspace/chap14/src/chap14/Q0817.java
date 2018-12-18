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

		  set.add(new Student("1234","홍길동","경영"));

		  set.add(new Student("2345","홍길순","경영"));

		  set.add(new Student("1234","홍길동","컴공"));

		  set.add(new Student("2345","홍길순","컴공"));

		  set.add(new Student("3456","김길동","컴공"));

		  System.out.println("등록된 학생수:"+set.size());

		 //Collection 객체는 개선된 for구문을 사용 할 수 있다.

		  for(Student s : set) {
			 
		   System.out.println(s);    

		  }

	}

}
