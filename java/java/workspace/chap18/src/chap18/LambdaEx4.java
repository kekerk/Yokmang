package chap18;
/*
 *  �Ű����� ������, ���� ���� ���� ���.
 */
interface LambdaInterface3{
	int method(int x,int y); //�Ű����� ������, int���̶� return�� ����.
}

public class LambdaEx4 {
	public static void main(String[] args) {
		LambdaInterface3 l3 = (x,y) -> {
			return x*y;
		};
		System.out.println(l3.method(2, 3)); //6
		// ���ٽ��� �����ΰ� return ���常 �ִ� ��� {} , return ���� ���� ����.
		 l3 = (x,y) -> {return x+y;};
		 System.out.println(l3.method(2, 3)); //5
		 
		 l3 = (x,y) -> x+y ;  // �߰�ȣ ���ָ� return�� ���� �Է����� �ʾƵ� �ȴ�.
		 System.out.println(l3.method(2, 3)); //5
		 l3 = (x,y) -> {
			 return sum(x,y);
		 };
		 System.out.println(l3.method(2, 3)); //5
		 l3 = (x,y) -> {
			 return sub(x,y);
		 };
		 System.out.println(l3.method(3, 2)); //1
	}
	
	static int sum(int x, int y) {
		return x+y;
	}
	static int sub(int x, int y) {
		return x-y;
	}
	
}
