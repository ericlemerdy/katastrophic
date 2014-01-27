package name.lemerdy.eric;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InvestTest {

    @Test
    public void acceptance() {
        assertThat(Invest.input("3\n" +
                "100\n" +
                "1 2 3 4 5 6 7 8 9 10 11 12\n" +
                "100\n" +
                "52 50 25 100 61 63 70 51 71 55 10 5\n" +
                "100\n" +
                "200 150 250 132 125 110 210 220 180 176 108 113").output(), is("Case #1: 1 12 1100\n" +
                "Case #2: 3 4 300\n" +
                "Case #3: IMPOSSIBLE"));
    }

    @Test
    public void with_amount_and_plan_should_calculate_profit() {
        assertThat(Investment.withAmount(100).andPlan(asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)).ifBuyIn(1).andSellIn(12).getProfit(), is(1100));
        assertThat(Investment.withAmount(100).andPlan(asList(52, 50, 25, 100, 61, 63, 70, 51, 71, 55, 10, 5)).ifBuyIn(3).andSellIn(4).getProfit(), is(300));
    }

    @Test
    public void with_amount_and_plan_should_calculate_all_profits() {
        assertThat(Investment.withAmount(100).andPlan(asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)).getBestProfit(), is("1 12 1100"));
        assertThat(Investment.withAmount(100).andPlan(asList(52, 50, 25, 100, 61, 63, 70, 51, 71, 55, 10, 5)).getBestProfit(), is("3 4 300"));
        assertThat(Investment.withAmount(100).andPlan(asList(200, 150, 250, 132, 125, 110, 210, 220, 180, 176, 108, 113)).getBestProfit(), is("IMPOSSIBLE"));
    }
}
