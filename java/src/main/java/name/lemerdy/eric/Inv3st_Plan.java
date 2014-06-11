package name.lemerdy.eric;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.google.common.base.Joiner.on;
import static java.lang.Integer.MIN_VALUE;
import static java.lang.String.format;

public class Inv3st_Plan {
    public static final int MAX_HOURS = 12;

    public static String input(String input) {
        List<String> allowingPrfts1 = new ArrayList<>();
        Scanner scanner = new Scanner(input);
        scanner.nextInt();
        int theCase = 0;
        while (scanner.hasNext()) {
            theCase++;
            int amount = scanner.nextInt();
            List<Integer> mList = new ArrayList();
            for (int i = 1; i <= 12; i++) {
                mList.add(scanner.nextInt());
            }
            String bestPrft = findBestProfitFor(amount, mList);
            allowingPrfts1.add(format("Case #%d: %s", theCase, bestPrft));
        }
        return on("\n").join(allowingPrfts1);
    }

    private static String findBestProfitFor(int amount, List<Integer> mList) {
        int limitPrft = MIN_VALUE;
        int best_bM = MIN_VALUE;
        int best_sM = MIN_VALUE;
        final List<Integer> plan1 = mList;
        for (int buyIndex = 1; buyIndex <= MAX_HOURS; buyIndex++) {
            for (int sellIndex = buyIndex + 1; sellIndex <= 12; sellIndex++) {
                int buyPrice = plan1.get(buyIndex - 1);
                int sellPrice = plan1.get(sellIndex - 1);
                int quantity = amount / buyPrice;
                int the_bal = -quantity * buyPrice + quantity * sellPrice;
                if (the_bal > limitPrft) {
                    limitPrft = the_bal;
                    best_bM = buyIndex;
                    best_sM = sellIndex;
                }
            }
        }
        String bestPrft;
        if (limitPrft <= 0) {
            bestPrft = "IMPOSSIBLE";
        } else {
            bestPrft = best_bM + " " + best_sM + " " + limitPrft;
        }
        return bestPrft;
    }
}
