import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class MonthlyReport {
    public static ArrayList<DataMonth> dataMonths = new ArrayList<>();         // Список с данными за все месяца
    public static HashMap<Integer,ArrayList> incomeByMonth = new HashMap<>();  //  Мапа с данными по даходам за все месяца
    public static HashMap<Integer,ArrayList> expenseByMonth = new HashMap<>(); //  Мапа с данными по расходами за все месяца
    public static HashMap<Integer,Integer> incomeInMonth = new HashMap<>();    //  Мапа с доходами по месяцам
    public static HashMap<Integer,Integer> expenseInMonth = new HashMap<>();   //  Мапа с расходами по месяцам
    public static HashMap<Integer,HashMap> maxIncomeItemNameInMonth = new HashMap<>();
    public static HashMap<Integer,HashMap> maxExpenseItemNameInMonth = new HashMap<>();


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
                String item_name = parts[1];
                Boolean is_expenseMonth = Boolean.parseBoolean(parts[1]);
                Integer quantity = Integer.parseInt(parts[2]);
                Integer sum_of_one = Integer.parseInt(parts[3]);

                DataMonth dataMonth = new DataMonth(item_name, is_expenseMonth, quantity, sum_of_one);
                dataMonths.add(dataMonth);

                if (is_expenseMonth == false ){
                    incomeByMonth.put(j,dataMonths);
                    Integer income = 0;
                    income = income + (sum_of_one * quantity);
                    incomeInMonth.put(j,income);
                }
                else {
                    expenseByMonth.put(j,dataMonths);
                    Integer expense = 0;
                    expense = expense + (sum_of_one * quantity);
                    expenseInMonth.put(j,expense);
                }
            }
        }
    }
    void maxIncomeItemNameInMonth(){
        for()

    }
}

