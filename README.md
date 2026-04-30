
# Java Quiz Application

A simple desktop-based Quiz Application built using **Core Java**, **Java Swing**, and **MySQL (JDBC)**. The application includes a login system connected to a database, a dynamic quiz loaded from the database, and a result screen at the end.

---

##  Project Structure

| File | Description |
|------|-------------|
| `Login.java` | Handles user authentication using MySQL database |
| `Quiz.java` | Fetches and displays questions from DB, tracks score |
| `Result.java` | Displays the final score to the user |
| `DBConnection.java` | Manages the database connection |

---

##  Technologies Used

- Java (Core + Swing)
- JDBC (Java Database Connectivity)
- MySQL

---

##  Database Tables

**users**
- `username` — stores the login username
- `password` — stores the login password

**questions**
- `question` — the question text
- `option1`, `option2`, `option3`, `option4` — four options
- `answer` — the correct answer

---

##  How It Works

1. User opens the app and sees a **Login screen**
2. Credentials are verified against the `users` table in MySQL
3. On successful login, the **Quiz screen** opens
4. Questions are fetched one by one from the `questions` table
5. User selects an option and clicks **Next**
6. After all questions, the **Result screen** shows the final score

---

##  How to Run

1. Clone this repository
2. Import the project in any Java IDE (Eclipse / NetBeans)
3. Set up MySQL and create the required tables
4. Update DB credentials in `DBConnection.java`
5. Run `Login.java` as the main file

---

##  Developed By

Tanisha Dyaga — Diploma in Computer Engineering
