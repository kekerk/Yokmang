package model;

public class Series {
	private int seriesno;
	private String posname;
	private String poscontent;
	private String posimage;
	private int seriescnt;
	private double onlinescore;
	private String moviedirector;
	private String outline;
	public int getSeriesno() {
		return seriesno;
	}
	public void setSeriesno(int seriesno) {
		this.seriesno = seriesno;
	}
	public String getPosname() {
		return posname;
	}
	public void setPosname(String posname) {
		this.posname = posname;
	}
	public String getPoscontent() {
		return poscontent;
	}
	public void setPoscontent(String poscontent) {
		this.poscontent = poscontent;
	}
	public String getPosimage() {
		return posimage;
	}
	public void setPosimage(String posimage) {
		this.posimage = posimage;
	}
	public double getSeriescnt() {
		return seriescnt;
	}
	public void setSeriescnt(int seriescnt) {
		this.seriescnt = seriescnt;
	}
	public double getOnlinescore() {
		return onlinescore;
	}
	public void setOnlinescore(double onlinescore) {
		this.onlinescore = onlinescore;
	}
	public String getMoviedirector() {
		return moviedirector;
	}
	public void setMoviedirector(String moviedirector) {
		this.moviedirector = moviedirector;
	}
	public String getOutline() {
		return outline;
	}
	public void setOutline(String outline) {
		this.outline = outline;
	}

}
