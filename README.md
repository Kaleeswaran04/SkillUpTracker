SkillUp Tracker – Personalized Skill Assessment & Progress Tracker
📌 Overview

SkillUp Tracker is a console-based Java + MySQL application designed for students to set learning goals, take quizzes, and track their progress.
Unlike a basic quiz app, it provides personalized feedback by identifying weak areas and recommending topics to improve. The project is built using Java OOP principles and SQL database integration for real-time analytics.

🚀 Features

### Learner Module

    Attempt quizzes (MCQs).

    Get instant score feedback.

    Track progress history stored in the database.

### Admin Module

    Add and manage topics.

    Add and manage quiz questions.

    View learner performance analytics.

🛠️ Tech Stack

- Language: Java (OOP-based design)

- Database: MySQL

- Build: Console-based application

###

🗄️ Database Setup

1. Create Database & Tables

Run the following SQL commands in MySQL CLI or Workbench:

CREATE DATABASE skillup;
USE skillup;

-- Users Table
CREATE TABLE Users (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL,
role ENUM('admin','learner') NOT NULL
);

-- Topics Table
CREATE TABLE Topics (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL UNIQUE
);

-- Questions Table
CREATE TABLE Questions (
id INT AUTO_INCREMENT PRIMARY KEY,
topic_id INT NOT NULL,
question TEXT NOT NULL,
optionA VARCHAR(200),
optionB VARCHAR(200),
optionC VARCHAR(200),
optionD VARCHAR(200),
correct_option CHAR(1) CHECK (correct_option IN ('A','B','C','D')),
FOREIGN KEY (topic_id) REFERENCES Topics(id)
);

-- Quiz History Table
CREATE TABLE QuizHistory (
id INT AUTO_INCREMENT PRIMARY KEY,
learner_id INT NOT NULL,
topic_id INT NOT NULL,
score INT NOT NULL,
taken_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (learner_id) REFERENCES Users(id),
FOREIGN KEY (topic_id) REFERENCES Topics(id)
);

📂 Project Structure
SkillUpTracker/
└── skilluptracker/
├── Main.java
├── DBConnection.java
├── User.java
├── Admin.java
├── Learner.java
├── AdminAddTopic.java
├── AdminViewStats.java
├── LearnerTakeQuiz.java

⚙️ How to Run

1. Compile

> > From the project root folder, run:

- javac \*.java

2. Run

- java -cp ".;mysql-connector-java-8.0.33.jar" Main

🧪 Sample Flow
=== Welcome to SkillUp Tracker ===
Login as:

1. Admin
2. Learner
   Choice:

- Admin → Add topics, questions, view stats.

- Learner → Attempt quiz, see score, track progress.

📌 Future Enhancements

    - Web-based interface (React/Node.js).

    - Coding challenges with auto-evaluation.

    - AI-based adaptive learning recommendations.
