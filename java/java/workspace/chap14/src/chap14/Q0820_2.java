package chap14;

import java.util.ArrayList;
import java.util.LinkedHashSet;

/*
 * LinkedHashSet :  ��������, �ߺ��Ұ�
 * Random
 * new ArrayList(Set) : Set ��ü�� List ��ü�� ����.
 */
public class Q0820_2 {
	public static void main(String[] args) {
		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
		// set.size()�� 6�� �Ǹ� ��
		while(set.size()<6) {
			if(set.size()==0) {
				System.out.println("3�� ���� ��÷�մϴ�.");
			}else if(set.size()==3) {
				System.out.println("2�� ���� ��÷�մϴ�.");
			}else if(set.size()==5) {
				System.out.println("1�� ���� ��÷�մϴ�.");
			}
			
			int num = (int)(Math.random()*1000)+1;
			if(set.add(num)) {
				System.out.println(num);
			}
			
		}
		System.out.println("***���� ��÷ ���***");
		//÷�� ���� ���� ArrayList ��
		ArrayList<Integer> list = new ArrayList<Integer>(set);
		System.out.println("1��:"+list.get(5));
		System.out.print("2��:");
		for(int i=4;i>=3;i--) {
			System.out.print(list.get(i)+",");
		}
		System.out.println();
		System.out.print("3��:");
		for(int i=2;i>=0;i--) {
			System.out.print(list.get(i)+",");
		}
		System.out.println();
		System.out.println("1��:"+list.subList(5, 6));
		System.out.println("2��:"+list.subList(3, 5));
		System.out.println("3��:"+list.subList(0, 3));
		
		
		
	}
}
