package chap18;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

/*
 * �ڹ� API 
 *     Consumer : �Ű������� �ְ�, ����Ÿ���� ���� �߻�޼��带 ����� ������ FunctionalInterface 
 *     			  .accept();
 */
public class LambdaEx6 {
	static Integer[] arr = {1,2,3,4,5};
	static Integer[] x = {10,20,30,40,50}; // Ŭ���� �ɹ�

	public static void main(String[] args) {
		// c1 : String Ÿ���� �Ű������� �Լ���ü
		Consumer<Object> c1 = t -> {
			System.out.println(t+"8.0");
		};
		c1.accept("java");
		System.out.println();
		// c2 : Integer[] Ÿ���� �Ű������� ������ �Լ� ��ü.
		Consumer<Integer[]> c2 = t-> {  // t�� Integer[] Ÿ������ ��.
		  //Integer[] arr = (Integer[]) t; // �� ���� �����ص� ��.
			int  sum = 0;
			for(int i:t) sum+=i;
			System.out.println("�迭�� ��: "+ sum);
		};
		c2.accept(x);
		System.out.println();
		// c3 : String Ÿ���� �Ű������� 2���� �Լ� ��ü.
		BiConsumer<String, String> c3 = (t,u) ->{
			System.out.println(t+u);
		};
		c3.accept("java", "8.0");
		System.out.println();
		// c4 : Double Ÿ���� �Ű������� ���� �Լ� ��ü.
		DoubleConsumer c4 = d -> {
			System.out.println("java"+ d);
		};
		c4.accept(8.0);
		System.out.println();
		// c5 : �Ű������� �Ѱ��� StringŸ���̰� �ٸ� �Ѱ��� Int Ÿ���� �Լ� ��ü.
		ObjIntConsumer<String> c5 = (t,i) -> {
			System.out.println(t+i);
		};
		c5.accept("java", 8);
	}
}
