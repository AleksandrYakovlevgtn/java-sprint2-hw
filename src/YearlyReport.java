import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {
    public static String[] months = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
    public static ArrayList<DataYear> datas = new ArrayList<>();
    public static HashMap<Integer, Integer> incomeInYear = new HashMap<>();
    public static HashMap<String, Integer> expenseInYear = new HashMap<>();
    public static int income;  // доход
    public static int expense; // расход

    //public static HashMap<Integer, DataYear> dohod = new HashMap<>();
    //public static HashMap<Integer, DataYear> rashod = new HashMap<>();


    public YearlyReport(String path) {
        String content = readFileContents(path);
        String[] lines = content.split("\r?\n");
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] parts = line.split(",");
            int month = Integer.parseInt(parts[0]);
            int amount = Integer.parseInt(parts[1]);
            boolean is_expense = Boolean.parseBoolean(parts[2]);

            DataYear data = new DataYear(month, amount, is_expense);
            datas.add(data);
        }
    }

        static int DetailsExpenseIncome() {
            for (DataYear data : datas) {
                if (data.is_expense == false) {
                    incomeInYear.put(data.month, data.amount);
                    income += data.amount;
                } else {
                    expenseInYear.put(months[data.month -1], data.amount);
                    expense += data.amount;
                }
            }

            return 0;
        }


        public String readFileContents (String path){
            try {
                System.out.println("Файл удачно считан.");
                return Files.readString(Path.of(path));
            } catch (IOException e) {
                System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
                return null;
            }
        }
    }

