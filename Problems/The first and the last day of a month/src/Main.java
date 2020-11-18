import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = Integer.parseInt(scanner.nextLine());
        int month = Integer.parseInt(scanner.nextLine());
        LocalDate firstDay = LocalDate.of(year, month, 1);
        LocalDate lastDay = LocalDate.of(year, month, firstDay.getMonth().length(firstDay.isLeapYear()));
        System.out.println(firstDay + " " + lastDay);

    }
}