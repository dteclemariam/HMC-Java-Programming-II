public class ProductWarehouseWithHistory extends ProductWarehouse {

    private ChangeHistory history = new ChangeHistory();

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        super.addToWarehouse(initialBalance);
        history.add(initialBalance);
    }

    @Override
    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        history.add(getBalance());
    }

    @Override
    public double takeFromWarehouse(double amount) {
        double returnAmount = super.takeFromWarehouse(amount);
        history.add(getBalance());
        return returnAmount;
    }

    public String history() {
        return history.toString();
    }

    public void printAnalysis() {
        System.out.print("Product: " + getName()
                + "\n History: " + history()
                + "\n Largest amount of product: " + history.maxValue()
                + "\n Smallest amount of product: " + history.minValue()
                + "\n Average: " + history.average());
    }
}
