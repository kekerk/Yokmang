package chap4;

import java.util.Scanner;//

//�ʸ� ȭ�鿡�� �Է¹޾� ����ϱ�
public class Exam1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int a = 12345;
		System.out.println("����� �ʸ� �Է��Ͻÿ�");
		//System.in : ǥ�� �Է� (Ű����κ��� �Է�)
		// Scanner : ǥ�� �Է� ��Ʈ���� ���Ͽ� �����͸� �Է¹޴� Ŭ����
		Scanner scan = new Scanner(System.in); 
		int a = scan.nextInt();//�Է¹��� ���ڸ� ���������� �ٲٴ� ��
		int h = (int)(a/3600);
		int m = (int)(a%3600) / 60;
		int s = (int)(a%3600) % 60;
		System.out.println("����ð�:"+h+"��"+m+"��"+s+"��");
	}

}
