import java.util.Scanner;

public class GRADE_CALCULATER {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student's name: ");
        String name = sc.nextLine();
        System.out.println("Enter Subject 1 marks");
        int subject1 = sc.nextInt();
        System.out.println("Enter Subject 2 marks");
        int  subject2 = sc.nextInt();
        System.out.println("Enter Subject 3 marks");
        int subject3 = sc.nextInt();
        System.out.println("Enter Subject 4 marks");
        int subject4 = sc.nextInt();
        System.out.println("Enter the Subject 5 marks");
        int subject5 = sc.nextInt();
        int score = (subject1)+(subject2)+(subject3)+(subject4)+(subject5);
        int per =(score*100/500);
        char grade = calculateGrade(score);
        System.out.println("Student's name: " + name);
        System.out.println("student percentages is : "+per);
        System.out.println("Student's score: " + score);
        System.out.println("Student's grade: " + grade);
    }

    public static char calculateGrade(int score) {
        if (score >= 450) {
            return 'A';
        } else if (score >= 400) {
            return 'B';
        } else if (score >= 350) {
            return 'C';
        } else if (score >= 300) {
            return 'D';
        } else {
            return 'F';
        }
    }
}