import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime time = LocalDateTime.parse(scanner.nextLine());
        int hours = scanner.nextInt();
        int minutes = scanner.nextInt();
        System.out.println(time.minusHours(hours).plusMinutes(minutes));
    }
}