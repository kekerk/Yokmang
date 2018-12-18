package chap12;

/*
 * count 메서드 구현하기.
 * 매개변수 : String str1, String str2
 * 기능 : str1문자열 중 str2 문자열이 몇번 존재하는지 리턴.
 * 리턴 타입 int 
 */
public class Exam1 {

	public static void main(String[] args) {

		System.out.println(count("12345AB12AB345AB", "12")); // 2
		System.out.println(count("12345AB12AB345AB", "AB")); // 3
		System.out.println(count("12345", "6"));
	}

	public static int count(String str1, String str2)//메서드 구현 (선언부)
	{ 												 //메서드 구현 (몸통부)
		int num = 0, count = 0;
		while (true) {

			num = str1.indexOf(str2, num);
			if (num >= 0) { //str1에 str2문자열이 존재.
				num++;
				count++;
			} else { //num이 -1이 되면 break; 걸린다.
				break;
			}
		}
		return count;
	}

}
