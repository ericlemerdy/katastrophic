package name.lemerdy.eric;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.google.common.base.Joiner.on;
import static java.lang.Integer.MIN_VALUE;
import static java.lang.String.format;

public class Inv3st_Plan {

    public static String input(String input) {
        Scanner scanner = new Scanner(input);
        scanner.nextInt();
        List<String> profits = new ArrayList<>();
        int caseCount = 0;
        while (scanner.hasNext()) {
            caseCount++;
            int amount = scanner.nextInt();
            List<Integer> prices = new ArrayList();
            for (int i = 1; i <= 12; i++) {
                prices.add(scanner.nextInt());
            }
            try {
                profits.add(format("Case #%d: %s", caseCount, bestProfit(amount, prices)));
            } catch (IllegalArgumentException e) {
                profits.add(format("Case #%d: IMPOSSIBLE",caseCount));
            }
        }
        return on('\n').join(profits);
    }

    private static Profit bestProfit(int amount, List<Integer> prices) {
        Integer bestBuyIndex = MIN_VALUE;
        Integer bestSellIndex = MIN_VALUE;
        Integer maxProfit = MIN_VALUE;
        for (int buyIndex = 0; buyIndex <= 11; buyIndex++) {
            int buyPrice = prices.get(buyIndex);
            int quantity = amount / buyPrice;
            for (int sellIndex = buyIndex + 1; sellIndex <= 11; sellIndex++) {
                int sellPrice = prices.get(sellIndex);
                int profit = (-quantity * buyPrice) + (quantity * sellPrice);
                if (profit > maxProfit) {
                    maxProfit = profit;
                    bestBuyIndex = buyIndex + 1;
                    bestSellIndex = sellIndex + 1;
                } else if (profit == maxProfit) {
                    System.out.println("Hello Michelin !");
                }
            }
        }
        if (maxProfit <= 0) {
            throw new IllegalArgumentException();
        }
        return new Profit(bestBuyIndex, bestSellIndex, maxProfit);
    }
}
