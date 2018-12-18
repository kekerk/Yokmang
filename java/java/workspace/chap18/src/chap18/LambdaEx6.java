package chap18;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

/*
 * 자바 API 
 *     Consumer : 매개변수가 있고, 리턴타입이 없는 추상메서드를 멤버로 가지는 FunctionalInterface 
 *     			  .accept();
 */
public class LambdaEx6 {
	static Integer[] arr = {1,2,3,4,5};
	static Integer[] x = {10,20,30,40,50}; // 클래스 맴버

	public static void main(String[] args) {
		// c1 : String 타입의 매개변수를 함수객체
		Consumer<Object> c1 = t -> {
			System.out.println(t+"8.0");
		};
		c1.accept("java");
		System.out.println();
		// c2 : Integer[] 타입의 매개변수를 가지는 함수 객체.
		Consumer<Integer[]> c2 = t-> {  // t가 Integer[] 타입으로 됨.
		  //Integer[] arr = (Integer[]) t; // 이 줄을 생략해도 됨.
			int  sum = 0;
			for(int i:t) sum+=i;
			System.out.println("배열의 합: "+ sum);
		};
		c2.accept(x);
		System.out.println();
		// c3 : String 타입의 매개변수가 2개인 함수 객체.
		BiConsumer<String, String> c3 = (t,u) ->{
			System.out.println(t+u);
		};
		c3.accept("java", "8.0");
		System.out.println();
		// c4 : Double 타입의 매개변수를 가진 함수 객체.
		DoubleConsumer c4 = d -> {
			System.out.println("java"+ d);
		};
		c4.accept(8.0);
		System.out.println();
		// c5 : 매개변수가 한개는 String타입이고 다른 한개는 Int 타입인 함수 객체.
		ObjIntConsumer<String> c5 = (t,i) -> {
			System.out.println(t+i);
		};
		c5.accept("java", 8);
	}
}
