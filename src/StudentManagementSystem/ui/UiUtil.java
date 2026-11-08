package StudentManagementSystem.ui;

import StudentManagementSystem.Language;
import StudentManagementSystem.LanguageManager;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Component;

/** 各个窗口共用的小工具：弹出提示框、让 JOptionPane 的按钮文字跟随当前语言。 */
final class UiUtil {

    private UiUtil() {
    }

    static void info(Component parent, Language language, String key) {
        show(parent, LanguageManager.getText(key, language), LanguageManager.getText("title_info", language),
                JOptionPane.INFORMATION_MESSAGE);
    }

    static void error(Component parent, Language language, String key) {
        errorText(parent, language, LanguageManager.getText(key, language));
    }

    static void errorText(Component parent, Language language, String text) {
        show(parent, text, LanguageManager.getText("title_error", language), JOptionPane.ERROR_MESSAGE);
    }

    static void warn(Component parent, Language language, String text) {
        show(parent, text, LanguageManager.getText("title_warning", language), JOptionPane.WARNING_MESSAGE);
    }

    private static void show(Component parent, String text, String title, int type) {
        JOptionPane.showMessageDialog(parent, text, title, type);
    }

    // JOptionPane 的“是/否/确定/取消”默认跟随系统语言，这里改成跟随程序当前语言
    static void applyOptionPaneTexts(Language language) {
        UIManager.put("OptionPane.yesButtonText", LanguageManager.getText("btn_yes", language));
        UIManager.put("OptionPane.noButtonText", LanguageManager.getText("btn_no", language));
        UIManager.put("OptionPane.okButtonText", LanguageManager.getText("btn_ok", language));
        UIManager.put("OptionPane.cancelButtonText", LanguageManager.getText("btn_cancel", language));
    }
}