package com.computer.backend;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {
	
	// TODO
	// 1. Logger 설정 하기
	// 2. Convention 규칙에 따라 Project 구성하기
	
	private static Logger logger = LoggerFactory.getLogger(BackendApplication.class);
	
	public static void main(String[] args) {
		logger.trace("LOG TRACE TEST !");
		logger.debug("LOG DEBUG TEST !");	
		logger.info("LOG INFO TEST");
		logger.warn("LOG WARN TEST!");
		logger.error("LOG ERROR TEST !");
		
		
		SpringApplication.run(BackendApplication.class, args);
	}

}
