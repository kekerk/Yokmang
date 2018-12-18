package chap18;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/*
 *  Stream ���� : jdk 8.0 ���� ���������� ��� ����.
 *  			���ιݺ��� ����. ���� ó�� �ӵ�.
 *  			���� ó���� ����.
 */
public class StreamEx1 {

	public static void main(String[] args) {
		// List<String> list : String Ÿ�Ը� ��Ƽ� list��
		List<String> list = Arrays.asList("ȫ�浿", "���", "�̸���");
		System.out.println("�ܺ� �ݺ���(Iterator)�� ��ȸ�ϱ�.");
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String name = it.next();
			System.out.println(name + " ");
		}
		System.out.println();
		System.out.println("���� �ݺ���(Stream)�� ��ȸ�ϱ�.");
		Stream<String> st = list.stream();
		// name : list�� ��ҵ� �ϳ��ϳ��� ����.
		st.forEach(name -> System.out.println(name + " "));
		System.out.println();
		List<student> list2 = Arrays.asList(new student("ȫ�浿", 80, 90), new student("���", 70, 80),
				new student("�̸���", 85, 92));
		System.out.println("Stream<student> �̿�");
		Stream<student> st2 = list2.stream();
		// s�� Ÿ���� student. s�� student ��ü �Ѱ�. ��� ��ü.
		// .forEach : �Ѱ��� �о���� �޼���.
		st2.forEach(s -> {
			String name = s.getName(); // ȫ�浿
			int sum = s.getEng()+s.getMath(); //���� �ջ�
			System.out.println(name+" ����: "+ sum);
		});
		System.out.println();
		//����� ȫ�浿,����,����,����,���
		Stream<student> st3 = list2.stream();
		st3.forEach(s -> {
			String name = s.getName();
			int e = s.getEng();
			int m = s.getMath();
			int sum = s.getEng()+s.getMath();
			double avg = sum/2.0;
			if(s.getName().equals("ȫ�浿")){
			System.out.println(name+" ��������: " + m +" ��������: "+ e +" ����: "+ sum + " ��� : "+avg);
			}
		});
		//�κ� ��Ʈ������ �����ϱ�.
		// mapToInt
		System.out.print("�л����� ���� ���� ���: ");
		//IntStream : mapToInt
		// ������ ���� ��ҷ� ������ �ִ� Stream
		double avg = list2.stream().mapToInt(student :: getMath).average().getAsDouble();
		System.out.println(avg);
		
		System.out.print("�л����� ���� ���� ���: ");
		avg = list2.stream().mapToInt(student :: getEng).average().getAsDouble();
		System.out.println(avg);
		
		System.out.print("�л����� ���� ���� ����: ");
		long sum = list2.stream().mapToInt(student :: getMath).sum();
		System.out.println(sum);
		
		System.out.print("�л����� ���� ���� ����: ");
		sum = list2.stream().mapToInt(student :: getEng).sum();
		System.out.println(sum);
		
		Stream<student> st4 = list2.stream();
		
	}

}
