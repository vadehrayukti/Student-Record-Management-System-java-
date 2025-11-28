import java.util.*;

public class StudentManager {

    private ArrayList<Student> list = new ArrayList<>();

    public StudentManager(ArrayList<Student> list) {
        this.list = list;
    }

    public void addStudent(Student s) {
        list.add(s);
        System.out.println("Student added successfully!");
    }

    public void viewAll() {
        Iterator<Student> it = list.iterator();
        while (it.hasNext()) {
            it.next().display();
            System.out.println("-----------");
        }
    }

    public void searchByName(String name) {
        boolean found = false;
        for (Student s : list) {
            if (s.getName().equalsIgnoreCase(name)) {
                s.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Student not found!");
        }
    }

    public void deleteByName(String name) {
        Iterator<Student> it = list.iterator();
        boolean removed = false;

        while (it.hasNext()) {
            if (it.next().getName().equalsIgnoreCase(name)) {
                it.remove();
                removed = true;
                System.out.println("Student deleted.");
            }
        }
        if (!removed) {
            System.out.println("No student found with this name.");
        }
    }

    public void sortByMarks() {
        Collections.sort(list);
        System.out.println("Sorted Student List by Marks:");
        viewAll();
    }

    public ArrayList<Student> getList() {
        return list;
    }
}
