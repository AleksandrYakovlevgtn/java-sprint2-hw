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

        //Checker checker = new Checker(monthlyReport, yearlyReport);
        //boolean result = checker.check();


        while (true) {
            printMenu();
            String command = scanner.next();
            if (command.equals("1")) {
                MonthlyReport monthlyReport = new MonthlyReport();
                for (int i = 1; i < 13; i++) {
                    monthlyReport.loudFile(path + i +".csv");
                }
            }
            else if (command.equals("2")) {
                YearlyReport yearlyReport = new YearlyReport("resources/y.2021.csv");
            }
            else if (command.equals("3")) {

            }
            else if (command.equals("4")) {

            }
            else if (command.equals("5")) {
                YearlyReport.DetailsRashodDahod();
                System.out.println(YearlyReport.dohod);
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


