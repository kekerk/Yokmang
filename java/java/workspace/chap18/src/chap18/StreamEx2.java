package chap18;

import java.util.Arrays;
import java.util.List;

/*
 *  병렬 스트림 예제 
 */
public class StreamEx2 {
	public static void main(String[] args) {
	List<String> list = Arrays.asList("홍길동","김삿갓","이몽룡","성춘향","임꺽정","스트림");
	//순차처리.
	System.out.println("순차처리");
	list.stream().forEach(StreamEx2::print);
	System.out.println();
	//병렬처리
	//필요에 따라 Thread를 생성하여 병렬로 처리한다.
	System.out.println("병렬처리");
	//parallelStream() : 병렬로 처리하는 기능을 가진 메서드
	list.parallelStream().forEach(StreamEx2::print);

	}
	private static void print (String str) {
		System.out.println(str+":"+Thread.currentThread().getName());
	}
	
}
