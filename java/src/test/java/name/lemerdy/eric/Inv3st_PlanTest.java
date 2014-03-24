package name.lemerdy.eric;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Inv3st_PlanTest {
    @Test
    public void should_start() {
        assertThat(new Inv3st_Plan().run("0 " +
                "10 1 2 3 4 5 6 7 8 9 10 11 12 " +
                "10 12 11 10 9 8 7 6 5 4 3 2 1")).isEqualTo("Case #1: 1 12 110\n" +
                "Case #2: IMPOSSIBLE");
    }
}
