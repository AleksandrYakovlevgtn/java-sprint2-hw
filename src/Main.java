
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
        String path = ("resources/m.20210");
        Scanner scanner = new Scanner(System.in);



        while (true) {
            printMenu();
            String command = scanner.next();
            if (command.equals("1")) {
                MonthlyReport monthlyReport = new MonthlyReport();
                monthlyReport.loudFile(path);
                System.out.println("Файлы удачно считались.");
            }
            else if (command.equals("2")) {
                YearlyReport yearlyReport = new YearlyReport("resources/y.2021.csv");
            }
            else if (command.equals("3")) {
                Checker.check();
            }
            else if (command.equals("4")) {
                MonthlyReport.account();
            }
            else if (command.equals("5")) {
                YearlyReport.account();
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


