package chap4;

import java.util.Scanner;

import javax.sound.midi.Synthesizer;

/*
 * ���ǿ�����(���׿�����) : (���ǽ�) ? �� : ����
 */
public class OpEx9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("������ �Է��ϼ���(0~100)");
		Scanner scan = new Scanner(System.in);
		int score = scan.nextInt();
		String result = (score >=60)? "�հ�":"���հ�";
		System.out.println(score+":"+result);
		//���ھ ¦������ Ȧ������ ����ϱ�
		System.out.println(score+":"+((score%2==0)?"¦��":"Ȧ��"));
	}

}