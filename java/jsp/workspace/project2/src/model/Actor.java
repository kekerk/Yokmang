package model;

import java.util.Date;

public class Actor {
	private int no;
	private String actorname;
	private String actorimg;
	private String seriesname;
	private Date birthdate;
	private String birthplace;
	private String actseries;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getActorname() {
		return actorname;
	}
	public void setActorname(String actorname) {
		this.actorname = actorname;
	}
	public String getActorimg() {
		return actorimg;
	}
	public void setActorimg(String actorimg) {
		this.actorimg = actorimg;
	}
	public String getSeriesname() {
		return seriesname;
	}
	public void setSeriesname(String seriesname) {
		this.seriesname = seriesname;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getBirthplace() {
		return birthplace;
	}
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}
	public String getActseries() {
		return actseries;
	}
	public void setActseries(String actseries) {
		this.actseries = actseries;
	}
	@Override
	public String toString() {
		return "Actor [no=" + no + ", actorname=" + actorname + ", actorimg=" + actorimg + ", seriesname=" + seriesname
				+ ", birthdate=" + birthdate + ", birthplace=" + birthplace + ", actseries=" + actseries + "]";
	}

}
