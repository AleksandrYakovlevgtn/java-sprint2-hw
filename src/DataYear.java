import java.util.ArrayList;

public class DataYear {
    static int month;
    static int amount;
    static boolean is_expense;
    public static ArrayList<DataYear> datas;

    static {
        datas = new ArrayList<>();
    }


    public DataYear(int month, int amount, boolean is_expense) {
        this.month = month;
        this.amount = amount;
        this.is_expense = is_expense;

    }
}
