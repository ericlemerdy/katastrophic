package name.lemerdy.eric;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.google.common.base.Joiner.on;
import static java.lang.Integer.MIN_VALUE;
import static java.lang.String.format;

public class Inv3st_Plan {

    public static final int MONTH = 12;

    public String input(String input) {
        Scanner scanner = new Scanner(input);
        scanner.nextInt();
        List<String> bestProfitsByPlan = new ArrayList<>();
        int theCase = 0;
        while (scanner.hasNext()) {
            theCase++;
            int amount = scanner.nextInt();
            List<Integer> monthMarketPrices = new ArrayList<>();
            for (int i = 1; i <= MONTH; i++) {
                monthMarketPrices.add(scanner.nextInt());
            }
            bestProfitsByPlan.add(findBestProfitFor(theCase, amount, monthMarketPrices));
        }
        return on('\n').join(bestProfitsByPlan);
    }

    private String findBestProfitFor(int cases, int amount, List<Integer> mList) {
        int best_bM = MIN_VALUE;
        int best_sM = MIN_VALUE;
        int limitPrft = MIN_VALUE;
        int the_bal;
        for (int buyIndex = 1; buyIndex <= MONTH; buyIndex++) {
            for (int sellIndex = buyIndex + 1; sellIndex <= MONTH; sellIndex++) {
                int buyPrice = mList.get(buyIndex - 1);
                int sellPrice = mList.get(sellIndex - 1);
                int quantity = amount / buyPrice;
                the_bal = -quantity * buyPrice + quantity * sellPrice;
                if (the_bal > limitPrft) {
                    limitPrft = the_bal;
                    best_bM = buyIndex;
                    best_sM = sellIndex;
                }
            }
        }
        String bestPrft = format("Case #%d: ", cases);
        if (limitPrft <= 0) {
            bestPrft += "IMPOSSIBLE";
        } else {
            bestPrft += best_bM + " " + best_sM + " " + limitPrft;
        }
        return bestPrft;
    }
}
