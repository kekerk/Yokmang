package chap5;

/*
 * switch ����
 * switch (����,����) {   Switch ����, �������� ���Ǵ� �ڷ����� char, byte, short, int, String �� ��밡��
 * 	case ��1: ����1; break;
 * 	case ��2: ����2;
 *  ---
 * 	case ��n : ����n;
 *  default : ����m;
 *  
 */
import java.util.Scanner;

public class SwitchEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("������ �Է��Ͻÿ�");
		Scanner scan = new Scanner(System.in);
		int score = scan.nextInt();
		String grade; // grade�� ���� ǥ�ñ� ������ ���ڿ� ǥ�ø� ���� String ���� ����
		switch (score / 10) { // ( )���� ���� case ( ) : ~ �� ��
		case 10:
		case 9:
			grade = "A";
			break; // break; : break�� ���� Switch ������ �����.
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
		System.out.println(score + "���� " + grade + "�����Դϴ�.");
		// �Էµ� ������ 60�� �̻��̸� PASS�Դϴ�.
		// 60�� �̸��̸� FAIL�Դϴ�.
		switch (score / 10) { // score/10 �� �������μ� �������.
		case 10:
		case 9: // break; : break�� ���� Switch ������ �����.
		case 8:
		case 7:
		case 6:
			grade = "PASS";
			break;
		default:
			grade = "FAIL";
			break;
		}
		System.out.println(score + "���� " + grade + "�Դϴ�.");
	}

}
