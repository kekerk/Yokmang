package chap10;
/*
 * 내부클래스는 외부클래스의 멤버 중 하나임.
 * 외부클래스의 private 멤버에 접근 가능.
 */
class Outer2{
	private int outeriv = 10;
	private static int outercv = 20;
	class InstanceInner{
		int iiv = outeriv;
		int iiv2 = outercv;
	}
	static class StaticInner{ //클래스 멤버 - 클래스화가 명확히 되어야 하므로 outeriv의 값을 정확히 초기화하여야한다.
//		int siv = outeriv; 오류
		int siv = new Outer2().outeriv; 
		static int scv = outercv;
	}
	
	static StaticInner cv = new StaticInner();
	InstanceInner iv = new InstanceInner();
//	static InstanceInner cv2 = new InstanceInner(); 오류
	static InstanceInner cv2 = new Outer2().new InstanceInner();
	
	//외부 클래스의 멤버 메서드
	void method(int pv) {
     	// pv = 100;
		final int num = 100; //상수화.
		class LocalInner { // 지역 내부 클래스
			int liv = outeriv;
			int liv2 = outercv;
			void method() { //지역 내부 클래스의 멤버 메서드
				/*
				 *  외부 메서드의 지역변수를 지역 내부클래스에서 접근하려면 상수화되어야 한다.
				 *  상수화 : 변경되면 안됨. final을 붙여 안전하게 초기화시킨다.
				 */
				System.out.println("pv="+pv);
				System.out.println("num="+num);
				System.out.println(liv+","+liv2);
				System.out.println(outeriv+","+outercv); //outercv :외부 클래스의 private 멤버
			}
		}
		LocalInner li = new LocalInner();
		li.method();
	}
	
}
public class InnerEx2 {
	public static void main(String[] args) {
		Outer2 outer = new Outer2(); //외부 클래스의 객체 생성 및 초기화.
		outer.method(1);
		// 1. InstanceInner 클래스의 객체 생성하고, 멤버 변수 출력하기.
		Outer2.InstanceInner ii = outer.new InstanceInner();
		System.out.println(ii.iiv);
		System.out.println(ii.iiv2);
		// 2. StaticInner 클래스의 객체 생성하고, 멤버 변수 출력하기.
		Outer2.StaticInner si = new Outer2.StaticInner();
		System.out.println(si.siv);
		System.out.println(si.scv);
		
		
	}
}
