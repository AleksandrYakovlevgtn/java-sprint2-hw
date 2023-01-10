import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class MonthlyReport {
    public static int availableMonthsCount = 3;
    public static ArrayList<DataMonth> dataMonths = new ArrayList<>();         // Список с данными за все месяца
    public static HashMap<Integer, Integer> incomeInMonth = new HashMap<>();    //  Мапа с доходами по месяцам
    public static HashMap<Integer, Integer> expenseInMonth = new HashMap<>();   //  Мапа с расходами по месяцам

    public static HashMap<Integer, Integer> maxIncomeByMonth = new HashMap<>();    // Мапа с максимальным доходом по месяцам
    public static HashMap<Integer , Integer> maxExpenseByMonth = new HashMap<>();  // Мапа с расходом доходом по месяцам
    public static HashMap<Integer , String> maxIncomeByMonthName = new HashMap<>();// Мапа с именем максимального дохода
    public static HashMap<Integer, String> maxExpenseByMonthName = new HashMap<>();// Мапа с именем максим расходом
      /*
Считываем файлы
 */

    /*public String readFileContents(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
            return null;
        }
    }*/

    /*
Читаем по сторокам и заносим в нужные мапы и списки.
     */
    void loudFile(String path) {
        for (int j = 1; j <= availableMonthsCount; j++) {
            String content = readFileContents.readFileContents(path + j + ".csv");
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
                maxNameIncomeExpense(j,item_name,is_expenseMonth,sum_of_one,quantity);
                /*
Заносим в даходные мапы
                 */

                if (!is_expenseMonth) {
                    Integer income = 0;
                    income = income + (sum_of_one * quantity);
                    incomeInMonth.put(j, incomeInMonth.getOrDefault(j, 0) + income);

                    /*
Заносим в расходные мапы
                     */
                } else {
                    Integer expense = 0;
                    expense = expense + (sum_of_one * quantity);
                    expenseInMonth.put(j, expenseInMonth.getOrDefault(j, 0) + expense);

                }
            }
        }
    }

    /*
Метод для печати отчета
     */
    static void account(){
        if(!maxIncomeByMonth.isEmpty()) {
            for (int i = 1; i <= availableMonthsCount; i++) {
                System.out.println(YearlyReport.months[i - 1]);
                System.out.println("Самый доходный товар в этом месяце " + maxIncomeByMonthName.get(i) + " " + maxIncomeByMonth.get(i));
                System.out.println("Самая большая трата в этом месяце " + maxExpenseByMonthName.get(i) + " " + maxExpenseByMonth.get(i));
            }
        }else {
            System.out.println("Сначала необходимо выполнить чтение файлов !");
        }
    }
    /*
    Считаем и ищем имя максимальных расходов и доходов.
     */
    static void maxNameIncomeExpense(Integer i, String name,Boolean is_expenseMonth, int sum_of_one, int quantity){
        if (maxIncomeByMonth.isEmpty() || maxExpenseByMonth.isEmpty()){
            for (int j = 1;j <= availableMonthsCount; j++ ) {
                maxIncomeByMonth.put(j, 0);
                maxExpenseByMonth.put(j, 0);
            }
        }
        Integer income =  sum_of_one * quantity;
        if((maxIncomeByMonth.get(i) <= income ) && (!is_expenseMonth) || ((maxExpenseByMonth.get(i) <= income )) && (is_expenseMonth)){
            if(!is_expenseMonth ) {
                    maxIncomeByMonth.put(i, income);
                    maxIncomeByMonthName.put(i, name);

            }if(is_expenseMonth){
                maxExpenseByMonth.put(i,income);
                maxExpenseByMonthName.put(i,name);
            }
        }
    }
}




