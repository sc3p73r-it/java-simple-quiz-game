import java.util.Scanner;

/**
 * A simple quiz game that prompts the user with five multiple-choice questions.
 * It tracks the user's score and displays the final result as a percentage.
 */
public class SimpleQuizGame {

    public static void main(String[] args) {
        // Initialize a Scanner object to read user input from the console.
        Scanner scanner = new Scanner(System.in);
        
        // Initialize the score counter.
        int score = 0;
        
        // Define arrays to hold the questions, options, and correct answers.
        String[] questions = {
            "1. What is the capital of Myanmar?",
            "2. Which provisioner invokes a process on the resource created by Terraform?",
            "3. Which command is used to list all files in the current directory, including hidden files?",
            "4. Who wrote the play 'Romeo and Juliet'?",
            "5. What is the chemical symbol for gold?"
        };
        
        String[][] options = {
            {"A. Bago", "B. Mandalay", "C. Naypyidaw", "D. Yangon"},
            {"A. null-exec", "B. remote-exec", "C. local-exec", "D. file"},
            {"A. ls -l", "B. ls -t", "C. ls -i", "D. ls -a"},
            {"A. Charles Dickens", "B. William Shakespeare", "C. Jane Austen", "D. Mark Twain"},
            {"A. Ag", "B. Au", "C. Fe", "D. Cu"}
        };
        
        char[] correctAnswers = {'C', 'B', 'D', 'B', 'B'};
        
        // Use a for loop to iterate through each question.
        for (int i = 0; i < questions.length; i++) {
            System.out.println("------------------------------------------");
            System.out.println(questions[i]);
            
            // Print the options for the current question.
            for (String option : options[i]) {
                System.out.println(option);
            }
            
            char userAnswer;
            
            // This loop handles input validation. It will continue to prompt the user
            // until they enter a valid option (A, B, C, or D).
            while (true) {
                System.out.print("Enter your answer (A, B, C, or D): ");
                String input = scanner.nextLine().toUpperCase();
                
                // Check if the input is a single character and one of the valid options (A, B, C, or D).
                // The indexOf method on a string is a clean way to check for valid characters.
                if (input.length() == 1 && "ABCD".indexOf(input.charAt(0)) != -1) {
                    userAnswer = input.charAt(0);
                    break; // Exit the validation loop.
                } else {
                    System.out.println("Invalid input. Please enter A, B, C, or D.");
                }
            }
            
            // Use a switch case statement to check the user's answer against the correct answer.
            // This is an alternative to an if-else if chain and can be more readable for this purpose.
            switch (userAnswer) {
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                    if (userAnswer == correctAnswers[i]) {
                        System.out.println("Correct!");
                        score++; // Increment the score for a correct answer.
                    } else {
                        System.out.println("Incorrect. The correct answer was " + correctAnswers[i] + ".");
                    }
                    break;
            }
        }
        
        System.out.println("------------------------------------------");
        System.out.println("\nQuiz completed!");
        
        // Calculate the final score as a percentage.
        // We cast the score to a double to ensure floating-point division.
        double percentage = (double) score / questions.length * 100;
        
        // Display the final score.
        System.out.printf("You got %d out of %d questions correct.\n", score, questions.length);
        System.out.printf("Your final score is %.2f%%\n", percentage);
        
        // Close the scanner to prevent resource leaks.
        scanner.close();
    }
}

