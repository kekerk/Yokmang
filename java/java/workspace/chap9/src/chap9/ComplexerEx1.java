package chap9;

interface Printerable {
	int INK = 100;

	void print();

}

interface Scannerable {
	void scan();
}

interface Faxable {
	public static String FAX_NO = "010-12345"; // public static String

	void send(String tel);

	void receive(String tel);

}

interface Complexerable extends Printerable, Scannerable, Faxable {

} //���� �������̽������� ���� ��� ����.  A extends B,C,D

class Complexer implements Complexerable {
	int ink;

	Complexer() {
		this.ink = INK;
	}

	public void print() {
		System.out.println("���̿� ����մϴ�. ���� ��ũ��: " + --ink);
	}

	public void scan() {
		System.out.println("�̹����� ��ĵ�մϴ�.");
	}

	public void send(String tel) {
		System.out.println(FAX_NO + "���� " + tel + "��ȣ�� FAX�� �����մϴ�.");
	}

	public void receive(String tel) {
		System.out.println(tel + "���� " + FAX_NO + "��ȣ�� FAX�� �޾ҽ��ϴ�.");
	}
}

public class ComplexerEx1 {

	public static void main(String[] args) {
		Complexer com = new Complexer();
		System.out.println("�⺻��ũ��: " + Printerable.INK);
		System.out.println("FAX_NO: " + Faxable.FAX_NO);
		com.print();
		com.scan();
		com.receive("02-5678");
		com.send("02-5678");

		if (com instanceof Complexer) // instanceof ��ü ������ ����
			System.out.println("com ��ü�� Complexer ��ü��");

		if (com instanceof Complexerable)
			System.out.println("com ��ü�� Complexerable ��ü��");

		if (com instanceof Printerable)
			System.out.println("com ��ü�� Printerable ��ü��");
		if (com instanceof Scannerable)
			System.out.println("com ��ü�� Scannerable ��ü��");
		if (com instanceof Faxable)
			System.out.println("com ��ü�� Faxable ��ü��");

		if (com instanceof Object)
			System.out.println("com ��ü�� Object ��ü��");
	}

}
