package chap14;

import java.util.Set;
import java.util.TreeSet;

/*
 * 로또번호
 * 중복
 * TreeSet을 이용하여 Ltto번호 6개 저장하기. 
 * 1~45
 */
public class Exam4 {
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<Integer>();
		while (set.size() < 6) {
			int num = (int) ((Math.random() * 45) + 1);
			set.add(num);
		}
		
		System.out.println("로또 번호" + set);
	}
}
