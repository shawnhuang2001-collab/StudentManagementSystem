package com.itheima.demo1.StudentManagementSystem;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    static UserService userService = new UserService();
    static String userFile = "users.txt";
    static ArrayList<User> users = userService.loadUsersFromFile(userFile);

    public static void main(String[] args) {
        showLoginPanel();
    }

    public static void showLoginPanel() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===============================================");
            System.out.println("              🎓 学 生 管 理 系 统");
            System.out.println("===============================================\n");

            System.out.println("  1. 登录");
            System.out.println("  2. 注册");
            System.out.println("  3. 忘记密码");
            System.out.println("  4. 退出系统\n");

            System.out.println("===============================================");
            System.out.print("👉 请输入你的选择：");

            String choice = sc.next();
            System.out.println(); // 换行更美观

            switch (choice) {
                case "1" -> login();
                case "2" -> register();
                case "3" -> forgetPassword();
                case "4" -> {
                    System.out.println("👋 谢谢使用，再见！");
                    System.exit(0);
                }
                default -> {
                    System.out.println("❌ 输入有误，请重新输入！");
                }
            }
        }
    }


    public static void login() {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入用户名：");
        String username = sc.next();
        System.out.println("请输入密码：");
        String password = sc.next();

        if (userService.login(users, username, password)) {
            System.out.println("登录成功！");
            StudentManagementApp.start();
        } else {
            System.out.println("用户名或密码错误！");
        }
    }

    public static void register() {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入用户名：");
        String username = sc.next();

        if (userService.usernameExists(users, username)) {
            System.out.println("用户名已存在，请重新注册！");
            return;
        }

        System.out.println("请输入密码：");
        String password = sc.next();

        System.out.println("请输入手机号：");
        String phone = sc.next();

        // 保存用户
        users.add(new User(username, password, phone));
        userService.saveUsersToFile(users, userFile);

        System.out.println("注册成功！");
    }

    public static void forgetPassword() {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入用户名：");
        String username = sc.next();

        System.out.println("请输入注册时的手机号：");
        String phone = sc.next();

        if (userService.checkPhone(users, username, phone)) {
            System.out.println("身份验证成功，请输入新密码：");
            String newPassword = sc.next();

            for (User u : users) {
                if (u.getUsername().equals(username)) {
                    u.setPassword(newPassword);
                    break;
                }
            }

            userService.saveUsersToFile(users, userFile);
            System.out.println("密码重置成功！");
        } else {
            System.out.println("验证失败，手机号或用户名不正确！");
        }
    }
}
