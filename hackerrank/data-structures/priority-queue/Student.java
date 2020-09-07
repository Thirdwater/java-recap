import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Student {

    private static Set<Integer> idSet = new HashSet<Integer>();

    private int id;
    private String name;
    private double cgpa;

    public Student (int id, String name, double cgpa) {
        assert 1 <= id && id <= 100_000;
        assert !Student.idSet.contains(id);
        assert 2 <= name.length() && name.length() <= 30;
        assert 0 <= cgpa && cgpa <= 4.00;

        this.id = id;
        Student.idSet.add(id);
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID () {
        return id;
    }

    public String getName () {
        return name;
    }

    public double getCGPA () {
        return cgpa;
    }

}

class Priorities {

    private static final Comparator<Student> CGPA_ORDER = new Comparator<Student>() {
        @Override
        public int compare (Student student1, Student student2) {
            if (student1.getCGPA() == student2.getCGPA()) {
                if (student1.getName().equals(student2.getName())) {
                    return student1.getID() - student2.getID();
                }
                return student1.getName().compareTo(student2.getName());
            }
            return Double.compare(student2.getCGPA(), student1.getCGPA());
        }
    };

    public List<Student> getStudents (List<String> events) {
        PriorityQueue<Student> priorityQueue = new PriorityQueue<Student>(
                events.size(), Priorities.CGPA_ORDER);
        for (String event: events) {
            String[] eventDetails = event.split(" ");
            switch (eventDetails[0]) {
                case "ENTER":
                    String name = eventDetails[1];
                    double cgpa = Double.parseDouble(eventDetails[2]);
                    int id = Integer.parseInt(eventDetails[3]);
                    Student student = new Student(id, name, cgpa);
                    priorityQueue.offer(student);
                    break;
                case "SERVED":
                    priorityQueue.poll();
                    break;
            }
        }
        List<Student> remainingStudents = new ArrayList<Student>();
        while (!priorityQueue.isEmpty()) {
            remainingStudents.add(priorityQueue.poll());
        }
        return remainingStudents;
    }

}
