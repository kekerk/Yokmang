package chap9;

/*
 * Animal2 Ŭ������ ������ ����. ����Ŭ������ �������� �� ������ ����� �������� ���α׷� �����ϱ�.
 * [���]
 * �񵹱�� ���� ������ ��� �Դ´�.
 * ��ѱ�� ���� �ٴϴ� ���Դϴ�.
 * �����̴� �������� ���Ÿ� ���� �Դ´�.
 * �������� ���� ���� ��� �Դ´�.
 * �������� ��û ���� ���� �ٴѴ�.
 */
abstract class Animal2 {
	String name;

	Animal2(String name) { 
		this.name = name;
	}

	abstract void eat();
}

interface Flyable {
	public abstract void fly();
}

class Dove extends Animal2 implements Flyable {
	Dove() {
		super("��ѱ�"); //�߻� Ŭ���� ���� �� �����ڿ��� �Ű������� �����ϹǷ� �ٷ� �ʱ�ȭ�Ǿ�� �Ѵ�.
	}

	@Override
	void eat() { // Animal2���� �������̵��� eat()�� ����Ų��.
		System.out.println(name + "�� ���� ������ ��ƸԴ´�.");

	}

	@Override
	public void fly() {
		System.out.println(name + "�� ���� �ٴϴ� ���Դϴ�.");

	}

}

class Monkey extends Animal2 {
	Monkey() {
		super("������");
	}

	@Override
	void eat() {
		System.out.println(name + "�� �������� ���Ÿ� ���� �Դ´�.");

	}

}

class Eagle extends Animal2 implements Flyable {
	Eagle() {
		super("������");
	}

	@Override
	void eat() {
		System.out.println(name + "�� ���� ���� ��� �Դ´�.");
		;

	}

	@Override
	public void fly() {
		System.out.println(name + "�� ��û ���� ���ƴٴѴ�.");

	}

}

public class Exam1 {

	public static void main(String[] args) {
		Animal2[] arr = new Animal2[3];
		arr[0] = new Dove(); // Dove ��ü�� Animal2 Ŭ������ ����ȯ�� �����ؾ� ��.
							 // Dove Ŭ������ Animal2 Ŭ������ �ڼ�Ŭ����������.
		arr[1] = new Monkey();
		arr[2] = new Eagle();
		for (Animal2 a : arr) {
			if (a instanceof Animal2) {
				a.eat();
			}
			if (a instanceof Flyable) { // a�� Flyable�� ������ ���� Ŭ����
				((Flyable) a).fly();
			}
		}
	}

}
