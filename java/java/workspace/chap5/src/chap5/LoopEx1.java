package chap5;

public class LoopEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(1);// print : ������ ����
		System.out.print(2);
		System.out.print(3);
		System.out.print(4);
		System.out.println(5); // println : ���� �ٿ� ����
		System.out.println("for������ 1~5 ���");

		int i = 0;
		for (i = 1; i <= 5; i++) {
			System.out.println(i);
		}
		System.out.println("i=" + i);

		System.out.println("\n while������ 1~5���");
		int l = 1;
		while (l <= 5) { // ���ǽ��� ���� �� ���๮�� ����ǰ�, ������ �� ���� Ż��
			System.out.println(l);
			l++;
		}
		System.out.println("l=" + l);

		System.out.println("\n do while������ 1~5 ���");
		int s = 1;
		do { // do while���� while(���ǹ�) ���� �� �����ݷ����� ������ �ؾ��Ѵ�.(;)
			System.out.println(s);
			s++;
		} while (s <= 5); // ���๮�� ���� ����ǰ� ���ǹ����� ���� �� �ٽ� �ݺ�, ������ �� ���� Ż�� (������ �ѹ��� �����)
		System.out.println("s=" + s);
	}

}
