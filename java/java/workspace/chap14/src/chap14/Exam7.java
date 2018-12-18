package chap14;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * Exam6.java���� ��ϵ� ���� �ƴ� ��� ������ �Է¹޾� ����ϱ�.
 * ����� ���� map�� ������ ����ϱ�. (Iterator �̿�)
 */
public class Exam7 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		String[] country = { "���ѹα�", "ĳ����", "����", "������" };
		String[] capital = { "����", "��Ÿ��", "����", "����" };
		for (int i = 0; i < country.length; i++) {
			map.put(country[i], capital[i]);
		}
		System.out.println(map);

		while (true) {
			System.out.println("�����̸��� �Է��ϼ���.");
			Scanner scan = new Scanner(System.in);
			String name = scan.nextLine();
			if (name.equals("��"))
				break;
			// String value = map.get(name);
			if (map.get(name) == null) {
				System.out.println("��ϵ��� ���� �����Դϴ�. ������ ������ּ���.");
				String cap = scan.nextLine();
				map.put(name, cap);

			} else {
				System.out.println(name + "�� ������ " + map.get(name));
			}
		}
		System.out.println("Map�� ���� ��ȸ�ϱ�:1");
		Set<String> keys = map.keySet(); // key���� ������ �������� ���. ���� �ҷ��´�.
		Iterator it = keys.iterator();
		// Keys �� ���� Iterator ������ �޼���� �ҷ�����.
		while (it.hasNext()) { //�о�� ��Ұ� �������ִ��� �ƴ���. 
			// Iterator�� ���׸� ǥ�ð� ��� Object�� ����.
			Object k = it.next(); //���� ��Ҹ� �о�´�.
			System.out.println(k + ":" + map.get(k));
		}
		
		System.out.println("Map�� ���� ��ȸ�ϱ�:2");
		Set<Map.Entry<String, String>> entry = map.entrySet();
		it = entry.iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> k = (Map.Entry<String, String>) it.next();
			System.out.println(k.getKey() + ":" + k.getValue());
		}

	}
}
