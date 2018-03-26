package org.tx.aop;

import java.util.*;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class SampleAdvice {

	private static final Logger logger = LoggerFactory.getLogger(SampleAdvice.class);
	
	@Before("execution(* org.tx.service.MessageService*.*(..))")
	public void startLog() {
		logger.info("-----------------------");
		logger.info("-----------------------");
		System.out.println("SampleAdvice--");
	}
}
