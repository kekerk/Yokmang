package test;

import java.util.Scanner;
/*
 * math.random() : 0<= x <1.0
 *  math.random() * 3 : 0<= x <3.0
 *  (int)(math.random()*3) : 0<= x <= 2
 *  (int)(math.random()*3) +1 : 0<= x <=3
 *    
 * 
 */
public class Test2_2 {

	public static void main(String[] args) {
		int comn = (int) (Math.random() * 3) + 1;
		System.out.println("��ǻ�Ͱ� ���Ŵ�" + comn);
		Scanner scan = new Scanner(System.in);
		System.out.println("����(1), ����(2), ��(3) �� �ϰ� �� ����?");
    	int num = scan.nextInt();
		String result = null;
		
		
		switch (comn) {
		case 1:
			result = (num == 1) ? "���" : (num == 2) ? "���� �¸�" : "��Ǫ�� �¸�";
			break;
		case 2:
			result = (num == 2) ? "���" : (num == 3) ? "���� �¸�" : "��Ǫ�� �¸�";
			break;

		case 3:
			result = (num == 3) ? "���" : (num == 1) ? "���� �¸�" : "��Ǫ�� �¸�";
			break;

		}
		System.out.println(result);
	}

}
