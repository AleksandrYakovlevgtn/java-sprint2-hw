import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
        public static void main(String[] args) {

        String path = ("resources/m.20210");
        Scanner scanner = new Scanner(System.in);


        while (true) {
            printMenu();
            String command = scanner.next();
            if (command.equals("1")) {
                MonthlyReport monthlyReport = new MonthlyReport();
                for (int i = 1; i < 4; i++) {
                    monthlyReport.loudFile(path + i + ".csv");
                }
                System.out.println("Файлы удачно считались.");
            }
            else if (command.equals("2")) {
                YearlyReport yearlyReport = new YearlyReport("resources/y.2021.csv");
            }
            else if (command.equals("3")) {

            }
            else if (command.equals("4")) {
                System.out.println(MonthlyReport.dohod.get(1));
            }
            else if (command.equals("5")) {
                if(!YearlyReport.datas.isEmpty()) { // проверяет был ли выполнен пункт  меню 2 через проверку пустоты таблицы.
                    YearlyReport.DetailsExpenseIncome(); // создает мапы  доходов и расходов по месяцам.И !примитивы(за все месяца)!
                    System.out.println("Отчет за 2021 год.");
                    System.out.println("Средний расход за месяц равен: " + YearlyReport.expense / 12); // доход деленый на 12
                    System.out.println("Средний доход за месяц равен: " + YearlyReport.income / 12);   // расход деленный на 12
                    YearlyReport.profitByMonths(); // Создает мапу по доходу за год и сразу печатает ее.
                }else{
                    System.out.println("Таблица не считано! Пожалуйста сначало выполните 2 команду. ");
                }
            }
            else if (command.equals("q")) {
                 break;
            }
            else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }





    public static void printMenu (){
            System.out.println("Что вы хотите сделать? ");
            System.out.println("1 - Считать все месячные отчёты");
            System.out.println("2 - Считать годовой отчёт");
            System.out.println("3 - Сверить отчёты");
            System.out.println("4 - Вывести информацию о всех месячных отчётах");
            System.out.println("5 - Вывести информацию о годовом отчёте");
            System.out.println("q - Выход");
        }
}


