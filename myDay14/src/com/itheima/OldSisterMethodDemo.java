package com.itheima;

import java.lang.reflect.Method;

/*
    反射:
        1.获取某个类的字节码对象
        2.根据字节码对象获取一个类中相应的成员(成员变量,成员方法,构造方法)对象
                Method[] getDeclaredMethods():获取一个类中所有的成员方法对象,返回一个Method类型的数组
                Method getDeclaredMethod(String name, Class<?>... parameterTypes):
                    获取一个类中指定的成员方法对象,返回具体的某个方法对象
        3.启动方法  属于: Method
             Object invoke(Object obj, Object... args)

     注意:
        若invoke启动的是一个无返回值的方法,invoke方法的返回值是 null
        若invoke启动的是一个有返回值的方法,invoke方法的返回值就是启动方法的返回值
 */
public class OldSisterMethodDemo {
    public static void main(String[] args) throws Exception{
        //获取某个类的字节码对象
        Class<OldSister> clazz = OldSister.class;
        //根据Class对象获取类中的成员  --> 成员方法
        // Method getDeclaredMethod(String name, Class<?>... parameterTypes)
        //String name -> 你要获取的方法名称
        // Class<?>... parameterTypes : 方法的形式参数的字节码对象
        Method show = clazz.getDeclaredMethod("show");
        //启动方法
        //Object invoke(Object obj, Object... args)
        //Object obj : 调用方法的对象
        //Object...args: 调用方法的实际参数
        //创建OldSister对象
        OldSister os = clazz.newInstance();
        System.out.println(show.invoke(os));

        Method eat = clazz.getDeclaredMethod("eat", String.class);
        eat.invoke(os, "腰子");//null

        Method speak = clazz.getDeclaredMethod("speak");
        //invoke  会不会是 speak方法的结果>>
        Object invoke = speak.invoke(os);
        System.out.println("invoke = " + invoke);

        Method answer = clazz.getDeclaredMethod("answer", String.class);
        //开启暴力反射开关
        answer.setAccessible(true);
        Object invoke1 = answer.invoke(os, "请问你叫什么?");
        System.out.println("invoke1 = " + invoke1);//18


    }
}
