#🎓 Student Management System(Java console-based)

[🇩🇪 Deutsche Version hier ansehen](./README_DE.md)

学生管理系统（Java 控制台版） 
该项目使用 **Java 控制台** 实现学生信息的增删改查功能，并支持文件保存（持久化）。

---

![Java](https://img.shields.io/badge/Language-Java-orange?logo=openjdk)
![Version](https://img.shields.io/badge/Version-1.0-blue)
![Status](https://img.shields.io/badge/Status-Stable-green)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

## 📘 Project Overview/项目简介 
This project helps practice **OOP**, **Collections**, **File I/O**, and **Console Interaction** in Java.

本项目以控制台交互的方式管理学生信息，结构清晰、逻辑简单，适合作为 Java 初学者的入门实践。

**Key Concepts / 主要内容:**

- Object-Oriented Programming (面向对象编程)
- `ArrayList` (集合操作)
- File Read/Write(文件读写 )
-  `Scanner`(控制台输入输出)

---

## 🧩 System Features/ 系统功能 

### 🏠 Main Menu/主菜单 
-------------Welcome to Student Management System/欢迎来到学生管理系统 --------------

1：Add Student/添加学生 / 

2：Delete Student/删除学生 

3：Edit Student/修改学生 

4：View Students/查询学生 

5：Exit/退出系统  

Please enter your choice/请输入您的选择:

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

---

## 📂  Project Structure/ 项目结构 

StudentManagementSystem/

​		├── students.txt                # 学生信息存储文件 / Data File

​		├── README.md                   # 项目说明（中英版） / Main Documentation

​		├── README_DE.md                # 德语版说明 / German Version

​		└── src/

​				├── Student.java            # 学生类 / Student Class

​				├── StudentService.java     # 业务逻辑类 / Service Layer (CRUD & File I/O)

​				└── StudentManagementApp.java  # 主程序入口 / Main Entry (main method)

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

- Java SE
- Collections: ArrayList (集合)
- BufferedReader / BufferedWriter (文件操作)
- Scanner (控制台交互)
- Object-Oriented Programming (面向对象编程)

##🌱  Future Improvements/未来改进方向

- 优化文件读写逻辑，避免重复或覆盖
  Improve file handling logic
- 增加输入验证（年龄、地址等）
  Add input validation (age, address, etc.)
- 引入登录注册模块，实现多用户管理
  Add login/register functions for multiple users
- 未来扩展图形界面（JavaFX / Swing）
  Extend to GUI version (JavaFX / Swing)

------

## 👨‍💻Author/ 作者信息

- Author/作者 : **Shawn Huang**
-  Created/创建时间: October 2025
- Tech Stack/技术栈  : **Java SE, Collections, File I/O, CLI**

------

📜 **License**
	本项目采用 [MIT License]()
	欢迎 Fork、Star、修改与学习使用！

This project is for learning purposes only. Forks and improvements are welcome!






```
StudentManagementSystem
├─ README.md
├─ README_DE.md
├─ src
│  └─ com
│     └─ itheima
│        └─ demo1
│           └─ StudentManagementSystem
│              ├─ App.java
│              ├─ Student.java
│              ├─ StudentManagementApp.java
│              └─ StudentService.java
└─ students.txt

```