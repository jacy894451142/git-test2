package com.test;

import com.itheima.MyMath;
import org.junit.Assert;
import org.junit.Test;

/*
    第一步:创建一个叫 test 包
    第二步:在包下创建 一个 XxxTest类  Xxx->代表的是你要测试的类
    第三步:在XxxxxTest类中 定义测试方法
        方法名: testXxxx  Xxxx-->你要测试的方法名
        形参:空
        返回值: void
    第四步:在testXxxx方法上面添加注解 @Test,并导入 Junit4的依赖
    第五步:在测试方法内 调用你要测试的方法
    第六步:运行testXxx方法,在控制台上查看运行情况
        红灯:失败
        绿灯:成功

     若要测试的方法没有异常,但是和我预想的结果不一致怎么办??  --> 断言(确定)
        在你需要断言的位置:
            Assert类  static assertEquals(你断言的值,实际的结果);
 */
public class MyMathTest {
    @Test
    public void testSum(){
        MyMath mm = new MyMath();
        int sum = mm.sum(10, 20);
//        System.out.println("sum = " + sum);
        Assert.assertEquals(30,sum);
    }
}
