package chap18;

import java.util.Arrays;
import java.util.List;

public class StreamEx6 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("This is a Java Book", "Lambda Expressions",
				"Java8 Supports Lambda Expressions");
		// flatMap : 새로운 Stream 객체 생성. 기능을 추가.
		list.stream().flatMap(s -> {
			String[] strarr = s.split(" ");
			return Arrays.stream(strarr); // 배열을 Stream
		}).forEach(System.out::println);
		System.out.println();
		System.out.println("정렬하여 출력하기.");
		list.stream().flatMap(s -> Arrays.stream(s.split(" "))).sorted().forEach(System.out::println);
		System.out.println();
		System.out.println("중복을 제거하고 정렬하여 출력하기.");
		list.stream().flatMap(s -> Arrays.stream(s.split(" "))).distinct().sorted().forEach(System.out::println);
		System.out.println();

		List<String> list2 = Arrays.asList("10,20,30", "40,50,60");
		list2.stream().flatMapToInt(data -> { // 중괄호로 묶였으므로 return 타입 사용해야한다.
			String[] strarr = data.split(",");
			int[] intarr = new int[strarr.length];
			for (int i = 0; i < strarr.length; i++) {
				intarr[i] = Integer.parseInt(strarr[i].trim());
			}
			return Arrays.stream(intarr);
		}).forEach(System.out::println);

		double avg = list2.stream().flatMapToInt(data -> { // 중괄호로 묶였으므로 return 타입 사용해야한다.
			String[] strarr = data.split(","); // 문자열이 들어감. 2개.
			int[] intarr = new int[strarr.length]; 
			int a = strarr.length;
			System.out.print(a);
			for (int i = 0; i < strarr.length; i++) {
				intarr[i] = Integer.parseInt(strarr[i].trim()); // 정수형 값이 들어감. 3개 * 2 = 6개
			}
			return Arrays.stream(intarr);
		}).average().getAsDouble();
		System.out.println("평균: " + avg);
		
		int sum = list2.stream().flatMapToInt(data -> { // 중괄호로 묶였으므로 return 타입 사용해야한다.
			String[] strarr = data.split(",");
			int[] intarr = new int[strarr.length];
			for (int i = 0; i < strarr.length; i++) {
				intarr[i] = Integer.parseInt(strarr[i].trim());
			}
			return Arrays.stream(intarr);
		}).sum();
		System.out.println("합계: " + sum);

	}
}
