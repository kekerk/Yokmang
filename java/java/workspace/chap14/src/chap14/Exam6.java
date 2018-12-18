package chap14;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * ���ѹα�(����), ĳ����(��Ÿ��), ����(����), ������(����)�� ������ 
 * HashMap�� ���� �� ȭ�鿡�� �����̸��� �Է¹޾�, �Է¹��� ������ 
 * ������ ����ϴ� ���α׷� �ۼ��ϱ�.
 * �Էµ� ���� �ƴѰ�� "��ϵ��� ���� �����Դϴ�" ����ϱ�.
 */
public class Exam6 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		String[] country = { "���ѹα�", "ĳ����", "����", "������" };
		String[] capital = { "����", "��Ÿ��", "����", "����" };
		for (int i = 0; i < country.length; i++) {
			map.put(country[i], capital[i]);
		}
		System.out.println(map);
		System.out.println("�����̸��� �Է��ϼ���.");
		while (true) {
			Scanner scan = new Scanner(System.in);
			String name = scan.nextLine();
			if (name.equals("��"))
				break;
//			String value = map.get(name);
			if ( map.get(name) == null) {
				System.out.println("��ϵ��� ���� �����Դϴ�.");
			} else {
				System.out.println(name + "�� ������ " + map.get(name));
			}
		}
	}

}
