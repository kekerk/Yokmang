package chap7;

//���� 7-4 : �������� ����
public class LocalValtest {

	public static void main(String[] args) {
		//args : �Ű������� ��������
		int num; //��������
		boolean b = true; //��������
		if (b) {
			num = 100;
		} else {
			num = 200;
		}
		System.out.println(num);
		String grade="F"; //��������   //�ʱ�ȭ�� ���־�� �Ѵ�.  ���������� ������ �ʱ�ȭ�ؾ��Ѵ�.
		int score= 80; //��������
		switch(score/10) {
		case 9: grade = "A"; break;
		case 8: grade = "B"; break;
		case 7: grade = "A"; break;
		case 6: grade = "D"; break;
//		default : grade ="F";
		}
		System.out.println("����: "+grade);
	}

}
