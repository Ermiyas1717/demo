package emd;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RemainTime extends Tracker {
    public RemainTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime finishingDate = LocalDateTime.parse(toDoDate, formatter);
        LocalDateTime currentDate = LocalDateTime.now();
        Duration duration = Duration.between(currentDate, finishingDate);

        long remainingDays = duration.toDays();
        long remainingHours = duration.toHours() % 24;
        long remainingMinutes = duration.toMinutes() % 60;
        long remainingSeconds = duration.getSeconds() % 60;

        System.out.println("Remaining time: " + remainingDays + " days, " +
                remainingHours + " hours, " + remainingMinutes + " minutes, " + remainingSeconds
                + " seconds.\n");
    }
}
