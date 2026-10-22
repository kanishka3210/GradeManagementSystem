# Grade Management System: User Manual

## 1. Overview

The Grade Management System is a Java console application that helps manage student marks, calculate averages and grades, search student records, identify top performers, and generate academic performance reports.

## 2. Requirements

- Java Development Kit (JDK)
- Command Prompt or VS Code terminal

## 3. How to Run the Application

Open a terminal in the project root directory.

**Compile the program:**

```bash
javac -d out src/GradeManagementSystem.java
```

**Run the program:**

```bash
java -cp out GradeManagementSystem
```

## 4. Menu Options

1. **Add Student Marks:** Enter a student's name and marks for five subjects.
2. **View All Students:** Display recorded student marks, averages, and grades.
3. **Calculate Averages and Grades:** View individual averages, highest marks, lowest marks, and grades.
4. **Find Top Performers:** Identify students based on their average scores.
5. **Generate Performance Report:** View class average, subject-wise averages, grade distribution, and top performer.
6. **Search Student:** Find a student by name. The search is case-insensitive.
7. **Exit:** Close the application.

## 5. Subjects

The application manages marks for:

- Mathematics
- Science
- English
- History
- Computer

## 6. Grading Criteria

| Average | Grade |
|---|---|
| 90 and above | A |
| 80 to below 90 | B |
| 70 to below 80 | C |
| 60 to below 70 | D |
| Below 60 | F |

## 7. Input Validation

Marks must be numeric values between 0 and 100, inclusive. Invalid values are rejected, and the user is prompted to enter a valid mark.

## 8. Data Storage

Student records are stored in memory using arrays. Records are cleared when the application exits.