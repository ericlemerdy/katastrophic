package name.lemerdy.eric;

import org.junit.Test;
import org.junit.experimental.theories.Theory;

import java.util.Random;

import static name.lemerdy.eric.Inv3st_Plan.input;
import static org.assertj.core.api.Assertions.assertThat;

public class Inv3st_PlanTest {

    @Test
    public void should_return_empty_string_for_single_integer() {
        assertThat(input("42").output()).isEqualTo("");
    }

    @Test
    public void should_return_a_case_for_large_random_case() {
        Random random = new Random(42);
        StringBuilder input = new StringBuilder("0 ");
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 13; j++) {
                input.append(random.nextInt());
                input.append(" ");
            }
        }
        assertThat(input(input.toString()).output()).isEqualTo("Case #1: 1 2 2086354008\n" +
                "Case #2: 1 4 2088823388\n" +
                "Case #3: 5 8 2094474921\n" +
                "Case #4: 4 5 2144120132\n" +
                "Case #5: 1 2 2121974128\n" +
                "Case #6: 3 6 2146534748\n" +
                "Case #7: 3 7 2131800001\n" +
                "Case #8: 2 5 2057897427\n" +
                "Case #9: 8 12 2099372130\n" +
                "Case #10: 10 12 2130262957\n" +
                "Case #11: 2 5 2106465860\n" +
                "Case #12: 6 12 1925298181\n" +
                "Case #13: 1 10 2115478514\n" +
                "Case #14: 6 12 2140306340\n" +
                "Case #15: 1 9 2122015761\n" +
                "Case #16: 1 4 2128843467\n" +
                "Case #17: 1 9 1784833901\n" +
                "Case #18: 2 10 1698717149\n" +
                "Case #19: 4 7 2008286760\n" +
                "Case #20: 10 11 1477759696\n" +
                "Case #21: 8 10 1715077609\n" +
                "Case #22: 4 12 1323897434\n" +
                "Case #23: 2 7 2137226481\n" +
                "Case #24: 4 6 2052229744\n" +
                "Case #25: 4 6 2056324699\n" +
                "Case #26: 8 11 1977636928\n" +
                "Case #27: 4 7 2099756259\n" +
                "Case #28: IMPOSSIBLE\n" +
                "Case #29: 7 9 2125135848\n" +
                "Case #30: 1 9 2115042602\n" +
                "Case #31: IMPOSSIBLE\n" +
                "Case #32: 6 12 1934504798\n" +
                "Case #33: 6 12 2120807178\n" +
                "Case #34: 1 5 2121193737\n" +
                "Case #35: 1 11 2124071963\n" +
                "Case #36: 6 9 1750571578\n" +
                "Case #37: 10 11 1682919382\n" +
                "Case #38: 2 3 2126721001\n" +
                "Case #39: 7 11 1586752585\n" +
                "Case #40: IMPOSSIBLE\n" +
                "Case #41: 1 4 2134655502\n" +
                "Case #42: 3 5 1894434754\n" +
                "Case #43: 2 4 2085590896\n" +
                "Case #44: 1 9 2112974382\n" +
                "Case #45: 8 12 2023927607\n" +
                "Case #46: 8 10 1450201294\n" +
                "Case #47: 3 7 2058198648\n" +
                "Case #48: 2 9 2144885140\n" +
                "Case #49: 9 12 2044599745\n" +
                "Case #50: 3 10 2106886474\n" +
                "Case #51: 2 11 2092338592\n" +
                "Case #52: 2 4 1620259655\n" +
                "Case #53: 6 7 2099944779\n" +
                "Case #54: IMPOSSIBLE\n" +
                "Case #55: 1 7 2075440719\n" +
                "Case #56: 3 8 2062378904\n" +
                "Case #57: 1 6 1953007509\n" +
                "Case #58: 5 9 2140061585\n" +
                "Case #59: 8 12 962640512\n" +
                "Case #60: 2 8 1979363427\n" +
                "Case #61: 1 12 1694851643\n" +
                "Case #62: 1 5 1612769323\n" +
                "Case #63: 7 12 1700321112\n" +
                "Case #64: 7 9 1955184627\n" +
                "Case #65: 4 11 1940325908\n" +
                "Case #66: 5 6 2139065698\n" +
                "Case #67: 3 10 1864446408\n" +
                "Case #68: 1 11 2071613687\n" +
                "Case #69: 8 11 2035388266\n" +
                "Case #70: IMPOSSIBLE\n" +
                "Case #71: 3 6 2038637640\n" +
                "Case #72: 1 12 2139391815\n" +
                "Case #73: 2 5 1736188587\n" +
                "Case #74: 4 11 2004072678\n" +
                "Case #75: 8 9 2143321987\n" +
                "Case #76: IMPOSSIBLE\n" +
                "Case #77: 2 10 2082595502\n" +
                "Case #78: 1 5 2029510584\n" +
                "Case #79: IMPOSSIBLE\n" +
                "Case #80: 2 4 2106163760\n" +
                "Case #81: 2 7 2047814374\n" +
                "Case #82: 2 11 1986608924\n" +
                "Case #83: 5 11 1853580067\n" +
                "Case #84: IMPOSSIBLE\n" +
                "Case #85: 11 12 2070958472\n" +
                "Case #86: 1 9 2099625994\n" +
                "Case #87: 1 11 1938278760\n" +
                "Case #88: 1 3 1875623574\n" +
                "Case #89: 3 12 1889035423\n" +
                "Case #90: 1 3 1689781967\n" +
                "Case #91: 5 9 2089849281\n" +
                "Case #92: 4 8 1945190406\n" +
                "Case #93: 6 9 2123889936\n" +
                "Case #94: IMPOSSIBLE\n" +
                "Case #95: 11 12 1544893015\n" +
                "Case #96: 4 7 2101038921\n" +
                "Case #97: 7 12 2090779253\n" +
                "Case #98: 10 12 2077683894\n" +
                "Case #99: 5 11 1555300357\n" +
                "Case #100: 5 6 1786735668");
    }

    @Test
    public void should_return_a_case_for_integer_and_single_integer_and_twelve_integer() {
        assertThat(input("10 10 1 2 3 4 5 6 7 8 9 10 11 12\n" +
                "5 5 10 15 20 25 30 35 40 45 50 55 60\n" +
                "0 5 5 5 5 5 5 5 5 5 5 5 5").output()).isEqualTo("Case #1: 1 12 110\n" +
                "Case #2: 1 12 55\n" +
                "Case #3: IMPOSSIBLE");
    }
}
