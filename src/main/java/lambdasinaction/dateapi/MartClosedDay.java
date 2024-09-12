package lambdasinaction.dateapi;

import java.time.LocalDate;

public class MartClosedDay {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("현재날짜 = " + today);
    }
}
