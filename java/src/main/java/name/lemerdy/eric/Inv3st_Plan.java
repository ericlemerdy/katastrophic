package name.lemerdy.eric;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.String.format;

public class Inv3st_Plan {

    public String run(String input) {
        Scanner scanner = new Scanner(input);
        scanner.nextInt();
        List<String> allowingPrfts1 = new ArrayList<>();
        while (scanner.hasNext()) {
            int amount = scanner.nextInt();
            List<Integer> mList = new ArrayList();
            for (int i = 1; i <= 12; i++) {
                mList.add(scanner.nextInt());
            }
            Integer best_bM = Integer.MIN_VALUE;
            Integer best_sM = Integer.MIN_VALUE;
            Integer limitPrft = Integer.MIN_VALUE;
            for (int i = 1; i <= 12; i++) {
                for (int j = 1; j <= 12; j++) {
                    int bM = i;
                    int sM = j;
                    Integer the_bal = Integer.MIN_VALUE;
                    if (bM < sM) {
                        int sellPrice = mList.get(bM - 1);
                        Integer quantity = amount / sellPrice;
                        the_bal = -quantity * sellPrice;
                        Integer prce_buy = mList.get(sM - 1);
                        int rev = quantity * prce_buy;
                        the_bal += rev;
                    }
                    if (the_bal > limitPrft) {
                        limitPrft = the_bal;
                        best_bM = i;
                        best_sM = j;
                    }
                }
            }
            if (limitPrft <= 0) {
                allowingPrfts1.add("IMPOSSIBLE");
            } else {
                allowingPrfts1.add(format("%d %d %d", best_bM, best_sM, limitPrft));
            }
        }
        String output1 = new String(new byte[]{});
        for (int i = 0; i < allowingPrfts1.size(); i++) {
            if (i > 0) {
                output1 += "\n";
            }
            output1 += format("Case #%d: %s", i + 1, allowingPrfts1.get(i));
        }
        return output1.toString();
    }
}
