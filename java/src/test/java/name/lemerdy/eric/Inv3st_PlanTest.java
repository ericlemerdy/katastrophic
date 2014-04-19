package name.lemerdy.eric;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Inv3st_PlanTest {

    @Test
    public void should_start() {
        assertThat(Inv3st_Plan.input("42 666 1 2 3 4 5 6 7 8 9 10 11 12")
                ).isEqualTo("Case #1: 1 12 7326");
    }
    @Test
    public void should_test_with_random_values() {
        assertThat(Inv3st_Plan.input("3\n" +
                "100\n" +
                "1 2 3 4 5 6 7 8 9 10 11 12\n" +
                "100\n" +
                "52 50 25 100 61 63 70 51 71 55 10 5\n" +
                "100\n" +
                "200 150 250 132 125 110 210 220 180 176 108 113")).isEqualTo("Case #1: 1 12 1100\n" +
                "Case #2: 3 4 300\n" +
                "Case #3: IMPOSSIBLE");
    }

    @Test
    public void should_be_impossible() {
        assertThat(Inv3st_Plan.input("42 666 12 11 10 9 8 7 6 5 4 3 2 1")
                ).isEqualTo("Case #1: IMPOSSIBLE");
    }

    @Test
    public void should_be_accept_several_integer_list_of_twelve() {
        assertThat(Inv3st_Plan.input("42 666 12 11 10 9 8 7 6 5 4 3 2 1 666 12 11 10 9 8 7 6 5 4 3 2 1")
                ).isEqualTo("Case #1: IMPOSSIBLE\nCase #2: IMPOSSIBLE");
    }
}
