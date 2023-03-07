//import java.text.NumberFormat;
//import java.util.Scanner;
//
//public class MortgageOld {
//    final byte MONTHS_IN_YEAR = 12;
//    final byte PERCENT = 100;
//
//        System.out.print("Principal: ");
//    Scanner scanner = new Scanner(System.in);
//    int principal = scanner.nextInt();
//
//        System.out.print("Annual interest Rate: ");
//    float annualInterestRate = scanner.nextFloat();
//    float monthlyRate = annualInterestRate / PERCENT/ MONTHS_IN_YEAR;
//
//        System.out.print("Period (Years): ");
//    byte periodYears = scanner.nextByte();
//    int numberOfPayments = periodYears * MONTHS_IN_YEAR;
//
//    double mortgage = principal
//            * (monthlyRate * Math.pow(1 + monthlyRate, numberOfPayments))
//            / (Math.pow(1 + monthlyRate, numberOfPayments)-1);
//
//    String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
//
//        System.out.println("Mortgage: " + mortgageFormatted);
//
//}
