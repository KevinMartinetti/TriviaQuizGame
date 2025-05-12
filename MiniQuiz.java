import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * The MiniQuiz class is a small quiz containing 5 random multiple-choice questions.
 * It asks the user the questions, evaluates the answers, and gives them their score performance.
 */
public class MiniQuiz {

    /**
     * Starts the Mini Quiz by randomly selecting 5 questions and validate the user's performance.
     * The quiz ends either when the user completes all questions or when they can no longer reach the passing score.
     */
    public static void startMiniQuiz() {
        Scanner input = new Scanner(System.in);
        
        // Get the full list of questions and shuffle their order.
        List<QuestionsList> questions = QuestionsList.getAllQuestions();
        Collections.shuffle(questions);

        // Select the first 5 questions for the mini quiz.
        List<QuestionsList> miniQuizQuestions = questions.subList(0, 5);

        int totalScore = 0; //score start at 0.
        int totalQuestions = miniQuizQuestions.size(); //Total number of questions in the mini quiz.
        int pointsPerCorrect = 5;  // Points awarded for each correct answer.
        int passingScore = 15;     // Minimum score to pass the quiz.

        System.out.println("");

        // Loop through each question in the mini quiz.
        for (int i = 0; i < totalQuestions; i++) {
            QuestionsList questionItem = miniQuizQuestions.get(i);

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
                String userInput = input.nextLine().trim();

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

            // End the quiz early if the remaining score cannot reach the passing score.
            int remaining = totalQuestions - (i + 1);
            int maxPossible = totalScore + (remaining * pointsPerCorrect);
            if (maxPossible < passingScore) {
                System.out.println("Mhhh..you can no longer reach the passing score. Better luck next time!");
                break;  // Exit the loop early if passing score is impossible.
            }
        }

        // Display the final results of the quiz.
        System.out.println("\nYou completed the Mini Quiz! You final score is: " + totalScore + "/" + (totalQuestions * pointsPerCorrect));

        // Evaluate the user's performance based on their score.
        if (totalScore >= passingScore) {
            if (totalScore == totalQuestions * pointsPerCorrect) {
                System.out.println("WOW! You are a genius in the making.\n");
            } else if (totalScore == 4 * pointsPerCorrect) {
                System.out.println("Well Done! Consider youself a miniquiz Sous Chef.\n");
            } else if (totalScore == 3 * pointsPerCorrect) {
                System.out.println("Congratulations! You hit the passing score wearing a Lifejacket.\n");
            }
        } else {
            System.out.println("Ohh noo...you did not pass the Mini Quiz. Better luck next time!\n");
        }
    }
}
