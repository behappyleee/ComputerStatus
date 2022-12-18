package com.computer.backend.status.dto;

public class ComputerBasicDTO {
	
	private String os;				// 컴퓨터 기본 OS
	private String cpu;				// 컴퓨터 기본 CPU
	private String userCountry;		// 사용자 국가 정보
	private String userTimeZone; 	// 사용자 TimeZone
	
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getUserCountry() {
		return userCountry;
	}
	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}
	public String getUserTimeZone() {
		return userTimeZone;
	}
	public void setUserTimeZone(String userTimeZone) {
		this.userTimeZone = userTimeZone;
	}
	
	@Override
	public String toString() {
		return "OS : " + this.os + " CPU : " + this.cpu + " USER COUNTRY : " + this.userCountry + " USER TIME ZONE : " + this.userTimeZone; 
	}
	
}
