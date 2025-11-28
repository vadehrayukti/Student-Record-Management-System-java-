import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Student> list = FileUtil.loadStudents("students.txt");
        System.out.println("Loaded students from file:");

        for (Student s : list) {
            s.display();
            System.out.println();
        }

        StudentManager sm = new StudentManager(list);

        int choice;

        do {
            System.out.println("\n===== Capstone Student Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by Name");
            System.out.println("4. Delete by Name");
            System.out.println("5. Sort by Marks");
            System.out.println("6. Save and Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    sm.addStudent(new Student(roll, name, email, course, marks));
                    break;

                case 2:
                    sm.viewAll();
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String search = sc.nextLine();
                    sm.searchByName(search);
                    break;

                case 4:
                    System.out.print("Enter name to delete: ");
                    String del = sc.nextLine();
                    sm.deleteByName(del);
                    break;

                case 5:
                    sm.sortByMarks();
                    break;

                case 6:
                    FileUtil.saveStudents("students.txt", sm.getList());
                    System.out.println("Saved successfully. Exiting...");
                    FileUtil.randomRead("students.txt");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);
    }
}
