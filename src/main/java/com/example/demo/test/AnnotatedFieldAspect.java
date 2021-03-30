package com.example.demo.test;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.WeakHashMap;

@Aspect
@Component
@Slf4j
public class AnnotatedFieldAspect {
    @Around("execution(* com.example.demo.test.Test.setValue(..))")
    public Object interceptResponse(ProceedingJoinPoint  thisJoinPoint) throws Throwable {
        Object[] args = thisJoinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            Object raw = args[i];
            if (raw instanceof String) {
                // and replace it with a new value
                args[i] =    args[i] + "GUMENT";
            }
        }
        return thisJoinPoint.proceed(args);
    }
}
