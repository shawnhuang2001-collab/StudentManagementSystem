package StudentManagementSystem.ui;

import StudentManagementSystem.FileUtil;
import StudentManagementSystem.Language;
import StudentManagementSystem.LanguageManager;
import StudentManagementSystem.StudentService;
import StudentManagementSystem.UserService;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;

/** 登录窗口：三个页签（登录 / 注册 / 忘记密码）+ 语言下拉框。 */
public class LoginFrame extends JFrame {

    private Language language;
    private final UserService userService;
    private final StudentService studentService;

    private final JLabel titleLabel = new JLabel("", JLabel.CENTER);
    private final JLabel languageLabel = new JLabel();
    private final JComboBox<String> languageBox = new JComboBox<>(LanguageManager.displayNames());
    private final JTabbedPane tabs = new JTabbedPane();

    // 登录页
    private final JLabel loginUserLabel = new JLabel();
    private final JLabel loginPassLabel = new JLabel();
    private final JTextField loginUser = new JTextField(18);
    private final JPasswordField loginPass = new JPasswordField(18);
    private final JButton loginButton = new JButton();

    // 注册页
    private final JLabel regUserLabel = new JLabel();
    private final JLabel regPassLabel = new JLabel();
    private final JLabel regPhoneLabel = new JLabel();
    private final JTextField regUser = new JTextField(18);
    private final JPasswordField regPass = new JPasswordField(18);
    private final JTextField regPhone = new JTextField(18);
    private final JButton regButton = new JButton();

    // 忘记密码页
    private final JLabel resetUserLabel = new JLabel();
    private final JLabel resetPhoneLabel = new JLabel();
    private final JLabel resetPassLabel = new JLabel();
    private final JTextField resetUser = new JTextField(18);
    private final JTextField resetPhone = new JTextField(18);
    private final JPasswordField resetPass = new JPasswordField(18);
    private final JButton resetButton = new JButton();

    private final JButton[] pageButtons = {loginButton, regButton, resetButton};

