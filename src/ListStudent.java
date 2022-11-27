import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;


public class ListStudent {
    ArrayList<Student> studentList;

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public void init() {
        this.studentList = new ArrayList<Student>();
    }

    public ListStudent() {
        init();
    }

    public ListStudent(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public void inputStudent(Scanner sc) {
        Student stu = new Student();
        stu.inputStudentInfo(sc);
        this.studentList.add(stu);
    }

    public void inputStudentFromDummyData() {
        try {
            FileReader reader = new FileReader("src/DummyDataStudent.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] listInfo = line.split(" # ");
                Student stu = new Student(listInfo[0], listInfo[1], Float.parseFloat(listInfo[2]), Float.parseFloat(listInfo[3]),
                        Float.parseFloat(listInfo[4]));
                stu.calAverageScore();
                stu.classifyStudentLevel();
                this.studentList.add(stu);
            }
            reader.close();// Đóng tập tin
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printLine() {
        System.out.println("=====================================================================================================================================================");
    }

    private String formatCell(String st) {
        return String.format("%4s", " ") + String.format("%-16s", st);
    }

    private void header() {
        String text = "";
        text += "||" + formatCell("Student Name");
        text += "|" + formatCell("Student ID");
        text += "|" + formatCell("Math Score");
        text += "|" + formatCell("Physics Score");
        text += "|" + formatCell("Chemistry Score");
        text += "|" + formatCell("Average Score");
        text += "|" + formatCell("Level Classify") + "||";
        System.out.println(text);
    }

    public void printOutListStudentFormat(ArrayList<Student> studentList) {
        printLine();
        header();
        printLine();
        for (Student st : studentList) {
            st.printOutStudentInfo();
        }
        printLine();
    }

    public void printOutOneStudentFormat(Student st) {
        printLine();
        header();
        printLine();
        st.printOutStudentInfo();
        printLine();
    }

    public ArrayList<Student> listOfStudentWithHighestAverageScore() {
        int maxIndex = 0;
        ArrayList<Student> listStudentHighest = new ArrayList<Student>();
        Student maxStudent = this.studentList.get(0);
        for (int i = 0; i < this.studentList.size(); i++) {
            if (this.studentList.get(i).getAverageScore() > maxStudent.getAverageScore()) {
                maxStudent = this.studentList.get(i);
                maxIndex = i;
            }
        }

        if (maxIndex == this.studentList.size() - 1) {
            listStudentHighest.add(maxStudent);
            return listStudentHighest;
        } else {
            listStudentHighest.add(maxStudent);
            for (int i = maxIndex + 1; i < this.studentList.size(); i++) {
                if (this.studentList.get(i).getAverageScore() == maxStudent.getAverageScore()) {
                    listStudentHighest.add(this.studentList.get(i));
                }
            }
            return listStudentHighest;
        }
    }

    public ArrayList<Student> listOfStudentWithWeakLevel() {
        ArrayList<Student> listWeakStudent = new ArrayList<Student>();

        for (Student st : this.studentList) {
            if (st.getLevel().equals("Weak")) {
                listWeakStudent.add(st);
            }
        }

        return listWeakStudent;
    }

    public ArrayList<Student> findStudentByName(Scanner sc) {
        ArrayList<Student> listStudentByName = new ArrayList<Student>();
        System.out.print("Input name student: ");
        String nameInput = sc.nextLine();
        for (Student st : this.studentList) {
            if (st.getName().equalsIgnoreCase(nameInput)) {
                listStudentByName.add(st);
            }
        }
        return listStudentByName;
    }

    public Student findStudentById(Scanner sc) {
        Student st = null;
        System.out.print("Please input student ID you want to find: ");
        String studentId = sc.nextLine();
        for (Student st1 : this.studentList) {
            if (st1.getStudentId().equalsIgnoreCase(studentId)) {
                st = st1;
                break;
            }
        }
        return st;
    }

    public void removeStudentById(Scanner sc) {
        System.out.println("Input student id you want to remove from the list: ");
        String studentId = sc.nextLine();

        for (int i = 0; i < this.studentList.size(); i++) {
            if (this.studentList.get(i).getStudentId().equalsIgnoreCase(studentId)) {
                this.studentList.remove(i);
                break;
            }
        }
    }


}
