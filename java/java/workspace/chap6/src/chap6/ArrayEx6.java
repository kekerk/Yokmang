package chap6;

/*
 * command line에서 파라미터값 입력 받기.
 */
public class ArrayEx6 {
	public static void main(String[] args) { // return 타입이 void : 끝나면 전달해줄 값이 없다. 리턴값을 남기지 않음.
		if (args.length == 0) {
			System.out.println("커맨드 라인에 파라미터를 입력하세요");
			System.out.println("java ArrayEx6 홍길동 김삿갓");
			return; // 메서드 종료
		}
		for (int i = 0; i < args.length; i++) {
			System.out.println("args[" + i + "]=" + args[i]);
		}

	}// 메서드 종료

}
