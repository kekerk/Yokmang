package chap4;

public class OpEx3 {

	public static void main(String[] args) {
		int x=5, y=5;
		System.out.println("(x++ + y--)="+ (x++ + y--)); //x=5, y=5 ���, x=6, y=4 ����
		System.out.println("(x++ + y--)="+ (++x + --y)); //x=7, y=3 ���, x=7, y=3 ����
		System.out.println("(x++ + y--)="+ (++x + y--)); //x=8, y=3 ���, x=8, y=2 ����
		System.out.println("(x++ + y--)="+ (x++ + --y)); //x=8, y=2 ���, x=8, y=1 ����
		

	}

}
