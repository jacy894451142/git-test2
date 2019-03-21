package com.itheima;

@SuppressWarnings("all")
public class OldSister {
    //成员变量
    public String name;
    protected String weight;
    String gender;
    private int age;

    //构造方法
    public OldSister(){}
    private OldSister(String weight, int age) {
        this.weight = weight;
        this.age = age;
    }
    public OldSister(String name, String weight, String gender, int age) {
        this.name = name;
        this.weight = weight;
        this.gender = gender;
        this.age = age;
    }

    //成员方法
    //无参无返回值
    public void show(){
        System.out.println("来了,老弟~");
    }
    //含参无返回值
    protected void eat(String food){
        System.out.println("吃了十斤"+food);
    }
    //无参有返回值
    String speak(){
        return "爱老虎油~";
    }
    //有参有返回值
    private int answer(String question){
        return 18;
    }

    @Override
    public String toString() {
        return "OldSister{" +
                "name='" + name + '\'' +
                ", weight='" + weight + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
