package chap4;

public class OpEx2 {

	public static void main(String[] args) {
		int x=5, y=5;
		x++; //x라는 값을 1 증가. 5->6
		y--; //y라는 값을 1 감소. 5->4
		System.out.println("x="+x+",y="+y);
		x=y=5; //x와y에 5를 집어넣음.
		++x; //
		--y;
		System.out.println("x="+x+",y="+y);
		x=5;
		y=x++; //대입연산이 먼저 실행되고 x++이 실행
		System.out.println("x="+x+",y="+y); //x=6, y=5 
		x=5;
		y=++x;
		System.out.println("x="+x+",y="+y); //x=6, y=6 ++x가 먼저 연산되고 그다음 대입연산 실행, 
		System.out.println("x="+ x++); //6을 먼저 기능으로 전달, 그다음 자기가 하나 증가, 7인 상태
		System.out.println("x="+ ++x); // 먼저 7을 8로 하나 증가, 그다음 8로 출력.
		System.out.println("x="+ --x +",y=" + y--);
		System.out.println("x="+x+",y="+y);
	}

}
