package chap7;
/*
 * 매개변수 예제
 * 기본형 매개변수 : 조회만 가능
 * 				값을 복사하여 호출되기 때문에 원래의 객체  값의 변경이 안된다.
 * 참조형 매개변수 : 조회와 변경 가능
 * 				참조값을 복사하여 호출되기 때문에 원래의 객체의 값을 변경할 수 있다.
 */
class Value{
	int val;
}
public class ParameterEx1 {

	public static void main(String[] args) {
		Value v = new Value();
		v.val = 100;
		change1(v.val);
		System.out.println("change1() 이후:"+ v.val);
		change2(v);
		System.out.println("change2() 이후:"+ v.val);
		
		
	}
	static void change1(int val) {
		val += 100;
		System.out.println("change1() :" + val);
	}
	static void change2(Value v) {
		v.val += 100;
		System.out.println("change2() :" + v.val);
	}

}
