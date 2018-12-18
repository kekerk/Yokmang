package chap18;

import java.util.Arrays;
import java.util.List;

/*
 *  ���� ��Ʈ�� ���� 
 */
public class StreamEx2 {
	public static void main(String[] args) {
	List<String> list = Arrays.asList("ȫ�浿","���","�̸���","������","�Ӳ���","��Ʈ��");
	//����ó��.
	System.out.println("����ó��");
	list.stream().forEach(StreamEx2::print);
	System.out.println();
	//����ó��
	//�ʿ信 ���� Thread�� �����Ͽ� ���ķ� ó���Ѵ�.
	System.out.println("����ó��");
	//parallelStream() : ���ķ� ó���ϴ� ����� ���� �޼���
	list.parallelStream().forEach(StreamEx2::print);

	}
	private static void print (String str) {
		System.out.println(str+":"+Thread.currentThread().getName());
	}
	
}
