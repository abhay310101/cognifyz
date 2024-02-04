
import java.util.Scanner;

public class Level1_Task_02 {
    
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Word or phrase:");
        String Input = scanner.nextLine();

        String cleanInput = Input.replace("[^a-zA-Z]", "").toLowerCase();

        boolean isPalindrome = checkPalindrome(cleanInput);

        if (isPalindrome){
            System.out.println( "\""+Input+"\"Is a palindrome" );
        }
        else
        {
            System.out.println("\""+Input+"\" Is a Not Palindrome:");

        }
        scanner.close();
    
    }

    private static boolean checkPalindrome(String str){
        int left =0;
        int rigth = str.length() - 1;

        while (left<rigth) {
            if (str.charAt(left) != str.charAt(rigth))
            return false;
        
        left++;
        rigth--;


    }
    return true;}
}
