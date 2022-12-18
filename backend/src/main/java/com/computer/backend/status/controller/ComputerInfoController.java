package com.computer.backend.status.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computer.backend.status.dto.ComputerBasicDTO;
import com.computer.backend.status.service.ComputerInfoService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@CrossOrigin
@RequestMapping("/computerInfo/v1")
public class ComputerInfoController {

	private static Logger logger = LoggerFactory.getLogger(ComputerInfoController.class);
	
	@Autowired
	ComputerInfoService computerInfoService;
	
	@GetMapping("/computerBasicData")
	@ResponseBody
	public ComputerBasicDTO coumputerBasicData(HttpServletRequest request) {
		logger.debug("computerBasinData REQ : {} ", request);
		return computerInfoService.ComputerInfo(request);
	}
	
	public static void main(String[] args) {
//		Properties test = System.getProperties();
//		for(Object obj : test.keySet()) {
//			logger.debug("OBJECT DATA : {}  VALUE : {} " , obj, test.get(obj));
//		}
		logger.trace("LOG TRACE TEST !");
		logger.debug("LOG DEBUG TEST !");	
		logger.info("LOG INFO TEST");
		logger.warn("LOG WARN TEST!");
		logger.error("LOG ERROR TEST !");
		
		
		List <String> listA = new ArrayList <String>();
		
		listA.add("1");
		listA.add("2");
		listA.add("3");
		
		logger.debug("LIST ARRAY CHECK : {} ");
		
	}
	
}
