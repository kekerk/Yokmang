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

} //같은 인터페이스끼리는 다중 상속 가능.  A extends B,C,D

class Complexer implements Complexerable {
	int ink;

	Complexer() {
		this.ink = INK;
	}

	public void print() {
		System.out.println("종이에 출력합니다. 남은 잉크량: " + --ink);
	}

	public void scan() {
		System.out.println("이미지를 스캔합니다.");
	}

	public void send(String tel) {
		System.out.println(FAX_NO + "에서 " + tel + "번호로 FAX를 전송합니다.");
	}

	public void receive(String tel) {
		System.out.println(tel + "에서 " + FAX_NO + "번호로 FAX를 받았습니다.");
	}
}

public class ComplexerEx1 {

	public static void main(String[] args) {
		Complexer com = new Complexer();
		System.out.println("기본잉크량: " + Printerable.INK);
		System.out.println("FAX_NO: " + Faxable.FAX_NO);
		com.print();
		com.scan();
		com.receive("02-5678");
		com.send("02-5678");

		if (com instanceof Complexer) // instanceof 객체 포함의 여부
			System.out.println("com 객체는 Complexer 객체임");

		if (com instanceof Complexerable)
			System.out.println("com 객체는 Complexerable 객체임");

		if (com instanceof Printerable)
			System.out.println("com 객체는 Printerable 객체임");
		if (com instanceof Scannerable)
			System.out.println("com 객체는 Scannerable 객체임");
		if (com instanceof Faxable)
			System.out.println("com 객체는 Faxable 객체임");

		if (com instanceof Object)
			System.out.println("com 객체는 Object 객체임");
	}

}
