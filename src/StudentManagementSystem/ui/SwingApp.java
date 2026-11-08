package StudentManagementSystem.ui;

import StudentManagementSystem.ui.LoginFrame;
import StudentManagementSystem.Language;
import StudentManagementSystem.LanguageManager;
import StudentManagementSystem.StudentService;
import StudentManagementSystem.UserService;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.io.IOException;

/** Swing 版程序入口（控制台版入口仍然是 App.main）。 */
public class SwingApp {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
            // 用默认外观即可
        }
        SwingUtilities.invokeLater(SwingApp::start);
    }

    private static void start() {
        Language language = Language.CHINESE;   // 默认语言，可以在登录窗口右上角切换
        StudentManagementSystem.ui.UiUtil.applyOptionPaneTexts(language);

        UserService userService = new UserService("users.txt");
        StudentService studentService = new StudentService("students.txt");
        try {
            userService.load();
            studentService.load();
        } catch (IOException e) {
            // 读不了就直接退出，免得之后保存时把原来的文件覆盖掉
            StudentManagementSystem.ui.UiUtil.errorText(null, language, LanguageManager.getText("file_load_fail", language) + ": " + e.getMessage());
            System.exit(1);
            return;
        }

        int skipped = userService.getSkippedLines() + studentService.getSkippedLines();
        if (skipped > 0) {
            StudentManagementSystem.ui.UiUtil.warn(null, language, LanguageManager.format("warn_skipped", language, skipped));
        }

        new LoginFrame(language, userService, studentService).setVisible(true);
    }
}