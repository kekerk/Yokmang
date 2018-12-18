package el;

public class Compute {
	public static int add(String x, String y) {
		try {
			// a : x파라미터를 정수로 변환한 값
			int a = Integer.parseInt(x);
			// b : y파라미터를 정수로 변환한 값
			int b = Integer.parseInt(y);
			return a+b;
		}catch(Exception e) {}
		return 0; // 다른 것들이 입력되면 결과 0 처리
	}
}
