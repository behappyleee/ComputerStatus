package com.computer.backend.status.controller;

import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computer.backend.status.dto.ComputerBasicDTO;
import com.computer.backend.status.service.ComputerInfoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@CrossOrigin
@RequestMapping("/computerInfo/v1")
public class ComputerInfoController {

	private static Logger logger = LoggerFactory.getLogger(ComputerInfoController.class);
	
	@Autowired
	ComputerInfoService computerInfoService;
	
	@RequestMapping("/computerBasicData")
	@ResponseBody
	public ComputerBasicDTO coumputerBasicData(HttpServletRequest request) {
		logger.debug("computerBasinData REQ : {} ", request);
		logger.debug("RETURN DATA CHECK : {} ", computerInfoService.ComputerInfo(request));
		
		return computerInfoService.ComputerInfo(request);
	}
	
	@RequestMapping("/getTimeFromBack")
	@ResponseBody
	public LocalTime localTime(HttpServletResponse res) {
		res.setHeader("Access-Control-Allow-Origin", "*");
		return LocalTime.now();
	}
	
	public static void main(String[] args) {
		System.out.println("JAVA LOCAL DATA : " + LocalTime.now());
	}
	
	
	
}
