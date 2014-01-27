package name.lemerdy.eric;

import java.util.List;

import static java.lang.Integer.MIN_VALUE;
import static java.util.Arrays.asList;

public class Investment {
    private final int amount;
    private List<Integer> commodityPriceForecast;
    private final int buyMonth;
    private final int sellMonth;

    public Investment(int amount, List<Integer> commodityPriceForecast, int buyMonth, int sellMonth) {
        this.amount = amount;
        this.commodityPriceForecast = commodityPriceForecast;
        this.buyMonth = buyMonth;
        this.sellMonth = sellMonth;
    }

    public static Investment withAmount(int amount) {
        return new Investment(amount, null, 0, 0);
    }

    public Investment andPlan(List<Integer> months) {
        return new Investment(amount, months, buyMonth, sellMonth);
    }

    public Investment ifBuyIn(int buyMonth) {
        return new Investment(amount, commodityPriceForecast, buyMonth, sellMonth);
    }

    public Investment andSellIn(int sellMonth) {
        return new Investment(amount, commodityPriceForecast, buyMonth, sellMonth);
    }

    public Integer getProfit() {
        if (buyMonth >= sellMonth) {
            return null;
        }
        Integer buyPrice = commodityPriceForecast.get(buyMonth - 1);
        Integer quantity = amount / buyPrice;
        Integer balance = -quantity * buyPrice;
        Integer sellPrice = commodityPriceForecast.get(sellMonth - 1);
        Integer sellRevenue = quantity * sellPrice;
        balance += sellRevenue;
        return balance;
    }

    public String getBestProfit() {
        Integer bestBuyMonth = MIN_VALUE;
        Integer bestSellMonth = MIN_VALUE;
        Integer maxProfit = MIN_VALUE;
        for (int i = 1; i <= 12; i++) {
            for (int j = 1; j <= 12; j++) {
                Integer currentProfit = ifBuyIn(i).andSellIn(j).getProfit();
                if (currentProfit != null && currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                    bestBuyMonth = i;
                    bestSellMonth = j;
                }
            }
        }
        if (maxProfit <= 0) {
            return "IMPOSSIBLE";
        }
        return bestBuyMonth + " " + bestSellMonth + " " + maxProfit;
    }
}