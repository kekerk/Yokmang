package chap7;
/*
 * 예제 7-17
 * static(클래스) 초기화 블럭 :
 *     클래스 변수의 초기화를 담당
 *     main 메서드 이전에 호출됨. 한번만 호출됨.                    
 * 
 * 인스턴스 초기화 블럭 
 * 		주로 인스턴스 변수의 초기화를 담당. 생성자와 기능이 겹침.
 * 	 	생성자보다 먼저 호출됨.
 * 		객체화될 때마다 생성자보다 먼저 호출됨.
 */
public class InitEx {
	static int cv;
	int iv;
	InitEx() {
		System.out.println("5. 생성자 호출됨");
	}
	static { //static 을 주고 중괄호 생성하면 static 초기화 블럭. main보다 먼저 실행. (1)
		cv = (int)(Math.random()*100);
		System.out.println("1.클래스 초기화 블럭 실행 cv= "+ cv);
//		System.out.println(iv); //오류
	    System.out.println(new InitEx().iv);
	}
	{  //static없이 바로 중괄호 생성되면 인스턴스 초기화 블럭.
		System.out.println("4. 인스턴스 초기화 블럭. 생성자보다 먼저 실행됨.");
	}
	public static void main(String[] args) {
		System.out.println("2. main 메서드 시작");
		System.out.println("3. main init1 객체 생성");
		InitEx init1 = new InitEx();
		System.out.println("6. main init2 객체 생성");
		InitEx init2 = new InitEx();
		
		
	}

}
