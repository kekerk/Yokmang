package chap14;

import java.util.Set;
import java.util.TreeSet;

/*
 * �ζǹ�ȣ
 * �ߺ�
 * TreeSet�� �̿��Ͽ� Ltto��ȣ 6�� �����ϱ�. 
 * 1~45
 */
public class Exam4 {
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<Integer>();
		while (set.size() < 6) {
			int num = (int) ((Math.random() * 45) + 1);
			set.add(num);
		}
		
		System.out.println("�ζ� ��ȣ" + set);
	}
}
