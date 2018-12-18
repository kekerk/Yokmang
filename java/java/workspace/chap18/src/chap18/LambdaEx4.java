package chap18;
/*
 *  매개변수 여러개, 리턴 값도 있을 경우.
 */
interface LambdaInterface3{
	int method(int x,int y); //매개변수 여러개, int형이라 return값 존재.
}

public class LambdaEx4 {
	public static void main(String[] args) {
		LambdaInterface3 l3 = (x,y) -> {
			return x*y;
		};
		System.out.println(l3.method(2, 3)); //6
		// 람다식의 구현부가 return 문장만 있는 경우 {} , return 구문 생략 가능.
		 l3 = (x,y) -> {return x+y;};
		 System.out.println(l3.method(2, 3)); //5
		 
		 l3 = (x,y) -> x+y ;  // 중괄호 없애면 return을 따로 입력하지 않아도 된다.
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
