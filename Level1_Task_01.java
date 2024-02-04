import java.util.Scanner;

public class Level1_Task_01 {

// Method to convert Celsius to Fahrenheit
private static double celsiusToFahrenheit(double celsius) {
    return (celsius * 9 / 5) + 32;
}

// Method to convert Fahrenheit to Celsius
private static double fahrenheitToCelsius(double fahrenheit) {
    return (fahrenheit - 32) * 5 / 9;
}



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter temperature and unit
        System.out.print("Enter temperature value: ");
        double temperature = scanner.nextDouble();
        System.out.print("Enter unit of measurement (C for Celsius, F for Fahrenheit): ");
        char unit = scanner.next().charAt(0);

        // Perform conversion and display result
        double convertedTemperature;
        if (unit == 'C' || unit == 'c') {
            convertedTemperature = celsiusToFahrenheit(temperature);
            System.out.println(temperature + " Celsius is equal to " + convertedTemperature + " Fahrenheit.");
        } else if (unit == 'F' || unit == 'f') {
            convertedTemperature = fahrenheitToCelsius(temperature);
            System.out.println(temperature + " Fahrenheit is equal to " + convertedTemperature + " Celsius.");
        } else {
            System.out.println("Invalid unit of measurement. Please enter 'C' or 'F'.");
        }

        scanner.close();
    }

    
}
