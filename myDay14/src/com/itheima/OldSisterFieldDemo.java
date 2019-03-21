package com.itheima;

import java.lang.reflect.Field;
import java.util.Arrays;

/*
    Field:成员变量

    Class类中的方法:
        Field[] getDeclaredFields():获取一个字节码对象中所有成员变量对象,并返回一个Field类型的数组
        Field getDeclaredField(String name):获取一个字节码对象中指定的成员变量对象,并返回这个成员变量的Field对象
   获取,赋值
    Field类中的方法:
        Object get(Object obj) :获取成员变量的值
        void set(Object obj, Object value):设置成员变量的值

 */
public class OldSisterFieldDemo {
    public static void main(String[] args) throws Exception {
        //获取字节码对象
        Class<OldSister> clazz  = OldSister.class;
        //根据字节码对象快速的获取一个类的无参对象
        OldSister os = clazz.newInstance();
        //获取一个字节码对象中所有的成员变量对象
        Field[] fields = clazz.getDeclaredFields();
        System.out.println(Arrays.toString(fields));
        System.out.println("-----------------------------");
        //获取一个字节码对象中指定的成员变量对象
        //getDeclaredField(String name):  String name --->这个成员变量的名字
        Field name = clazz.getDeclaredField("name");
        Field gender = clazz.getDeclaredField("gender");
        Field weight = clazz.getDeclaredField("weight");
        Field age = clazz.getDeclaredField("age");
        //有了成员变量对象,   获取,赋值
        //获取值Object get(Object obj)    Object obj-->代表的是你要获取哪一个OldSister对象的name属性值
        System.out.println(name.get(os));//null
        age.setAccessible(true);
        System.out.println(age.get(os));//0
        System.out.println(gender.get(os));//null
        System.out.println(weight.get(os));//null
        System.out.println("-----------------------------");
        //void set(Object obj, Object value):设置成员变量的值
        name.set(os,"凤姐");
        age.set(os,19);
        gender.set(os,"男");
        weight.set(os,"180");
        System.out.println(name.get(os));//
        System.out.println(age.get(os));//
        System.out.println(gender.get(os));//
        System.out.println(weight.get(os));//

        System.out.println(os);

        OldSister os1 = clazz.newInstance();
        System.out.println(os1);//



    }
}
