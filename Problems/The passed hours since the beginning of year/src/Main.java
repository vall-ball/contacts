import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime time = LocalDateTime.parse(scanner.nextLine());
        System.out.println(time.getDayOfYear() * 24 + time.getHour() - 24);
    }
}