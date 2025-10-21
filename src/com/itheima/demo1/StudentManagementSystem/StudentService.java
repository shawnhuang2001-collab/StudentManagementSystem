package com.itheima.demo1.StudentManagementSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentService {

    //添加学生
    public static void addStudent(ArrayList<Student> students) {
        //利用空参构造方法创建学生对象
        Student s = new Student();
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("请输入学生的id:");
            String id = sc.next();
            //判断id是否存在
            boolean exist = isExist(students, id);
            if (exist) {
                System.out.println("此id已经存在,请您重新录入");
            } else {
                s.setId(id);
                System.out.println("我被执行了");
                break;
            }
        }


        System.out.println("请输入学生姓名:");
        String name = sc.next();
        s.setName(name);

        System.out.println("请输入学生年龄:");
        int age = sc.nextInt();
        s.setAge(age);


        System.out.println("请输入学生家庭地址:");
        String address = sc.next();
        s.setAddress(address);

        //将学生对象添加到集合中
        students.add(s);
        System.out.println("学生信息添加成功！");

    }

    //删除学生
    public static void deleteStudent(ArrayList<Student> students) {
        //键盘录入学生id
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的学生id:");
        String id = sc.next();
        //判断id是否存在
        boolean exist = isExist(students, id);
        if (exist) {
            //删除
            int index = getIndex(students, id);
            students.remove(index);
            System.out.println("学生" + id + "信息删除成功！");
        } else {
            System.out.println("该学生id不存在，删除失败！");
        }
    }

    //修改学生
    public static void updateStudent(ArrayList<Student> students) {
        //键盘录入要修改的学生id
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改的学生id:");
        String id = sc.next();
        //判断id是否存在
        int index = getIndex(students, id);
        if (index >= 0) {
            //根据索引获取到要修改的学生对象
            Student stu = students.get(index);
            //键盘录入新的学生信息并修改
            System.out.println("请输入新的学生姓名:");
            String newName = sc.next();
            stu.setName(newName);

            System.out.println("请输入新的学生年龄:");
            int newAge = sc.nextInt();
            stu.setAge(newAge);

            System.out.println("请输入新的学生家庭住址:");
            String newAddress = sc.next();
            stu.setAddress(newAddress);

            System.out.println("学生" + id + "信息修改成功！");

        } else {
            System.out.println("该学生id不存在，修改失败！");
        }
    }

    //查询学生
    public static void queryStudent(ArrayList<Student> students) {
        if (students.size() == 0) {
            System.out.println("暂无学生信息，请添加后再查询！");
            return;
        }
        //打印表头
        System.out.println("学号\t\t姓名\t年龄\t地址");
        for (int i = 0; i < students.size(); i++) {
            Student stu = students.get(i);
            System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t" + stu.getAddress());
        }
    }

    //判断id是否存在
    public static boolean isExist(ArrayList<Student> students, String id) {
//        //遍历集合,并用获取到的id进行判断是否存在
//        for (int i = 0; i < students.size(); i++) {
//            //获取学生对象
//            Student stu = students.get(i);
//            //获取id
//            String sid = stu.getId();
//            //判断
//            if (sid.equals(id)) {
//                return true;
//            }
//        }
//        return false;
        return getIndex(students, id) >= 0;
    }

    //通过id获取集合索引
    public static int getIndex(ArrayList<Student> students, String id) {
        //遍历集合
        for (int i = 0; i < students.size(); i++) {
            //得到学生对象
            Student stu = students.get(i);
            //获取id
            String sid = stu.getId();
            //判断
            if (sid.equals(id)) {
                //如果相同返回索引
                return i;
            }
        }
        //如果不存在返回-1
        return -1;
    }

    //文件保存方法
    public static void saveStudentsToFile(ArrayList<Student> students, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Student s : students) {
                String line = s.getId() + "," + s.getName() + "," + s.getAge() + "," + s.getAddress();
                bw.write(line);
                bw.newLine();
            }
            System.out.println("学生信息已保存到文件：" + filename);
        } catch (IOException e) {
            System.out.println("保存文件失败：" + e.getMessage());
        }
    }

    //文件读取方法
    public static ArrayList<Student> loadStudentsFromFile(String filename) {
        ArrayList<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String id = parts[0];
                    String name = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    String address = parts[3];
                    students.add(new Student(id, name, age, address));
                }
            }
            System.out.println("学生信息已从文件加载：" + filename);
        } catch (IOException e) {
            System.out.println("读取文件失败：" + e.getMessage());
        }
        return students;
    }


}

