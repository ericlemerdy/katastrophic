package name.lemerdy.eric;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

public class InestPlanTest {

    @Test(expected = NullPointerException.class)
    public void with_null_invest_plan_should_fail() throws Exception {
        Inv3st_Plan.input(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void with_empty_string_invest_plan_should_fail() throws Exception {
        Inv3st_Plan.input("");
    }

    @Test()
    public void with_integer_invest_plan_should_return_empty_string() throws Exception {
        String input = Inv3st_Plan.input("42");
        assertThat(input).isEmpty();
    }

    @Test(expected = ArithmeticException.class)
    public void with_integer_and_amount_and_list_startwith_zero_invest_plan_should_fail() throws Exception {
        int amount = 66;
        String input = Inv3st_Plan.input("42 " + amount + " 0 1 2 3 4 5 6 7 8 9 10 11");
        assertThat(input).isEmpty();
    }

    @Test
    public void with_integer_and_amount_and_list_invest_plan_should_return_case_id_and_3_integer() throws Exception {
        int amount = 66;
        String input = Inv3st_Plan.input("42 " + amount + " 1 2 3 4 5 6 7 8 9 10 11 12");
        assertThat(input).isEqualTo("Case #1: 1 12 726");
    }

    @Test
    public void with_integer_and_amount_and_inverted_list_invest_plan_should_return_case_id_and_3_integer_() throws Exception {
        int amount = 66;
        String input = Inv3st_Plan.input("42 " + amount + " 12 11 10 9 8 7 6 5 4 3 2 1");
        assertThat(input).isEqualTo("Case #1: IMPOSSIBLE");
    }

    @Test
    public void with_integer_and_2_amounts_and_2_list_invest_plan_should_return_case_id_and_3_integer() throws Exception {
        int amount = 66;
        String input = Inv3st_Plan.input("42 "
                + amount + " 1 2 3 4 5 6 7 8 9 10 11 12 "
                + amount + " 1 2 3 4 5 6 7 8 9 10 11 12");
        assertThat(input).isEqualTo("Case #1: 1 12 726\n" +
                "Case #2: 1 12 726");
    }
}
