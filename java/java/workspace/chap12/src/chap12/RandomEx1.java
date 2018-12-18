package chap12;
import java.util.Random;
/*
 * Random 클래스 : 난수 발생 클래스.
 * 			1. 자료형 별로 난수 발생.
 * 				nextInt()     : 정수형 난수 리턴
 * 				nextInt(n)    : 0 <= x < n 정수형 난수 리턴.
 * 				nextDouble()  : 실수형 난수 리턴. (0 <= x < 1.0)
 * 				nextBoolean() : true, false 둘 중 하나 리턴.
 * 			2. seed 설정 가능.
 * 				
 */
public class RandomEx1 {
	public static void main(String[] args) {
		Random rand = new Random();
		//setSeed(long):seed 설정.
		//System.currentTimeMillis() : 1970년부터 지금까지의 시간을 밀리초로 리턴.
		//                             같은 난수를 표현할 수 없게. 많이 쓰임.
		rand.setSeed(System.currentTimeMillis());
		//
		for(int i=0;i<5;i++) {
			System.out.println(i+":"+rand.nextInt(1000));
		}
		
		Random rand1 = new Random();
		Random rand2 = new Random();
		//seed값에 따라 나오는 난수가 고정된다.
		//seed값이 같으면 다른 객체라도 같은 난수값이 표현됨.
		//.setSeed(long l);
		rand1.setSeed(0L); rand2.setSeed(0L);
		System.out.println("rand1 난수 ==>");
		for(int i=0;i<5;i++) {
			System.out.println(i+":"+rand1.nextInt(10));
		}
		System.out.println("rand2 난수 ==>");
		for(int i=0;i<5;i++) {
			System.out.println(i+":"+rand2.nextInt(10));
		}
		
		
	}
}
