package com.computer.backend.status.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CpuStatusController {

	private static Logger logger = LoggerFactory.getLogger(CpuStatusController.class);
	
	@RequestMapping("/cpuStatus")
	public Model cpuStatus(Model model) {
		logger.debug("CPU STATUS ");
		return model;
	}
	
	
	public static void main(String[] args) {
		System.out.println("사용 OS 확인 " + System.getProperties());
		System.out.println("OS NAME : " + System.getProperty("os.name"));
	}
	
	
	
}
