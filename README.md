

🎓 Student Management System(Java console-based)

[🇩🇪 Deutsche Version hier ansehen](./README_DE.md)

学生管理系统（Java 控制台版） 
该项目使用 **Java 控制台** 实现学生信息的增删改查功能，并支持文件保存（持久化）。

---

![Java](https://img.shields.io/badge/Language-Java-orange?logo=openjdk)
![Version](https://img.shields.io/badge/Version-1.0-blue)
![Status](https://img.shields.io/badge/Status-Stable-green)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

## 📘 Project Overview/项目简介 
This project practices **OOP**, **Collections**, **File I/O**, and **Console Interaction** in Java.
It now includes a **user registration and login system**, and the **console UI** has been redesigned for a better user experience.

本项目以控制台交互的方式管理学生信息，结构清晰、逻辑简单，适合作为 Java 初学者的入门实践。
现已新增 **用户注册与登录功能**，并 **美化了控制台界面**。

**Key Concepts / 主要内容:**

- Object-Oriented Programming (面向对象编程)
- `ArrayList` (集合操作)
- File Read/Write (文件读写)
- Scanner (控制台输入输出)
- `Simple Authentication` (简单登录注册逻辑)

---

## 🧩 System Features/ 系统功能 

### 🏠 Main Menu/主菜单 

```java
=========== Welcome to Student Management System ===========
1. Register / 注册新用户
2. Login / 登录系统
3. Add Student / 添加学生
4. Delete Student / 删除学生
5. Edit Student / 修改学生
6. View Students / 查看学生信息
7. Exit / 退出系统
============================================================
Please enter your choice: 
```

### 👤 User Management / 用户管理

- **Register** — Enter username, password, and phone number to create an account.
  **注册：** 输入用户名、密码和手机号完成注册。
- **Login** — Only registered users can access the system.
  **登录：** 仅注册用户可进入系统。
- **Forgot Password** — Verify phone number to reset password (future feature).
  **忘记密码：** 可通过手机号验证重置密码（后续功能）。

User data is stored in `users.txt`.
用户信息保存在 `users.txt` 文件中。

### Student Information学生信息 
| Field/属性 | Description/说明                   |
| ---------- | ---------------------------------- |
| id         | Unique Student ID/学号（唯一标识） |
| name       | Name/姓名                          |
| age        | Age/年龄                           |
| address    | Address/家庭住址                   |

### Function Description/功能描述 
- **Add/添加学生 **：输入学生信息并保存（id 唯一）  
- **Delete/删除学生 **：根据 id 删除学生  
- **Edit/修改学生 **：修改姓名、年龄、地址  
- **View/查询学生**:  查看所有学生信息  
- **Exit/退出系统 **：保存学生数据到 `students.txt` 文件  

## 🎨 3. Console Interface / 控制台界面

✅ Clear layout and friendly prompts
✅ 清晰的排版与友好的提示

✅ Visual enhancements and icons for better readability
✅ 增加了符号与分隔线提升可读性

Example / 示例：

```css

```

```css

```



---

## 📂  Project Structure/ 项目结构 

```bash

```



## ▶️ 运行方式 / How to Run

1. Clone repository  克隆项目到本地:

   ~~~bash
   git clone https://github.com/yourname/StudentManagementSystem.git
   cd StudentManagementSystem
   ~~~

2. Open with IntelliJ IDEA or any Java IDE.  使用 IntelliJ IDEA 或 Eclipse 打开项目。

3. Make sure `students.txt` is in the root directory.  确保 students.txt 文件位于项目根目录（StudentManagementSystem/）。

4. Run the `main()` method in `StudentManagementApp.java`.  运行 StudentManagementApp.java 中的 main() 方法。

5. Follow the console instructions.  在控制台根据提示输入操作。

##💡 Key Techniques/技术要点

- **Java SE**
- **Collections: ArrayList（集合）**
- **File Operations: BufferedReader / BufferedWriter（文件操作）**
- **Console Interaction: Scanner（控制台交互）**
- **Object-Oriented Programming（面向对象编程）**
- **User Authentication Logic（用户验证逻辑）**
- **Console UI Beautification（控制台界面美化）**

##🌱  Future Improvements/未来改进方向

- Add data validation (e.g., age range, address format)(增加输入验证（例如年龄范围、地址格式）)
- Encrypt passwords for better security(对密码进行加密，提升安全性)
- Add student search and sorting functions(增加学生搜索与排序功能)

- Author/作者 : **Shawn Huang**
-  Created/创建时间: October 2025
- Tech Stack/技术栈  : **Java SE, Collections, File I/O, CLI**

## 👨‍💻Author/ 作者信息

- Author/作者 : **Shawn Huang**
- Created/创建时间: November 2025
- Tech Stack/技术栈  : **Java SE, Collections, File I/O, CLI**

📜 **License**
	本项目采用 [MIT License]()
	欢迎 Fork、Star、修改与学习使用！

This project is for learning purposes only. Forks and improvements are welcome!







