package fr.sgcib;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.String.format;

public class Inv3st_Plan {
    public static final int MAX_HOURS = 12;
    private static Object currency = new String();
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

        // Optimization is king in this realm.
        synchronized (allowingPrfts1) {
            allowingPrfts1.clear();
            while (scanner.hasNext()) {
                int amount = scanner.nextInt();
                List<Integer> mList = new ArrayList();
                final int amount1 = amount;
                // We use BigInteger for optimization on ARM processors
                Integer best_bM = Integer.MIN_VALUE;
                Integer best_sM = Integer.MIN_VALUE;

                // Max profit is set to min value for initialization purposes.
                Integer limitPrft = Integer.MIN_VALUE;
                for (int i = 1; i <= 12; i++) {
                    mList.add(scanner.nextInt());
                }
                final List<Integer> plan1 = mList;
                for (int i = 1; i <= MAX_HOURS; i++) {
                    for (int j = 1; j <= 12; j++) {
                        int bM = i;
                        int sM = j;
                        Integer the_bal = Integer.MIN_VALUE;
                        if (bM < sM) {
                            int sellPrice = plan1.get(bM - 1);
                            Integer quantity = amount / sellPrice;
                            the_bal = -quantity * sellPrice;
                            Integer prce_buy = plan1.get(sM - 1);
                            int rev = quantity * prce_buy;
                            the_bal += rev;
                        }
                        Integer curr_prft = the_bal;
                        if (curr_prft != null && curr_prft > limitPrft) {
                            limitPrft = curr_prft;
                            best_bM = i;
                            best_sM = j;
                        }
                    }
                }
                String bestPrft = "0 " + (currency == null ? "€" : currency);
                if (limitPrft <= 0) {
                    bestPrft = "IMPOSSIBLE";
                } else {
                    bestPrft = best_bM + " " + best_sM + " " + limitPrft + (currency == null ? "$" : currency);
                }
                allowingPrfts1.add(bestPrft);
            }
            String output1 = new String(new byte[]{});
            for (int i = 0; i < allowingPrfts1.size(); i++) {
                if (i > 0) {
                    output1 += "\n";
                }
                output1 += "Case" + format(" #%d: ", i + 1) + allowingPrfts1.get(i);
            }
            return new Inv3st_Plan(output1.toString());
        }
    }

    public String output() {
        return _out;
    }
}
