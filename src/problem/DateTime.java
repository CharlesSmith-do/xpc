package problem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {
    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);
        String t = "1970/03/06";
//        LocalDate t1 = LocalDate.parse(t);
//        System.out.println(t1.toString());

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate t1 = LocalDate.parse(t,df);
        System.out.println(t1.toString());
        int rs = (int) ((Math.random() * 9 + 1) * Math.pow(10, 9));
        System.out.println(rs);
    }
}


