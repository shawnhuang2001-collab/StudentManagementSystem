package com.itheima.demo1.StudentManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementApp {
    public static void main(String[] args) {
        String filename = "students.txt";
        StudentService service = new StudentService();

        // 从文件加载数据
        ArrayList<Student> students = service.loadStudentsFromFile(filename);

        Scanner sc = new Scanner(System.in);

        loop:
        while (true) {
            System.out.println("---------- 欢迎使用学生管理系统 ----------");
            System.out.println("1. 添加学生");
            System.out.println("2. 删除学生");
            System.out.println("3. 修改学生");
            System.out.println("4. 查询学生");
            System.out.println("5. 退出");
            System.out.print("请输入您的选择：");
            String choice = sc.next();

            switch (choice) {
                case "1" -> service.addStudent(students);
                case "2" -> service.deleteStudent(students);
                case "3" -> service.updateStudent(students);
                case "4" -> service.queryStudent(students);
                case "5" -> {
                    service.saveStudentsToFile(students, filename);
                    System.out.println("感谢您的使用，再见！");
                    break loop;
                }
                default -> System.out.println("输入有误，请重新输入！");
            }
        }
    }
}
