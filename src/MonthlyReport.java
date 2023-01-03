import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MonthlyReport {
    String item_name;
    Boolean is_expense;
    Integer quantity;
    Integer sum_of_one;
    List <String> readFileContents= new ArrayList<>();
    String line;
    //String[] lineContents = line.split(",");





    List<String> readFileContents(String path) {
        try {
                return Files.readAllLines(Path.of(path));
            } catch (IOException e) {
                System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
                return Collections.emptyList();
            }
        }






}
