package StudentManagementSystem;

import java.io.IOException;
import java.util.Scanner;

//控制台版程序入口（Swing 版入口是 ui.SwingApp）
public class App {

    private static final String LINE = "===============================================";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem.UserService userService = new StudentManagementSystem.UserService("users.txt");
        StudentService studentService = new StudentService("students.txt");

        StudentManagementSystem.Language language = chooseLanguage(sc);
        try {
            userService.load();
            studentService.load();
        } catch (IOException e) {
            System.out.println(LanguageManager.getText("file_load_fail", language) + ": " + e.getMessage());
            return;
        }

        while (true) {
            showLoginMenu(language);
            String choice = sc.nextLine().trim();
            System.out.println();

            switch (choice) {
                case "1" -> login(sc, language, userService, studentService);
                case "2" -> register(sc, language, userService);
                case "3" -> forgetPassword(sc, language, userService);
                case "4" -> {
                    System.out.println(LanguageManager.getText("bye", language));
                    return;
                }
                default -> System.out.println(LanguageManager.getText("invalid_choice", language));
            }
        }
    }

    //让用户选择系统语言
    private static StudentManagementSystem.Language chooseLanguage(Scanner sc) {
        while (true) {
            System.out.println(LINE);
            System.out.println("Please select your language / Bitte wählen Sie Ihre Sprache");
            System.out.println("1. 中文");
            System.out.println("2. Deutsch");
            System.out.println("3. English");
            System.out.println(LINE);
            System.out.print("Please enter your selection: ");

            switch (sc.nextLine().trim()) {
                case "1": return StudentManagementSystem.Language.CHINESE;
                case "2": return StudentManagementSystem.Language.GERMAN;
                case "3": return StudentManagementSystem.Language.ENGLISH;
                default: System.out.println("Invalid input, please try again!");
            }
        }
    }

    //显示登录 / 注册主菜单
    private static void showLoginMenu(StudentManagementSystem.Language language) {
        System.out.println("\n" + LINE);
        System.out.println("               " + LanguageManager.getText("app_title", language));
        System.out.println(LINE + "\n");
        System.out.println("  1. " + LanguageManager.getText("login", language));
        System.out.println("  2. " + LanguageManager.getText("register", language));
        System.out.println("  3. " + LanguageManager.getText("forgot_password", language));
        System.out.println("  4. " + LanguageManager.getText("exit_system", language) + "\n");
        System.out.println(LINE);
        System.out.print(" " + LanguageManager.getText("enter_choice", language));
    }

    private static String ask(Scanner sc, StudentManagementSystem.Language language, String key) {
        System.out.println(LanguageManager.getText(key, language));
        return sc.nextLine().trim();
    }

    //处理用户登录
    private static void login(Scanner sc, StudentManagementSystem.Language language, StudentManagementSystem.UserService userService, StudentService studentService) {
        String username = ask(sc, language, "username");
        String password = ask(sc, language, "password");

        if (userService.login(username, password)) {
            System.out.println(LanguageManager.getText("login_success", language));
            StudentManagementSystem.StudentManagementApp.start(sc, language, studentService);
        } else {
            System.out.println(LanguageManager.getText("login_fail", language));
        }
    }

    //处理用户注册
    private static void register(Scanner sc, StudentManagementSystem.Language language, StudentManagementSystem.UserService userService) {
        String username = ask(sc, language, "username");
        String password = ask(sc, language, "password");
        String phone = ask(sc, language, "phone");

        if (username.isEmpty() || password.isEmpty() || phone.isEmpty()) {
            System.out.println(LanguageManager.getText("invalid_choice", language));
            return;
        }
        if (!FileUtil.isSafeField(username) || !FileUtil.isSafeField(password) || !FileUtil.isSafeField(phone)) {
            System.out.println(LanguageManager.getText("err_comma", language));
            return;
        }
        try {
            if (userService.register(username, password, phone)) {
                System.out.println(LanguageManager.getText("register_success", language));
            } else {
                System.out.println(LanguageManager.getText("username_exists", language));
            }
        } catch (IOException e) {
            System.out.println(LanguageManager.getText("file_save_fail", language) + ": " + e.getMessage());
        }
    }

    //忘记密码：用户名 + 注册时的手机号验证通过后重置
    private static void forgetPassword(Scanner sc, StudentManagementSystem.Language language, StudentManagementSystem.UserService userService) {
        String username = ask(sc, language, "username");
        String phone = ask(sc, language, "register_phone");
        String newPassword = ask(sc, language, "new_password");

        if (newPassword.isEmpty() || !FileUtil.isSafeField(newPassword)) {
            System.out.println(LanguageManager.getText("err_comma", language));
            return;
        }
        try {
            if (userService.resetPassword(username, phone, newPassword)) {
                System.out.println(LanguageManager.getText("reset_success", language));
            } else {
                System.out.println(LanguageManager.getText("reset_fail", language));
            }
        } catch (IOException e) {
            System.out.println(LanguageManager.getText("file_save_fail", language) + ": " + e.getMessage());
        }
    }
}