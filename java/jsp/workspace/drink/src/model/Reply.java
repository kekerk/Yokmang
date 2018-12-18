package model;


public class Reply {
	private int rnum;
	private String rname;
	private double rating;
	private String rcontent;
	private int num;
	
	
	@Override
	public String toString() {
		return "Reply [rnum=" + rnum + ", rname=" + rname + ", rating=" + rating + ", rcontent=" + rcontent + ", num="
				+ num + "]";
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
}