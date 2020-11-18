import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime first = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime second = LocalDateTime.parse(scanner.nextLine());
        int result = (second.getDayOfYear() - first.getDayOfYear()) * 24 + (second.getHour() - first.getHour());
        if (second.getMinute() < first.getMinute()) {
            result--;
        }
        System.out.println(result);

    }
}