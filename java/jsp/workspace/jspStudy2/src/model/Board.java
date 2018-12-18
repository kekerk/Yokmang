package model;

import java.util.Date;

public class Board {
	private int  num;
	private String  name;
	private String  pass;
	private String  title;
	private String  content;
	private String  file1;
	private String search;
	private String searchfor;
	
	private Date  regdate;
	private int  readcnt;
	private int ref;
	private int reflevel;
	private int refstep;
	
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
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
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getReflevel() {
		return reflevel;
	}
	public void setReflevel(int reflevel) {
		this.reflevel = reflevel;
	}
	public int getRefstep() {
		return refstep;
	}
	public void setRefstep(int refstep) {
		this.refstep = refstep;
	}
	
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
	public String getSearchfor() {
		return searchfor;
	}
	public void setSearchfor(String searchfor) {
		this.searchfor = searchfor;
	}
	@Override
	public String toString() {
		return "Board [num=" + num + ", name=" + name + ", pass=" + pass + ", title=" + title + ", content=" + content
				+ ", file1=" + file1 + ", readcnt=" + readcnt + ", ref=" + ref + ", reflevel=" + reflevel + ", refstep="
				+ refstep + "]";
	}
	
	
	
}
