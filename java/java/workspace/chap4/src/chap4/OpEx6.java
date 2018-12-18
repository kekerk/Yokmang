package chap4;
/*
 * 비트 연산자 예제 :
 * &,|,^,~
 * & : 모든 비트를 and
 * | : 모든 비트를 or
 * ^ : 모든 비트를 xor
 * ~ : not, 0->1 , 1-> 0 변환
 */
public class OpEx6 {

	public static void main(String[] args) {
		System.out.println(6&3);
		System.out.println(6|3);
		System.out.println(6^3);
		System.out.println(~255);
/*
 *  10 : 00001010
 * ~10 : 11110101  부호 비트가 1 : 음수
 *  자바의 음수는 2의 보수로 표현
 *  1110101 : ?의 2의 보수 (2의보수는 1의보수 +1)
 *  ? 는 1110101의 보수를 계산함 
 *  1의 보수 :0001010
 *     +1  : 0001011 1110101은  11의 2의 보수
 *     결과는 -11로 출력됨.
 */
		
	}

}
