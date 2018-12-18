package chap18;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

// 파일의 내용을 Stream으로 처리하기.
public class StreamEx4 {
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("src/chap18/StreamEx3.java");
		// Charset.defaultCharset() : 우리나라 기본 Character set으로 읽는 기능.
		Stream<String> stream = Files.lines(path, Charset.defaultCharset());
		stream.forEach(System.out :: println);
		System.out.println();
		// 폴더의 하위 목록을 Stream
		Path path2 = Paths.get("src/chap18");
		// Files.list(path2) : path2의 경로에 있는 모든 파일과 폴더를 리스트로 만든다.
		Stream<Path> stream2 = Files.list(path2);
		stream2.forEach(p-> System.out.println(p.getFileName()));
		
	}
}
