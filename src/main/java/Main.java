import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Введите сумму кредита:");
        System.out.print(">> ");
        int loanAmount = input();
        System.out.println("Введите под какой процент берется кредит:");
        System.out.print(">> ");
        int percent = input();
        System.out.println("Введите на какой период берется кредит:");
        System.out.print(">> ");
        int period = input();

        CreditCalculator creditCalculator = new CreditCalculator(loanAmount, percent, period);

        System.out.println("Рассчет месячного платежа:");
        System.out.println(creditCalculator.monthlyPayment());
        System.out.println("Рассчет общей суммы к возврату в банк:");
        System.out.println(creditCalculator.totalAmountPayments());
        System.out.println("Рассчет переплаты за весь период:");
        System.out.println(creditCalculator.overpayment());
    }

    public static int input() {
        int number = 0;
        try {
            number = scanner.nextInt();
        } catch (Exception e) {
            System.out.println();
        }
        return number;
    }
}
