package model;

public class StudentBean {

	private String name;
	private String major;
	private double gpa;

	public StudentBean(String name, String major, double gpa) {
		this.name = name;
		this.major = major;
		this.gpa = gpa;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
}
