package name.lemerdy.eric;

import org.junit.Test;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static java.lang.String.format;

public class Inv3st_PlanTest {

    private Inv3st_Plan inv3st_plan = new Inv3st_Plan();

    @Test(expected = NullPointerException.class)
    public void with_null_should_fail() {
        inv3st_plan.input(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void with_empty_string_should_fail() throws Exception {
        inv3st_plan.input("");
    }

    @Test(expected = InputMismatchException.class)
    public void with_foo_should_fail() throws Exception {
        inv3st_plan.input("foo");
    }

    @Test
    public void with_integer_should_be_empty() throws Exception {
        assertThat(inv3st_plan.input("42")).isEmpty();
    }

    @Test(expected = ArithmeticException.class)
    public void with_amount_42_and_first_element_zero_should_fail() throws Exception {
        int amount = 42;
        String amounts = "0 1 2 3 4 5 6 7 8 9 10 11";
        inv3st_plan.input(format("42 %s %s", amount, amounts));
    }

    @Test
    public void with_amount_42_and_amounts_from_1_to_12_should_print_strange_case_1() throws Exception {
        int amount = 42;
        String amounts = "1 2 3 4 5 6 7 8 9 10 11 12";
        assertThat(inv3st_plan.input(format("42 %s %s", amount, amounts))).isEqualTo("Case #1: 1 12 462");
    }

    @Test
    public void with_amount_42_and_two_amount_list_should_print_case_1_and_2() throws Exception {
        int amount = 42;
        String amounts = "1 2 3 4 5 6 7 8 9 10 11 12";
        assertThat(inv3st_plan.input(format("42 %d %s %d %s", amount, amounts, amount, amounts)))
                .isEqualTo("Case #1: 1 12 462\n" +
                        "Case #2: 1 12 462");
    }

    @Test
    public void with_amount_42_and_amounts_decreasing_should_print_impossible() throws Exception {
        int amount = 42;
        String amounts = "12 11 10 9 8 7 6 5 4 3 2 1";
        assertThat(inv3st_plan.input(format("42 %s %s", amount, amounts))).isEqualTo("Case #1: IMPOSSIBLE");
    }
}