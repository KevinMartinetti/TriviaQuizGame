import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * The FullQuiz class is a quiz consisting of 10 random multiple-choice questions.
 * It asks the user the questions, evaluates the answers, and gives them their score performance.
 */
public class FullQuiz {

    /**
     * Starts the Full Quiz, randomly selecting 10 questions and validating the user's performance.
     * The quiz ends either when the user completes all questions or when they can no longer reach the passing score.
     */
    public static void startFullQuiz() {
        Scanner scanner = new Scanner(System.in);

        // Get the full list of questions and shuffle their order
        List<QuestionsList> questions = QuestionsList.getAllQuestions();
        Collections.shuffle(questions);

        // Select the first 10 questions for the full quiz
        List<QuestionsList> fullQuizQuestions = questions.subList(0, 10);

        int totalScore = 0; // Score starts at 0
        int totalQuestions = fullQuizQuestions.size(); // Total number of questions in the full quiz
        int pointsPerCorrect = 5;  // Points awarded for each correct answer
        int passingScore = 30;     // Minimum score to pass the quiz

        System.out.println("");

        // Loop through each question in the full quiz.
        for (int i = 0; i < totalQuestions; i++) {
            QuestionsList questionItem = fullQuizQuestions.get(i);

            // Display the current question to the user.
            System.out.println("Question " + (i + 1) + ": " + questionItem.getQuestion());

            // Display the multiple choice options.
            String[] options = questionItem.getMultipleChoices();
            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ": " + options[j]);
            }

            // Input validation loop to ensure the user enters a valid answer.
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Enter your answer (1-4): ");
                String userInput = scanner.nextLine().trim();

                // Check if the input is valid (between 1 and 4).
                if (userInput.matches("[1-4]")) {
                    int chosenOption = Integer.parseInt(userInput);
                    if (chosenOption == questionItem.getCorrectAnswer()) { // Check if the answer is correct.
                        totalScore += pointsPerCorrect;
                        System.out.println("Correct! " + questionItem.getAnswerInsight());
                    } else {
                        int correctIndex = questionItem.getCorrectAnswer();
                        System.out.println("Not quite. The correct answer was " + correctIndex + ": " + options[correctIndex - 1]);
                    }
                    validInput = true;  // Break the loop once valid input is received.
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 4.");
                }
            }

            // Display the user's score.
            System.out.println("Your score: " + totalScore);
            System.out.println("");

            // Exit early if the user cannot achieve the passing score based on remaining questions.
            int remainingQuestions = totalQuestions - (i + 1);
            int maxPossibleScore = totalScore + (remainingQuestions * pointsPerCorrect);
            if (maxPossibleScore < passingScore) {
                System.out.println("You can no longer pass. Game over!");
                break;  // End the quiz early if passing score is impossible.
            }
        }

        // Display the final results of the quiz.
        System.out.println("You completed the Full Quiz! You final score is: " + totalScore + "/" + (totalQuestions * pointsPerCorrect));

        // Evaluate the user's performance based on their score.
        if (totalScore >= passingScore) {
            if (totalScore == totalQuestions * pointsPerCorrect) {
                System.out.println("WOW! You are a Trivia Master!");
            } else if (totalScore >= 4 * pointsPerCorrect) {
                System.out.println("Well Done! Consider yourself a Trivia Ninja!");
            } else if (totalScore >= 3 * pointsPerCorrect) {
                System.out.println("Congratulations! You hit the passing score wearing a Lifejacket.");
            }
        } else {
            System.out.println("Ohh noo...you did not pass the Full Quiz. Better luck next time!");
        }
    }
}
