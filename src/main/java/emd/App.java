package emd;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        JSONObject object = new JSONObject();

        JSONArray array = new JSONArray();

        Scanner scan = new Scanner(System.in);

        Tracker tracer = new Tracker();

        System.out.print("Enter the finishing date of the activity (yyyy-MM-dd HH:mm:ss): ");
        tracer.toDoDate = scan.nextLine();

        System.out.print("enter project name: ");
        tracer.toDoName = scan.nextLine();

        System.out.print("enter project No: ");
        tracer.toDoID = scan.nextInt();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime finishingDate = LocalDateTime.parse(tracer.toDoDate,
                formatter);
        LocalDateTime currentDate = LocalDateTime.now();
        Duration duration = Duration.between(currentDate, finishingDate);

        long remainingDays = duration.toDays();
        long remainingHours = duration.toHours() % 24;
        long remainingMinutes = duration.toMinutes() % 60;
        long remainingSeconds = duration.getSeconds() % 60;

        System.out.println("tracer to Do ID: " + tracer.toDoID);
        System.out.println("tracer to Do Name: " + tracer.toDoName);
        System.out.println("Remaining time: " + remainingDays + " days, " +
                remainingHours + " hours, " + remainingMinutes + " minutes, " + remainingSeconds + " seconds.");

        array.add(tracer.toDoName);
        array.add(tracer.toDoDate);
        object.put(tracer.toDoID, array);

        try {
            String path = "C:\\Users\\al\\Desktop\\projects\\maven\\demo\\src\\main\\file.json";
            FileWriter file = new FileWriter(path);
            String json = object.toJSONString();
            file.write(json);
            file.close();
        } catch (IOException io) {
            System.out.println("Error while writing to file.");
        }

    }
}
