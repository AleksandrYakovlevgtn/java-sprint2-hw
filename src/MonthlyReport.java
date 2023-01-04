import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class MonthlyReport {
    public static ArrayList<DataMonth> dataMonths = new ArrayList<>();
    public static HashMap<Integer, DataMonth> dohod = new HashMap<>();
    public static HashMap<Integer, DataMonth> rashod = new HashMap<>();
public MonthlyReport(){

}
void loudFile(String path){
    String content = readFileContents(path);
    String[] lines = content.split("\r?\n");
    for (int i = 1; i < lines.length; i++) {
        String line = lines[i];
        String[] parts = line.split(",");
        String item_name = parts[1];
        Boolean is_expenseMonth = Boolean.parseBoolean(parts[1]);
        Integer quantity = Integer.parseInt(parts[2]);
        Integer sum_of_one = Integer.parseInt(parts[3]);

        DataMonth dataMonth = new DataMonth(item_name,is_expenseMonth,quantity,sum_of_one);
        dataMonths.add(dataMonth);

        if(is_expenseMonth == false )
            dohod.put(i, dataMonths.get(i - 1));
        else{
            rashod.put(i,dataMonths.get(i - 1));
        }
    }
 }
    public String readFileContents(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
            return null;
        }
    }
}
