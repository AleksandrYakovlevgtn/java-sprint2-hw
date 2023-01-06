import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class MonthlyReport {
    public static ArrayList<DataMonth> dataMonths = new ArrayList<>();         // Список с данными за все месяца
    public static HashMap<Integer,ArrayList> incomeByMonth = new HashMap<>();  //  Мапа с данными по даходам за все месяца
    public static HashMap<Integer,ArrayList> expenseByMonth = new HashMap<>(); //  Мапа с данными по расходами за все месяца
    public static HashMap<Integer,Integer> incomeInMonth = new HashMap<>();    //  Мапа с доходами по месяцам
    public static HashMap<Integer,Integer> expenseInMonth = new HashMap<>();   //  Мапа с расходами по месяцам
    public static HashMap<Integer,HashMap> maxIncomeItemNameInMonth = new HashMap<>();
    public static HashMap<Integer,HashMap> maxExpenseItemNameInMonth = new HashMap<>();
    public static HashMap<String,Integer> ItemName = new HashMap<>();
    public static HashMap<Integer,HashMap> ItemNameInMonth = new HashMap<>();


    public String readFileContents(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
            return null;
        }
    }


    void  loudFile(String path) {
        for (int j = 1; j < 4; j++) {
            String content = readFileContents(path + j + ".csv");
            String[] lines = content.split("\r?\n");
            for (int i = 1; i < lines.length; i++) {
                String line = lines[i];
                String[] parts = line.split(",");
                String item_name = parts[0];
                Boolean is_expenseMonth = Boolean.parseBoolean(parts[1]);
                Integer quantity = Integer.parseInt(parts[2]);
                Integer sum_of_one = Integer.parseInt(parts[3]);

                DataMonth dataMonth = new DataMonth(item_name, is_expenseMonth, quantity, sum_of_one);
                dataMonths.add(dataMonth);
                maxIncomeItemNameInMonth(j);


                if (is_expenseMonth == false ){
                    incomeByMonth.put(j,dataMonths);
                    Integer income = 0;
                    income = income + (sum_of_one * quantity);
                    incomeInMonth.put(j,incomeInMonth.getOrDefault(j,0) + income);
                    //ItemName.put( item_name , (sum_of_one * quantity));
                    //ItemNameInMonth.put( j,ItemName);

                }
                else {
                    expenseByMonth.put(j,dataMonths);
                    Integer expense = 0;
                    expense = expense + (sum_of_one * quantity);
                    expenseInMonth.put(j,expenseInMonth.getOrDefault(j,0) + expense);
                }
            }
        }
    }
    static void maxIncomeItemNameInMonth(int i){
        for (DataMonth data : dataMonths){
            ItemName.put(data.item_name, (data.sum_of_one * data.quantity));
            ItemNameInMonth.put(i,);
            ItemName.clear();
            }
    }
}


