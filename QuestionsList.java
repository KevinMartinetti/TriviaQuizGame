import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The QuestionsList class represents a single multiple-choice trivia question with the following components:
 * Question text, possible answer choices, index of the correct answer, insight on the correct answer.
 */
public class QuestionsList {
    // The text of the question.
    private String question;

    // An array of possible answer choices.
    private String[] multipleChoices;

    // 1-based index of the correct answer.
    private int correctAnswer;

    // Explanation for the correct answer.
    private String answerInsight;

    /**
     * QuestionsList object constructor with necessary components.
     *
     * @param question        The question text.
     * @param multipleChoices The answer choices.
     * @param correctAnswer   The index (1-based) of the correct answer.
     * @param answerInsight   A brief explanation for the correct answer.
     */
    public QuestionsList(String question, String[] multipleChoices, int correctAnswer, String answerInsight) {
        this.question = question;
        this.multipleChoices = multipleChoices;
        this.correctAnswer = correctAnswer;
        this.answerInsight = answerInsight;
    }

    // Getter for the question text.
    public String getQuestion() {
        return question;
    }

    // Getter for the multiple-choice options.
    public String[] getMultipleChoices() {
        return multipleChoices;
    }

    // Getter for the correct answer's index.
    public int getCorrectAnswer() {
        return correctAnswer;
    }

    // Getter for the explanation/insight.
    public String getAnswerInsight() {
        return answerInsight;
    }

    /**
     * Static method that returns a random list of all available trivia questions.
     * The questions are manually added to the list - the questions can be changed or expanded as needed. 
     *
     * @return A randomized List of QuestionsList objects.
     */
    public static List<QuestionsList> getAllQuestions() {
        List<QuestionsList> questions = new ArrayList<>();

        // Each question added with its choices, correct answer (1-based), and explanation.
        questions.add(new QuestionsList("What is the chemical symbol for gold?",
                new String[]{"Au", "Ag", "Gd", "Go"}, 1,
                "'Au' is the chemical symbol for gold. It comes from the Latin word 'aurum,' meaning 'shining dawn.'"));

        questions.add(new QuestionsList("Which planet is known as the 'Evening Star' or 'Morning Star'?",
                new String[]{"Mars", "Venus", "Jupiter", "Mercury"}, 2,
                "Venus appears very bright in the sky at dawn or dusk, earning those nicknames."));

        questions.add(new QuestionsList("Who wrote the play 'Hamlet'?",
                new String[]{"Charles Dickens", "William Shakespeare", "Jane Austen", "George Bernard Shaw"}, 2,
                "William Shakespeare wrote 'Hamlet' around the year 1600."));

        questions.add(new QuestionsList("How many time zones are there in Russia?",
                new String[]{"8", "9", "10", "11"}, 4,
                "Russia spans 11 time zones, more than any other country."));

        questions.add(new QuestionsList("What’s the national flower of Japan?",
                new String[]{"Lotus", "Cherry Blossom", "Rose", "Peony"}, 2,
                "The cherry blossom, or 'sakura,' is a national symbol of beauty and renewal in Japan."));

        questions.add(new QuestionsList("How many stripes are there on the US flag?",
                new String[]{"10", "12", "13", "15"}, 3,
                "There are 13 stripes to represent the original 13 colonies."));

        questions.add(new QuestionsList("What’s the national animal of Australia?",
                new String[]{"Koala", "Emu", "Red Kangaroo", "Platypus"}, 3,
                "The red kangaroo is a national symbol of Australia."));

        questions.add(new QuestionsList("How many days does it take for the Earth to orbit the Sun?",
                new String[]{"364", "365", "366", "367"}, 2,
                "Earth takes 365 days to orbit the Sun in a typical year."));

        questions.add(new QuestionsList("Which of the following empires had no written language:",
                new String[]{"Incan", "Aztec", "Egyptian", "Roman"}, 1,
                "The Incan Empire had no written language and used quipus, knotted strings, for communication."));

        questions.add(new QuestionsList("Until 1923, what was the Turkish city of Istanbul called?",
                new String[]{"Ankara", "Byzantium", "Constantinople", "Izmir"}, 3,
                "Istanbul was called Constantinople until its name officially changed in 1923."));

        questions.add(new QuestionsList("When was Netflix founded:",
                new String[]{"1997", "2001", "2009", "2015"}, 1,
                "Netflix began in 1997 as a DVD rental service."));

        questions.add(new QuestionsList("Name Disney’s first film?",
                new String[]{"Snow White", "Cinderella", "Pinocchio", "Fantasia"}, 1,
                "Disney’s first full-length film was 'Snow White and the Seven Dwarfs,' released in 1937."));

        questions.add(new QuestionsList("What was the clothing company Nike originally called?",
                new String[]{"Air Athletics", "Blue Ribbon Sports", "Track Co.", "Victory Gear"}, 2,
                "Nike was originally founded as Blue Ribbon Sports in 1964."));

        // Shuffle the list to randomize the order of questions.
        Collections.shuffle(questions);

        return questions;
    }

    /**
     * Method to print a question to the console.
     *
     * @param question The QuestionsList object to display.
     */
    public static void printQuestion(QuestionsList question) {
        System.out.println("");
        System.out.println("QUESTION: " + question.getQuestion());
        System.out.println("");

        // Print each option with a number starting from 1 
        for (int i = 0; i < question.getMultipleChoices().length; i++) {
            System.out.println((i + 1) + ". " + question.getMultipleChoices()[i]);
        }

        System.out.println("");
        System.out.println("Interesting facts: " + question.getAnswerInsight());
        System.out.println("");
    }
}
