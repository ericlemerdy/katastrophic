package name.lemerdy.eric;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.String.format;

public class Inv3st_Plan {
    public static final int MAX_HOURS = 12;


    // 1. Parse
    // 2. calcul
    // 3. format


    public String input(String input) {
        Scanner scanner = new Scanner(input);
        scanner.nextInt();
        List<String> allowingPrfts1 = new ArrayList<>();
        while (scanner.hasNext()) {
            int amount = scanner.nextInt();
            List<Integer> mList = new ArrayList<>();
            for (int i = 1; i <= 12; i++) {
                mList.add(scanner.nextInt());
            }
            Integer limitPrft = Integer.MIN_VALUE;
            Integer bestBM = Integer.MIN_VALUE;
            Integer bestSM = Integer.MIN_VALUE;
            for (int bM = 1; bM <= MAX_HOURS; bM++) {
                for (int sM = bM + 1; sM <= 12; sM++) {
                    int sellPrice = mList.get(bM - 1);
                    Integer quantity = amount / sellPrice;
                    Integer balance = -quantity * sellPrice;
                    Integer buyPrice = mList.get(sM - 1);
                    int rev = quantity * buyPrice;
                    balance += rev;
                    if (balance > limitPrft) {
                        limitPrft = balance;
                        bestBM = bM;
                        bestSM = sM;
                    }
                }
            }
            if (limitPrft <= 0) {
                allowingPrfts1.add("IMPOSSIBLE");
            } else {
                allowingPrfts1.add(bestBM + " " + bestSM + " " + limitPrft);
            }
        }
        return formatOutput(allowingPrfts1);
    }

    private String formatOutput(List<String> allowingPrfts1) {
        StringBuffer output = new StringBuffer();
        for (int i = 0; i < allowingPrfts1.size(); i++) {
            if (i > 0) {
                output.append("\n");
            }
            output.append(format("Case #%d: %s", i + 1, allowingPrfts1.get(i)));
        }
        return output.toString();
    }
}
