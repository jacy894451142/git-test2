package com.itheima;

import javax.management.ReflectionException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
    String:  "com.itheima.Person"

    Class:类
    Constructor:构造方法
    Field:成员变量
    Method:成员方法
 */
public class PersonTest {
    public static void main(String[] args) throws Exception{
        //获取了一个类的字节码对象
        Class clazz = Class.forName("com.itheima.Person");

        //查看这个类中有多少个构造方法
//        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
//        for (Constructor declaredConstructor : declaredConstructors) {
//            System.out.println("declaredConstructor = " + declaredConstructor);
//        }
        //获取某一个构造方法对象
        Constructor constructor = clazz.getDeclaredConstructor(String.class, int.class);
        //根据构造方法对象创建这个类的对象
        Person p = (Person) constructor.newInstance("迪丽热巴", 20);

        System.out.println(p);

        System.out.println(p.getName());
        System.out.println(p.getAge());

    }
}
