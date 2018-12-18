package chap11;

interface Parseable {

	void parse();

}

public class Q0814_4 {

	public static void main(String[] args) {
		// 무명의 내부 클래스 이용.
		Parseable htmlParser = new Parseable() {
			public void parse() {
				System.out.println("html을 출력합니다.");
			}
		};

		htmlParser.parse();

		Parseable xmlParser = new Parseable() {
			public void parse() {
				System.out.println("xml을 출력합니다.");
			}
		};

		xmlParser.parse();

	}

}
