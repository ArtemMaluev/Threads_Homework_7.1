import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;

public class TestCreditCalculator {

    private final int LOAN_AMOUNT = 100_000;
    private final int PERCENT = 12;
    private final int PERIOD = 12;

    private double monthlyPayment;

    @BeforeEach
    public void init() {
        System.out.println("Тесты запущенны");
    }

    @BeforeAll
    public static void started() {
        System.out.println("Старт теста");
    }

    @AfterEach
    public void finished() {
        System.out.println("Окончание теста");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("Тесты завершенны");
    }

    @Test
    public void testMonthlyPayment() {
        CreditCalculator creditCalculator = new CreditCalculator();

        double rateOneMonth = PERCENT * 0.01 / 12;
        monthlyPayment = (double) LOAN_AMOUNT * (rateOneMonth + (rateOneMonth / (1 + rateOneMonth) * PERIOD - 1));
        double expected = monthlyPayment;

        double result = creditCalculator.monthlyPayment();

        MatcherAssert.assertThat(result, Matchers.equalTo(expected));
    }

    @Test
    public void testTotalAmountPayments() {
        CreditCalculator creditCalculator = new CreditCalculator();

        double expected = monthlyPayment * PERIOD;

        double result = creditCalculator.totalAmountPayments();

        MatcherAssert.assertThat(result, Matchers.equalTo(expected));
    }

    @Test
    public void testOverpayment() {
        CreditCalculator creditCalculator = new CreditCalculator();

        double expected = monthlyPayment * PERIOD - LOAN_AMOUNT;

        double result = creditCalculator.overpayment();

        MatcherAssert.assertThat(result, Matchers.equalTo(expected));
    }
}
