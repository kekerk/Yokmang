package model;

import java.sql.Date;

public class Allboard {
	private int no;
	private String id;
	private String password;
	private String dormi;
	private String nickname;
	private int seriesno;
	private String seriesname;
	private int boardtype;
	private String title;
	private String content;
	private String file1;
	private Date regdate;
	private int readcnt;

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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getSeriesname() {
		return seriesname;
	}

	public void setSeriesname(String seriesname) {
		this.seriesname = seriesname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getDormi() {
		return dormi;
	}

	public void setDormi(String dormi) {
		this.dormi = dormi;
	}

	public int getSeriesno() {
		return seriesno;
	}

	public void setSeriesno(int seriesno) {
		this.seriesno = seriesno;
	}

	public int getBoardtype() {
		return boardtype;
	}

	public void setBoardtype(int boardtype) {
		this.boardtype = boardtype;
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

}
