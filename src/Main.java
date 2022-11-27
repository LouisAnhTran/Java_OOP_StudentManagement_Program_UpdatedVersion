import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        Student st1=new Student("Louis","1005242",9,9,9);
//        st1.calAverageScore();
//        st1.classifyStudentLevel();
//        st1.printOutStudentInfo();

        ListStudent listStu = new ListStudent();
        listStu.inputStudentFromDummyData();
        process(sc, listStu);
    }

    private static void showMenu() {
        System.out.println("============ Menu =============");
        System.out.println("1. List out students with highest score");
        System.out.println("2. List out students with weak level");
        System.out.println("3. Find student by name");
        System.out.println("4. Find student by Id");
        System.out.println("5. Remove student from the list by ID");
        System.out.println("6. Exit");
        System.out.println("===============================");
    }

    private static void process(Scanner sc, ListStudent listStudent) {
        int userInput;
        do {
            showMenu();
            System.out.print("Please choose option you want to proceed: ");
            userInput = Integer.parseInt(sc.nextLine());
            while (userInput < 0 || userInput > 6) {
                System.out.print("Please choose again 1-6: ");
                userInput = Integer.parseInt(sc.nextLine());
            }

            switch (userInput) {
                case 1:
                    listStudent.printOutListStudentFormat(listStudent.studentList);
                    option1(listStudent);
                    System.out.println();
                    break;
                case 2:
                    listStudent.printOutListStudentFormat(listStudent.studentList);
                    option2(listStudent);
                    System.out.println();
                    break;
                case 3:
                    listStudent.printOutListStudentFormat(listStudent.studentList);
                    option3(listStudent, sc);
                    System.out.println();
                    break;
                case 4:
                    listStudent.printOutListStudentFormat(listStudent.studentList);
                    option4(listStudent, sc);
                    System.out.println();
                    break;
                case 5:
                    listStudent.printOutListStudentFormat(listStudent.studentList);
                    option5(listStudent, sc);
                    System.out.println();
                    break;
                case 6:
                    break;
            }
        } while (userInput != 6);
    }

    private static void option1(ListStudent studentList) {
        ArrayList<Student> stuList = studentList.listOfStudentWithHighestAverageScore();
        studentList.printOutListStudentFormat(stuList);
    }

    private static void option2(ListStudent studentList) {
        ArrayList<Student> stuList = studentList.listOfStudentWithWeakLevel();
        studentList.printOutListStudentFormat(stuList);
    }

    private static void option3(ListStudent studentList, Scanner sc) {
        ArrayList<Student> stuList = studentList.findStudentByName(sc);
        studentList.printOutListStudentFormat(stuList);
    }

    private static void option4(ListStudent studentList, Scanner sc) {
        Student st = studentList.findStudentById(sc);
        if (st == null) {
            System.out.println("Can not find student the given ID");
            return;
        }
        studentList.printOutOneStudentFormat(st);
    }

    private static void option5(ListStudent studentList, Scanner sc) {
        studentList.removeStudentById(sc);
    }

}