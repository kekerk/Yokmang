package chap12;

import java.util.Arrays;
import java.util.List;

/*
 * 
 */
public class ArraysEx1 {
	public static void main(String[] args) {
		String[] arr = {"����","�̸���","���","����"};
		//�迭�� List�� �����.
		List<String> list = Arrays.asList(arr);
		System.out.println(list);
		Arrays.fill(arr, "������");
		for(String n : arr) {
			System.out.println(n+",");
		}
		
		
		System.out.println();
		Arrays.fill(arr,1,3, "��");
		for(String n : arr) {
			System.out.println(n+",");
		}
	}
}
