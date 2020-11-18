import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int offset = scanner.nextInt();
        LocalDate date = LocalDate.of(year, month, 20);
        int l = date.getMonth().length(date.isLeapYear());
        LocalDate d = LocalDate.of(year, month, l - offset + 1);


        System.out.println(d);
    }
}
