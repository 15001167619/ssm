package com.whs.ssm.aop;

import com.whs.ssm.dto.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * @author 武海升
 */
@Component
@Aspect
@Slf4j
public class BindingResultAop {


    @Pointcut("execution(* com.znkf.shop.web.*.*(..))")
    public void aopMethod(){}

    @Around("aopMethod()")
    public Object  around(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("调用web 方法");
        BindingResult bindingResult = null;
        for(Object arg:joinPoint.getArgs()){
            if(arg instanceof BindingResult){
                bindingResult = (BindingResult) arg;
            }
        }
        if(bindingResult != null){
            if(bindingResult.hasErrors()){
                String errorInfo="["+bindingResult.getFieldError().getField()+"]"+bindingResult.getFieldError().getDefaultMessage();
                return new BaseResult<Object>(false, errorInfo);
            }
        }
        return joinPoint.proceed();
    }
}
