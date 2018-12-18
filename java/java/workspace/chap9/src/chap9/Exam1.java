package chap9;

/*
 * Animal2 클래스는 다음과 같다. 구동클래스를 실행했을 때 다음의 결과가 나오도록 프로그램 구현하기.
 * [결과]
 * 비돌기는 작은 벌레를 잡아 먹는다.
 * 비둘기는 날아 다니는 새입니다.
 * 원숭이는 나무에서 열매를 따서 먹는다.
 * 독수리는 작은 새를 잡아 먹는다.
 * 독수리는 엄청 높이 날아 다닌다.
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
		super("비둘기"); //추상 클래스 생성 시 생성자에는 매개변수가 존재하므로 바로 초기화되어야 한다.
	}

	@Override
	void eat() { // Animal2에서 오버라이딩된 eat()을 가리킨다.
		System.out.println(name + "는 작은 벌레를 잡아먹는다.");

	}

	@Override
	public void fly() {
		System.out.println(name + "는 날아 다니는 새입니다.");

	}

}

class Monkey extends Animal2 {
	Monkey() {
		super("원숭이");
	}

	@Override
	void eat() {
		System.out.println(name + "는 나무에서 열매를 따서 먹는다.");

	}

}

class Eagle extends Animal2 implements Flyable {
	Eagle() {
		super("독수리");
	}

	@Override
	void eat() {
		System.out.println(name + "는 작은 새를 잡아 먹는다.");
		;

	}

	@Override
	public void fly() {
		System.out.println(name + "는 엄청 높이 날아다닌다.");

	}

}

public class Exam1 {

	public static void main(String[] args) {
		Animal2[] arr = new Animal2[3];
		arr[0] = new Dove(); // Dove 객체는 Animal2 클래스로 형변환이 가능해야 함.
							 // Dove 클래스는 Animal2 클래스의 자손클래스여야함.
		arr[1] = new Monkey();
		arr[2] = new Eagle();
		for (Animal2 a : arr) {
			if (a instanceof Animal2) {
				a.eat();
			}
			if (a instanceof Flyable) { // a는 Flyable이 구현된 구현 클래스
				((Flyable) a).fly();
			}
		}
	}

}
