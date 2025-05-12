import java.util.Scanner;

/**
 * The TriviaQuizGame is the Trivia Quiz Game main class.
 * The class presents the user with a choice between the Mini Quiz or the Full Quiz and calls the chosen class appropriately. 
 */
public class TriviaQuizGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Welcome message and instructions for the user.
        System.out.println("\nWelcome to the Trivia Quiz Game!");
        System.out.println("");
        System.out.println("Please choose a quiz type below by typing the number and pressing Enter:");
        System.out.println("1: Mini Quiz (5 questions)");
        System.out.println("2: Full Quiz (10 questions)");
        System.out.println("\n");
        

        int quizChoice = 0;

        // Input validation loop to ensure the user enters a valid input choice.
        while (quizChoice != 1 && quizChoice != 2) {
            System.out.print("Enter your choice (1 or 2): ");
            
            // Check if the user input is an integer.
            if (scanner.hasNextInt()) {
                quizChoice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character after the integer input.

                // Start the Mini Quiz if option 1 is selected.
                if (quizChoice == 1) {
                    System.out.println("\nYou choose to play the Mini Quiz Get ready to answer 5 multiple choice questions.");
                    System.out.println("Each correct answer gives 5 points - you need a total of 15 points to pass the quiz.");
                    System.out.println("Good luck. Let's start!");
                    MiniQuiz.startMiniQuiz();  // Initiates the Mini Quiz.
                } 
                // Start the Full Quiz if option 2 is selected.
                else if (quizChoice == 2) {
                    System.out.println("\nYou choose to play the Full Quiz Get ready to answer 10 multiple choice questions.");
                    System.out.println("Each correct answer gives 5 points - you need a total of 30 points to pass the quiz.");
                    System.out.println("Good luck. Let's start!");
                    FullQuiz.startFullQuiz();  // Initiates the Full Quiz.
                } 
                // Handle invalid quiz type input.
                else {
                    System.out.println("\nInvalid choice. Please select a valid option (1 or 2).");
                }
            } 
            // Handle non-integer input.
            else {
                System.out.println("\nInvalid input. Please enter a number (1 or 2).");
                scanner.nextLine(); // Consume the invalid input.
            }
        }
    }
}
