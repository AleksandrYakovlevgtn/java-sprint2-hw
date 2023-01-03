import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static String path = ("resources/m.20210");

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();

        while (true) {
            printMenu();
            String command = scanner.next();
            if (command.equals("1")) {
                for (int i = 1;i < 4; i++) {
                    monthlyReport.readFileContents(path + i + ".csv");
                }
            }
            else if (command.equals("2")) {

            }
            else if (command.equals("3")) {

            }
            else if (command.equals("4")) {

            }
            else if (command.equals("5")) {

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
    public enum Month {
        Январь,
        Февраль,
        Март
    }
    }


