package com.itheima.demo1.StudentManagementSystem;

import java.io.*;
import java.util.ArrayList;

public class UserService {

    // 从文件加载用户数据
    public ArrayList<User> loadUsersFromFile(String filename) {
        ArrayList<User> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                if (arr.length == 3) {
                    list.add(new User(arr[0], arr[1], arr[2]));
                }
            }
        } catch (IOException e) {
            // 文件不存在时不报错（第一次运行）
        }

        return list;
    }

    // 保存用户数据到文件
    public void saveUsersToFile(ArrayList<User> list, String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (User u : list) {
                pw.println(u.getUsername() + "," + u.getPassword() + "," + u.getPhone());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 判断用户名是否存在
    public boolean usernameExists(ArrayList<User> list, String username) {
        for (User u : list) {
            if (u.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    // 登录方法
    public boolean login(ArrayList<User> list, String username, String password) {
        for (User u : list) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // 忘记密码 - 检查手机号
    public boolean checkPhone(ArrayList<User> list, String username, String phone) {
        for (User u : list) {
            if (u.getUsername().equals(username) && u.getPhone().equals(phone)) {
                return true;
            }
        }
        return false;
    }
}
