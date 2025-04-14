package dev.example.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectConfig {

    @Before(value = "execution(* dev.example.controller.*.*(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("Before: " + joinPoint);
    }

    @After(value = "execution(* dev.example.controller.*.*(..))")
    public void after(JoinPoint joinPoint) {
        System.out.println("After: " + joinPoint);
    }
}
