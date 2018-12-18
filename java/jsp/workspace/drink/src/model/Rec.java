package model;

public class Rec {
	private Double avg;
	private String title;
	private String content;
	private String file1;
	private int num;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Double getAvg() {
		return avg;
	}
	@Override
	public String toString() {
		return "Rec [avg=" + avg + ", title=" + title + ", content=" + content + ", file1=" + file1 + ", num= "+num +"]";
	}
	public void setAvg(Double avg) {
		this.avg = avg;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFile1() {
		return file1;
	}
	public void setFile1(String file1) {
		this.file1 = file1;
	}
	
}
