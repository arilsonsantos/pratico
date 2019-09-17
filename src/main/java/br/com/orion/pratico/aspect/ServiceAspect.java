package br.com.orion.pratico.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * ServiceAspect
 */
@Aspect
@Component
@Slf4j
public class ServiceAspect {

    
    @Before("execution(* br.com.orion.pratico.service.*Service.insert(..))")
    public void beforeInsert(JoinPoint joinPoing) {
        log.info("Inicializou " + joinPoing.getSignature().toShortString() + " " + joinPoing.getArgs()[0]);
    }
    
    @After("execution(* br.com.orion.pratico.service.*Service.insert(..))")
    public void afterInsert(JoinPoint joinPoing) {
        log.info("Finalizou " + joinPoing.getSignature().toShortString() +  " " + joinPoing.getArgs()[0]);
    }
}