import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class YearlyReport {

public YearlyReport(String path){
    String content = readFileContents(path);
    String[] lines = content.split("\r?\n");
    for (int i = 1; i < lines.length; i++) {
        String line = lines[i];
        String[] parts = line.split(",");
        int month = Integer.parseInt(parts[0]);
        int amount = Integer.parseInt(parts[1]);
        boolean is_expense = Boolean.parseBoolean(parts[2]);
    }
}
    public String readFileContents(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
            return Collections.emptyList();
        }
    }
}
