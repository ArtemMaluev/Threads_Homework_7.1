public class CreditCalculator {

    private final int loanAmount;
    private final int percent;
    private final int period;
    private double monthlyPayment;

    public CreditCalculator(int loanAmount, int percent, int period) {
        this.loanAmount = loanAmount;
        this.percent = percent;
        this.period = period;
    }

    public double monthlyPayment() {
        double rateOneMonth = percent * 0.01 / 12;
        monthlyPayment = (double) loanAmount * (rateOneMonth + (rateOneMonth / (1 + rateOneMonth) * period));

        return Math.ceil(monthlyPayment);
    }

    public double totalAmountPayments() {
        return Math.ceil(monthlyPayment * period);
    }

    public double overpayment() {
        return Math.ceil(monthlyPayment * period - loanAmount);
    }
}
