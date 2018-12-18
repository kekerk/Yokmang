package chap4;
/*
 * 대입연산자 예제 : 연산이 방향 <----
 * int a=10; a 변수에 10 값을 저장.
 * 변수 = (값, 변수, 상수, 수식)
 * lvalue = 변수만 가능함.
 * rvalue = 값, 변수, 상수, 수식 
 */
public class OpEx8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 100;
		System.out.println(num); //100
		num += 10; // num = num + 10
		System.out.println(num); //110
		num/= 10; //num = num / 10;
		System.out.println(num);//11
		num *= 2+3; // num = num *(2+3)
		System.out.println(num);// 55
		
		byte b=1;
		b*= 2; // b=b*2
		System.out.println(b);//2
		b*= 2; // b=b*2
		System.out.println(b);//4
		b*= 2; // b=b*2
		System.out.println(b);//8
		b*= 2; // b=b*2. int 형이라서 error
		System.out.println(b);//16
		
	}

}
