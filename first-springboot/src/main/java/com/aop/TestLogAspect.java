package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.annotation.TestLog;

@Aspect
@Component
public class TestLogAspect {
	@Pointcut(value = "args(para)", argNames = "para")
	private void pointcut1(String para){}
	
	@Before(value="execution(* test(*)) && args(param)", argNames="param" )
	public void before(String param) {
		System.out.println("before begin =============>");
		System.out.println(param);
		System.out.println("before end =============<");
	}
	
	@After(value="execution(* test(*)) && args(param)")
	public void after(String param){
		System.out.println("after begin =============>");
		System.out.println(param);
		System.out.println("after end =============<");
	}
}
