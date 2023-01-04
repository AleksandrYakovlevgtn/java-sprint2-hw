public class DataMonth {
    String item_name;
    boolean is_expenseMonth;
    int quantity;
    int sum_of_one;

    public DataMonth(String item_name, boolean is_expenseMonth, int quantity, int sum_of_one) {
        this.item_name = item_name;
        this.is_expenseMonth = is_expenseMonth;
        this.quantity = quantity;
        this.sum_of_one = sum_of_one;
    }
}
