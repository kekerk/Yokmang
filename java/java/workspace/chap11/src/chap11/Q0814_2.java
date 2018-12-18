package chap11;


class Outer2 {

	 static class Inner { //내부클래스의 객체의 자료형

	  int iv = 200;  

	 }

	}
public class Q0814_2 {

	public static void main(String[] args) {
		Outer2.Inner i = new Outer2.Inner();
		System.out.println(i.iv);

	}

}
