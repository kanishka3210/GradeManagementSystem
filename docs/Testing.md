# Grade Management System: Testing Documentation

## 1. Test Environment

- **Programming Language:** Java
- **Execution Environment:** Command Prompt / VS Code terminal
- **Data Storage:** In-memory arrays

## 2. Test Cases and Results

| Test Case | Input or Action | Expected Result | Result |
|---|---|---|---|
| Add student | Enter a name and five valid marks | Student record is added | Passed |
| View students | Select menu option 2 | Student records are displayed | Passed |
| Calculate average | Marks: 99, 81, 78, 92, 99 | Average is 89.80 | Passed |
| Calculate grade | Average: 89.80 | Grade is B | Passed |
| Performance report | Select menu option 5 | Class and subject statistics are displayed | Passed |
| Search student | Search for ELIJAH when the stored name is ElijaH | Student is found | Passed |
| Upper boundary | Enter 100 | Mark is accepted | Passed |
| Lower boundary | Enter 0 | Mark is accepted | Passed |
| Invalid high mark | Enter 120 | Mark is rejected | Passed |
| Invalid negative mark | Enter -5 | Mark is rejected | Passed |
| Non-numeric mark | Enter hello | Invalid input is rejected | Passed |
| Exit application | Select menu option 7 | Application closes | Passed |

## 3. Testing Summary

The tested functions worked as expected. The application accepted valid marks, rejected invalid marks, calculated averages and grades, generated performance reports, supported case-insensitive student searches, and exited successfully.

**Note:** These results reflect the tests performed during development. Student records are stored in memory and are cleared when the application exits.