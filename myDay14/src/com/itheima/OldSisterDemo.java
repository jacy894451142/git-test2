package com.itheima;
/*

反射操作的步骤:
        1.获取类的字节码对象
        2.根据字节码对象获取 类中的成员(成员变量,成员方法,构造方法)
        3.有了成员变量对象(Field)  -->取值,赋值
          有了成员方法对象(Method) --> 启动方法
          有了构造方法对象(Constructor)  -->创建对象
     如何获取一个类的字节码对象:
         1.Class clazz = 类的对象.getClass();
         2.Class clazz = 类名.class;
         3.Class clazz = Class.forName("全类名");
 */
public class OldSisterDemo {
    public static void main(String[] args) throws Exception{
        // 1.Class clazz = 类的对象.getClass();
        OldSister os = new OldSister();
        Class clazz1 = os.getClass();
        //2.Class clazz = 类名.class;
        Class clazz2 = OldSister.class;
        //3.Class clazz = Class.forName("全类名");
        Class clazz3 = Class.forName("com.itheima.OldSister");
        //其实三种方式获取的字节码对象 就是同一个字节码对象!
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
        System.out.println(clazz2 == clazz3);
    }
}
