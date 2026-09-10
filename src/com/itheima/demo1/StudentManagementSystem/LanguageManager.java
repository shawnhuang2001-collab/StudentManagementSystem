package com.itheima.demo1.StudentManagementSystem;
import javax.security.auth.login.LoginContext;
import java.util.Scanner;

public class LanguageManager {
    //让用户选择系统语言
    public static Language chooseLanguage() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("===============================================");
            System.out.println("Pleas select your language / Bitte wählen Ihre Sprache");
            System.out.println("1. 中文");
            System.out.println("2. Deutsch");
            System.out.println("3. English");
            System.out.println("===============================================");
            System.out.print("Pleas enter your selection：");

            String choice = sc.next();

            switch (choice) {
                case "1":
                    return Language.CHINESE;

                case "2":
                    return Language.GERMAN;

                case "3":
                    return Language.ENGLISH;

                default:
                    System.out.println("Invalid input;pleas try again！");
            }
        }
    }
    //根据用户的语言选择来显示登录,注册主菜单
    public static void showLoginMenu(Language language) {

        if (language == Language.CHINESE) {
            System.out.println("\n===============================================");
            System.out.println("               学 生 管 理 系 统");
            System.out.println("===============================================\n");

            System.out.println("  1. 登录");
            System.out.println("  2. 注册");
            System.out.println("  3. 忘记密码");
            System.out.println("  4. 退出系统\n");

            System.out.println("===============================================");
            System.out.print(" 请输入你的选择：");

        } else if (language == Language.GERMAN) {
            System.out.println("\n===============================================");
            System.out.println("               STUDENTENVERWALTUNGSSYSTEM");
            System.out.println("===============================================\n");

            System.out.println("  1. Anmelden");
            System.out.println("  2. Registrieren");
            System.out.println("  3. Passwort vergessen");
            System.out.println("  4. System verlassen\n");

            System.out.println("===============================================");
            System.out.print(" Bitte wählen Sie: ");

        } else if (language == Language.ENGLISH) {
            System.out.println("\n===============================================");
            System.out.println("               StudentManagementSystem");
            System.out.println("===============================================\n");

            System.out.println("  1. Login");
            System.out.println("  2. Register");
            System.out.println("  3. Forget Password");
            System.out.println("  4. Exit System \n");

            System.out.println("===============================================");
            System.out.print(" Please enter your choice：");
        }
    }
    // 根据语言和文字编号，返回对应的提示文字  (语言包)
    public static String getText(String key, Language language) {

        if (language == Language.CHINESE) {

            if (key.equals("username")) {
                return "请输入用户名：";
            }

            if (key.equals("password")) {
                return "请输入密码：";
            }

            if (key.equals("phone")) {
                return "请输入手机号：";
            }
            if (key.equals("login_success")) {
                return "登录成功！";
            }
            if (key.equals("loginFail")) {
                return "用户名或密码错误！";
            }
            if (key.equals("login_fail")) {
                return "用户名或密码错误！";
            }
            if (key.equals("username_exists")) {
                return "用户名已存在，请重新输入！";
            }
            if (key.equals("register_success")) {
                return "注册成功！";
            }
            if (key.equals("register_phone")) {
                return "请输入注册时的手机号：";
            }
            if (key.equals("new_password")) {
                return "请输入新密码：";
            }
            if ("reset_success".equals(key)) {
                return "密码重置成功！";
            }
            if ("reset_fail".equals(key)) {
                return "密码重置失败，请检查用户名和手机号是否正确！";
            }
            if (key.equals("bye")) {
                return "感谢您的使用,再见👋！";
            }
            if (key.equals("welcome")) {
                return "               欢迎使用学生管理系统!";
            }
            if (key.equals("add_student")) {
                return "  1. 添加学生";
            }
            if (key.equals("delete_student")) {
                return "  2. 删除学生";
            }
            if (key.equals("update_student")) {
                return "  3. 修改学生";
            }
            if (key.equals("query_student")) {

                return "  4. 查询学生";
            }
            if (key.equals("exit_system")) {
                return "  5. 退出系统";
            }
            if (key.equals("enter_choice")) {
                return "  请输入你的选择：";
            }
            if (key.equals("invalid_choice")) {
                return "❌ 输入有误，请重新输入！";
            }
            if (key.equals("student_id")) {
                return "请输入学生ID：";
            }
            if (key.equals("id_exists")) {
                return "学生ID已存在，请重新输入！";
            }
            if (key.equals("student_name")) {
                return "请输入学生姓名：";
            }
            if (key.equals("student_age")) {

                return "请输入学生年龄：";
            }
            if (key.equals("student_address")) {
                return "请输入学生地址：";
            }
            if (key.equals("add_success")) {
                return "学生添加成功！";
            }
            if (key.equals("delete_student_id")) {
                return "请输入要删除的学生ID：";
            }
            if (key.equals("student")) {
                return "学生";
            }
            if (key.equals("delete_success")) {
                return "删除成功！";
            }
            if (key.equals("delete_fail")) {
                return "删除失败，学生ID不存在！";
            }
            if (key.equals("new_student_id")) {
                return "请输入新的学生ID：";
            }
            if (key.equals("new_student_name")) {
                return "请输入新的学生姓名：";
            }
            if (key.equals("new_student_age")) {
                return "请输入新的学生年龄：";
            }
            if (key.equals("new_student_address")) {
                return "请输入新的学生地址：";
            }
            if (key.equals("update_success")) {
                return "学生信息更新成功！";
            }
            if (key.equals("update_fail")) {
                return "修改失败！学生ID:";
            }
            if (key.equals("not_exist")) {
                return "不存在！";
            }
            if (key.equals("no_students")) {
                return "未查询到学生信息！";
            }
            if (key.equals("tebale_header")) {
                return "学生ID\t\t姓名\t\t年龄\t\t地址";
            }
            if (key.equals("file_save_success")) {
                return "学生信息已保存到文件:";
            }
            if (key.equals("file_save_fail")) {
                return "保存学生信息到文件失败";
            }
            if (key.equals("file_load_success")) {
                return "学生信息已从文件加载:";
            }
            if (key.equals("file_load_fail")) {
                return "文件读取失败";
            }

        } else if (language == Language.GERMAN) {

            if (key.equals("username")) {
                return "Bitte geben Sie Ihren Benutzernamen ein:";
            }

            if (key.equals("password")) {
                return "Bitte geben Sie Ihr Passwort ein:";
            }

            if (key.equals("phone")) {
                return "Bitte geben Sie Ihre Telefonnummer ein:";
            }
            if (key.equals("login_success")) {
                return "Anmeldung erfolgreich!";
            }
            if (key.equals("login_fail")) {
                return "Benutzername oder Passwort ist falsch!";
            }
            if (key.equals("username_exists")) {
                return "Benutzername existiert bereits, bitte geben Sie einen anderen ein!";
            }
            if (key.equals("register_success")) {
                return "Registrierung erfolgreich!";
            }
            if (key.equals("register_phone")) {
                return "Bitte geben Sie die bei der Registrierung verwendete Telefonnummer ein:";
            }
            if (key.equals("new_password")) {
                return "Bitte geben Sie Ihr neues Passwort ein:";
            }
            if ("reset_success".equals(key)) {
                return "Passwort erfolgreich zurückgesetzt!";
            }
            if ("reset_fail".equals(key)) {
                return "Passwort zurücksetzen fehlgeschlagen, bitte überprüfen Sie, ob Benutzername und Telefonnummer korrekt sind!";
            }
            if (key.equals("bye")) {
                return "Vielen Dank für Ihre Nutzung, auf Wiedersehen!";
            }
            if (key.equals("welcome")) {
                return "         Willkommen beim Student Management System!";
            }
            if (key.equals("add_student")) {
                return "  1. Student hinzufügen";
            }
            if (key.equals("delete_student")) {
                return "  2. Student löschen";
            }
            if (key.equals("update_student")) {
                return "  3. Student aktualisieren";
            }
            if (key.equals("query_student")) {
                return "  4. Student abfragen";
            }
            if (key.equals("exit_system")) {
                return "  5. System verlassen";
            }
            if (key.equals("enter_choice")) {
                return "  Bitte geben Sie Ihre Wahl ein:";
            }
            if (key.equals("invalid_choice")) {
                return "❌ Ungültige Eingabe, bitte erneut eingeben!";
            }
            if (key.equals("student_id")) {
                return "Bitte geben Sie die Studenten-ID ein:";
            }
            if (key.equals("id_exists")) {
                return "Studenten-ID existiert bereits, bitte geben Sie eine andere ein!";
            }
            if (key.equals("student_name")) {
                return "Bitte geben Sie den Namen des Studenten ein:";
            }
            if (key.equals("student_age")) {
                return "Bitte geben Sie das Alter des Studenten ein:";
            }
            if (key.equals("student_address")) {
                return "Bitte geben Sie die Adresse des Studenten ein:";
            }
            if (key.equals("add_success")) {
                return "Student erfolgreich hinzugefügt!";
            }
            if (key.equals("delete_student_id")) {
                return "Bitte geben Sie die zu löschende Studenten-ID ein:";
            }
            if (key.equals("student")) {
                return "Student";
            }
            if (key.equals("delete_success")) {
                return "Erfolgreich gelöscht!";
            }
            if (key.equals("delete_fail")) {
                return "Löschen fehlgeschlagen, Studenten-ID existiert nicht!";
            }
            if (key.equals("new_student_id")) {
                return "Bitte geben Sie die neue Studenten-ID ein:";
            }
            if (key.equals("new_student_name")) {
                return "Bitte geben Sie den neuen Namen des Studenten ein:";
            }
            if (key.equals("new_student_age")) {
                return "Bitte geben Sie das neue Alter des Studenten ein:";
            }
            if (key.equals("new_student_address")) {
                return "Bitte geben Sie die neue Adresse des Studenten ein:";
            }
            if (key.equals("update_success")) {
                return "Studenteninformationen erfolgreich geändert !";
            }
            if (key.equals("update_fail")) {
                return "Änderung fehlgeschlagen! Studenten-ID: ";
            }
            if (key.equals("not_exist")) {
                return " existiert nicht!";
            }
            if (key.equals("no_students")) {
                return "Keine Studenteninformationen gefunden!";
            }
            if (key.equals("tebale_header")) {
                return "Studenten-ID\t\tName\t\tAlter\t\tAdresse";
            }
            if (key.equals("file_save_success")) {
                return "Studenteninformationen wurden in die Datei gespeichert:";
            }
            if (key.equals("file_save_fail")) {
                return "Fehler beim Speichern der Studenteninformationen in die Datei";
            }
            if (key.equals("file_load_success")) {
                return "Studenteninformationen wurden aus der Datei geladen:";
            }
            if (key.equals("file_load_fail")) {
                return "Fehler beim Laden der Datei";
            }



        } else if (language == Language.ENGLISH) {

            if (key.equals("username")) {
                return "Please enter your username:";
            }

            if (key.equals("password")) {
                return "Please enter your password:";
            }

            if (key.equals("phone")) {
                return "Please enter your phone number:";
            }
            if (key.equals("login_success")) {
                return "Login successful!";
            }
            if (key.equals("login_fail")) {
                return "Username or password is incorrect!";
            }
            if (key.equals("username_exists")) {
                return "Username already exists, please enter a different one!";
            }
            if (key.equals("register_success")) {
                return "Registration successful!";
            }
            if (key.equals("register_phone")) {
                return "Please enter the phone number used during registration:";
            }
            if (key.equals("new_password")) {
                return "Please enter your new password:";
            }
            if ("reset_success".equals(key)) {
                return "Password reset successful!";
            }
            if ("reset_fail".equals(key)) {
                return "Password reset failed, please check if the username and phone number are correct!";
            }
            if (key.equals("bye")) {
                return "Thank you for using, goodbye!";
            }
            if (key.equals("welcome")) {
                return "         Welcome to the Student Management System!";
            }
            if (key.equals("add_student")) {
                return "  1. Add Student";
            }
            if (key.equals("delete_student")) {
                return "  2. Delete Student";
            }
            if (key.equals("update_student")) {
                return "  3. Update Student";
            }
            if (key.equals("query_student")) {
                return "  4. Query Student";
            }
            if (key.equals("exit_system")) {
                return "  5. Exit System";
            }
            if (key.equals("enter_choice")) {
                return "  Please enter your choice:";
            }
            if (key.equals("invalid_choice")) {
                return "❌ Invalid input, please try again!";
            }
            if (key.equals("student_id")) {
                return "Please enter the student ID:";
            }
            if (key.equals("id_exists")) {
                return "Student ID already exists, please enter a different one!";
            }
            if (key.equals("student_name")) {
                return "Please enter the student's name:";
            }
            if (key.equals("student_age")) {
                return "Please enter the student's age:";
            }
            if (key.equals("student_address")) {
                return "Please enter the student's address:";
            }
            if (key.equals("add_success")) {
                return "Student added successfully!";
            }
            if (key.equals("delete_student_id")) {
                return "Please enter the student ID to delete:";
            }
            if (key.equals("student")) {
                return "Student";
            }
            if (key.equals("delete_success")) {
                return "Successfully deleted!";
            }
            if (key.equals("delete_fail")) {
                return "Deletion failed, student ID does not exist!";
            }
            if (key.equals("new_student_id")) {
                return "Please enter the new student ID:";
            }
            if (key.equals("new_student_name")) {
                return "Please enter the new student's name:";
            }
            if (key.equals("new_student_age")) {
                return "Please enter the new student's age:";
            }
            if (key.equals("new_student_address")) {
                return "Please enter the new student's address:";
            }
            if (key.equals("update_success")) {
                return "Student information updated successfully!";
            }
            if (key.equals("update_fail")) {
                return "Update failed! Student ID: ";
            }
            if (key.equals("not_exist")) {
                return " does not exist!";
            }
            if (key.equals("no_students")) {
                return "No student information found!";
            }
            if (key.equals("tebale_header")) {
                return "Student ID\t\tName\t\tAge\t\tAddress";
            }
            if (key.equals("file_save_success")) {
                return "Student information has been saved to the file:";
            }
            if (key.equals("file_save_fail")) {
                return "Failed to save student information to file";
            }
            if (key.equals("file_load_success")) {
                return "Student information has been loaded from the file:";
            }
            if (key.equals("file_load_fail")) {
                return "File read failed";
            }

        }

        return "";
    }

}