    public LoginFrame(Language language, UserService userService, StudentService studentService) {
        this.language = language;
        this.userService = userService;
        this.studentService = studentService;

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        tabs.addTab("", buildForm(new JLabel[]{loginUserLabel, loginPassLabel},
                new JComponent[]{loginUser, loginPass}, loginButton));
        tabs.addTab("", buildForm(new JLabel[]{regUserLabel, regPassLabel, regPhoneLabel},
                new JComponent[]{regUser, regPass, regPhone}, regButton));
        tabs.addTab("", buildForm(new JLabel[]{resetUserLabel, resetPhoneLabel, resetPassLabel},
                new JComponent[]{resetUser, resetPhone, resetPass}, resetButton));

        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 22f));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(8, 0, 12, 0));
        JPanel langPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 6, 6));
        langPanel.add(languageLabel);
        langPanel.add(languageBox);
        JPanel header = new JPanel(new BorderLayout());
        header.add(langPanel, BorderLayout.NORTH);
        header.add(titleLabel, BorderLayout.CENTER);

        add(header, BorderLayout.NORTH);
        add(tabs, BorderLayout.CENTER);

        languageBox.setSelectedIndex(language.ordinal());   // 先选中，再加监听

        languageBox.addActionListener(e -> {
            this.language = Language.values()[languageBox.getSelectedIndex()];
            UiUtil.applyOptionPaneTexts(this.language);
            applyLanguage();
        });
        tabs.addChangeListener(e -> getRootPane().setDefaultButton(pageButtons[tabs.getSelectedIndex()]));
        loginButton.addActionListener(e -> onLogin());
        regButton.addActionListener(e -> onRegister());
        resetButton.addActionListener(e -> onReset());

        UiUtil.applyOptionPaneTexts(language);
        applyLanguage();
        getRootPane().setDefaultButton(loginButton);   // 回车 = 当前页的按钮
        setSize(520, 400);
        setLocationRelativeTo(null);
    }

    // 一页表单：左边标签、右边输入框，最下面一个按钮
    private JPanel buildForm(JLabel[] labels, JComponent[] fields, JButton button) {
        JPanel p = new JPanel(new GridBagLayout());
        p.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);
        for (int i = 0; i < labels.length; i++) {
            c.gridy = i;
            c.gridx = 0;
            c.gridwidth = 1;
            c.weightx = 0;
            c.fill = GridBagConstraints.NONE;
            c.anchor = GridBagConstraints.EAST;
            p.add(labels[i], c);
            c.gridx = 1;
            c.weightx = 1;
            c.fill = GridBagConstraints.HORIZONTAL;
            c.anchor = GridBagConstraints.WEST;
            p.add(fields[i], c);
        }
        c.gridx = 0;
        c.gridy = labels.length;
        c.gridwidth = 2;
        c.weightx = 0;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(16, 6, 6, 6);
        p.add(button, c);
        return p;
    }

    private String t(String key) {
        return LanguageManager.getText(key, language);
    }

    // 把界面上所有文字换成当前语言
    private void applyLanguage() {
        setTitle(t("app_title"));
        titleLabel.setText(t("app_title"));
        languageLabel.setText(t("language_label"));

        tabs.setTitleAt(0, t("login"));
        tabs.setTitleAt(1, t("register"));
        tabs.setTitleAt(2, t("forgot_password"));

        loginUserLabel.setText(t("lbl_username"));
        loginPassLabel.setText(t("lbl_password"));
        loginButton.setText(t("login"));

        regUserLabel.setText(t("lbl_username"));
        regPassLabel.setText(t("lbl_password"));
        regPhoneLabel.setText(t("lbl_phone"));
        regButton.setText(t("register"));

        resetUserLabel.setText(t("lbl_username"));
        resetPhoneLabel.setText(t("lbl_register_phone"));
        resetPassLabel.setText(t("lbl_new_password"));
        resetButton.setText(t("btn_reset"));
    }

    private void onLogin() {
        String username = loginUser.getText().trim();
        String password = new String(loginPass.getPassword());
        if (username.isEmpty() || password.isEmpty()) {
            UiUtil.error(this, language, "err_empty");
            return;
        }
        if (!userService.login(username, password)) {
            UiUtil.error(this, language, "login_fail");
            return;
        }
        // 登录成功：打开主窗口，关闭登录窗口；“退出登录”时重新打开登录窗口
        MainFrame main = new MainFrame(username, language, studentService,
                lang -> new LoginFrame(lang, userService, studentService).setVisible(true));
        main.setVisible(true);
        dispose();
    }

    private void onRegister() {
        String username = regUser.getText().trim();
        String password = new String(regPass.getPassword());
        String phone = regPhone.getText().trim();
        if (username.isEmpty() || password.isEmpty() || phone.isEmpty()) {
            UiUtil.error(this, language, "err_empty");
            return;
        }
        if (!FileUtil.isSafeField(username) || !FileUtil.isSafeField(password) || !FileUtil.isSafeField(phone)) {
            UiUtil.error(this, language, "err_comma");
            return;
        }
        try {
            if (!userService.register(username, password, phone)) {
                UiUtil.error(this, language, "username_exists");
                return;
            }
        } catch (IOException e) {
            UiUtil.errorText(this, language, t("file_save_fail") + ": " + e.getMessage());
            return;
        }
        UiUtil.info(this, language, "register_success");
        // 注册成功：回到登录页，并把用户名填好
        loginUser.setText(username);
        loginPass.setText("");
        regUser.setText("");
        regPass.setText("");
        regPhone.setText("");
        tabs.setSelectedIndex(0);
        loginPass.requestFocusInWindow();
    }

    private void onReset() {
        String username = resetUser.getText().trim();
        String phone = resetPhone.getText().trim();
        String newPassword = new String(resetPass.getPassword());
        if (username.isEmpty() || phone.isEmpty() || newPassword.isEmpty()) {
            UiUtil.error(this, language, "err_empty");
            return;
        }
        if (!FileUtil.isSafeField(newPassword)) {
            UiUtil.error(this, language, "err_comma");
            return;
        }
        try {
            if (!userService.resetPassword(username, phone, newPassword)) {
                UiUtil.error(this, language, "reset_fail");
                return;
            }
        } catch (IOException e) {
            UiUtil.errorText(this, language, t("file_save_fail") + ": " + e.getMessage());
            return;
        }
        UiUtil.info(this, language, "reset_success");
        loginUser.setText(username);
        loginPass.setText("");
        resetUser.setText("");
        resetPhone.setText("");
        resetPass.setText("");
        tabs.setSelectedIndex(0);
        loginPass.requestFocusInWindow();
    }
}