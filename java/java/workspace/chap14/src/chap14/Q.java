package chap14;

import java.util.HashMap;
import java.util.Scanner;

public class Q {
 public static void main(String[] args) {
	 HashMap<String, Integer> map = new HashMap<String, Integer>();
	 map.put("홍길동", 123);
	 map.put("성춘향", 134);
	 map.put("이몽룡", 145);
	 map.put("이순신", 156);
	 
	 Scanner scan = new Scanner(System.in);
	 String name = scan.nextLine();
	
	 if(map.get(name)==null) {
		 System.out.println(name+"에 해당하는 키가 없음");
	 } else {
		 System.out.println(name+":"+map.get(name));
	 }
 }
}
