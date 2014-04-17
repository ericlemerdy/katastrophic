package name.lemerdy.eric;

import static java.lang.String.format;

public class Profit {
    private final Integer bestBuyIndex;
    private final Integer bestSellIndex;
    private final Integer maxProfit;

    public Profit(Integer bestBuyIndex, Integer bestSellIndex, Integer maxProfit) {
        this.bestBuyIndex = bestBuyIndex;
        this.bestSellIndex = bestSellIndex;
        this.maxProfit = maxProfit;
    }

    @Override
    public String toString() {
        return format("%d %d %d", bestBuyIndex, bestSellIndex, maxProfit);
    }
}
