package tn.esprit.spring.testspringelmahdichabbouh.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Slf4j
public class loggingAspect {
    @AfterReturning("execution(* tn.esprit.spring.testspringelmahdichabbouh.servicesInterfaces..ajouter*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Bienvenue dans l’application \n" +
                "Boycott :" + name );
    }
}