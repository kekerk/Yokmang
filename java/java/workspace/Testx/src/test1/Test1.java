package test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;

@FunctionalInterface
interface Lamba1 {
	void method();
}

public class Test1 {
	public static void main(String[] args) throws InterruptedException {
		Lamba1 l1;
		l1 = () -> {
			int[] i = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
			String[] s = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
			Map<Integer, String> map = new HashMap<Integer, String>();
			for (int j = 0; j < i.length; j++) {
				map.put(i[j], s[j]);
			}
			Set<Integer> set = new HashSet(map.keySet());
			List<String> list = new ArrayList(map.values());

			Iterator i1 = set.iterator();
			Iterator i2 = list.iterator();
			while (i1.hasNext() && i2.hasNext()) {
				try {
					System.out.println("key : " + i1.next() + " value : " + i2.next());
					i1.remove();
					i2.remove();
					Thread.sleep(1000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
		};
		l1.method();
		
		// 랜덤수 10개를 더하여 5배 시켜서 출력.
		
		Thread.sleep(1000);
		// consumer : 매개변수 o, 리턴타입x 추상메서드를 멤버로 갖는다.
		Consumer<Integer> c1 = x -> {
			int sum = 0;
			int[] sub1 = new int[10];
			for(int j=0;j<sub1.length;j++) {
				for(int i=1;i<=1000;i++) {
					sub1[j] = (int)(Math.random()*10)+1;
				}
				sum += sub1[j];
			}
			sum *= x;
			
			System.out.println("임의의 수 10개를 더하여"+x+"배한 값: "+ sum);
			
		};
		c1.accept(5); //{  }; 밖에서 Consumer 객체의 메서드를 지정.
		//Supplier :매개변수 x, 리턴타입 o 추상메서드를 멤버로 갖는다.		
		Thread.sleep(1000);
		Supplier<String> s1 = () -> {
			return "현정이는 오늘도 열심히 한다";
		};
		System.out.println(s1.get());
	}
}
