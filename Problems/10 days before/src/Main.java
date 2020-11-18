import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        LocalDate date = LocalDate.parse(str);


        System.out.println(date.minusDays(10));
    }
}
