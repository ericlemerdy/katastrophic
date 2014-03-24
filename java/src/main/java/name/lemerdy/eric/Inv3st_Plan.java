package name.lemerdy.eric;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;

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
        List<String> profits = new ArrayList<>();
        int caseCount = 0;
        while (scanner.hasNext()) {
            caseCount++;
            int amount = scanner.nextInt();
            List<Integer> mList = new ArrayList();
            for (int i = 1; i <= 12; i++) {
                mList.add(scanner.nextInt());
            }
            int bestBuyMonth = 0;
            int bestSellMonth = 0;
            int maxProfit = 0;
            for (int i = 1; i <= 12; i++) {
                for (int j = i; j <= 12; j++) {
                    int buyPrice = mList.get(i - 1);
                    int sellPrice = mList.get(j - 1);
                    int quantity = amount / buyPrice;
                    int profit = - (quantity * buyPrice) + (quantity * sellPrice);
                    if (profit > maxProfit) {
                        maxProfit = profit;
                        bestBuyMonth = i;
                        bestSellMonth = j;
                    }
                }
            }
            if (maxProfit == 0) {
                profits.add(format("Case #%d: IMPOSSIBLE", caseCount));
            } else {
                profits.add(format("Case #%d: %d %d %d", caseCount, bestBuyMonth, bestSellMonth, maxProfit));
            }
        }
        return on('\n').join(profits);
    }
}
