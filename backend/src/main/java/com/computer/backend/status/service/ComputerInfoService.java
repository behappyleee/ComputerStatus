package com.computer.backend.status.service;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.computer.backend.status.dto.ComputerBasicDTO;

import jakarta.servlet.http.HttpServletRequest;
import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;

@Service
public class ComputerInfoService {

	private static Logger logger = LoggerFactory.getLogger(ComputerInfoService.class);
	
	// Computer 기본정보 Return
	public ComputerBasicDTO ComputerInfo (HttpServletRequest req) {
		ComputerBasicDTO dto = new ComputerBasicDTO();
		
		// REQ 모든 정보 출력 하기
//		Enumeration allReqAttriuteName = req.getAttributeNames();
//		while(allReqAttriuteName.hasMoreElements()) {
//			String reqAttrivuteName = (String)allReqAttriuteName.nextElement();
//			logger.debug("REQUEST KEY : {} , VALUE : {} ", reqAttrivuteName, req.getAttribute(reqAttrivuteName));
//		}
		Properties systemProperties = System.getProperties();
		for(Object systemPropertyKey : systemProperties.keySet()) {
			// logger.debug("OBJECT DATA : {}  VALUE : {} " , systemPropertyKey, systemProperties.get(systemPropertyKey));
		}
		
		dto.setOs((String)systemProperties.get("os.name"));						// OS 정보
		dto.setCpu((String)systemProperties.get("sun.cpu.isalist"));					// CPU 정보
		dto.setUserCountry((String)systemProperties.get("user.country"));			// USER 국가 정보
		dto.setUserTimeZone((String)systemProperties.get("user.timezone"));          // USER TimeZone 정보
		
		// RETURN DTO 정보
		logger.debug("DTO RETURN DATA : {} " , dto.toString());
		
		return dto;
	}
	
	public static void main(String[] args) {
		// OS 정보 조회 Interface
		OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
		logger.debug(osBean.getArch());
		logger.debug(osBean.getName());
		logger.debug( "TEST {}",  osBean.getSystemLoadAverage() );
		logger.debug("OS BEAN : {} " , osBean.getName());
		osBean.getSystemLoadAverage();
		
	}
	
	
}
