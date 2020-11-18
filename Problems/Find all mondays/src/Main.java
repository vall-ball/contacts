import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();

        for (int i = 1; i <= Month.of(month).length(Year.of(year).isLeap()); i++) {
            LocalDate date = LocalDate.of(year, month, i);
            if (date.getDayOfWeek() == DayOfWeek.MONDAY) {
                System.out.println(date);
            }
        }
    }
}