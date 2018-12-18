package chap18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 *  chap18 프로젝트 폴더에 goodee.txt 문서 분석하여 저장된 단어의 갯수를 출력하기.
 *  사용된 단어가 많은 순으로 출력하기.
 */
public class StreamEx7 {
	public static void main(String[] args) throws Exception {
		Path path = Paths.get("goodee.txt"); //
//		Stream<String> steam;
//		List<String> list = new ArrayList<String>();
		FileReader fr = new FileReader(path.toFile()); // path의 파일을 읽어온다.
		BufferedReader br = new BufferedReader(fr); // 읽어온 파일을 BufferedReader에 넣는다. String으로 만든다.
		Map<String, Long> wordcount = br.lines().flatMap(
				// br.lines() : IO스트림의 원본(파일)의 내용을 Stream 객체로 변환.
				// flatMap : 파일의 내용을 가공하여 다른 Stream으로 변경.
				str -> {
					str = str.replace("가", " ");
					str = str.replace("는", " ");
					str = str.replace("을", " ");
					str = str.replace(",", " ");
					str = str.replace(".", " ");
					str = str.replace("!", " ");
					String[] strarr = str.split("\\s+"); // \\s+ 공백이 여러개 를 기준으로 분리.
					return Arrays.stream(strarr); // 공백을 기준으로 단어들을 Stream화
				}).collect(Collectors.groupingBy(String::toString,
						Collectors.mapping(String::toString, Collectors.counting())));
		// collect : Map 객체 리턴.
		// String :: toString, Collectors.counting()
		// 단 어(key) , 해당 단어 개수(value) --> Map 객체.
		// Set<Map.entry> wordcount.entrySet()
		// map : String형의 Stream 으로 생성.
		System.out.println(wordcount);
		wordcount.entrySet().stream().map(s -> s.getKey() + "," + s.getValue())
		// "단어, 갯수" 형인 문자열 Stream 객체.
		//	.sorted(Comparator 함수 객체) : 정렬 방식 결정
		.sorted((a, b) -> { //갯수의 내림차순 정렬.(정렬 재지정)
			String str1 = a.substring(a.lastIndexOf(",") + 1); //"갯수" 부분만 
			String str2 = b.substring(b.lastIndexOf(",") + 1); //"갯수" 부분만
			return Integer.parseInt(str2) - Integer.parseInt(str1);
			// 갯수의 내림차순으로 정렬.
		}).forEach(s -> System.out.println(s));
	}
}
