package StudentManagementSystem;

import java.io.IOException;
import java.util.Scanner;

//控制台版的学生管理菜单：只负责输入输出，数据操作都交给 StudentService
public class StudentManagementApp {

    private static final String LINE = "====================================================";

    public static void start(Scanner sc, StudentManagementSystem.Language language, StudentService service) {
        while (true) {
            System.out.println("\n" + LINE);
            System.out.println(LanguageManager.getText("welcome", language));
            System.out.println(LINE + "\n");
            System.out.println("  1. " + LanguageManager.getText("btn_add", language));
            System.out.println("  2. " + LanguageManager.getText("btn_delete", language));
            System.out.println("  3. " + LanguageManager.getText("btn_edit", language));
            System.out.println("  4. " + LanguageManager.getText("query_student", language));
            System.out.println("  5. " + LanguageManager.getText("btn_logout", language));
            System.out.println(LINE);
            System.out.print("  " + LanguageManager.getText("enter_choice", language));

            String choice = sc.nextLine().trim();
            System.out.println();

            try {
                switch (choice) {
                    case "1" -> addStudent(sc, language, service);
                    case "2" -> deleteStudent(sc, language, service);
                    case "3" -> updateStudent(sc, language, service);
                    case "4" -> queryStudent(language, service);
                    case "5" -> {
                        System.out.println(LanguageManager.getText("bye", language));
                        return;
                    }
                    default -> System.out.println(LanguageManager.getText("invalid_choice", language));
                }
            } catch (IOException e) {
                System.out.println(LanguageManager.getText("file_save_fail", language) + ": " + e.getMessage());
            }
        }
    }

    private static String ask(Scanner sc, StudentManagementSystem.Language language, String key) {
        System.out.println(LanguageManager.getText(key, language));
        return sc.nextLine().trim();
    }

    // 一直问到输入的内容非空、且不含逗号和换行为止
    private static String askSafe(Scanner sc, StudentManagementSystem.Language language, String key) {
        while (true) {
            String value = ask(sc, language, key);
            if (value.isEmpty()) {
                System.out.println(LanguageManager.getText("err_empty", language));
            } else if (!FileUtil.isSafeField(value)) {
                System.out.println(LanguageManager.getText("err_comma", language));
            } else {
                return value;
            }
        }
    }

    private static int askAge(Scanner sc, StudentManagementSystem.Language language, String key) {
        while (true) {
            try {
                int age = Integer.parseInt(ask(sc, language, key));
                if (age >= 0 && age <= 150) {
                    return age;
                }
            } catch (NumberFormatException ignored) {
                // 落到下面的提示
            }
            System.out.println(LanguageManager.getText("err_age", language));
        }
    }

    //添加学生
    private static void addStudent(Scanner sc, StudentManagementSystem.Language language, StudentService service) throws IOException {
        String id;
        while (true) {
            id = askSafe(sc, language, "student_id");
            if (service.isExist(id)) {
                System.out.println(LanguageManager.getText("id_exists", language));
            } else {
                break;
            }
        }
        String name = askSafe(sc, language, "student_name");
        int age = askAge(sc, language, "student_age");
        String address = askSafe(sc, language, "student_address");

        service.add(new StudentManagementSystem.Student(id, name, age, address));
        System.out.println(LanguageManager.getText("add_success", language));
    }

    //删除学生
    private static void deleteStudent(Scanner sc, StudentManagementSystem.Language language, StudentService service) throws IOException {
        String id = ask(sc, language, "delete_student_id");
        if (service.delete(id)) {
            System.out.println(LanguageManager.getText("student", language) + id
                    + LanguageManager.getText("delete_success", language));
        } else {
            System.out.println(LanguageManager.getText("delete_fail", language));
        }
    }

    //修改学生
    private static void updateStudent(Scanner sc, StudentManagementSystem.Language language, StudentService service) throws IOException {
        String id = ask(sc, language, "update_student_id");
        if (!service.isExist(id)) {
            System.out.println(LanguageManager.getText("update_fail", language) + id
                    + LanguageManager.getText("not_exist", language));
            return;
        }
        String name = askSafe(sc, language, "new_student_name");
        int age = askAge(sc, language, "new_student_age");
        String address = askSafe(sc, language, "new_student_address");

        service.update(id, name, age, address);
        System.out.println(LanguageManager.getText("student", language) + id
                + LanguageManager.getText("update_success", language));
    }

    //查询学生
    private static void queryStudent(StudentManagementSystem.Language language, StudentService service) {
        if (service.getAll().isEmpty()) {
            System.out.println(LanguageManager.getText("no_students", language));
            return;
        }
        System.out.println(LanguageManager.getText("col_id", language) + "\t\t"
                + LanguageManager.getText("col_name", language) + "\t\t"
                + LanguageManager.getText("col_age", language) + "\t\t"
                + LanguageManager.getText("col_address", language));
        for (StudentManagementSystem.Student s : service.getAll()) {
            System.out.println(s.getId() + "\t\t" + s.getName() + "\t\t" + s.getAge() + "\t\t" + s.getAddress());
        }
    }
}