import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DollarCalculatorTest {

    /**
     * MarketApu Mock 처리
     */
    @Mock
    public MarketApi marketApi;

    @BeforeEach
    public void init() {
        Mockito.lenient().when(marketApi.connect()).thenReturn(3000);
    }

    @Test
    public void testHello() {
        System.out.println("hello");
    }

    @Test
    public void dollarTest() {

        MarketApi marketApi = new MarketApi();
        DollarCalculator dollarCalculator = new DollarCalculator(marketApi);
        dollarCalculator.init();

        Calculator calculator1 = new Calculator(dollarCalculator);
        System.out.println(calculator1.sum(10,10));

        Assertions.assertEquals(22000, calculator1.sum(10,10));
        Assertions.assertEquals(0, calculator1.minus(10,10));
    }

    @Test
    public void mockTest() {

        DollarCalculator dollarCalculator = new DollarCalculator(marketApi);
        dollarCalculator.init();

        Calculator calculator1 = new Calculator(dollarCalculator);
        System.out.println(calculator1.sum(10,10));

        Assertions.assertEquals(60000, calculator1.sum(10,10));
        Assertions.assertEquals(0, calculator1.minus(10,10));
    }
}
