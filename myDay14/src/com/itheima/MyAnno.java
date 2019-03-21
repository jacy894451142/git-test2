package com.itheima;



/*
    1.注解的本质其实就是接口
    2.注解的声明:  @interface
    3.注解的属性就是接口中的抽象方法!

        注解中的抽象方法:
            使用起来像成员变量
            本质却是一个抽象方法
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAnno {
    //属性
    public abstract String show();
}
