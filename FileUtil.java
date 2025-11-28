import java.io.*;
import java.util.*;

public class FileUtil {

    // Read students from file
    public static ArrayList<Student> loadStudents(String fileName) {
        ArrayList<Student> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    int roll = Integer.parseInt(data[0]);
                    String name = data[1];
                    String email = data[2];
                    String course = data[3];
                    double marks = Double.parseDouble(data[4]);

                    list.add(new Student(roll, name, email, course, marks));
                }
            }

        } catch (Exception e) {
            System.out.println("File not found or error reading file.");
        }
        return list;
    }

    // Save students to file
    public static void saveStudents(String fileName, ArrayList<Student> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Student s : list) {
                bw.write(s.toString());
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error writing to file.");
        }
    }

    // Random Access Read
    public static void randomRead(String fileName) {
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {
            System.out.println("\nReading first 50 bytes using RandomAccessFile:");
            byte[] b = new byte[50];
            raf.read(b);
            System.out.println(new String(b));
        } catch (Exception e) {
            System.out.println("Random access failed.");
        }
    }
}
