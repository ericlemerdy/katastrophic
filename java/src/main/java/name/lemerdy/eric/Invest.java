package name.lemerdy.eric;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.String.format;

public class Invest {
    private String output;

    private Invest(String output) {
        this.output = output;
    }

    public static Invest input(String input) {
        List<String> bestProfits = parseInputAndFillBestProfits(input);
        StringBuffer output = formatBestProfits(bestProfits);
        return new Invest(output.toString());
    }

    private static List<String> parseInputAndFillBestProfits(String input) {
        Scanner scanner = new Scanner(input);
        scanner.nextInt();
        List<String> bestProfits = new ArrayList<String>();
        while (scanner.hasNext()) {
            int amount = scanner.nextInt();
            List<Integer> months = new ArrayList();
            for (int i = 0; i < 12; i++) {
                months.add(scanner.nextInt());
            }
            bestProfits.add(Investment.withAmount(amount).andPlan(months).getBestProfit());
        }
        return bestProfits;
    }

    private static StringBuffer formatBestProfits(List<String> bestProfits) {
        StringBuffer output = new StringBuffer();
        for (int i = 0; i < bestProfits.size(); i++) {
            if (i > 0) {
                output.append("\n");
            }
            output.append(format("Case #%d: ", i + 1));
            output.append(bestProfits.get(i));
        }
        return output;
    }

    public String output() {
        return output;
    }
}
