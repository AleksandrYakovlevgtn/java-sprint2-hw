import java.util.HashMap;

public class Checker {
     /*
     Класс для проверки суммы за месяц расхода и дохода. Проверка отдельная
     по расходу и даходу для удобства поиска неточности.
      */
    public static boolean check(){
        for (int i = 1; i <= MonthlyReport.availableMonthsCount; i++){
            if((MonthlyReport.incomeInMonth.get(i)) == (YearlyReport.incomeInYear.get(i))){
              System.out.println("В отчете ошибка за " + YearlyReport.months[i - 1] + " несоответствует доход!");
            }
            if ((MonthlyReport.expenseInMonth.get(i)) == (YearlyReport.expenseInYear.get(i))){
                System.out.println("В отчете ошибка за " + YearlyReport.months[i - 1] + " несоответствует расход!" );
            }
        }
            System.out.println("В отчете нет ошибок!");
            return false;

    }
}
