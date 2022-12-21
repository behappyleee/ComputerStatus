package com.computer.backend.status.service;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.computer.backend.status.dto.CpuStatusDto;

@Service
public class CpuStatusService {

	private static Logger logger = LoggerFactory.getLogger(CpuStatusService.class);
	
	public CpuStatusDto currentCpuStatus() {
		CpuStatusDto cpuStatusDto = new CpuStatusDto();
		cpuStatusDto.setCpuName("");
		cpuStatusDto.setCpuCount(0);
		cpuStatusDto.setCpuUsage(null);
		cpuStatusDto.setJvmUsage(null);
		return cpuStatusDto;
	}
	
	
	public static void main(String[] args) {
		OperatingSystemMXBean osBean = (com.sun.management.OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean();
		
		double testOs = osBean.getSystemLoadAverage();
		
		// System 메모리 확인
		osBean.getSystemLoadAverage();
		
		MemoryMXBean mBean = ManagementFactory.getMemoryMXBean();
		
		mBean.getHeapMemoryUsage();
		
		logger.debug("HEAP STATUS : {} ", mBean.getHeapMemoryUsage().getUsed());
		logger.debug("testOs : {} ", testOs);
		logger.debug("OS CPU STATUS : {} ", osBean.getArch());
		logger.debug("OS CPU GET 1: {} ", osBean.getAvailableProcessors());
		logger.debug("OS CPU GET 2: {} ", osBean.getVersion());
		logger.debug("OS CPU GET 3: {} ", osBean.getArch() );
		logger.debug("OS CPU GET 4: {} ", osBean.getObjectName());
		logger.debug("OS BEAN GET DATA TEST 1: {} " , osBean.getName());
	
	  // TODO CPU 사용량 구하기 ......	
		
	  RuntimeMXBean runBean = (RuntimeMXBean) ManagementFactory.getRuntimeMXBean();
		
	  long currentCpuStatus = runBean.getUptime();
	  
	  logger.debug("CPU STATUS : {} " , currentCpuStatus);
	  
	}
	
}
