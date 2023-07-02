package com.main;

import java.time.LocalDate;

public class FootBaller extends Person {
	Integer no;
	Integer clubNo;
	Integer captainNo;
	Integer goals;	
	boolean isCaptain;
	@Override
	public String toString() {
		return "FootBaller [no=" + no + ", clubNo=" + clubNo + ", captainNo=" + captainNo + ", goals=" + goals
				+ ", isCaptain=" + isCaptain + ", name=" + name + ", age=" + age + ", dateOfBirth=" + dateOfBirth + "]";
	}
	public FootBaller(String name, Integer age, Integer no, Integer clubNo, Integer captainNo,
			Integer goals, boolean isCaptain) {
		super(name, age);
		this.no = no;
		this.clubNo = clubNo;
		this.captainNo = captainNo;
		this.goals = goals;
		this.isCaptain = isCaptain;
	}
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public Integer getClubNo() {
		return clubNo;
	}
	public void setClubNo(Integer clubNo) {
		this.clubNo = clubNo;
	}
	public Integer getCaptainNo() {
		return captainNo;
	}
	public void setCaptainNo(Integer captainNo) {
		this.captainNo = captainNo;
	}
	public Integer getGoals() {
		return goals;
	}
	public void setGoals(Integer goals) {
		this.goals = goals;
	}
	public boolean isCaptain() {
		return isCaptain;
	}
	public void setCaptain(boolean isCaptain) {
		this.isCaptain = isCaptain;
	}
	
}
