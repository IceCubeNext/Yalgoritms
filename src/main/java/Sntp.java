import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;


class Sntp {
    public void sntp(String[] args) {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("HH:mm:ss");
        Scanner scanner = new Scanner(System.in);
        LocalTime[] times = new LocalTime[3];
        for (int i = 0; i < 3; i++) {
            LocalTime time = LocalTime.parse(scanner.nextLine(), dt);
            times[i] = time;
        }
        double diff;
        if (times[0].isBefore(times[2])) {
            diff = times[0].until(times[2], ChronoUnit.SECONDS) / 2.;
        } else {
            diff = (86400 + times[0].until(times[2], ChronoUnit.SECONDS)) / 2.;
        }

        System.out.println(times[1].plusSeconds(Math.round(diff)).format(dt));
    }
}