package chap18;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Student2 implements Comparable<Student2> { //�����ϱ����� Comparable �������̽� �����ް� compareTo() �������̵�. 
	private String name;
	private int score;

	public Student2(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}
	// �̸������� ����.
	@Override
	public int compareTo(Student2 s) {
		
//		return (name.compareTo(s.name))*(-1);
		return (name.compareTo(s.name));
	}
	
	
	// ������ �������� �����ϵ��� �⺻�����ϱ�.
//	@Override
//	public int compareTo(Student2 s) {
//		
//		return score - s.score;
//	}
	

}
public class StreamEx3 {
	public static void main(String[] args) {
		List<Student2> list = Arrays.asList(new Student2("ȫ�浿", 90), new Student2("���", 80), new Student2("�̸���", 100));

		int tot = list.stream().mapToInt(Student2::getScore).sum();
		long count = list.stream().mapToInt(Student2::getScore).count();
		double avg = list.stream().mapToInt(Student2::getScore).average().getAsDouble();
		System.out.println("�ο��� :" + count);
		System.out.println("���� : " + tot);
		System.out.println("��� : " + avg);
		System.out.println();
		list.stream().forEach(s -> System.out.println(s.getName() + ":" + s.getScore()));
		System.out.println();
		// �������� �����Ͽ� ����ϱ� -- sorted()���� ������ ��. comparable(�������̽�) �����ؾ���.
		// 1. Comparable ����Ŭ������ ��ü�� ������ ����.
		// 2. 
		list.stream().sorted().forEach(s -> System.out.println(s.getName() + ":" + s.getScore()));
		// �̸� ��������.
		System.out.println();
		list.stream().sorted(Comparator.reverseOrder()).forEach(s -> System.out.println(s.getName() + ":" + s.getScore()));
	}
}
