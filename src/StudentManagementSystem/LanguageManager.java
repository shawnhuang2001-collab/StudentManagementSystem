package StudentManagementSystem;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * 多语言文字管理（语言包）。
 * 每种语言一张 key -> 文字 的表；找不到 key 时返回 "!key!"，方便发现拼写错误。
 */
public class LanguageManager {

    private static final Map<StudentManagementSystem.Language, Map<String, String>> TEXTS = new EnumMap<>(StudentManagementSystem.Language.class);

    static {
        TEXTS.put(StudentManagementSystem.Language.CHINESE, build(
                // ---- 通用 / 窗口 ----
                "app_title", "学生管理系统",
                "language_label", "语言：",
                "login", "登录",
                "register", "注册",
                "forgot_password", "忘记密码",
                "exit_system", "退出系统",
                "btn_reset", "重置密码",
                "btn_ok", "确定",
                "btn_cancel", "取消",
                "btn_yes", "是",
                "btn_no", "否",
                "btn_add", "添加学生",
                "btn_edit", "修改学生",
                "btn_delete", "删除学生",
                "btn_logout", "退出登录",
                "query_student", "查询学生",
                "lbl_search", "搜索：",
                "lbl_username", "用户名：",
                "lbl_password", "密码：",
                "lbl_phone", "手机号：",
                "lbl_register_phone", "注册时的手机号：",
                "lbl_new_password", "新密码：",
                "lbl_student_id", "学生ID：",
                "lbl_name", "姓名：",
                "lbl_age", "年龄：",
                "lbl_address", "地址：",
                "col_id", "学生ID",
                "col_name", "姓名",
                "col_age", "年龄",
                "col_address", "地址",
                "welcome_user", "欢迎，%s",
                "status_count", "共 %d 名学生",
                "title_info", "提示",
                "title_error", "错误",
                "title_confirm", "确认",
                "title_warning", "警告",
                "err_empty", "请填写所有必填项！",
                "err_age", "年龄必须是 0 到 150 之间的整数！",
                "err_comma", "输入内容不能包含英文逗号或换行！",
                "err_select_row", "请先在表格中选择一名学生！",
                "confirm_delete", "确定要删除学生 %s 吗？",
                "warn_skipped", "有 %d 行数据格式不正确，已被忽略；下次保存时它们将从文件中移除。",
                // ---- 提示语 / 控制台 ----
                "username", "请输入用户名：",
                "password", "请输入密码：",
                "phone", "请输入手机号：",
                "login_success", "登录成功！",
                "login_fail", "用户名或密码错误！",
                "username_exists", "用户名已存在，请重新输入！",
                "register_success", "注册成功！",
                "register_phone", "请输入注册时的手机号：",
                "new_password", "请输入新密码：",
                "reset_success", "密码重置成功！",
                "reset_fail", "密码重置失败，请检查用户名和手机号是否正确！",
                "bye", "感谢您的使用,再见👋！",
                "welcome", "欢迎使用学生管理系统!",
                "enter_choice", "请输入你的选择：",
                "invalid_choice", "❌ 输入有误，请重新输入！",
                "student_id", "请输入学生ID：",
                "id_exists", "学生ID已存在，请重新输入！",
                "student_name", "请输入学生姓名：",
                "student_age", "请输入学生年龄：",
                "student_address", "请输入学生地址：",
                "add_success", "学生添加成功！",
                "delete_student_id", "请输入要删除的学生ID：",
                "student", "学生",
                "delete_success", "删除成功！",
                "delete_fail", "删除失败，学生ID不存在！",
                "update_student_id", "请输入要修改的学生ID：",
                "new_student_name", "请输入新的学生姓名：",
                "new_student_age", "请输入新的学生年龄：",
                "new_student_address", "请输入新的学生地址：",
                "update_success", "学生信息更新成功！",
                "update_fail", "修改失败！学生ID:",
                "not_exist", "不存在！",
                "no_students", "未查询到学生信息！",
                "file_save_fail", "保存文件失败",
                "file_load_fail", "文件读取失败"
        ));

        TEXTS.put(StudentManagementSystem.Language.GERMAN, build(
                "app_title", "Studentenverwaltungssystem",
                "language_label", "Sprache:",
                "login", "Anmelden",
                "register", "Registrieren",
                "forgot_password", "Passwort vergessen",
                "exit_system", "System verlassen",
                "btn_reset", "Passwort zurücksetzen",
                "btn_ok", "OK",
                "btn_cancel", "Abbrechen",
                "btn_yes", "Ja",
                "btn_no", "Nein",
                "btn_add", "Student hinzufügen",
                "btn_edit", "Student bearbeiten",
                "btn_delete", "Student löschen",
                "btn_logout", "Abmelden",
                "query_student", "Student abfragen",
                "lbl_search", "Suche:",
                "lbl_username", "Benutzername:",
                "lbl_password", "Passwort:",
                "lbl_phone", "Telefonnummer:",
                "lbl_register_phone", "Bei der Registrierung verwendete Telefonnummer:",
                "lbl_new_password", "Neues Passwort:",
                "lbl_student_id", "Studenten-ID:",
                "lbl_name", "Name:",
                "lbl_age", "Alter:",
                "lbl_address", "Adresse:",
                "col_id", "Studenten-ID",
                "col_name", "Name",
                "col_age", "Alter",
                "col_address", "Adresse",
                "welcome_user", "Willkommen, %s",
                "status_count", "%d Studenten",
                "title_info", "Hinweis",
                "title_error", "Fehler",
                "title_confirm", "Bestätigen",
                "title_warning", "Warnung",
                "err_empty", "Bitte füllen Sie alle Felder aus!",
                "err_age", "Das Alter muss eine ganze Zahl zwischen 0 und 150 sein!",
                "err_comma", "Eingaben dürfen kein Komma und keinen Zeilenumbruch enthalten!",
                "err_select_row", "Bitte wählen Sie zuerst einen Studenten in der Tabelle aus!",
                "confirm_delete", "Student %s wirklich löschen?",
                "warn_skipped", "%d Zeilen haben ein ungültiges Format und wurden ignoriert; sie werden beim nächsten Speichern aus der Datei entfernt.",
                "username", "Bitte geben Sie Ihren Benutzernamen ein:",
                "password", "Bitte geben Sie Ihr Passwort ein:",
                "phone", "Bitte geben Sie Ihre Telefonnummer ein:",
                "login_success", "Anmeldung erfolgreich!",
                "login_fail", "Benutzername oder Passwort ist falsch!",
                "username_exists", "Benutzername existiert bereits, bitte geben Sie einen anderen ein!",
                "register_success", "Registrierung erfolgreich!",
                "register_phone", "Bitte geben Sie die bei der Registrierung verwendete Telefonnummer ein:",
                "new_password", "Bitte geben Sie Ihr neues Passwort ein:",
                "reset_success", "Passwort erfolgreich zurückgesetzt!",
                "reset_fail", "Passwort zurücksetzen fehlgeschlagen, bitte überprüfen Sie, ob Benutzername und Telefonnummer korrekt sind!",
                "bye", "Vielen Dank für Ihre Nutzung, auf Wiedersehen!",
                "welcome", "Willkommen beim Student Management System!",
                "enter_choice", "Bitte geben Sie Ihre Wahl ein:",
                "invalid_choice", "❌ Ungültige Eingabe, bitte erneut eingeben!",
                "student_id", "Bitte geben Sie die Studenten-ID ein:",
                "id_exists", "Studenten-ID existiert bereits, bitte geben Sie eine andere ein!",
                "student_name", "Bitte geben Sie den Namen des Studenten ein:",
                "student_age", "Bitte geben Sie das Alter des Studenten ein:",
                "student_address", "Bitte geben Sie die Adresse des Studenten ein:",
                "add_success", "Student erfolgreich hinzugefügt!",
                "delete_student_id", "Bitte geben Sie die zu löschende Studenten-ID ein:",
                "student", "Student",
                "delete_success", "Erfolgreich gelöscht!",
                "delete_fail", "Löschen fehlgeschlagen, Studenten-ID existiert nicht!",
                "update_student_id", "Bitte geben Sie die zu ändernde Studenten-ID ein:",
                "new_student_name", "Bitte geben Sie den neuen Namen des Studenten ein:",
                "new_student_age", "Bitte geben Sie das neue Alter des Studenten ein:",
                "new_student_address", "Bitte geben Sie die neue Adresse des Studenten ein:",
                "update_success", "Studenteninformationen erfolgreich geändert!",
                "update_fail", "Änderung fehlgeschlagen! Studenten-ID: ",
                "not_exist", " existiert nicht!",
                "no_students", "Keine Studenteninformationen gefunden!",
                "file_save_fail", "Fehler beim Speichern der Datei",
                "file_load_fail", "Fehler beim Laden der Datei"
        ));

        TEXTS.put(StudentManagementSystem.Language.ENGLISH, build(
                "app_title", "Student Management System",
                "language_label", "Language:",
                "login", "Login",
                "register", "Register",
                "forgot_password", "Forgot Password",
                "exit_system", "Exit System",
                "btn_reset", "Reset Password",
                "btn_ok", "OK",
                "btn_cancel", "Cancel",
                "btn_yes", "Yes",
                "btn_no", "No",
                "btn_add", "Add Student",
                "btn_edit", "Edit Student",
                "btn_delete", "Delete Student",
                "btn_logout", "Log out",
                "query_student", "Query Student",
                "lbl_search", "Search:",
                "lbl_username", "Username:",
                "lbl_password", "Password:",
                "lbl_phone", "Phone number:",
                "lbl_register_phone", "Phone number used at registration:",
                "lbl_new_password", "New password:",
                "lbl_student_id", "Student ID:",
                "lbl_name", "Name:",
                "lbl_age", "Age:",
                "lbl_address", "Address:",
                "col_id", "Student ID",
                "col_name", "Name",
                "col_age", "Age",
                "col_address", "Address",
                "welcome_user", "Welcome, %s",
                "status_count", "%d students",
                "title_info", "Info",
                "title_error", "Error",
                "title_confirm", "Confirm",
                "title_warning", "Warning",
                "err_empty", "Please fill in all fields!",
                "err_age", "Age must be a whole number between 0 and 150!",
                "err_comma", "Input must not contain commas or line breaks!",
                "err_select_row", "Please select a student in the table first!",
                "confirm_delete", "Delete student %s?",
                "warn_skipped", "%d line(s) had an invalid format and were ignored; they will be removed from the file on the next save.",
                "username", "Please enter your username:",
                "password", "Please enter your password:",
                "phone", "Please enter your phone number:",
                "login_success", "Login successful!",
                "login_fail", "Username or password is incorrect!",
                "username_exists", "Username already exists, please enter a different one!",
                "register_success", "Registration successful!",
                "register_phone", "Please enter the phone number used during registration:",
                "new_password", "Please enter your new password:",
                "reset_success", "Password reset successful!",
                "reset_fail", "Password reset failed, please check if the username and phone number are correct!",
                "bye", "Thank you for using, goodbye!",
                "welcome", "Welcome to the Student Management System!",
                "enter_choice", "Please enter your choice:",
                "invalid_choice", "❌ Invalid input, please try again!",
                "student_id", "Please enter the student ID:",
                "id_exists", "Student ID already exists, please enter a different one!",
                "student_name", "Please enter the student's name:",
                "student_age", "Please enter the student's age:",
                "student_address", "Please enter the student's address:",
                "add_success", "Student added successfully!",
                "delete_student_id", "Please enter the student ID to delete:",
                "student", "Student",
                "delete_success", "Successfully deleted!",
                "delete_fail", "Deletion failed, student ID does not exist!",
                "update_student_id", "Please enter the student ID to update:",
                "new_student_name", "Please enter the new student's name:",
                "new_student_age", "Please enter the new student's age:",
                "new_student_address", "Please enter the new student's address:",
                "update_success", "Student information updated successfully!",
                "update_fail", "Update failed! Student ID: ",
                "not_exist", " does not exist!",
                "no_students", "No student information found!",
                "file_save_fail", "Failed to save file",
                "file_load_fail", "File read failed"
        ));
    }

    // 把 key, value, key, value ... 变成一张表
    private static Map<String, String> build(String... keyValues) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i + 1 < keyValues.length; i += 2) {
            map.put(keyValues[i], keyValues[i + 1]);
        }
        return map;
    }

    // 根据语言和文字编号，返回对应的提示文字（语言包）
    public static String getText(String key, StudentManagementSystem.Language language) {
        Map<String, String> map = TEXTS.get(language);
        String text = map == null ? null : map.get(key);
        return text != null ? text : "!" + key + "!";
    }

    // 带占位符的文字，例如 format("welcome_user", lang, "Tom")
    public static String format(String key, StudentManagementSystem.Language language, Object... args) {
        return String.format(getText(key, language), args);
    }

    // 语言下拉框里显示的名字（每种语言用它自己的写法），顺序与 Language.values() 一致
    public static String[] displayNames() {
        return new String[]{"中文", "Deutsch", "English"};
    }
}