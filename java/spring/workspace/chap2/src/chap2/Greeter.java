package chap2;

public class Greeter {
	private String format;

	public String greet(String guest) {
		//String.format("%s,�ȳ��ϼ���!","������")
		return String.format(format, guest); //������,�ȳ��ϼ���!
	}
	//format : %s, �ȳ��ϼ���!
	public void setFormat(String format) {
		this.format = format;
	}
}
