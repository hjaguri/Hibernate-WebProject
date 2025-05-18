# 🎓 Student Management System (Servlet + Hibernate)

A full-stack Java web application for managing student records using **Servlets** and **Hibernate ORM**.

---

## 🧠 Project Explanation

This project is a **Student Management System** where users can **perform all CRUD operations** (Create, Read, Update, Delete) on student data stored in a **MySQL database**.

The application is divided into three main layers:

1. **Presentation Layer (HTML + Servlet Controller)**  
   User interacts through web pages. Data from the form is sent to Servlets.

2. **Business Logic Layer (Service Classes)**  
   Servlets pass data to Service classes which apply logic (if needed) and call DAO layer.

3. **Data Access Layer (DAO + Hibernate)**  
   Uses Hibernate to interact with the MySQL database. All insert, update, delete, and fetch operations are handled here.

---

## ✨ Key Features

- Add New Student  
- View All Students  
- Update Existing Student  
- Delete Student from Records  
- Proper Success and Error Handling  
- Clean and Modular Code (MVC structure)

---

## 🔧 Technologies Used

- Java Servlets (for controller logic)
- Hibernate ORM (for DB interaction)
- MySQL Database
- HTML & CSS (Frontend pages)
- Apache Tomcat (Server)
- Eclipse IDE

---


## 📸 Screenshots


>
> ### 🧾 Login Page (index.html)
![Screenshot (65)](https://github.com/user-attachments/assets/221462b3-b11d-4301-b198-6487450743f2)


### 🧾 Home Page (Menu.html)
![Screenshot (66)](https://github.com/user-attachments/assets/4318fce2-b9af-4a20-aa47-bbb76f2962a5)


### ➕ Add Student
![Screenshot (67)](https://github.com/user-attachments/assets/c01eee1a-944d-4d89-9ec3-5e45a746bfe2)
![Screenshot (73)](https://github.com/user-attachments/assets/0d0423dc-1820-42f9-81fb-f6012d4a50fa)



### 📋 Read Student
![Screenshot (70)](https://github.com/user-attachments/assets/98a56f40-19d7-43af-ad68-c21cbb030ed2)
![Screenshot (71)](https://github.com/user-attachments/assets/3abb1821-f59c-4140-9656-ef94b1605a74)



### ❌ Delete Student
![Screenshot (69)](https://github.com/user-attachments/assets/ef1e1ea4-f371-4144-9703-1bce1fd54fc8)
![Screenshot (73)](https://github.com/user-attachments/assets/6616c679-32d4-46a4-a9f0-f5e3e39211b2)



### 🔄 Update Student
![Screenshot (68)](https://github.com/user-attachments/assets/f9a64a08-eca2-424b-9189-7288993b3fe6)
![Screenshot (72)](https://github.com/user-attachments/assets/bde7de70-6af3-460d-a179-300896311bf9)
![Screenshot (73)](https://github.com/user-attachments/assets/707b49be-0a7d-46e1-a9e0-ff3cef06c1cb)




---

## ⚙️ How to Run

1. Clone the repository
2. Import it into Eclipse as a Dynamic Web Project
3. Configure `hibernate.cfg.xml` with your MySQL credentials
4. Make sure Tomcat is configured
5. Run on server (Right-click on project → Run As → Run on Server)

---

## 💬 Author

**Hansraj Jaguri**  
📧 Email: Hjaguri27@gmail.com 
🌐 LinkedIn/GitHub: www.linkedin.com/in/hansraj-jaguri-00a003217


---

## 📝 License

This project is for educational purposes only.

