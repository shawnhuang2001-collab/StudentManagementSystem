package StudentManagementSystem.ui;

import StudentManagementSystem.FileUtil;
import StudentManagementSystem.Language;
import StudentManagementSystem.LanguageManager;
import StudentManagementSystem.Student;
import StudentManagementSystem.StudentService;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

/** 添加 / 修改学生的对话框。existing 为 null 表示添加，否则表示修改（此时 ID 不可编辑）。 */
public class StudentDialog extends JDialog {

    private final Language language;
    private final StudentService service;
    private final boolean editMode;

    private final JTextField idField = new JTextField(20);
    private final JTextField nameField = new JTextField(20);
    private final JTextField ageField = new JTextField(20);
    private final JTextField addressField = new JTextField(20);

    private Student result;   // 点“确定”且校验通过后才有值；取消则为 null

    public StudentDialog(Frame owner, Language language, StudentService service, Student existing) {
        super(owner, LanguageManager.getText(existing == null ? "btn_add" : "btn_edit", language), true);
        this.language = language;
        this.service = service;
        this.editMode = existing != null;

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel form = new JPanel(new GridBagLayout());
        form.setBorder(BorderFactory.createEmptyBorder(15, 20, 5, 20));
        addRow(form, 0, "lbl_student_id", idField);
        addRow(form, 1, "lbl_name", nameField);
        addRow(form, 2, "lbl_age", ageField);
        addRow(form, 3, "lbl_address", addressField);

        if (existing != null) {
            idField.setText(existing.getId());
            idField.setEditable(false);
            nameField.setText(existing.getName());
            ageField.setText(String.valueOf(existing.getAge()));
            addressField.setText(existing.getAddress());
        }

        JButton okButton = new JButton(LanguageManager.getText("btn_ok", language));
        JButton cancelButton = new JButton(LanguageManager.getText("btn_cancel", language));
        okButton.addActionListener(e -> onOk());
        cancelButton.addActionListener(e -> dispose());

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 8));
        buttons.setBorder(BorderFactory.createEmptyBorder(0, 12, 8, 12));
        buttons.add(okButton);
        buttons.add(cancelButton);

        add(form, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);

        getRootPane().setDefaultButton(okButton);                       // 回车 = 确定
        getRootPane().registerKeyboardAction(e -> dispose(),            // Esc = 取消
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);

        pack();
        setResizable(false);
        setLocationRelativeTo(owner);
    }

    private void addRow(JPanel form, int row, String labelKey, JTextField field) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.gridy = row;

        c.gridx = 0;
        c.anchor = GridBagConstraints.EAST;
        form.add(new JLabel(LanguageManager.getText(labelKey, language)), c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        form.add(field, c);
    }

    private void onOk() {
        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        String ageText = ageField.getText().trim();
        String address = addressField.getText().trim();

        if (id.isEmpty() || name.isEmpty() || ageText.isEmpty() || address.isEmpty()) {
            UiUtil.error(this, language, "err_empty");
            return;
        }
        if (!FileUtil.isSafeField(id) || !FileUtil.isSafeField(name) || !FileUtil.isSafeField(address)) {
            UiUtil.error(this, language, "err_comma");
            return;
        }
        int age;
        try {
            age = Integer.parseInt(ageText);
        } catch (NumberFormatException e) {
            UiUtil.error(this, language, "err_age");
            return;
        }
        if (age < 0 || age > 150) {
            UiUtil.error(this, language, "err_age");
            return;
        }
        if (!editMode && service.isExist(id)) {
            UiUtil.error(this, language, "id_exists");
            return;
        }
        result = new Student(id, name, age, address);
        dispose();
    }

    /** 对话框关闭后调用；用户取消则返回 null。 */
    public Student getResult() {
        return result;
    }
}