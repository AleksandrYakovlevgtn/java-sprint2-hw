import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class MonthlyReport {
    public static int availableMonthsCount = 3;
    public static ArrayList<DataMonth> dataMonths = new ArrayList<>();         // Список с данными за все месяца
    public static HashMap<Integer, Integer> incomeInMonth = new HashMap<>();    //  Мапа с доходами по месяцам
    public static HashMap<Integer, Integer> expenseInMonth = new HashMap<>();   //  Мапа с расходами по месяцам
    public static HashMap<Integer, ArrayList> maxIncomeItemNameInMonth = new HashMap<>(); // Мапа с самыми прибыльными товарами по месяцам
    public static ArrayList<String> maxIncomeItemNameInMonth1;   // Списки с самыми прибыльными товарами по месяцам
    public static ArrayList<String> maxIncomeItemNameInMonth2;
    public static ArrayList<String> maxIncomeItemNameInMonth3;

    static {
        maxIncomeItemNameInMonth1 = new ArrayList<>();
        maxIncomeItemNameInMonth1.add("0");
        maxIncomeItemNameInMonth1.add("0");
        maxIncomeItemNameInMonth2 = new ArrayList<>();
        maxIncomeItemNameInMonth2.add("0");
        maxIncomeItemNameInMonth2.add("0");
        maxIncomeItemNameInMonth3 = new ArrayList<>();
        maxIncomeItemNameInMonth3.add("0");
        maxIncomeItemNameInMonth3.add("0");
    }

    public static HashMap<Integer, ArrayList> maxExpenseItemNameInMonth = new HashMap<>();  // Мапа с самыми расходными товарами по месяцам
    public static ArrayList<String> maxExpenseItemNameInMonth1;   // Списки с самыми расходными товарами по месяцам
    public static ArrayList<String> maxExpenseItemNameInMonth2;
    public static ArrayList<String> maxExpenseItemNameInMonth3;

    static {
        maxExpenseItemNameInMonth1 = new ArrayList<>();
        maxExpenseItemNameInMonth1.add("0");
        maxExpenseItemNameInMonth1.add("0");
        maxExpenseItemNameInMonth2 = new ArrayList<>();
        maxExpenseItemNameInMonth2.add("0");
        maxExpenseItemNameInMonth2.add("0");
        maxExpenseItemNameInMonth3 = new ArrayList<>();
        maxExpenseItemNameInMonth3.add("0");
        maxExpenseItemNameInMonth3.add("0");
    }


/*
Считываем файлы
 */

    public String readFileContents(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
            return null;
        }
    }

    /*
Читаем по сторокам и заносим в нужные мапы и списки.
     */
    void loudFile(String path) {
        for (int j = 1; j <= availableMonthsCount; j++) {
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
                /*
Заносим в даходные мапы и списки
                 */

                if (!is_expenseMonth) {
                    Integer income = 0;
                    income = income + (sum_of_one * quantity);
                    incomeInMonth.put(j, incomeInMonth.getOrDefault(j, 0) + income);
                    maxIncomeItemNameInMonth(j, item_name, quantity, sum_of_one);
                    /*
Заносим в расходные мапы и списки
                     */
                } else {
                    Integer expense = 0;
                    expense = expense + (sum_of_one * quantity);
                    expenseInMonth.put(j, expenseInMonth.getOrDefault(j, 0) + expense);
                    maxExpenseItemNameInMonth(j, item_name, quantity, sum_of_one);
                }
            }
        }
    }
    /*
Находим самые доходные товары по месяцам и разносим их в список затем в мапу по с ключем "месяц"
     */
    static void maxIncomeItemNameInMonth(int i, String name, int sum_of_one, int quantity) {
        if (i == 1) {
            if ((sum_of_one * quantity) > Integer.parseInt(maxIncomeItemNameInMonth1.get(1))) {
                maxIncomeItemNameInMonth1.clear();
                maxIncomeItemNameInMonth1.add(name);
                maxIncomeItemNameInMonth1.add(String.valueOf((sum_of_one * quantity)));
                maxIncomeItemNameInMonth.put(i, maxIncomeItemNameInMonth1);
            }
        }
        if (i == 2) {
            if ((sum_of_one * quantity) > Integer.parseInt(maxIncomeItemNameInMonth2.get(1))) {
                maxIncomeItemNameInMonth2.clear();
                maxIncomeItemNameInMonth2.add(name);
                maxIncomeItemNameInMonth2.add(String.valueOf((sum_of_one * quantity)));
                maxIncomeItemNameInMonth.put(i, maxIncomeItemNameInMonth2);
            }
        }
        if (i == 3) {
            if ((sum_of_one * quantity) > Integer.parseInt(maxIncomeItemNameInMonth3.get(1))) {
                maxIncomeItemNameInMonth3.clear();
                maxIncomeItemNameInMonth3.add(name);
                maxIncomeItemNameInMonth3.add(String.valueOf((sum_of_one * quantity)));
                maxIncomeItemNameInMonth.put(i, maxIncomeItemNameInMonth3);
            }
        }
    }
    /*
Находим имя самого расходного товара и кладем в списки и затем в мапу с ключем "месяц"
     */
    static void maxExpenseItemNameInMonth(int i, String name, int sum_of_one, int quantity) {
        if (i == 1) {
            if ((sum_of_one * quantity) > Integer.parseInt(maxExpenseItemNameInMonth1.get(1))) {
                maxExpenseItemNameInMonth1.clear();
                maxExpenseItemNameInMonth1.add(name);
                maxExpenseItemNameInMonth1.add(String.valueOf((sum_of_one * quantity)));
                maxExpenseItemNameInMonth.put(i, maxExpenseItemNameInMonth1);
            }
        }
        if (i == 2) {
            if ((sum_of_one * quantity) > Integer.parseInt(maxExpenseItemNameInMonth2.get(1))) {
                maxExpenseItemNameInMonth2.clear();
                maxExpenseItemNameInMonth2.add(name);
                maxExpenseItemNameInMonth2.add(String.valueOf((sum_of_one * quantity)));
                maxExpenseItemNameInMonth.put(i, maxExpenseItemNameInMonth2);
            }
        }
        if (i == 3) {
            if ((sum_of_one * quantity) > Integer.parseInt(maxExpenseItemNameInMonth3.get(1))) {
                maxExpenseItemNameInMonth3.clear();
                maxExpenseItemNameInMonth3.add(name);
                maxExpenseItemNameInMonth3.add(String.valueOf((sum_of_one * quantity)));
                maxExpenseItemNameInMonth.put(i, maxExpenseItemNameInMonth3);
            }
        }
    }
    /*
Метод для печати отчета
     */
    static void account(){
        if(!maxExpenseItemNameInMonth.isEmpty()) {
            for (int i = 1; i <= availableMonthsCount; i++) {
                System.out.println(YearlyReport.months[i - 1]);
                System.out.println("Самый доходный товар в этом месяце " + maxIncomeItemNameInMonth.get(i));
                System.out.println("Самая большая трата в этом месяце " + maxExpenseItemNameInMonth.get(i));
            }
        }else {
            System.out.println("Сначала необходимо выполнить чтение файлов !");
        }
    }
}




