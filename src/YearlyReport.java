import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {
    public static ArrayList<DataYear> datas = new ArrayList<>();
    public static HashMap<Integer, Integer> dohodInYear = new HashMap<>();
    public static HashMap<Integer, Integer> rashodInYear = new HashMap<>();
    public static int dohod;

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

       /* if(is_expense == false )
            dohod.put(month, datas.get(i - 1));
        else{
            rashod.put(month,datas.get(i - 1));
        }*/
        }
    }

        static int DetailsRashodDahod () {
            for (DataYear data : datas) {
                if (data.is_expense == false) {
                    dohodInYear.put(data.month, data.amount);
                    dohod = dohod + data.amount;
                } else {
                    rashodInYear.put(data.month, data.amount);
                }
            }

            return 0;
        }


        public String readFileContents (String path){
            try {
                return Files.readString(Path.of(path));
            } catch (IOException e) {
                System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
                return null;
            }
        }
    }

