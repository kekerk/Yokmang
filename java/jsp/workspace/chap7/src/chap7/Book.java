package chap7;

public class Book {
	private String writer;
	private String title;
	private String content;

	// getters
	// getProperty : getXxx() : xxx (get옆에 Xxx가 Property)
	// getWriter : writer Property
	public String getWriter() {
		return writer;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	// setters
	// setProperty : setXxx() : xxx (set옆에 Xxx가 Property)
	// setWriter : writer Property
	public void setWriter(String writer) { //변수의 이름에서 첫글자를 대문자로 표시
		this.writer = writer;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
