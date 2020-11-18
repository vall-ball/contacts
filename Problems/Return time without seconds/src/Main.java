import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalTime time = LocalTime.parse(scanner.nextLine());
        if (time.getHour() < 10) {
            System.out.println("0" + time.getHour() + ":" + time.getMinute());
        } else {
            System.out.println(time.getHour() + ":" + time.getMinute());
        }
    }
}