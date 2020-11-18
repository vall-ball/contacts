import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = Integer.parseInt(scanner.nextLine());
        int firstDay = Integer.parseInt(scanner.nextLine());
        int secondDay = Integer.parseInt(scanner.nextLine());
        int thirdDay = Integer.parseInt(scanner.nextLine());
        LocalDate date = LocalDate.of(year, 1, 1);
        System.out.println(date.plusDays(firstDay -1));
        System.out.println(date.plusDays(secondDay - 1));
        System.out.println(date.plusDays(thirdDay - 1));
    }
}