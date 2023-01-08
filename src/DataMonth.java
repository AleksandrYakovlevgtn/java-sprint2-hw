public class DataMonth {
    String itemName;
    boolean isExpenseMonth;
    int quantity;
    int sumOfOne;

    public DataMonth(String item_name, boolean is_expenseMonth, int quantity, int sum_of_one) {
        this.itemName = item_name;
        this.isExpenseMonth = is_expenseMonth;
        this.quantity = quantity;
        this.sumOfOne = sum_of_one;
    }
}
