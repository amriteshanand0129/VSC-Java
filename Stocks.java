public class Stocks {
    public static int calulateProfit(int prices[]) {
        int profit = 0, buyprice = Integer.MAX_VALUE;

        // Traversing through each price in the array
        for(int i=0; i<prices.length; i++) {

            // If price is lower than the previous buying price, we'll buy the stock
            if(prices[i] < buyprice) 
                buyprice = prices[i];

            // If not then sell the stock to map the profit and check for maximum profit
            else 
                profit = Math.max(profit, prices[i] - buyprice);
        }
        return profit;
    }
    public static void main(String args[]) {
        int prices[] = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum profit yielded: " + calulateProfit(prices));
    }
}

// Time Complexity is O(n)
