package name.lemerdy.eric;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.google.common.base.Joiner.on;
import static java.lang.String.format;

public class Inv3st_Plan {

    public static String input(String input) {
        Scanner scanner = new Scanner(input);
        scanner.nextInt();
        List<String> calculs = new ArrayList<String>();
        int theCase = 0;
        while (scanner.hasNext()) {
            theCase++;
            int amount = scanner.nextInt();
            List<Integer> mList = new ArrayList();
            for (int i = 1; i <= 12; i++) {
                mList.add(scanner.nextInt());
            }
            calculs.add(format("Case #%d: %s", theCase, calcul(amount, mList)));
        }
        return on('\n').join(calculs);
    }

    private static String calcul(int amount, List<Integer> pricesByMonth) {
        Integer bestBuyHour = Integer.MIN_VALUE;
        Integer bestSellHour = Integer.MIN_VALUE;
        Integer limitPrft = Integer.MIN_VALUE;
        Integer balance;
        for (int buyIndex = 1; buyIndex <= 12; buyIndex++) {
            for (int sellIndex = buyIndex + 1; sellIndex <= 12; sellIndex++) {
                int buyPrixx = pricesByMonth.get(buyIndex - 1);
                int sellPrixx = pricesByMonth.get(sellIndex - 1);
                int quantity = amount / buyPrixx;
                balance = quantity * sellPrixx - quantity * buyPrixx;
                if (balance > limitPrft) {
                    limitPrft = balance;
                    bestBuyHour = buyIndex;
                    bestSellHour = sellIndex;
                }
            }
        }
        if (limitPrft <= 0) {
            return "IMPOSSIBLE";
        }
        return format("%d %d %d", bestBuyHour, bestSellHour, limitPrft);
    }

}
