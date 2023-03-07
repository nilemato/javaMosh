import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal = (int) readNumber("Principal:", 1000,1000000);
        float annualInterest = (float) readNumber("Annual interest Rate: ",1,30);
        byte periodYears = (byte) readNumber("Period (Years): ", 1, 30);

        double mortgage = calculateMortgage(principal, annualInterest, periodYears);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("________");
        System.out.println("Monthly payments: " + mortgageFormatted);
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("________");
        for(short month = 1; month <= periodYears * MONTHS_IN_YEAR; month++){
            double balance = calculateBalance(principal,annualInterest,periodYears,month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));

        }


        System.out.println("Mortgage: " + mortgageFormatted);
    }

    public static double calculateMortgage (int principal,
                                            float annualInterest,
                                            byte years){
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);
        float monthlyInterest = annualInterest/ PERCENT/ MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments)-1);

        return mortgage;
    }

    public static double calculateBalance(
            int principal,
            float annualInterest,
            byte years,
            short numbersOfPaymentsMade
    ){
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);
        float monthlyInterest = annualInterest/ PERCENT/ MONTHS_IN_YEAR;

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numbersOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }

    public static double readNumber (String prompt, double min, double max){
        Scanner scanner = new Scanner(System.in);
        double value;
        while(true){
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value > min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max + " :");
        }
        return value;
    }

}