package com.superjunit;

import org.junit.Assert;

/*
    创建的测试类  类名--->要测试类的类名Test
 */
public class MyMathTest {
    @MyTest
    //创建测试方法
    public void testSum(){
        MyMath mm = new MyMath();
        int sum = mm.sum(20, 20);
        //System.out.println("sum = " + sum);
        if (sum == 30){
            System.out.println("绿灯....");
        }else{
            System.out.println("红灯....");
        }
    }
    public void show(){
        System.out.println("show....");
    }
}
