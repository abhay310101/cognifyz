import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Level02_Task03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose operation (1 for encryption, 2 for decryption): ");
        int choice = scanner.nextInt();

        System.out.print("Enter the input file name or path: ");
        String inputFileName = scanner.next();

        System.out.print("Enter the output file name: ");
        String outputFileName = scanner.next();

        try {
            if (choice == 1) {
                encryptFile(inputFileName, outputFileName);
                System.out.println("Encryption successful. Result saved to " + outputFileName);
            } else if (choice == 2) {
                decryptFile(inputFileName, outputFileName);
                System.out.println("Decryption successful. Result saved to " + outputFileName);
            } else {
                System.out.println("Invalid choice. Please choose 1 for encryption or 2 for decryption.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void encryptFile(String inputFileName, String outputFileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String encryptedLine = encrypt(line);
                writer.write(encryptedLine);
                writer.newLine();
            }
        }
    }

    private static void decryptFile(String inputFileName, String outputFileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String decryptedLine = decrypt(line);
                writer.write(decryptedLine);
                writer.newLine();
            }
        }
    }

    private static String encrypt(String text) {
        // Simple encryption algorithm (for demonstration purposes)
        StringBuilder encryptedText = new StringBuilder();
        for (char ch : text.toCharArray()) {
            encryptedText.append((char) (ch + 1));
        }
        return encryptedText.toString();
    }

    private static String decrypt(String text) {
        // Simple decryption algorithm (for demonstration purposes)
        StringBuilder decryptedText = new StringBuilder();
        for (char ch : text.toCharArray()) {
            decryptedText.append((char) (ch - 1));
        }
        return decryptedText.toString();
    }
}
