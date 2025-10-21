# 🎓 学生管理系统（Java 控制台版）

[🇩🇪 Deutsche Version hier ansehen](./README_DE.md)

A simple **Java console-based Student Management System**.  
该项目使用 **Java 控制台** 实现学生信息的增删改查功能，并支持文件保存（持久化）。

---

![Java](https://img.shields.io/badge/Language-Java-orange?logo=openjdk)
![Version](https://img.shields.io/badge/Version-1.0-blue)
![Status](https://img.shields.io/badge/Status-Stable-green)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

## 📘 一、项目简介/ Project Overview
本项目以控制台交互的方式管理学生信息，结构清晰、逻辑简单，适合作为 Java 初学者的入门实践。

This project helps practice **OOP**, **Collections**, **File I/O**, and **Console Interaction** in Java.

**主要内容 / Key Concepts:**

- 面向对象编程 (Object-Oriented Programming)
- 集合操作 (`ArrayList`)
- 文件读写 (File Read/Write)
- 控制台输入输出 (`Scanner`)

---

## 🧩 2. 系统功能 / System Features

### 🏠 主菜单 / Main Menu
-------------欢迎来到学生管理系统 / Welcome to Student Management System-------------

1：添加学生 / Add Student

2：删除学生 / Delete Student

3：修改学生 / Edit Student

4：查询学生 / View Students

5：退出系统 / Exit

请输入您的选择 / Please enter your choice:

### 学生信息 / Student Information
| 属性 / Field | 说明 / Description                   |
| ------------ | ------------------------------------ |
| id           | 学号（唯一标识） / Unique Student ID |
| name         | 姓名 / Name                          |
| age          | 年龄 / Age                           |
| address      | 家庭住址 / Address                   |

### 功能描述 / Function Description
- **添加学生 / Add**：输入学生信息并保存（id 唯一）  
- **删除学生 / Delete**：根据 id 删除学生  
- **修改学生 / Edit**：修改姓名、年龄、地址  
- **查询学生 / View**：查看所有学生信息  
- **退出系统 / Exit**：保存学生数据到 `students.txt` 文件  

---

## 📂 3. 项目结构 / Project Structure

StudentManagementSystem/

├── students.txt                # 学生信息存储文件 / Data File

├── README.md                   # 项目说明（中英版） / Main Documentation

├── README_DE.md                # 德语版说明 / German Version

└── src/

├── Student.java            # 学生类 / Student Class

├── StudentService.java     # 业务逻辑类 / Service Layer (CRUD & File I/O)

└── StudentManagementApp.java  # 主程序入口 / Main Entry (main method)

1. 克隆项目到本地：

   ~~~bash
   git clone https://github.com/yourname/StudentManagementSystem.git
   ~~~

2. 使用 IntelliJ IDEA 或 Eclipse 打开项目。Open with IntelliJ IDEA or any Java IDE.

3. 确保 students.txt 文件位于项目根目录（StudentManagementSystem/）。Make sure `students.txt` is in the root directory.

4. 运行 StudentManagementApp.java 中的 main() 方法。Run the `main()` method in `StudentManagementApp.java`.

5. 在控制台根据提示输入操作。Follow the console instructions.

##💡 五、技术要点 / Key Techniques

- Java SE
- 集合 (Collections: ArrayList)
- 文件操作 (BufferedReader / BufferedWriter)
- 控制台交互 (Scanner)
- 面向对象编程 (Object-Oriented Programming)

##🌱 六、未来改进方向/ Future Improvements

- 优化文件读写逻辑，避免重复或覆盖
  Improve file handling logic
- 增加输入验证（年龄、地址等）
  Add input validation (age, address, etc.)
- 引入登录注册模块，实现多用户管理
  Add login/register functions for multiple users
- 未来扩展图形界面（JavaFX / Swing）
  Extend to GUI version (JavaFX / Swing)

------

## 👨‍💻 作者信息/ Author

- 作者 / Author: **Shawn Huang**
- 创建时间 / Created: October 2025
- 技术栈 / Tech Stack: Java SE, Collections, File I/O, CLI

------

📜 **License**
	本项目采用 [MIT License]()
	欢迎 Fork、Star、修改与学习使用！

This project is for learning purposes only. Forks and improvements are welcome!





