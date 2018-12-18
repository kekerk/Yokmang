package chap11;
/*
 * UnsupportedFunctionException Ŭ���� �����ϱ�.
 */

class UnsupportedFunctionException extends RuntimeException { //RuntimeException ���� ó�� ����.
	private final int ERR_CODE;

	UnsupportedFunctionException(String msg, int err) {
		super(msg);
		this.ERR_CODE = err;// ��ü���� �ٸ� ������� ���� �� �ְ� �ϱ� ����.
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
		throw new UnsupportedFunctionException("�������� �ʴ� ����Դϴ�", 100);
	}
}
