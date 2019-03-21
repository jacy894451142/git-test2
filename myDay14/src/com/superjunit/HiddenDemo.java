package com.superjunit;

import java.lang.reflect.Method;

@GetName(className = "com.superjunit.ScannerTest")
public class HiddenDemo {
    public static void main(String[] args) throws Exception{
        //获取本类的字节码对象
        Class<HiddenDemo> clazz = HiddenDemo.class;
        //获取本类字节码对象的注解的子类对象
        GetName gn = clazz.getAnnotation(GetName.class);
        //根据GetName注解的子类对象 gn 获取 注解的属性值 --> 获取测试类的全类名
        String testClassName = gn.className();
        //根据测试类的全类名  获取测试类的字节码对象
        Class testClass = Class.forName(testClassName);
        //创建一个测试类的对象
        Object instance = testClass.newInstance();
        //通过测试类的字节码对象获取所有的Method类型对象
        Method[] methods = testClass.getDeclaredMethods();
        //遍历Method数组
        for (Method method : methods) {
            // boolean isAnnotationPresent(Class<? extends Annotation> annotationClass)  :
            //判断这个方法对象指向的方法上有没有被某个注解标识!
            if (method.isAnnotationPresent(MyTest.class)){
                method.invoke(instance);
            }
        }
    }
}
