package com.itheima;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;

/*
    集合的泛型 对集合元素类型(在编译阶段)进行约束
        往一个泛型是String类型的集合中添加其他类型的元素!!
 */
public class ArrayListTest {
    public static void main(String[] args) throws Exception{
        //创建集合对象
        ArrayList<String> list  = new ArrayList<>();
        list.add("你好~");
        list.add("再见~");
        System.out.println("list = " + list);
        //反射
        //第一步:获取字节码对象
        Class<ArrayList> clazz = ArrayList.class;
        //第二步:根据字节码对象获取类的成员方法
        Method add = clazz.getDeclaredMethod("add", Object.class);
        //第三步:启动方法
        add.invoke(list,100);
        add.invoke(list,new OldSister());
        add.invoke(list,new Random());
        System.out.println("list = " + list);
    }
}
