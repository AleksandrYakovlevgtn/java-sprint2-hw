import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        printMenu();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int command = scanner.nextInt();
            if (command == 1) {

            }
            else if (command == 2) {

            }
            else if (command == 3) {

            }
            else if (command == 4) {

            }
            else if (command == 5) {

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
        }
    }


