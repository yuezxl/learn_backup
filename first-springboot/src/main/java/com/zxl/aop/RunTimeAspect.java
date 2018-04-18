package com.zxl.aop;


import org.aspectj.lang.JoinPoint.StaticPart;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.zxl.annotation.RunTime;

@Aspect
@Component
public class RunTimeAspect {
	@Around("@annotation(rt)")
	public void calculateRunTime(ProceedingJoinPoint jp, RunTime rt) throws Throwable {
		//计算运行时间
		Long beginTime = System.currentTimeMillis();
		jp.proceed();
		Long runTime = System.currentTimeMillis() - beginTime;
		
		System.out.println(jp.getKind());
		
		//获取运行的类名
		Class<?> cls = jp.getTarget().getClass();
		String className = cls.getName();
		
		
		//获取方法签名
		Signature signature = jp.getSignature();
		String methodName = signature.getName();
		
		System.out.println(signature.getDeclaringTypeName());
		
		System.out.println(signature.getDeclaringType());
		
		String entireMethodName = className + "." + methodName;
		System.out.println(entireMethodName + "运行时间为:" + runTime + "ms ---");
		
		StaticPart staticPart  = jp.getStaticPart();
		Signature signature1 = staticPart.getSignature();
		System.out.println(signature1.getName());
		
		
	}
}
