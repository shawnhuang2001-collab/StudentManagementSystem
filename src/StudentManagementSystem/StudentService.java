package StudentManagementSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * 学生业务逻辑：只负责数据和文件，不做任何输入输出，控制台版和 Swing 版共用。
 * 每次增删改都会立即保存；保存失败会回滚内存里的修改并抛出 IOException。
 */
public class StudentService {

    private final String filename;
    private final ArrayList<StudentManagementSystem.Student> students = new ArrayList<>();
    private int skippedLines;

    public StudentService(String filename) {
        this.filename = filename;
    }

    // 从文件加载；格式不对的行会被跳过并计数
    public void load() throws IOException {
        students.clear();
        skippedLines = 0;
        for (String line : StudentManagementSystem.FileUtil.readLines(filename)) {
            StudentManagementSystem.Student s = parse(line);
            if (s == null) {
                skippedLines++;
            } else {
                students.add(s);
            }
        }
    }

    private StudentManagementSystem.Student parse(String line) {
        String[] parts = line.split(",", -1);
        if (parts.length != 4 || parts[0].trim().isEmpty()) {
            return null;
        }
        try {
            return new StudentManagementSystem.Student(parts[0].trim(), parts[1].trim(), Integer.parseInt(parts[2].trim()), parts[3].trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public void save() throws IOException {
        List<String> lines = new ArrayList<>();
        for (StudentManagementSystem.Student s : students) {
            lines.add(s.getId() + "," + s.getName() + "," + s.getAge() + "," + s.getAddress());
        }
        StudentManagementSystem.FileUtil.writeLines(filename, lines);
    }

    public int getSkippedLines() {
        return skippedLines;
    }

    public List<StudentManagementSystem.Student> getAll() {
        return Collections.unmodifiableList(students);
    }

    public StudentManagementSystem.Student find(String id) {
        for (StudentManagementSystem.Student s : students) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    public boolean isExist(String id) {
        return find(id) != null;
    }

    // 添加；id 已存在返回 false
    public boolean add(StudentManagementSystem.Student s) throws IOException {
        if (isExist(s.getId())) {
            return false;
        }
        students.add(s);
        try {
            save();
        } catch (IOException e) {
            students.remove(s);
            throw e;
        }
        return true;
    }

    // 按 id 修改；id 不存在返回 false
    public boolean update(String id, String name, int age, String address) throws IOException {
        StudentManagementSystem.Student s = find(id);
        if (s == null) {
            return false;
        }
        String oldName = s.getName();
        int oldAge = s.getAge();
        String oldAddress = s.getAddress();
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        try {
            save();
        } catch (IOException e) {
            s.setName(oldName);
            s.setAge(oldAge);
            s.setAddress(oldAddress);
            throw e;
        }
        return true;
    }

    // 按 id 删除；id 不存在返回 false
    public boolean delete(String id) throws IOException {
        StudentManagementSystem.Student s = find(id);
        if (s == null) {
            return false;
        }
        int index = students.indexOf(s);
        students.remove(index);
        try {
            save();
        } catch (IOException e) {
            students.add(index, s);
            throw e;
        }
        return true;
    }

    // 在 id / 姓名 / 年龄 / 地址 中模糊搜索；关键字为空返回全部
    public List<StudentManagementSystem.Student> search(String keyword) {
        String k = keyword == null ? "" : keyword.trim().toLowerCase(Locale.ROOT);
        if (k.isEmpty()) {
            return new ArrayList<>(students);
        }
        List<StudentManagementSystem.Student> result = new ArrayList<>();
        for (StudentManagementSystem.Student s : students) {
            if (s.getId().toLowerCase(Locale.ROOT).contains(k)
                    || s.getName().toLowerCase(Locale.ROOT).contains(k)
                    || String.valueOf(s.getAge()).contains(k)
                    || s.getAddress().toLowerCase(Locale.ROOT).contains(k)) {
                result.add(s);
            }
        }
        return result;
    }
}