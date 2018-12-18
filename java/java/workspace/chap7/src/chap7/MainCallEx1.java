package chap7;
/*
 * 클래스 멤버와 인스턴스멤버간의 호출
 */
public class MainCallEx1 {
	static int cv1 = 10;
	static int cv2 = cv1;
	int iv1 = 100;
	int iv2 = iv1;
	public static void main(String[] args) {
		cv2= iv1;
		method1();
		method2();
	}
		void method1() {
			
			System.out.println(cv1+cv2);
			
			System.out.println(iv1+iv2);
		}
		
		static void method2() {
			System.out.println(cv1+cv2);
			System.out.println((iv1+iv2));
		}
		
	}


