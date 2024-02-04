
import java.util.Scanner;
public class Level1_Task_03 {
    
    public static void main(String [] args){
        Scanner Sc = new Scanner(System.in);
        System.out.println("How Many Grand Enter :");
        int Grade =Sc.nextInt();

        if (Grade <=0){
            System.out.println("Negative Value Or Grade Not Allowed please Enter Positvie Number  ");
        }

        double[] grade = new double[Grade];

        for (int i =0; i < Grade;i++){
            System.out.println("Enter the Grade #" + (i +1) + ":");
            grade[i] = Sc.nextDouble();

        }
        double total=0;
        for (double grades:grade){
            total+=grades;
        }
        double average =total/Grade;

        System.out.println("The average grade is :"+average);

        Sc.close();
    }

}
