package chap7;

public class Book {
	private String writer;
	private String title;
	private String content;

	// getters
	// getProperty : getXxx() : xxx (get���� Xxx�� Property)
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
	// setProperty : setXxx() : xxx (set���� Xxx�� Property)
	// setWriter : writer Property
	public void setWriter(String writer) { //������ �̸����� ù���ڸ� �빮�ڷ� ǥ��
		this.writer = writer;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
