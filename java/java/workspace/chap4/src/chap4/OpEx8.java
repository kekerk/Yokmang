package chap4;
/*
 * ���Կ����� ���� : ������ ���� <----
 * int a=10; a ������ 10 ���� ����.
 * ���� = (��, ����, ���, ����)
 * lvalue = ������ ������.
 * rvalue = ��, ����, ���, ���� 
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
		b*= 2; // b=b*2. int ���̶� error
		System.out.println(b);//16
		
	}

}
