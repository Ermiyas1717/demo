package emd;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonHandler {

    public JsonHandler() {
        Scanner scan = new Scanner(System.in);

        String toDoID = "";
        String toDoName = "";
        String toDoDate = "2024-12-17 12:00:00";

        System.out.print("Enter the finishing date of the activity (yyyy-MM-dd HH:mm:ss): ");
        toDoDate = scan.nextLine();

        System.out.print("enter project name: ");
        toDoName = scan.nextLine();

        System.out.print("enter project ID: ");
        toDoID = scan.nextLine();

        JSONObject object = new JSONObject();

        JSONArray array = new JSONArray();

        JSONParser parser = new JSONParser();
        try {
            array.add(toDoName);
            array.add(toDoDate);
            object.put(toDoID, array);

            try {
                String path = "C:\\Users\\al\\Desktop\\projects\\maven\\demo\\src\\file.json";
                FileReader fileReader = new FileReader(path);

                JSONObject updateJson = (JSONObject) parser.parse(fileReader);

                fileReader.close();

                // identifing if id is reppeted or not

                if (updateJson.containsKey(toDoID)) {

                    System.out.println(
                            "\n================================================\nproject ID is Already there try again.\n");
                    System.exit(0);

                } else {
                    updateJson.putAll(object);
                    FileWriter fileWriter = new FileWriter(path);
                    String json = updateJson.toJSONString();
                    fileWriter.write(json);
                    fileWriter.close();

                    System.out.println("\n ==============================================");
                    System.out.println("\nTo Do project ID: " + toDoID);
                    System.out.println("To Do Name: " + toDoName);

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime finishingDate = LocalDateTime.parse(toDoDate,
                            formatter);
                    LocalDateTime currentDate = LocalDateTime.now();
                    Duration duration = Duration.between(currentDate, finishingDate);

                    long remainingDays = duration.toDays();
                    long remainingHours = duration.toHours() % 24;
                    long remainingMinutes = duration.toMinutes() % 60;
                    long remainingSeconds = duration.getSeconds() % 60;

                    System.out.println("Remaining time: " + remainingDays + " days, " +
                            remainingHours + " hours, " + remainingMinutes + " minutes, " + remainingSeconds
                            + " seconds.\n");
                    System.exit(0);

                }

            } catch (IOException io) {
                System.out.println("Error while writing to JSON.");
            }
        } catch (

        ParseException e) {
            e.printStackTrace();
        }
    }
}
