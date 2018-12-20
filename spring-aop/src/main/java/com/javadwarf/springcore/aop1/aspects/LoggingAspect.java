package com.javadwarf.springcore.aop1.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.javadwarf.springcore..*.set(..))")
    public void callSetterPointCut(JoinPoint joinPoint){

    }

   // @Before("callSetterPointCut(joinPoint)")
   // @Before("execution(* com.javadwarf.springcore..*set*(..))")
    @Before("execution(* com.javadwarf.springcore..*.set*(..))")
    public void callSetter(JoinPoint joinPoint){

        String methodName = joinPoint.getSignature().getName();
        String args = null;

        if(joinPoint.getArgs().length > 0){
          args =   joinPoint.getArgs()[0].toString();
        }

        String target = joinPoint.getTarget().toString();

        logger.info("calling " +  methodName + " with agrs " + args + " "+ target  );
    }

    @Around("execution(* com.javadwarf.springcore..*.set*(..))")
    public Object aroundAdvice(ProceedingJoinPoint pjp){
        System.out.println("befor calling method");
        Object obj = null;
        try {
             obj = pjp.proceed();
            System.out.println(obj);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("after calling method");
        return obj;
    }



}

/*
Sep 14, 2018 11:34:33 PM org.springframework.context.support.AbstractApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@15327b79: startup date [Fri Sep 14 23:34:33 IST 2018]; root of context hierarchy
befor calling method
Sep 14, 2018 11:34:33 PM com.javadwarf.springcore.aop1.aspects.LoggingAspect callSetter
INFO: calling setGame with agrs null I am App config
I am game
after calling method
Chicago Cubs
 */
