package com.itheima;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
    private static ArrayList<Student> list = new ArrayList<Student>();

    static {
        try {
            duQu();
            System.out.println(1111);
            System.out.println(2222);
            System.out.println(3333);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        while(true){
            System.out.println("---欢迎来到学生管理系统---");
            System.out.println("1.查看所有学生信息");
            System.out.println("2.增加学生信息");
            System.out.println("3.删除学生信息");
            System.out.println("4.修改学生信息");
            System.out.println("5.退出");
            System.out.println("请输入你的选择:");
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            switch (i){
                case 1:
                    findAll();
                    //查看所有学生信息
                    break;
                case 2:
                    add();
                    //增加学生信息
                    break;
                case 3:
                    delete();
                    //删除学生信息
                    break;
                case 4:
                    //修改学生信息
                    break;
                case 5:
                    exitAndSave();
                    System.exit(0);
                    //退出
                    break;
                default:
                    System.out.println("你输入的选择有误,请重新输入");
            }
        }

    }

    //1.查看所有学生
    private static void findAll() {
        if(list.size() == 0){
            System.out.println("当前没有学生信息~");
        }else{
            System.out.println("学号"+"\t\t"+"姓名"+"\t\t"+"年龄"+"\t\t");
            for (Student student : list) {
                System.out.println(student.getId()+"\t\t"+student.getName()+"\t\t"+student.getAge()+"\t\t");
            }
        }
    }

    //2.添加学生信息
    private static void add() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请录入学号:");
        String id = sc.nextLine();
        //检测该学号是否存在
        for (Student student : list) {
            if(student.getId().equals(id)){
                System.out.println("该学号已存在!!!");
                return;
            }
        }
        System.out.println("请录入学生姓名:");
        String name = sc.nextLine();
        System.out.println("请录入学生年龄");
        String age = sc.nextLine();

        Student student = new Student(id, name, age);
        //将学生对象添加到集合中
        list.add(student);
    }

    //3.删除学生
    private static void delete() {
        if(list.size() == 0){
            System.out.println("当前没有学生信息~");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("请录入删除的学号:");
        String id = sc.nextLine();

        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            String stuId = list.get(i).getId();
            if(stuId.equals(id)){
                index = i;
            }
        }
        if(index != -1){
            list.remove(index);
            System.out.println("删除成功!");
        }else{
            System.out.println("该学号不存在");
        }
    }

    //5.退出时保存
    private static void exitAndSave() throws IOException {
        FileOutputStream fos = new FileOutputStream("StudentManager\\student.txt");
        for (Student student : list) {
            String s = student.getId()+"-"+student.getName()+"-"+student.getAge();
            fos.write(s.getBytes());
            fos.write("\r\n".getBytes());
        }
        fos.close();
    }

    //6.从文件中读取信息
    public static void duQu() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("StudentManager\\student.txt"));
        String line;
        while((line = br.readLine()) != null){
            String[] split = line.split("-");
            Student student = new Student(split[0], split[1], split[2]);
            list.add(student);
        }
        br.close();
    }

}
