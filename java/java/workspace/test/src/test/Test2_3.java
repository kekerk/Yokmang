package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test2_3 {
	public static void main(String[] args) {
		int comn = (int) (Math.random() * 3) + 1;
		
		System.out.println("��ǻ�Ͱ� ���Ŵ�" + comn);
		Scanner scan = new Scanner(System.in);
		System.out.println("����(1), ����(2), ��(3) �� �ϰ� �� ����?");
  //  	int num = scan.nextInt();
		String x = scan.nextLine();
    	HashMap <String,Integer> map = new HashMap<String,Integer>();
    	map.put("����", 1);
    	map.put("����", 2);
    	map.put("��", 3);
    	int ans = map.get(x);
     	switch (ans) {
		case 1:
			switch(comn) {
			case 1: System.out.println("���"); break;
			case 2: System.out.println("��ǻ�� �̱�"); break;
			case 3: System.out.println("���� �̱�"); break;
			}
			break;
		case 2:
			switch(comn) {
			case 1: System.out.println("���� �̱�"); break;
			case 2: System.out.println("���"); break;
			case 3: System.out.println("��ǻ�� �̱�"); break;
			}
			break;
			
		case 3:
			switch(comn) {
			case 1: System.out.println("��ǻ�� �̱�"); break;
			case 2: System.out.println("���� �̱�"); break;
			case 3: System.out.println("���"); break;
			}
			break;
			
		}
    	
    	
    	
    	
    	
	}
}
