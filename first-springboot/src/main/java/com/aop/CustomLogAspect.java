package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.annotation.CustomLog;

@Aspect
@Component
public class CustomLogAspect {
	@Around("within(com.*) && @annotation(log)")
	public void addLog(JoinPoint jp, CustomLog log) {
		Object[] paras = jp.getArgs();
		System.out.println("jp.getClass()=" + jp.getClass().toString());
		System.out.println("jp.getTarget().getClass()=" + jp.getTarget().getClass().toString());
		String className = jp.getTarget().getClass().toString();
		
		String signature = jp.getSignature().toLongString();
		System.out.println(signature);
		String methodName = signature.substring(signature.lastIndexOf("." + 1), signature.indexOf("("));
		
		
	}
}
