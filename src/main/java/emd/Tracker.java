package emd;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Tracker {
    Scanner scan = new Scanner(System.in);

    public String toDoID = "";
    public String toDoName = "";
    public String toDoDate = "2024-12-17 12:00:00";
    String remainTime;

    public void trac(String no, String name, String date, String remain) {
        toDoID = no;
        toDoName = name;
        toDoDate = date;
        remainTime = remain;
    }

    public Tracker() {

        System.out.print("Enter the finishing date of the activity (yyyy-MM-dd HH:mm:ss): ");
        toDoDate = scan.nextLine();

        System.out.print("enter project name: ");
        toDoName = scan.nextLine();

        System.out.print("enter project ID: ");
        toDoID = scan.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime finishingDate = LocalDateTime.parse(toDoDate,
                formatter);
        LocalDateTime currentDate = LocalDateTime.now();
        Duration duration = Duration.between(currentDate, finishingDate);

        long remainingDays = duration.toDays();
        long remainingHours = duration.toHours() % 24;
        long remainingMinutes = duration.toMinutes() % 60;
        long remainingSeconds = duration.getSeconds() % 60;

        System.out.println("\n ==============================================");
        System.out.println("\nTo Do project ID: " + toDoID);
        System.out.println("To Do Name: " + toDoName);
        System.out.println("Remaining time: " + remainingDays + " days, " +
                remainingHours + " hours, " + remainingMinutes + " minutes, " + remainingSeconds + " seconds.");
    }
}