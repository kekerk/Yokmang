package chap7;
/*
 * 클래스 멤버와 인스턴스멤버간의 호출
 * 클래스 멤버에서 인스턴스멤버를 호출할 때에는 객체화 필요.
 */
public class MainCallEx2 {
	static int cv1 = 10; //클래스멤버
	static int cv2 = cv1;//클래스멤버
	int iv1 = 100;		 //인스턴스멤버. 객체화 필요
	int iv2 = iv1;		 //인스턴스멤버. 객체화 필요
	static int cv3 = new MainCallEx2().iv2; //main 메서드 밖에서도 객체화가 가능하다.
	
	public static void main(String[] args) {
		MainCallEx2  mc = new MainCallEx2();
		cv2 = mc.iv1;
		 //iv1이 실행되기 전에 객체화가 되어야한다.
		mc.method1();
		method2();
	}
		void method1() { // 객체화가 되어야한다.
		//인스턴스 메서드
			System.out.println(cv1+cv2);  
			System.out.println(iv1+iv2);
		}
		
		static void method2() { //클래스 메서드
			MainCallEx2  mc = new MainCallEx2();
			System.out.println(cv1+cv2);
			System.out.println(mc.iv1+mc.iv2); //
		}
		
	}


