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
//  no, name 이 같은 경우 같은 hashCode 값을 리턴.
	@Override
	public int hashCode() {
	
		return no.hashCode()+name.hashCode();
	}
//no, name 이 같으면 true를 리턴.
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

		  set.add(new Student1("1234","홍길동","경영"));

		  set.add(new Student1("2345","홍길순","경영"));

		  set.add(new Student1("1234","홍길동","컴공"));

		  set.add(new Student1("2345","홍길순","컴공"));

		  set.add(new Student1("3456","김길동","컴공"));

		  System.out.println("등록된 학생수:"+set.size());

		 //Collection 객체는 개선된 for구문을 사용 할 수 있다.

		  for(Student1 s : set) {
			 
		   System.out.println(s);    

		  }
		
		
		
	}
}
