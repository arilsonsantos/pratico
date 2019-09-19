package br.com.orion.pratico.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
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
        log.info("Inserindo... " + joinPoing.getSignature().toShortString() + " " + joinPoing.getArgs()[0]);
    }

    @After("execution(* br.com.orion.pratico.service.*Service.insert(..))")
    public void afterInsert(JoinPoint joinPoing) {
        log.info("Inseriiu! " + joinPoing.getSignature().toShortString() + " " + joinPoing.getArgs()[0]);
    }

    @Before("execution(* br.com.orion.pratico.service.*Service.update(..))")
    public void beforeUpdate(JoinPoint joinPoing) {
        log.info("Atualizando... " + joinPoing.getSignature().toShortString() + " " + joinPoing.getArgs()[0]);
    }

    @After("execution(* br.com.orion.pratico.service.*Service.update(..))")
    public void afterUpdate(JoinPoint joinPoing) {
        log.info("Atualizou! " + joinPoing.getSignature().toShortString() + " " + joinPoing.getArgs()[0]);
    }

    @AfterThrowing(pointcut = "execution(* br.com.orion.pratico.service.*Service.*update(..))")
    public void afterThrowing() {
        log.info("lançou exceção ");
    }
}