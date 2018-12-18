package mybatis;

import java.util.Date;

public class Comment {
	private int no;
	private String id;
	private String content;
	private Date regdate;
	public Comment() {}	
	public Comment(int no, String id, String content, Date regdate) {
		this.no = no;
		this.id = id;
		this.content = content;
		this.regdate = regdate;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "Comment [no=" + no + ", id=" + id + ", content=" + content + ", regdate=" + regdate + "]";
	}
	
}
