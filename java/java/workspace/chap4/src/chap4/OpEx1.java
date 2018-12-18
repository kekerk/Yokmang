package chap4;
/*p.46
 * 증감연산자 예제
 * 
 */
public class OpEx1 {

	public static void main(String[] args) {
		int x=5, y=5;
		x++; //x라는 값을 1 증가. 5->6
		y--; //y라는 값을 1 감소. 5->4
		System.out.println("x="+x+",y="+y);
		x=y=5; //x와y에 5를 집어넣음.
		++x; //
		--y;
		System.out.println("x="+x+",y="+y);
			

	}

}
