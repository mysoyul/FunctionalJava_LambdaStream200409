package lambdasinaction.dateapi;

import java.time.DayOfWeek;
import java.time.LocalDate;
import static java.time.temporal.TemporalAdjusters.*;

public class MartClosedDay {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("현재날짜 = " + today);

        //Temporal 인터페이스 default Temporal with(TemporalAdjuster adjuster)
        //TemporalAdjuster 인터페이스 Temporal adjustInto(Temporal temporal)
        LocalDate closedDay = today.with(temporal -> {
            //1. 기준이 되는 날짜 구하기
            LocalDate theDay = LocalDate.from(temporal);
            //2. 두번째,네번째 일요일 날짜 구하기
            LocalDate secondDay = theDay.with(dayOfWeekInMonth(2, DayOfWeek.SUNDAY));
            LocalDate fourthDay = theDay.with(dayOfWeekInMonth(4, DayOfWeek.SUNDAY));
            //3. 기준날짜와 비교하기

            return theDay;
        });
        System.out.println("휴무일 = " + closedDay);


    }
}
