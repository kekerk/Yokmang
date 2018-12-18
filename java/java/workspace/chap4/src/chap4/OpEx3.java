package chap4;

public class OpEx3 {

	public static void main(String[] args) {
		int x=5, y=5;
		System.out.println("(x++ + y--)="+ (x++ + y--)); //x=5, y=5 출력, x=6, y=4 저장
		System.out.println("(x++ + y--)="+ (++x + --y)); //x=7, y=3 출력, x=7, y=3 저장
		System.out.println("(x++ + y--)="+ (++x + y--)); //x=8, y=3 출력, x=8, y=2 저장
		System.out.println("(x++ + y--)="+ (x++ + --y)); //x=8, y=2 출력, x=8, y=1 저장
		

	}

}
