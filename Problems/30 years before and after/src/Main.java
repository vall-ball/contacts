import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        LocalDate date = LocalDate.parse(s);
        System.out.println(date.minusYears(30));
        System.out.println(date.plusYears(30));
    }
}