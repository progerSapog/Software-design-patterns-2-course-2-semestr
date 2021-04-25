package com.ngtu.sdp.laboratory_work2.builder;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public interface Builder<T>
{
    public T build(ClassPathXmlApplicationContext context);
}
