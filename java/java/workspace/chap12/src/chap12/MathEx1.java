package chap12;
/*
 * math class : 모든 멤버가 static.
 * 				math.메소드명.
 * 				math.상수명.
 * 				final class -> 다른 클래스가 상속받을 수 없다.
 */
public class MathEx1 {

	public static void main(String[] args) {
		//abs() : 절대값
		System.out.println(Math.abs(5));//5
		System.out.println(Math.abs(-5));//5
		//ceil(숫자) : 숫자보다 큰 근사 정수
		System.out.println(Math.ceil(5.4));//6.0
		System.out.println(Math.ceil(-5.4));//-5.0
		//floor(숫자) : 숫자보다 작은 근사 정수
		System.out.println(Math.floor(5.4)); //5.0
		System.out.println(Math.floor(-5.4));//-6.0
		//rint(숫자) : 숫자와 가장 가까운 근사 정수		
		System.out.println(Math.rint(5.4)); //5.0
		System.out.println(Math.rint(-5.4)); //-5.0
		// max: 두 수중 큰 값, min: 두 수중 작은 값
		System.out.println(Math.max(5.4,5.3));//5.4
		System.out.println(Math.min(5.4,5.3));//5.3
		//round : 반올림. 정수값.
		System.out.println(Math.round(5.4)); // 5
		System.out.println(Math.round(5.5)); // 6
		//random : 임의의 수 0 <= x < 1.0
		System.out.println(Math.random());//?
		//로그함수
		System.out.println(Math.log(Math.E));//1.0
		//root(제곱근)
		System.out.println(Math.sqrt(25));//5.0
		//제곱
		System.out.println(Math.pow(5, 4));//5*5*5*5
		//sin : radian 단위.
		System.out.println(Math.sin(Math.PI/2));//1.0
		//cos : 60?
		System.out.println(Math.cos(Math.toRadians(60)));// 0.5
		//degrees  <= 라디안
		System.out.println(Math.toDegrees(Math.PI/2)); //90.0
		//tan 45?
		System.out.println(Math.tan(Math.PI/4)); // 0.99999999999
	}
	}
