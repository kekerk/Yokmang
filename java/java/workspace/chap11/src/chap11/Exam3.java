package chap11;
/*
 * UnsupportedFunctionException 클래스 구현하기.
 */

class UnsupportedFunctionException extends RuntimeException { //RuntimeException 예외 처리 생략.
	private final int ERR_CODE;

	UnsupportedFunctionException(String msg, int err) {
		super(msg);
		this.ERR_CODE = err;// 객체마다 다른 상수값을 가질 수 있게 하기 위해.
	}

	public int getErrorCode() {
		return ERR_CODE;
	}

	@Override
	public String getMessage() {
		return super.getMessage() + ":" + ERR_CODE;
	}
}

public class Exam3 {
	public static void main(String[] args) {
		throw new UnsupportedFunctionException("지원하지 않는 기능입니다", 100);
	}
}
