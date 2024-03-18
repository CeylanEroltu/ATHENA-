public class StockEx {
    public static void main(String[] args) {

        Stock s = new Stock("ORCL", "Oracle Corporation");

        s.setPreviousClosingPrice(160.0);
        s.setCurrentPrice(190.0);
        System.out.println("Percentage change: " + s.getChangePercent() + "%");
        System.out.println(s.toString());
        
    }
}

class Stock {

    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;

    public Stock(String symbol , String name) {

        this.symbol = symbol.toUpperCase();
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1);

    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public double getPreviousClosingPrice() {
        return previousClosingPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setPreviousClosingPrice(double previousClosingPrice) {

        if (previousClosingPrice < 0) {
            System.out.println("ERROR");
        }
        this.previousClosingPrice = previousClosingPrice;
    }

    public void setCurrentPrice(double currentPrice) {

        if (currentPrice < 0) {
            System.out.println("ERROR");
    }
    this.currentPrice = currentPrice;
    }

    public double getChangePercent() {
        if (previousClosingPrice == 0) {
            return 0; 
        }
        return ((currentPrice - previousClosingPrice) / previousClosingPrice) * 100;
    }

    @Override
    
    public String toString() {
        return "[" + symbol + "] - " + name + ": " + currentPrice;
    }

}
