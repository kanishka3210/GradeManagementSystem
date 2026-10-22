import java.util.Scanner;

public class GradeManagementSystem {

    private static final int MAX_STUDENTS = 100;
    private static final int SUBJECT_COUNT = 5;

    private static final String[] SUBJECTS = {
        "Mathematics", "Science", "English",
        "History", "Computer"
    };

    private static final String[] studentNames =
        new String[MAX_STUDENTS];

    private static final double[][] studentMarks =
        new double[MAX_STUDENTS][SUBJECT_COUNT];

    private static int studentCount = 0;

    private static final Scanner scanner =
        new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            System.out.println("\n===== GRADE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student Marks");
            System.out.println("2. View All Students");
            System.out.println("3. Calculate Averages and Grades");
            System.out.println("4. Find Top Performers");
            System.out.println("5. Generate Performance Report");
            System.out.println("6. Search Student");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = getValidInt(1, 7);

            switch (choice) {
                case 1:
                    addStudentMarks();
                    break;

                case 2:
                    viewAllStudents();
                    break;

                case 3:
                    calculateAverages();
                    break;

                case 4:
                    findTopPerformers();
                    break;

                case 5:
                    generateReport();
                    break;

                case 6:
                    searchStudent();
                    break;

                case 7:
                    running = false;
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }

    private static void addStudentMarks() {

        if (studentCount >= MAX_STUDENTS) {
            System.out.println("Maximum student limit reached!");
            return;
        }

        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        for (int i = 0; i < studentCount; i++) {
            if (studentNames[i].equalsIgnoreCase(name)) {
                System.out.println("Student already exists!");
                return;
            }
        }

        studentNames[studentCount] = name;

        System.out.println("Enter marks out of 100:");

        for (int i = 0; i < SUBJECT_COUNT; i++) {
            System.out.print(SUBJECTS[i] + ": ");
            studentMarks[studentCount][i] = getValidMark();
        }

        studentCount++;

        System.out.println("Student added successfully!");
    }

    private static void viewAllStudents() {

        if (studentCount == 0) {
            System.out.println("No students available.");
            return;
        }

        for (int i = 0; i < studentCount; i++) {
            System.out.println("\nStudent: " + studentNames[i]);

            for (int j = 0; j < SUBJECT_COUNT; j++) {
                System.out.println(
                    SUBJECTS[j] + ": " + studentMarks[i][j]
                );
            }

            System.out.printf("Average: %.2f%n",
                calculateAverage(i));

            System.out.println("Grade: " +
                getGrade(calculateAverage(i)));
        }
    }

    private static double calculateAverage(int studentIndex) {

        double sum = 0;

        for (int j = 0; j < SUBJECT_COUNT; j++) {
            sum += studentMarks[studentIndex][j];
        }

        return sum / SUBJECT_COUNT;
    }

    private static double getHighestMark(int studentIndex) {

        double highest = studentMarks[studentIndex][0];

        for (int j = 1; j < SUBJECT_COUNT; j++) {
            if (studentMarks[studentIndex][j] > highest) {
                highest = studentMarks[studentIndex][j];
            }
        }

        return highest;
    }

    private static double getLowestMark(int studentIndex) {

        double lowest = studentMarks[studentIndex][0];

        for (int j = 1; j < SUBJECT_COUNT; j++) {
            if (studentMarks[studentIndex][j] < lowest) {
                lowest = studentMarks[studentIndex][j];
            }
        }

        return lowest;
    }

