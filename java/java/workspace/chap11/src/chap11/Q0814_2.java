package chap11;


class Outer2 {

	 static class Inner { //����Ŭ������ ��ü�� �ڷ���

	  int iv = 200;  

	 }

	}
public class Q0814_2 {

	public static void main(String[] args) {
		Outer2.Inner i = new Outer2.Inner();
		System.out.println(i.iv);

	}

}
