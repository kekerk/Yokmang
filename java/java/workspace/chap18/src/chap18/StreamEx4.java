package chap18;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

// ������ ������ Stream���� ó���ϱ�.
public class StreamEx4 {
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("src/chap18/StreamEx3.java");
		// Charset.defaultCharset() : �츮���� �⺻ Character set���� �д� ���.
		Stream<String> stream = Files.lines(path, Charset.defaultCharset());
		stream.forEach(System.out :: println);
		System.out.println();
		// ������ ���� ����� Stream
		Path path2 = Paths.get("src/chap18");
		// Files.list(path2) : path2�� ��ο� �ִ� ��� ���ϰ� ������ ����Ʈ�� �����.
		Stream<Path> stream2 = Files.list(path2);
		stream2.forEach(p-> System.out.println(p.getFileName()));
		
	}
}
