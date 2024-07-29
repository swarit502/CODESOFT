import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizApplication {
    private String[] questions;
    private String[][] options;
    private String[] answers;
    private int score;
    private int time;

    public QuizApplication(String[] questions, String[][] options, String[] answers, int time) {
        this.questions = questions;
        this.options = options;
        this.answers = answers;
        this.score = 0;
        this.time = time;
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        Timer timer = new Timer();

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            for (int j = 0; j < options[i].length; j++) {
                System.out.println((j + 1) + ". " + options[i][j]);
            }

            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Time's up!");
                    scanner.nextLine();
                }
            };

            timer.schedule(task, time * 1000);

            System.out.print("Enter your answer (1-" + options[i].length + "): ");
            int answer = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            timer.cancel();

            if (options[i][answer - 1].equals(answers[i])) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was " + answers[i]);
            }
        }

        System.out.println("Quiz over. Your final score is " + score + "/" + questions.length);
    }

    public static void main(String[] args) {
        String[] questions = {
                "What is the capital of France?",
                "What is the largest planet in our solar system?",
                "Who wrote Romeo and Juliet?"
        };

        String[][] options = {
                {"Paris", "London", "Berlin", "Rome"},
                {"Earth", "Saturn", "Jupiter", "Uranus"},
                {"William Shakespeare", "Jane Austen", "Charles Dickens", "J.K. Rowling"}
        };

        String[] answers = {"Paris", "Jupiter", "William Shakespeare"};

        QuizApplication quiz = new QuizApplication(questions, options, answers, 10);
        quiz.startQuiz();
    }
}