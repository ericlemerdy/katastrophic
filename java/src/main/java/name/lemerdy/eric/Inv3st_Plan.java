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
        List<String> allowingPrfts1 = new ArrayList<>();
        int caseCount = 0;
        while (scanner.hasNext()) {
            caseCount++;
            int amount = scanner.nextInt();
            List<Integer> mList = new ArrayList();
            for (int i = 1; i <= 12; i++) {
                mList.add(scanner.nextInt());
            }
            int best_bM = MIN_VALUE;
            int best_sM = MIN_VALUE;
            int limitPrft = MIN_VALUE;
            for (int i = 1; i <= 12; i++) {
                for (int j = 1; j <= 12; j++) {
                    if (i < j) {
                        int sellPrice = mList.get(i - 1);
                        int quantity = amount / sellPrice;
                        int the_bal = -quantity * sellPrice;
                        int prce_buy = mList.get(j - 1);
                        int rev = quantity * prce_buy;
                        the_bal += rev;
                        if (the_bal > limitPrft) {
                            limitPrft = the_bal;
                            best_bM = i;
                            best_sM = j;
                        }
                    }
                }
            }
            if (limitPrft <= 0) {
                allowingPrfts1.add(format("Case #%d: IMPOSSIBLE", caseCount));
            } else {
                allowingPrfts1.add(format("Case #%d: %d %d %d", caseCount, best_bM, best_sM, limitPrft));
            }
        }
        return on('\n').join(allowingPrfts1);
    }
}
