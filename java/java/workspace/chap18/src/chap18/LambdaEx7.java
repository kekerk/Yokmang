package chap18;

import java.util.ArrayList;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/*
 * Suppler 인터페이스 : 매개변수가 없고, 리턴값이 있음.
 */
public class LambdaEx7 {
	public static void main(String[] args) {
		// s1 : String 타입의 리턴값이 있는 함수 객체.
		Supplier<String> s1 = () -> {
			return "java";
		};
		System.out.println(s1.get());
		
		IntSupplier s2 = () -> {
			int num = (int)(Math.random()*10)+1;
			return num;
		};
		System.out.println("1부터 10까지의 임의의 수: " + s2.getAsInt());
		
		//Supplier를 이용하여 1부터 100까지의 합 구하기.
		s2 = () -> {
			int sum=0;
			for(int i=1;i<=100;i++) {
				sum+=i;
			}
			return sum;
		};
		System.out.println("1부터 100까지의 합:"+ s2.getAsInt());
		// Supplier를 이용하여 arr 멤버의 합 구하기.
		Supplier s3 = () -> { //매개변수가 없으니, 람다식 안에서 변수 선언 및 조건문. 그리고 return값으로 받음.
			Integer[] arr = {1,2,3,4,5,6,7,8,9,10};
			Integer sum= new Integer(0);
			for(int i=0;i<arr.length;i++) {
				sum+=arr[i];
			}
			return sum;
		};
		System.out.println("arr 배열 요소의 합:" + s3.get());
		
	}
}
