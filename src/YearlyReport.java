import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
public class YearlyReport {
    public static String[] months = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
    public static ArrayList<DataYear> datas = new ArrayList<>(); // список с данными из файла
    public static HashMap<Integer, Integer> incomeInYear = new HashMap<>();  // мапа с доходами, ключ это месяц.
    public static HashMap<Integer, Integer> expenseInYear = new HashMap<>(); // мапа с расходами, ключ это месяц.
    public static HashMap<Integer, Integer> profitInYear = new HashMap<>();  // мапа с прибылью, ключ это месяц числом.
    public static int income;  // доход за весь год.
    public static int expense; // расход за весь год.

    public String readFileContents (String path){  // считываем файл.
        try {
            System.out.println("Файл удачно считан.");
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
            return null;
        }
    }


    public YearlyReport(String path) {    // читаем по линиям и упоковываем в список.
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
        /*
        создает мапы  доходов и расходов по месяцам.И !примитивы(за все месяца)!
       */
        static int DetailsExpenseIncome() {
            for (DataYear data : datas) {
                if (data.is_expense == false) {
                    incomeInYear.put(data.month, data.amount);
                    income += data.amount;
                } else {
                    expenseInYear.put(data.month, data.amount);
                    expense += data.amount;
                }
            }
            return 0;
        }
        /*
    Метод считает и печатает прибыль по месяцам.
     */
        static int profitByMonths(){  // Создает мапу по доходу за год и сразу печатает ее.
         for(int i = 1; i <= expenseInYear.size() ; i++){
          Integer profit = incomeInYear.get(i) - expenseInYear.get(i);
          profitInYear.put(i, profit);
          System.out.println("Прибыль в " + months[i - 1] + " составила " + profit + " !");
      }
      return 0;
    }
    /*
    Метод печати отчета за год.
     */
    static void Account(){
        if(!datas.isEmpty()) { // проверяет был ли выполнен пункт  меню 2 через проверку пустоты таблицы.
            DetailsExpenseIncome(); // создает мапы  доходов и расходов по месяцам.И !примитивы(за все месяца)!
            System.out.println("Отчет за 2021 год.");
            System.out.println("Средний расход за месяц равен: " + expense / 12); // доход деленый на 12
            System.out.println("Средний доход за месяц равен: " + income / 12);   // расход деленный на 12
            profitByMonths(); // Создает мапу по доходу за год и сразу печатает ее.
        }else{
            System.out.println("Таблица не считано! Пожалуйста сначало выполните 2 команду. ");
        }
    }
}





       /* увлекся лишним не посмотрев тз до конца.
       static void getMaxIncomeMonth(){    !!!поиск самого доходного месяца!!!

           Integer maxIncomeMoth = 0;
           Integer maxAmount = 0 ;

            for (Map.Entry<Integer,Integer> data : incomeInYear.entrySet()){
                if(maxAmount < data.getValue()){
                    maxAmount = data.getValue();
                    maxIncomeMoth = data.getKey();
                }
                    }
            System.out.println("Месяц с самым большим доходом: " + months[maxIncomeMoth - 1]);
            }

        static void maxExpenseMonth(){  !!!Поиск месяца с самым большим расходом!!!

            Integer maxExpenseMoth = 0;
            Integer maxAmount = 0 ;

            for (Map.Entry<Integer,Integer> data : expenseInYear.entrySet()){
                if(maxAmount < data.getValue()){
                    maxAmount = data.getValue();
                    maxExpenseMoth = data.getKey();
                }
            }
            System.out.println("Месяц с самым большим расходом: " + months[maxExpenseMoth - 1]);
        }*/





