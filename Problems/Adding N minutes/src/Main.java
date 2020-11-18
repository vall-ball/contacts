import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime time = LocalDateTime.parse(scanner.nextLine());
        int minutes = scanner.nextInt();
        LocalDateTime result = time.plusMinutes(minutes);
        System.out.println(result.getYear() + " " + result.getDayOfYear() + " " + result.toLocalTime());
    }
}