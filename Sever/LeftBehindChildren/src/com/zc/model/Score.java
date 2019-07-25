package com.zc.model;

public class Score {
	private int id;
	private String examtype;
	private String classin;
	private String stuname;
	private String chinese;
	private String math;
	private String english;
	private String teachersay;
	public Score() {
		super();
	}
	public Score(int id, String examtype, String classin, String stuname, String chinese, String math, String english,
			String teachersay) {
		super();
		this.id = id;
		this.examtype = examtype;
		this.classin = classin;
		this.stuname = stuname;
		this.chinese = chinese;
		this.math = math;
		this.english = english;
		this.teachersay = teachersay;
	}
	@Override
	public String toString() {
		return "Score [id=" + id + ", examtype=" + examtype + ", classin=" + classin + ", stuname=" + stuname + ", chinese=" + chinese
				+ ", math=" + math + ", english=" + english + ", teachersay=" + teachersay + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getExamtype() {
		return examtype;
	}
	public void setExamtype(String examtype) {
		this.examtype = examtype == null ? null : examtype.trim();
	}
	public String getClassin() {
		return classin;
	}
	public void setClassin(String classin) {
		this.classin = classin == null ? null : classin.trim();
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname == null ? null : stuname.trim();
	}
	public String getChinese() {
		return chinese;
	}
	public void setChinese(String chinese) {
		this.chinese = chinese == null ? null : chinese.trim();
	}
	public String getMath() {
		return math;
	}
	public void setMath(String math) {
		this.math = math == null ? null : math.trim();
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english == null ? null : english.trim();
	}
	public String getTeachersay() {
		return teachersay;
	}
	public void setTeachersay(String teachersay) {
		this.teachersay = teachersay == null ? null : teachersay.trim();
	}
}
