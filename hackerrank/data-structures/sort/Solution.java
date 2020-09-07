import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

class Student {

    private static Set<Integer> idSet = new HashSet<Integer>();

    private int id;
    private String firstName;
    private double cgpa;

    public Student (int id, String firstName, double cgpa) {
        super();
        assert 0 <= id && id <= 100_000;
        assert !Student.idSet.contains(id);
        assert 5 <= firstName.length() && firstName.length() <= 30;
        assert 0 <= cgpa && cgpa <= 4.00;

        this.id = id;
        Student.idSet.add(id);
        this.firstName = firstName;
        this.cgpa = cgpa;
    }

    public int getId () {
        return id;
    }

    public String getFirstName () {
        return firstName;
    }

    public double getCgpa () {
        return cgpa;
    }

}

public class Solution {

    public static void main (String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numStudents = scanner.nextInt();
            assert 2 <= numStudents && numStudents <= 1_000;

            List<Student> studentList = new ArrayList<Student>();
            for (int i = 0; i < numStudents; i++) {
                int id = scanner.nextInt();
                String firstName = scanner.next();
                double cgpa = scanner.nextDouble();

                Student student = new Student(id, firstName, cgpa);
                studentList.add(student);
            }

            Collections.sort(studentList, new Comparator<Student>() {
                @Override
                public int compare (Student student1, Student student2) {
                    if (student1.getCgpa() == student2.getCgpa()) {
                        if (student1.getFirstName().equals(student2.getFirstName())) {
                            return student1.getId() - student2.getId();
                        }
                        return student1.getFirstName().compareTo(student2.getFirstName());
                    }
                    return Double.compare(student2.getCgpa(), student1.getCgpa());
                }
            });

            for (Student student: studentList) {
                System.out.println(student.getFirstName());
            }
        }
    }

}
