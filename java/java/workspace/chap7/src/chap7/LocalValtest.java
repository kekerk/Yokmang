package chap7;

//예제 7-4 : 지역변수 예제
public class LocalValtest {

	public static void main(String[] args) {
		//args : 매개변수도 지역변수
		int num; //지역변수
		boolean b = true; //지역변수
		if (b) {
			num = 100;
		} else {
			num = 200;
		}
		System.out.println(num);
		String grade="F"; //지역변수   //초기화를 해주어야 한다.  지역변수는 무조건 초기화해야한다.
		int score= 80; //지역변수
		switch(score/10) {
		case 9: grade = "A"; break;
		case 8: grade = "B"; break;
		case 7: grade = "A"; break;
		case 6: grade = "D"; break;
//		default : grade ="F";
		}
		System.out.println("학점: "+grade);
	}

}
