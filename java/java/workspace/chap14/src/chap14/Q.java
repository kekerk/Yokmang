package chap14;

import java.util.HashMap;
import java.util.Scanner;

public class Q {
 public static void main(String[] args) {
	 HashMap<String, Integer> map = new HashMap<String, Integer>();
	 map.put("ȫ�浿", 123);
	 map.put("������", 134);
	 map.put("�̸���", 145);
	 map.put("�̼���", 156);
	 
	 Scanner scan = new Scanner(System.in);
	 String name = scan.nextLine();
	
	 if(map.get(name)==null) {
		 System.out.println(name+"�� �ش��ϴ� Ű�� ����");
	 } else {
		 System.out.println(name+":"+map.get(name));
	 }
 }
}
