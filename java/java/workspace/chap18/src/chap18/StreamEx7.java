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
 *  chap18 ������Ʈ ������ goodee.txt ���� �м��Ͽ� ����� �ܾ��� ������ ����ϱ�.
 *  ���� �ܾ ���� ������ ����ϱ�.
 */
public class StreamEx7 {
	public static void main(String[] args) throws Exception {
		Path path = Paths.get("goodee.txt"); //
//		Stream<String> steam;
//		List<String> list = new ArrayList<String>();
		FileReader fr = new FileReader(path.toFile()); // path�� ������ �о�´�.
		BufferedReader br = new BufferedReader(fr); // �о�� ������ BufferedReader�� �ִ´�. String���� �����.
		Map<String, Long> wordcount = br.lines().flatMap(
				// br.lines() : IO��Ʈ���� ����(����)�� ������ Stream ��ü�� ��ȯ.
				// flatMap : ������ ������ �����Ͽ� �ٸ� Stream���� ����.
				str -> {
					str = str.replace("��", " ");
					str = str.replace("��", " ");
					str = str.replace("��", " ");
					str = str.replace(",", " ");
					str = str.replace(".", " ");
					str = str.replace("!", " ");
					String[] strarr = str.split("\\s+"); // \\s+ ������ ������ �� �������� �и�.
					return Arrays.stream(strarr); // ������ �������� �ܾ���� Streamȭ
				}).collect(Collectors.groupingBy(String::toString,
						Collectors.mapping(String::toString, Collectors.counting())));
		// collect : Map ��ü ����.
		// String :: toString, Collectors.counting()
		// �� ��(key) , �ش� �ܾ� ����(value) --> Map ��ü.
		// Set<Map.entry> wordcount.entrySet()
		// map : String���� Stream ���� ����.
		System.out.println(wordcount);
		wordcount.entrySet().stream().map(s -> s.getKey() + "," + s.getValue())
		// "�ܾ�, ����" ���� ���ڿ� Stream ��ü.
		//	.sorted(Comparator �Լ� ��ü) : ���� ��� ����
		.sorted((a, b) -> { //������ �������� ����.(���� ������)
			String str1 = a.substring(a.lastIndexOf(",") + 1); //"����" �κи� 
			String str2 = b.substring(b.lastIndexOf(",") + 1); //"����" �κи�
			return Integer.parseInt(str2) - Integer.parseInt(str1);
			// ������ ������������ ����.
		}).forEach(s -> System.out.println(s));
	}
}
