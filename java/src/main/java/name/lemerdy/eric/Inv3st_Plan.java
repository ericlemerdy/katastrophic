package name.lemerdy.eric;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.google.common.base.Joiner.on;
import static java.lang.Integer.MIN_VALUE;
import static java.lang.String.format;

public class Inv3st_Plan {

    public String run(String input) {
        Scanner scanner = new Scanner(input);
        scanner.nextInt();
        List<String> bestProfits = new ArrayList<>();
        int count = 0;
        while (scanner.hasNext()) {
            count++;
            int amount = scanner.nextInt();
            List<Integer> pricesPlan = new ArrayList();
            for (int i = 1; i <= 12; i++) {
                pricesPlan.add(scanner.nextInt());
            }
            bestProfits.add(bestProfit(count, amount, pricesPlan));
        }
        return on('\n').join(bestProfits);
    }

    private String bestProfit(int count, int amount, List<Integer> pricesPlan) {
        int bestBuyMonth = 0;
        int bestSellMonth = 0;
        int maxProfit = MIN_VALUE;
        for (int i = 0; i <= 11; i++) {
            for (int j = i; j <= 11; j++) {
                int buyPrice = pricesPlan.get(i);
                int sellPrice = pricesPlan.get(j);
                int quantity = amount / buyPrice;
                int profit = -quantity * buyPrice + quantity * sellPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                    bestBuyMonth = i + 1;
                    bestSellMonth = j + 1;
                }
            }
        }
        String bestProfit;
        if (maxProfit <= 0) {
            bestProfit = format("Case #%d: %s", count, "IMPOSSIBLE");
        } else {
            bestProfit = format("Case #%d: %d %d %d", count, bestBuyMonth , bestSellMonth, maxProfit);
        }
        return bestProfit;
    }
}
