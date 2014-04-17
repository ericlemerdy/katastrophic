package name.lemerdy.eric;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Inv3st_PlanTest {

    @Test
    public void should_start() {
        assertThat(Inv3st_Plan.input("42")).isEqualTo("");
        assertThat(Inv3st_Plan.input("42 " +
                "10 1 2 3 4 5 6 7 8 9 10 11 12 " +
                "100 2 3 4 5 6 7 8 9 10 11 12 13")).
                isEqualTo("Case #1: 1 12 110\n" +
                        "Case #2: 1 12 550");
        assertThat(Inv3st_Plan.input("42 10 12 11 10 9 8 7 6 5 4 3 2 1")).isEqualTo("Case #1: IMPOSSIBLE");
    }

}