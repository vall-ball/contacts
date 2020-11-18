import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int offset = scanner.nextInt();

        LocalDate date = LocalDate.parse(s);

        int i = 0;
        while (true) {
            LocalDate d = date.plusDays(offset * i);
            if (d.getYear() != date.getYear()) {
                break;
            } else {
                i++;
                System.out.println(d);
            }
        }
    }
}