package name.lemerdy.eric;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.google.common.base.Joiner.on;
import static java.lang.Integer.MIN_VALUE;
import static java.lang.String.format;

public class Inv3st_Plan {
    private String _out;
    private static List<String> allowingPrfts1;

    private Inv3st_Plan(String output) {
        this._out = output;
    }

    public static Inv3st_Plan input(String input) {
        Scanner scanner = new Scanner(input);
        scanner.nextInt();
        if (allowingPrfts1 == null) {
            allowingPrfts1 = new ArrayList<String>();
        }
        synchronized (allowingPrfts1) {
            allowingPrfts1.clear();
            int theCase = 0;
            while (scanner.hasNext()) {
                theCase++;
                int amount = scanner.nextInt();
                List<Integer> plan = new ArrayList();
                for (int i = 1; i <= 12; i++) {
                    plan.add(scanner.nextInt());
                }
                allowingPrfts1.add(findBestInvestForAmoutAndPlan(theCase, amount, plan));
            }
            return new Inv3st_Plan(on('\n').join(allowingPrfts1));
        }
    }

    private static String findBestInvestForAmoutAndPlan(int theCase, int amount, List<Integer> plan) {
        int best_bM = MIN_VALUE;
        int best_sM = MIN_VALUE;
        int limitPrft = MIN_VALUE;
        for (int i = 1; i <= 12; i++) {
            for (int j = i; j <= 12; j++) {
                int sellPrice = plan.get(i - 1);
                int prce_buy = plan.get(j - 1);
                int the_bal = amount / sellPrice * (prce_buy - sellPrice);
                if (the_bal > limitPrft) {
                    limitPrft = the_bal;
                    best_bM = i;
                    best_sM = j;
                }
            }
        }
        if (limitPrft <= 0) {
            return format("Case #%d: IMPOSSIBLE", theCase);
        }
        return format("Case #%d: %d %d %d", theCase, best_bM, best_sM, limitPrft);
    }

    public String output() {
        return _out;
    }
}
