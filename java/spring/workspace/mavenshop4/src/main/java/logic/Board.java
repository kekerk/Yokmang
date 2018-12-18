package logic;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;


public class Board {
	private int num;
	private int readcnt;
	private int ref;
	private int reflevel;
	private int refstep;
	@NotEmpty(message="������̸��� �ʼ��Դϴ�.")
	private String name;
	@NotEmpty(message="��й�ȣ�� �ʼ��Դϴ�.")
	private String pass;
	@NotEmpty(message="������ �Է��ϼ���.")
	private String subject;
	@NotEmpty(message="������ �Է��ϼ���.")
	private String content;
	private String fileurl;
	private MultipartFile file1;
	private Date regdate;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFileurl() {
		return fileurl;
	}
	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}
	public MultipartFile getFile1() {
		return file1;
	}
	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "Board [num=" + num + ", readcnt=" + readcnt + ", ref=" + ref + ", reflevel=" + reflevel + ", refstep="
				+ refstep + ", name=" + name + ", pass=" + pass + ", subject=" + subject + ", content=" + content
				+ ", file1=" + file1 + ", regdate=" + regdate + "]";
	}

	
	
}
