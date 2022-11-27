import java.lang.reflect.Constructor;
import java.util.Scanner;

public class Student {
    //    Declare attributes
    private String name;
    private String studentId;
    private float scoreMath;
    private float scorePhysics;
    private float scoreChemistry;
    private float averageScore;
    private String level;

    //    Get and Set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public float getScoreMath() {
        return scoreMath;
    }

    public void setScoreMath(float scoreMath) {
        this.scoreMath = scoreMath;
    }

    public float getScorePhysics() {
        return scorePhysics;
    }

    public void setScorePhysics(float scorePhysics) {
        this.scorePhysics = scorePhysics;
    }

    public float getScoreChemistry() {
        return scoreChemistry;
    }

    public void setScoreChemistry(float scoreChemistry) {
        this.scoreChemistry = scoreChemistry;
    }

    public float getAverageScore() {
        return this.averageScore;
    }

    public String getLevel() {
        return this.level;
    }

//    Constructor


    public Student(String name, String studentId, float scoreMath, float scorePhysics, float scoreChemistry) {
        this.name = name;
        this.studentId = studentId;
        this.scoreMath = scoreMath;
        this.scorePhysics = scorePhysics;
        this.scoreChemistry = scoreChemistry;
    }

    public Student() {

    }

    public void calAverageScore() {
        this.averageScore = ((float) Math.round((this.scoreMath + this.scorePhysics + this.scoreChemistry) / 3 * 100) / 100);
    }

    public void classifyStudentLevel() {
        if (this.averageScore >= 9) {
            this.level = "Excellent";
        } else if (this.averageScore >= 8) {
            this.level = "Very Good";
        } else if (this.averageScore >= 7) {
            this.level = "Good";
        } else if (this.averageScore >= 6) {
            this.level = "Satisfactory";
        } else if (this.averageScore >= 5) {
            this.level = "Average";
        } else {
            this.level = "Weak";
        }
    }

    public void inputStudentInfo(Scanner sc) {
        System.out.println("============= Input Student Info ===========");
        System.out.print("Input student name: ");
        this.name = sc.nextLine();

        System.out.print("Input student student id: ");
        this.studentId = sc.nextLine();

        System.out.print("Input student Math score: ");
        this.scoreMath = Float.parseFloat(sc.nextLine());

        System.out.print("Input student Physics score: ");
        this.scorePhysics = Float.parseFloat(sc.nextLine());

        System.out.print("Input student Chemistry score: ");
        this.scoreChemistry = Float.parseFloat(sc.nextLine());
    }

    public void printOutStudentInfo() {
        String text = "";
        text += "||" + formatForStringAttribute(this.name) + "|";
        text += formatForStringAttribute(this.studentId) + "|";
        text += formatForFloatAttribute(this.scoreMath) + "|";
        text += formatForFloatAttribute(this.scorePhysics) + "|";
        text += formatForFloatAttribute(this.scoreChemistry) + "|";
        text += formatForFloatAttribute(this.averageScore) + "|";
        text += formatForStringAttribute(this.level) + "||";
        System.out.println(text);
    }

    private String formatForStringAttribute(String stringType) {
        String paddleLeft = "%5s";
        String paddleRight = "%-15s";
        return String.format(paddleLeft, " ") + String.format(paddleRight, stringType);
    }

    private String formatForFloatAttribute(Float floatType) {
        String paddleLeft = "%8s";
        String paddleRight = "%-12s";
        return String.format(paddleLeft, " ") + String.format(paddleRight, floatType);
    }


}
