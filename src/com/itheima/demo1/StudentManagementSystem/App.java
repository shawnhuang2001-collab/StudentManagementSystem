package com.itheima.demo1.StudentManagementSystem;
import java.util.ArrayList;
import java.util.Scanner;

//程序启动入口
public class App {

    static UserService userService = new UserService();
    static String userFile = "users.txt";
    static ArrayList<User> users = userService.loadUsersFromFile(userFile);

    public static void main(String[] args) {
        Language language = LanguageManager.chooseLanguage();
        showLoginPanel(language);
    }

    //显示主菜单
    public static void showLoginPanel(Language language) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            LanguageManager.showLoginMenu(language);

            String choice = sc.next();
            System.out.println(); // 换行更美观

            switch (choice) {
                case "1" -> login(language);
                case "2" -> register(language);
                case "3" -> forgetPassword(language);
                case "4" -> {
                    System.out.println(LanguageManager.getText("bye", language));
                    System.exit(0);
                }
                default -> {
                    System.out.println(LanguageManager.getText("invalid_choice", language));
                }
            }
        }
    }

    //处理用户登录
    public static void login(Language language) {
        Scanner sc = new Scanner(System.in);

        System.out.println(LanguageManager.getText("username", language));
        String username = sc.next();

        System.out.println(LanguageManager.getText("password", language));
        String password = sc.next();

        if (userService.login(users, username, password)) {
            System.out.println(LanguageManager.getText("login_success", language));
            StudentManagementApp.start(language);
        } else {
            System.out.println(LanguageManager.getText("login_fail", language));
        }
    }
    //处理用户注册
    public static void register(Language language) {
        Scanner sc = new Scanner(System.in);

        System.out.println(LanguageManager.getText("username", language));
        String username = sc.next();

        if (userService.usernameExists(users, username)) {
            System.out.println(LanguageManager.getText("username_exists", language));
            return;
        }

        System.out.println(LanguageManager.getText("password", language));
        String password = sc.next();

        System.out.println(LanguageManager.getText("phone", language));
        String phone = sc.next();

        // 保存用户
        users.add(new User(username, password, phone));
        userService.saveUsersToFile(users, userFile);

        System.out.println(LanguageManager.getText("register_success", language));
    }

    public static void forgetPassword(Language language) {
        Scanner sc = new Scanner(System.in);

        System.out.println(LanguageManager.getText("username", language));
        String username = sc.next();

        System.out.println(LanguageManager.getText("register_phone", language));
        String phone = sc.next();

        if (userService.checkPhone(users, username, phone)) {
            System.out.println(LanguageManager.getText("new_password", language));
            String newPassword = sc.next();

            for (User u : users) {
                if (u.getUsername().equals(username)) {
                    u.setPassword(newPassword);
                    break;
                }
            }

            userService.saveUsersToFile(users, userFile);
            System.out.println(LanguageManager.getText("reset_success", language));
        } else {
            System.out.println(LanguageManager.getText("reset_fail", language));
        }
    }
}
