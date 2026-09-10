package com.itheima.demo1.StudentManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementApp {
    public static void start(Language language) {
        String filename = "students.txt";
        StudentService service = new StudentService();

        // 从文件加载数据
        ArrayList<Student> students = service.loadStudentsFromFile(filename,language);

        Scanner sc = new Scanner(System.in);

        loop:
        while (true) {

            System.out.println("\n====================================================");
            System.out.println(LanguageManager.getText("welcome",language));
            System.out.println("====================================================\n");

            System.out.println(LanguageManager.getText("add_student",language));
            System.out.println(LanguageManager.getText("delete_student",language));
            System.out.println(LanguageManager.getText("update_student",language));
            System.out.println(LanguageManager.getText("query_student",language));
            System.out.println(LanguageManager.getText("exit_system",language));

            System.out.println("====================================================");
            System.out.print(LanguageManager.getText("enter_choice",language));

            String choice = sc.next();
            System.out.println();

            switch (choice) {
                case "1" -> service.addStudent(students, language,filename);
                case "2" -> service.deleteStudent(students, language,filename);
                case "3" -> service.updateStudent(students, language,filename);
                case "4" -> service.queryStudent(students, language);
                case "5" -> {
                    service.saveStudentsToFile(students, filename, language);
                    System.out.println(LanguageManager.getText("bye", language));
                    break loop;
                }
                default -> System.out.println(LanguageManager.getText("invalid_choice", language));
            }
        }
    }
}
