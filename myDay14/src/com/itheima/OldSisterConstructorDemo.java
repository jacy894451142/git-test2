package com.itheima;

import java.lang.reflect.Constructor;
import java.util.Arrays;

/*
    反射操作的步骤:
        1.获取类的字节码对象
        2.根据字节码对象获取 类中的成员(成员变量,成员方法,构造方法)
        3.有了构造方法对象(Constructor)  -->创建对象
     如何获取一个类的字节码对象:
         1.Class clazz = 类的对象.getClass();
         2.Class clazz = 类名.class;
         3.Class clazz = Class.forName("全类名");

     Class类中的成员方法:
        获取某一个类中的构造方法对象:
        了解:
            Constructor<?>[] getConstructors():获取一个字节码对象中的所有public修饰构造方法对象
            Constructor<T> getConstructor(Class<?>...parameterTypes):获取一个字节码对象中指定的某一个public修饰的构造方法对象
        重点:
            Constructor<?>[] getDeclaredConstructors():获取一个字节码对象中所有的构造方法对象(包括私有的)
            Constructor<T> getDeclaredConstructor(Class<?>...parameterTypes):获取一个字节码对象中指定的某一个构造方法对象(包括私有的)

         根据构造方法对象 创建对象!!
      Constructor类中的成员方法:
            T newInstance(Object... initargs)

        AccessibleObject:是Constructor,Field,Method的父类
            void setAccessible(boolean flag)


      总结: 虽然   getDeclaredXxxxx()方法能获取到一个类中的私有成员 但是要使用这个私有的成员时,必须打开暴力反射开关
         void setAccessible(boolean flag)

      利用反射创建一个类的对象的步骤:
            1.获取这个类的字节码对象 获取字节码对象的三种方式
            2.获取这个类中的指定的某一个构造方法对象 Class -->getDeclaredConstructor(方法的形参类型的字节码对象)
            3.若你获取的是一个私有的成员,在使用之前记得打开暴力反射开关! Constructor --> void setAccessible(boolean flag)
            4.根据这个构造方法对象创建实例  Constructor --> T newInstance(Object... initargs)


       如何快速的获取一个类的对象呢??
            Class类中方法:
                 T newInstance()  --> 根据字节码对象快速的获取一个类中的无参对象!!

 */
public class OldSisterConstructorDemo {
    public static void main(String[] args) throws Exception{
        //第一步获取一个类的字节码对象
        Class<OldSister> clazz = OldSister.class;
        //获取OldSister类中所有的构造方法
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        System.out.println(Arrays.toString(constructors));
        System.out.println("---------------------------------------");
        // public OldSister(String name, String weight, String gender, int age)
        Constructor<OldSister> constructor = clazz.getConstructor(String.class , String.class, String.class , int.class);
        System.out.println(constructor);
        // private OldSister(String weight, int age)
        Constructor<OldSister> constructor1 = clazz.getDeclaredConstructor(String.class, int.class);
        System.out.println(constructor1);

        //根据相应的构造方法对象创建该类对象
        //T newInstance(Object... initargs)
        OldSister os = constructor.newInstance("凤姐", "95", "女", 30);
        System.out.println(os);
        OldSister os1 = constructor.newInstance("汤唯", "100", "女", 20);
        System.out.println(os1);
        // void setAccessible(boolean flag):开启暴力反射开关
        constructor1.setAccessible(true);
        OldSister os2 = constructor1.newInstance("300", 18);
        System.out.println(os2);

        System.out.println("---------------------------------");
        OldSister os3 = clazz.newInstance();
        System.out.println(os3);


    }
}
