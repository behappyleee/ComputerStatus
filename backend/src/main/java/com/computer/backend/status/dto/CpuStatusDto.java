package com.computer.backend.status.dto;

public class CpuStatusDto {
	
	private String cpuName;		// CPU 이름 
	private int cpuCount;		// CPU 갯수
	private Long cpuUsage;		// CPU 사용량
	private Long jvmUsage;		// JVM 사용량
	
	public String getCpuName() {
		return cpuName;
	}
	public void setCpuName(String cpuName) {
		this.cpuName = cpuName;
	}
	public int getCpuCount() {
		return cpuCount;
	}
	public void setCpuCount(int cpuCount) {
		this.cpuCount = cpuCount;
	}
	public Long getCpuUsage() {
		return cpuUsage;
	}
	public void setCpuUsage(Long cpuUsage) {
		this.cpuUsage = cpuUsage;
	}
	public Long getJvmUsage() {
		return jvmUsage;
	}
	public void setJvmUsage(Long jvmUsage) {
		this.jvmUsage = jvmUsage;
	}
	
}	
