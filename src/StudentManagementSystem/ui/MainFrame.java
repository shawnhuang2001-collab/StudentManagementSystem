package StudentManagementSystem.ui;

import StudentManagementSystem.Language;
import StudentManagementSystem.LanguageManager;
import StudentManagementSystem.Student;
import StudentManagementSystem.StudentService;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

/** 登录后的主窗口：学生表格 + 搜索 + 添加/修改/删除。 */
public class MainFrame extends JFrame {

    private final String username;
    private final StudentService service;
    private final Consumer<Language> onLogout;
    private Language language;

    private final JLabel welcomeLabel = new JLabel();
    private final JLabel searchLabel = new JLabel();
    private final JTextField searchField = new JTextField(16);
    private final JLabel languageLabel = new JLabel();
    private final JComboBox<String> languageBox = new JComboBox<>(LanguageManager.displayNames());
    private final JButton logoutButton = new JButton();

    // 表格不可直接编辑；第 3 列按数字排序
    private final DefaultTableModel model = new DefaultTableModel(0, 4) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

        @Override
        public Class<?> getColumnClass(int column) {
            return column == 2 ? Integer.class : String.class;
        }
    };
    private final JTable table = new JTable(model);

    private final JButton addButton = new JButton();
    private final JButton editButton = new JButton();
    private final JButton deleteButton = new JButton();
    private final JLabel statusLabel = new JLabel();

    /**
     * @param onLogout 点“退出登录”时调用，参数是当前语言（用来重新打开登录窗口）
     */
    public MainFrame(String username, Language language, StudentService service, Consumer<Language> onLogout) {
        this.username = username;
        this.language = language;
        this.service = service;
        this.onLogout = onLogout;

        setDefaultCloseOperation(EXIT_ON_CLOSE);   // 数据每次修改都已保存，直接关窗口即可退出

        table.setAutoCreateRowSorter(true);        // 点表头可排序
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight(26);

        // 顶部：欢迎语 | 搜索 | 语言 + 退出登录
        JPanel top = new JPanel(new BorderLayout(10, 0));
        top.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
        top.add(welcomeLabel, BorderLayout.WEST);
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 6, 0));
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        top.add(searchPanel, BorderLayout.CENTER);
        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT, 6, 0));
        right.add(languageLabel);
        right.add(languageBox);
        right.add(logoutButton);
        top.add(right, BorderLayout.EAST);

        // 底部：学生数量 | 按钮
        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
        bottom.add(statusLabel, BorderLayout.WEST);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        buttons.add(addButton);
        buttons.add(editButton);
        buttons.add(deleteButton);
        bottom.add(buttons, BorderLayout.EAST);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        languageBox.setSelectedIndex(language.ordinal());   // 先选中，再加监听，避免触发事件

        languageBox.addActionListener(e -> {
            this.language = Language.values()[languageBox.getSelectedIndex()];
            UiUtil.applyOptionPaneTexts(this.language);
            applyLanguage();
        });
        logoutButton.addActionListener(e -> {
            onLogout.accept(this.language);   // 先打开登录窗口，再关闭自己
            dispose();
        });
        addButton.addActionListener(e -> onAdd());
        editButton.addActionListener(e -> onEdit());
        deleteButton.addActionListener(e -> onDelete());
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                refreshTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                refreshTable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                refreshTable();
            }
        });
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && table.getSelectedRow() >= 0) {
                    onEdit();   // 双击一行 = 修改
                }
            }
        });

        UiUtil.applyOptionPaneTexts(language);
        applyLanguage();
        setSize(900, 520);
        setLocationRelativeTo(null);
    }

    // 把界面上所有文字换成当前语言
    private void applyLanguage() {
        setTitle(LanguageManager.getText("app_title", language));
        welcomeLabel.setText(LanguageManager.format("welcome_user", language, username));
        searchLabel.setText(LanguageManager.getText("lbl_search", language));
        languageLabel.setText(LanguageManager.getText("language_label", language));
        logoutButton.setText(LanguageManager.getText("btn_logout", language));
        addButton.setText(LanguageManager.getText("btn_add", language));
        editButton.setText(LanguageManager.getText("btn_edit", language));
        deleteButton.setText(LanguageManager.getText("btn_delete", language));
        model.setColumnIdentifiers(new String[]{
                LanguageManager.getText("col_id", language),
                LanguageManager.getText("col_name", language),
                LanguageManager.getText("col_age", language),
                LanguageManager.getText("col_address", language)});
        table.getColumnModel().getColumn(2).setPreferredWidth(60);
        refreshTable();
    }

    // 按搜索框内容重新填充表格
    private void refreshTable() {
        List<Student> list = service.search(searchField.getText());
        model.setRowCount(0);
        for (Student s : list) {
            model.addRow(new Object[]{s.getId(), s.getName(), s.getAge(), s.getAddress()});
        }
        statusLabel.setText(list.isEmpty()
                ? LanguageManager.getText("no_students", language)
                : LanguageManager.format("status_count", language, list.size()));
    }

    // 当前选中行的学生 ID；没选中则提示并返回 null
    private String selectedId() {
        int row = table.getSelectedRow();
        if (row < 0) {
            UiUtil.info(this, language, "err_select_row");
            return null;
        }
        return (String) table.getValueAt(row, 0);   // 用视图行号取值，排序后也正确
    }

    private void onAdd() {
        StudentDialog dialog = new StudentDialog(this, language, service, null);
        dialog.setVisible(true);
        Student s = dialog.getResult();
        if (s == null) {
            return;
        }
        try {
            service.add(s);
        } catch (IOException e) {
            UiUtil.errorText(this, language, LanguageManager.getText("file_save_fail", language) + ": " + e.getMessage());
        }
        refreshTable();
    }

    private void onEdit() {
        String id = selectedId();
        if (id == null) {
            return;
        }
        Student existing = service.find(id);
        if (existing == null) {
            return;
        }
        StudentDialog dialog = new StudentDialog(this, language, service, existing);
        dialog.setVisible(true);
        Student s = dialog.getResult();
        if (s == null) {
            return;
        }
        try {
            service.update(id, s.getName(), s.getAge(), s.getAddress());
        } catch (IOException e) {
            UiUtil.errorText(this, language, LanguageManager.getText("file_save_fail", language) + ": " + e.getMessage());
        }
        refreshTable();
    }

    private void onDelete() {
        String id = selectedId();
        if (id == null) {
            return;
        }
        int choice = JOptionPane.showConfirmDialog(this,
                LanguageManager.format("confirm_delete", language, id),
                LanguageManager.getText("title_confirm", language),
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choice != JOptionPane.YES_OPTION) {
            return;
        }
        try {
            service.delete(id);
        } catch (IOException e) {
            UiUtil.errorText(this, language, LanguageManager.getText("file_save_fail", language) + ": " + e.getMessage());
        }
        refreshTable();
    }
}