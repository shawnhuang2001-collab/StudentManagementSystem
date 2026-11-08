package StudentManagementSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户业务逻辑：登录验证、注册、重置密码，以及 users.txt 的读写。
 */
public class UserService {

    private final String filename;
    private final ArrayList<StudentManagementSystem.User> users = new ArrayList<>();
    private int skippedLines;

    public UserService(String filename) {
        this.filename = filename;
    }

    public void load() throws IOException {
        users.clear();
        skippedLines = 0;
        for (String line : FileUtil.readLines(filename)) {
            String[] arr = line.split(",", -1);
            if (arr.length == 3 && !arr[0].trim().isEmpty()) {
                users.add(new StudentManagementSystem.User(arr[0].trim(), arr[1], arr[2].trim()));
            } else {
                skippedLines++;
            }
        }
    }

    private void save() throws IOException {
        List<String> lines = new ArrayList<>();
        for (StudentManagementSystem.User u : users) {
            lines.add(u.getUsername() + "," + u.getPassword() + "," + u.getPhone());
        }
        FileUtil.writeLines(filename, lines);
    }

    public int getSkippedLines() {
        return skippedLines;
    }

    private StudentManagementSystem.User find(String username) {
        for (StudentManagementSystem.User u : users) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }

    public boolean usernameExists(String username) {
        return find(username) != null;
    }

    public boolean login(String username, String password) {
        StudentManagementSystem.User u = find(username);
        return u != null && u.getPassword().equals(password);
    }

    // 注册；用户名已存在返回 false
    public boolean register(String username, String password, String phone) throws IOException {
        if (usernameExists(username)) {
            return false;
        }
        StudentManagementSystem.User u = new StudentManagementSystem.User(username, password, phone);
        users.add(u);
        try {
            save();
        } catch (IOException e) {
            users.remove(u);
            throw e;
        }
        return true;
    }

    // 忘记密码：用户名和手机号匹配才重置；不匹配返回 false
    public boolean resetPassword(String username, String phone, String newPassword) throws IOException {
        StudentManagementSystem.User u = find(username);
        if (u == null || !u.getPhone().equals(phone)) {
            return false;
        }
        String old = u.getPassword();
        u.setPassword(newPassword);
        try {
            save();
        } catch (IOException e) {
            u.setPassword(old);
            throw e;
        }
        return true;
    }
}