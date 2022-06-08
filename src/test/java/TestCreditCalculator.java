import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;

public class TestCreditCalculator {

    private final int LOAN_AMOUNT = 100_000;
    private final int PERCENT = 12;
    private final int PERIOD = 12;

    private CreditCalculator creditCalculator;
    private double monthlyPayment;

    @BeforeEach
    public void init() {
        System.out.println("Тесты запущенны");
        creditCalculator = new CreditCalculator(LOAN_AMOUNT, PERCENT, PERIOD);
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

        double rateOneMonth = PERCENT * 0.01 / 12;
        monthlyPayment = (double) LOAN_AMOUNT * (rateOneMonth + (rateOneMonth / (1 + rateOneMonth) * PERIOD));
        double expected = Math.ceil(monthlyPayment);

        double result = creditCalculator.monthlyPayment();

        MatcherAssert.assertThat(result, Matchers.equalTo(expected));
    }

    @Test
    public void testTotalAmountPayments() {

        double expected = monthlyPayment * PERIOD;

        double result = creditCalculator.totalAmountPayments();

        MatcherAssert.assertThat(result, Matchers.equalTo(expected));
    }

    @Test
    public void testOverpayment() {

        double expected = monthlyPayment * PERIOD - LOAN_AMOUNT;

        double result = creditCalculator.overpayment();

        MatcherAssert.assertThat(result, Matchers.equalTo(expected));
    }
}
