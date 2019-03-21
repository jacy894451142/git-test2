package com.superjunit;

import java.util.Scanner;

public class ScannerTest {
    @MyTest
    public void testNextInt(){
        Scanner sc = new Scanner(System.in);
        //提示
        System.out.println("请您输入一个数:");
        int num = sc.nextInt();
        if (num == 100){
            System.out.println("绿灯....");
        }else{
            System.err.println("红灯....");
        }
    }
}
