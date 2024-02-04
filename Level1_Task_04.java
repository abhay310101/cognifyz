import java.security.SecureRandom;
import java.util.Scanner;

public class Level1_Task_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the desired password length
        System.out.print("Enter the desired password length: ");
        int passwordLength = scanner.nextInt();

        // Prompt the user for password criteria
        System.out.print("Include numbers? (yes/no): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecialChars = scanner.next().equalsIgnoreCase("yes");

        // Generate the random password
        String password = generatePassword(passwordLength, includeNumbers, includeLowercase, includeUppercase, includeSpecialChars);

        // Display the generated password
        System.out.println("Generated Password: " + password);

        scanner.close();
    }

    private static String generatePassword(int length, boolean includeNumbers, boolean includeLowercase,
                                           boolean includeUppercase, boolean includeSpecialChars) {
        StringBuilder pass = new StringBuilder();
        SecureRandom random = new SecureRandom();

        String numbers = "0123456789";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";

        String allChars = "";
        if (includeNumbers) allChars += numbers;
        if (includeLowercase) allChars += lowercaseLetters;
        if (includeUppercase) allChars += uppercaseLetters;
        if (includeSpecialChars) allChars += specialChars;

        if (allChars.isEmpty()) {
            System.out.println("No character type selected. Please include at least one character type.");
            System.exit(0);
        }

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allChars.length());
            pass.append(allChars.charAt(randomIndex));
        }

        return pass.toString();
    }
}
