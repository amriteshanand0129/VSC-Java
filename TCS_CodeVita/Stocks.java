package TCS_CodeVita;
import java.util.*;
class Stock {
  int quantity;
  int buyDay;
  int sellDay;
  Stock(int quantity, int buyDay, int sellDay) {
    this.quantity = quantity;
    this.buyDay = buyDay;
    this.sellDay = sellDay;
  }
}
class Stocks {
  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt(); // Number of stocks
    Stock stockData[] = new Stock[N];
    int quantity, buyDay, sellDay;
    for(int i=0; i<N; i++) {
      quantity = in.nextInt();
      buyDay = in.nextInt();
      sellDay = in.nextInt();
      stockData[i] = new Stock(quantity, buyDay, sellDay); 
    }
    int M = in.nextInt(); // Number of days of price data
    int stockPrices[][] = new int[N][M];
    for(int i=0; i<N; i++) 
      for(int j=0; j<M; j++)
        stockPrices[i][j] = in.nextInt();
    int K = in.nextInt(); // K Observation Day
    in.close();
    
    int realizedProfit = 0, unrealizedProfit = 0;
    for(int i=0; i<N; i++) {
      Stock stock = stockData[i];

      if(stock.buyDay > K)
        continue;

      if(stock.sellDay == 0 || stock.sellDay > K) 
        unrealizedProfit += (stockPrices[i][K-1] - stockPrices[i][stock.buyDay-1]) * stock.quantity;

      else if(stock.sellDay <= K) 
        realizedProfit += (stockPrices[i][stock.sellDay-1] - stockPrices[i][stock.buyDay-1]) * stock.quantity;
    }
    System.out.println(realizedProfit);
    System.out.println(unrealizedProfit);
  }
}