    private static String getGrade(double average) {

        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    private static void calculateAverages() {

        if (studentCount == 0) {
            System.out.println("No students available.");
            return;
        }

        for (int i = 0; i < studentCount; i++) {
            double average = calculateAverage(i);

            System.out.printf(
                "%s | Average: %.2f | Grade: %s"
                    + " | Highest: %.2f | Lowest: %.2f%n",
                studentNames[i],
                average,
                getGrade(average),
                getHighestMark(i),
                getLowestMark(i)
            );
        }
    }

    private static void findTopPerformers() {

        if (studentCount == 0) {
            System.out.println("No students available.");
            return;
        }

        int[] order = new int[studentCount];

        for (int i = 0; i < studentCount; i++) {
            order[i] = i;
        }

        // Sort student indexes by average, highest first.
        for (int i = 0; i < studentCount - 1; i++) {
            for (int j = 0; j < studentCount - 1 - i; j++) {

                if (calculateAverage(order[j])
                        < calculateAverage(order[j + 1])) {

                    int temp = order[j];
                    order[j] = order[j + 1];
                    order[j + 1] = temp;
                }
            }
        }

        System.out.println("\n===== TOP PERFORMERS =====");

        for (int i = 0; i < studentCount; i++) {
            int index = order[i];

            System.out.printf(
                "%d. %s - Average: %.2f%n",
                i + 1,
                studentNames[index],
                calculateAverage(index)
            );
        }
    }

    private static void generateReport() {

        if (studentCount == 0) {
            System.out.println("No students available.");
            return;
        }

        double[] subjectTotals = new double[SUBJECT_COUNT];
        int[] gradeCounts = new int[5];

        double classTotal = 0;

        for (int i = 0; i < studentCount; i++) {

            double average = calculateAverage(i);
            classTotal += average;

            for (int j = 0; j < SUBJECT_COUNT; j++) {
                subjectTotals[j] += studentMarks[i][j];
            }

            switch (getGrade(average)) {
                case "A":
                    gradeCounts[0]++;
                    break;
                case "B":
                    gradeCounts[1]++;
                    break;
                case "C":
                    gradeCounts[2]++;
                    break;
                case "D":
                    gradeCounts[3]++;
                    break;
                case "F":
                    gradeCounts[4]++;
                    break;
                default:
                    break;
            }
        }

        System.out.println("\n===== PERFORMANCE REPORT =====");
        System.out.println("Total students: " + studentCount);

        System.out.printf("Class average: %.2f%n",
            classTotal / studentCount);

        System.out.println("\nSubject averages:");

        for (int j = 0; j < SUBJECT_COUNT; j++) {
            System.out.printf(
                "%s: %.2f%n",
                SUBJECTS[j],
                subjectTotals[j] / studentCount
            );
        }

        System.out.println("\nGrade distribution:");

        String[] grades = {"A", "B", "C", "D", "F"};

        for (int i = 0; i < grades.length; i++) {
            System.out.println(
                grades[i] + " Grade: " + gradeCounts[i] + " students"
            );
        }

        System.out.println("\nTop performer:");

        int topIndex = 0;

        for (int i = 1; i < studentCount; i++) {
            if (calculateAverage(i) >
                    calculateAverage(topIndex)) {
                topIndex = i;
            }
        }

        System.out.printf(
            "%s - Average: %.2f%n",
            studentNames[topIndex],
            calculateAverage(topIndex)
        );
    }

    private static void searchStudent() {

        if (studentCount == 0) {
            System.out.println("No students available.");
            return;
        }

        System.out.print("Enter student name to search: ");
        String searchName = scanner.nextLine().trim();

        for (int i = 0; i < studentCount; i++) {

            if (studentNames[i].equalsIgnoreCase(searchName)) {

                System.out.println("Student found: " + studentNames[i]);

                for (int j = 0; j < SUBJECT_COUNT; j++) {
                    System.out.println(
                        SUBJECTS[j] + ": " + studentMarks[i][j]
                    );
                }

                System.out.printf("Average: %.2f%n",
                    calculateAverage(i));

                System.out.println("Grade: " +
                    getGrade(calculateAverage(i)));

                return;
            }
        }

        System.out.println("Student not found.");
    }

    private static int getValidInt(int min, int max) {

        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());

                if (value >= min && value <= max) {
                    return value;
                }

                System.out.printf(
                    "Enter a number between %d and %d: ",
                    min, max
                );

            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a whole number: ");
            }
        }
    }

    private static double getValidMark() {

        while (true) {
            try {
                double mark = Double.parseDouble(
                    scanner.nextLine().trim()
                );

                if (Double.isFinite(mark) && mark >= 0 && mark <= 100) {
                    return mark;
                }

                System.out.print(
                    "Marks must be between 0 and 100. Re-enter: "
                );

            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a number: ");
            }
        }
    }
}

