package chap8;
class FinalValue {
	final int num; 
	FinalValue() {
		this(100); 
	}
					     //명시적 초기화가 되지 않은 상태에서 한번 초기화 가능함.
	FinalValue(int NUM){ //객체 생성에 관여하는 메서드
		this.num = NUM; //한번 초기화가 됨. 객체별로 다른 상수값이 가능함.
	}
	
	public int getnum() {
		return num;
	}
}
public class FinalValueEx {

	public static void main(String[] args) {
		FinalValue v1 = new FinalValue();
		System.out.println(v1.getnum());
//		v1.num = 200; // num은 상수이므로 변경 불가. 초기 생성자에서 100이라는 값으로 지정하고 final 변수로 선언하였으므로 값 변경 불가.
		FinalValue v2 = new FinalValue(120);
		System.out.println(v2.getnum());
	}

}
