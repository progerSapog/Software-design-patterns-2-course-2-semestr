package com.ngtu.sdp.laboratory_work2.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Aspect
public class LoggerAspect
{
    public static final Logger LOGGER = LoggerFactory.getLogger(LoggerAspect.class);

    @Before("execution(* com.ngtu.sdp.laboratory_work2.builder.Director.constructorGraph(..))")
    public void beforeBuilderConstructLog(JoinPoint joinPoint)
    {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className                = methodSignature.getDeclaringTypeName();
        Object[] args                   = methodSignature.getParameterTypes();

        LOGGER.debug("В " + className + " передан " + args[0]);
        LOGGER.debug("Создание графовой струтуры");
    }

    @AfterThrowing("execution(* com.ngtu.sdp.laboratory_work2.builder.Director.constructorGraph(..))")
    public void afterThrowingBuilderConstructLog()
    {
        LOGGER.error("Ошибка при создании графовой структуры");
    }

    @AfterReturning(value = "execution(* com.ngtu.sdp.laboratory_work2.builder.Director.constructorGraph(..))",
            returning = "nodeOpt")
    public void afterBuilderConstructLog(Optional<?> nodeOpt)
    {
        if (nodeOpt.isEmpty()) LOGGER.debug("Отмена создания графовой структуры");
        else LOGGER.debug("Создана графовая структура");
    }
}
