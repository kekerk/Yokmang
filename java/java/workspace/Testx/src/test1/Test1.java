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
		
		// ������ 10���� ���Ͽ� 5�� ���Ѽ� ���.
		
		Thread.sleep(1000);
		// consumer : �Ű����� o, ����Ÿ��x �߻�޼��带 ����� ���´�.
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
			
			System.out.println("������ �� 10���� ���Ͽ�"+x+"���� ��: "+ sum);
			
		};
		c1.accept(5); //{  }; �ۿ��� Consumer ��ü�� �޼��带 ����.
		//Supplier :�Ű����� x, ����Ÿ�� o �߻�޼��带 ����� ���´�.		
		Thread.sleep(1000);
		Supplier<String> s1 = () -> {
			return "�����̴� ���õ� ������ �Ѵ�";
		};
		System.out.println(s1.get());
	}
}
