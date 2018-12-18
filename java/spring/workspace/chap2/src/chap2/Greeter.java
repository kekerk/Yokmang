package chap2;

public class Greeter {
	private String format;

	public String greet(String guest) {
		//String.format("%s,안녕하세요!","스프링")
		return String.format(format, guest); //스프링,안녕하세요!
	}
	//format : %s, 안녕하세요!
	public void setFormat(String format) {
		this.format = format;
	}
}
