package name.lemerdy.eric;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.google.common.base.Joiner.on;
import static java.lang.Integer.MIN_VALUE;
import static java.lang.String.format;

public class InvestmentPlan {

    public String bestPlanForAmountAndPriceList(String input) {
        List<String> bestProfits = new ArrayList<>();
        Scanner scanner = new Scanner(input);
        scanner.nextInt();
        int caseCount = 0;
        while (scanner.hasNext()) {
            caseCount++;
            int amount = scanner.nextInt();
            List<Integer> prices = new ArrayList();
            for (int i = 1; i <= 12; i++) {
                prices.add(scanner.nextInt());
            }
            bestProfits.add(format("Case #%d: %s", caseCount, bestInvestmentPlan(amount, prices)));
        }
        return on('\n').join(bestProfits);
    }

    private String bestInvestmentPlan(int amount, List<Integer> prices) {
        int best_bM = MIN_VALUE;
        int best_sM = MIN_VALUE;
        int maxProfit = MIN_VALUE;
        for (int buyIndex = 0; buyIndex <= 11; buyIndex++) {
            int buyPrice = prices.get(buyIndex);
            for (int sellIndex = buyIndex; sellIndex <= 11; sellIndex++) {
                int sellPrice = prices.get(sellIndex);
                int quantity = amount / buyPrice;
                int profit = (-quantity * buyPrice) + (quantity * sellPrice);
                if (profit > maxProfit) {
                    maxProfit = profit;
                    best_bM = buyIndex + 1;
                    best_sM = sellIndex + 1;
                }
            }
        }
        if (maxProfit <= 0) {
            return "IMPOSSIBLE";
        }
        return format("%s %s %s", best_bM, best_sM, maxProfit);
    }
}
