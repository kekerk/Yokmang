package chap11;

interface Parseable {

	void parse();

}

public class Q0814_4 {

	public static void main(String[] args) {
		// ������ ���� Ŭ���� �̿�.
		Parseable htmlParser = new Parseable() {
			public void parse() {
				System.out.println("html�� ����մϴ�.");
			}
		};

		htmlParser.parse();

		Parseable xmlParser = new Parseable() {
			public void parse() {
				System.out.println("xml�� ����մϴ�.");
			}
		};

		xmlParser.parse();

	}

}
