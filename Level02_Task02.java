import java.util.Scanner;

public class Level02_Task02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to input a password
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Check password strength
        String strengthFeedback = checkPasswordStrength(password);

        // Display the password strength feedback
        System.out.println("Password Strength: " + strengthFeedback);

        scanner.close();
    }

    private static String checkPasswordStrength(String password) {
        // Initialize variables to track different criteria
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        // Check each character in the password
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (isSpecialCharacter(ch)) {
                hasSpecialChar = true;
            }
        }

        // Check password length
        int passwordLength = password.length();
        boolean isLengthValid = passwordLength >= 8 && passwordLength <= 20;

        // Provide feedback based on criteria
        if (isLengthValid && hasUppercase && hasLowercase && hasDigit && hasSpecialChar) {
            return "Strong Password";
        } else {
            StringBuilder feedback = new StringBuilder("Weak Password. Consider including:");
            if (!hasUppercase)
                feedback.append(" Uppercase Letters,");
            if (!hasLowercase)
                feedback.append(" Lowercase Letters,");
            if (!hasDigit)
                feedback.append(" Numbers,");
            if (!hasSpecialChar)
                feedback.append(" Special Characters,");
            if (!isLengthValid)
                feedback.append(" Length between 8 and 20 characters,");

            // Remove trailing comma
            if (feedback.charAt(feedback.length() - 1) == ',') {
                feedback.deleteCharAt(feedback.length() - 1);
            }

            return feedback.toString();
        }
    }

    private static boolean isSpecialCharacter(char ch) {
        // Define special characters (you can customize this based on your requirements)
        String specialCharacters = "!@#$%^&*()-_+=<>?";

        // Check if the character is a special character
        return specialCharacters.indexOf(ch) != -1;
    }
}
