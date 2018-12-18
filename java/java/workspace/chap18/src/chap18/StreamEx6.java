package chap18;

import java.util.Arrays;
import java.util.List;

public class StreamEx6 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("This is a Java Book", "Lambda Expressions",
				"Java8 Supports Lambda Expressions");
		// flatMap : ���ο� Stream ��ü ����. ����� �߰�.
		list.stream().flatMap(s -> {
			String[] strarr = s.split(" ");
			return Arrays.stream(strarr); // �迭�� Stream
		}).forEach(System.out::println);
		System.out.println();
		System.out.println("�����Ͽ� ����ϱ�.");
		list.stream().flatMap(s -> Arrays.stream(s.split(" "))).sorted().forEach(System.out::println);
		System.out.println();
		System.out.println("�ߺ��� �����ϰ� �����Ͽ� ����ϱ�.");
		list.stream().flatMap(s -> Arrays.stream(s.split(" "))).distinct().sorted().forEach(System.out::println);
		System.out.println();

		List<String> list2 = Arrays.asList("10,20,30", "40,50,60");
		list2.stream().flatMapToInt(data -> { // �߰�ȣ�� �������Ƿ� return Ÿ�� ����ؾ��Ѵ�.
			String[] strarr = data.split(",");
			int[] intarr = new int[strarr.length];
			for (int i = 0; i < strarr.length; i++) {
				intarr[i] = Integer.parseInt(strarr[i].trim());
			}
			return Arrays.stream(intarr);
		}).forEach(System.out::println);

		double avg = list2.stream().flatMapToInt(data -> { // �߰�ȣ�� �������Ƿ� return Ÿ�� ����ؾ��Ѵ�.
			String[] strarr = data.split(","); // ���ڿ��� ��. 2��.
			int[] intarr = new int[strarr.length]; 
			int a = strarr.length;
			System.out.print(a);
			for (int i = 0; i < strarr.length; i++) {
				intarr[i] = Integer.parseInt(strarr[i].trim()); // ������ ���� ��. 3�� * 2 = 6��
			}
			return Arrays.stream(intarr);
		}).average().getAsDouble();
		System.out.println("���: " + avg);
		
		int sum = list2.stream().flatMapToInt(data -> { // �߰�ȣ�� �������Ƿ� return Ÿ�� ����ؾ��Ѵ�.
			String[] strarr = data.split(",");
			int[] intarr = new int[strarr.length];
			for (int i = 0; i < strarr.length; i++) {
				intarr[i] = Integer.parseInt(strarr[i].trim());
			}
			return Arrays.stream(intarr);
		}).sum();
		System.out.println("�հ�: " + sum);

	}
}
