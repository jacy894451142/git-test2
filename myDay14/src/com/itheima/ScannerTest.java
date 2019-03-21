package com.itheima;

import org.junit.Test;

import java.util.Random;
import java.util.Scanner;
/*
    框架:  Junit框架
    注解:  @Test
        当一个方法被@Test修饰,这个方法就可以独立的运行

     如何不需要main方法就能单独的运行某个方法:
        1.在方法的声明上面加一个@Test
        2.导入Junit4框架
        3.点击方法前面的播放按钮
 */

public class ScannerTest {
    @Test
    public void show(){
       //创建Random对象
        Random r = new Random();
        //生成随机数
        int num = r.nextInt(10);
        System.out.println("num = " + num);
    }

    @Test
    public void show1(){
        //创建Random对象
        Random r = new Random();
        //生成随机数
        int num = r.nextInt(10);
        System.out.println("num = " + num);
    }
}
