package chap5;

/*
 * switch 구문
 * switch (변수,수식) {   Switch 변수, 수식으로 사용되는 자료형은 char, byte, short, int, String 만 사용가능
 * 	case 값1: 문장1; break;
 * 	case 값2: 문장2;
 *  ---
 * 	case 값n : 문장n;
 *  default : 문장m;
 *  
 */
import java.util.Scanner;

public class SwitchEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("점수를 입력하시오");
		Scanner scan = new Scanner(System.in);
		int score = scan.nextInt();
		String grade; // grade는 학점 표시기 때문에 문자열 표시를 위해 String 으로 선언
		switch (score / 10) { // ( )안의 값이 case ( ) : ~ 로 됨
		case 10:
		case 9:
			grade = "A";
			break; // break; : break가 속한 Switch 구문을 벗어난다.
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "F";
			break;
		}
		System.out.println(score + "점은 " + grade + "학점입니다.");
		// 입력된 점수가 60점 이상이면 PASS입니다.
		// 60점 미만이면 FAIL입니다.
		switch (score / 10) { // score/10 은 수식으로서 집어넣음.
		case 10:
		case 9: // break; : break가 속한 Switch 구문을 벗어난다.
		case 8:
		case 7:
		case 6:
			grade = "PASS";
			break;
		default:
			grade = "FAIL";
			break;
		}
		System.out.println(score + "점은 " + grade + "입니다.");
	}

}
