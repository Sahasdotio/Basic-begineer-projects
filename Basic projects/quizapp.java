import java.util.Scanner;

public class QuizApp {
    static String[] questions = {
        "1. Which language is used for Android development?",
        "2. What does HTML stand for?",
        "3. Which company owns Java?"
    };

    static String[][] options = {
        {"a) Java", "b) Python", "c) C#", "d) Kotlin"},
        {"a) Hyper Trainer Marking Language", "b) Hyper Text Markup Language", "c) High Text Machine Language", "d) None"},
        {"a) Microsoft", "b) Apple", "c) Oracle", "d) Google"}
    };

    static char[] answers = {'d', 'b', 'c'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }
            System.out.print("Enter your answer (a/b/c/d): ");
            char userAnswer = sc.next().charAt(0);

            if (userAnswer == answers[i]) {
                System.out.println("✅ Correct!\n");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer is: " + answers[i] + "\n");
            }
        }

        System.out.println("Your final score is: " + score + "/" + questions.length);
        if (score == questions.length) {
            System.out.println("🎉 Excellent!");
        } else if (score >= 1) {
            System.out.println("👍 Good job!");
        } else {
            System.out.println("😅 Better luck next time.");
        }

        sc.close();
    }
}
