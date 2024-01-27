package emd;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonHandler {

    public JsonHandler() {
        Tracker tracker = new Tracker();
        Tracker.trace();

        new Display();

        JSONObject object = new JSONObject();

        JSONArray array = new JSONArray();

        JSONParser parser = new JSONParser();
        try {
            array.add(tracker.toDoName);
            array.add(tracker.toDoDate);
            object.put(tracker.toDoID, array);

            try {
                String path = "C:\\Users\\al\\Desktop\\projects\\maven\\demo\\src\\file.json";
                FileReader fileReader = new FileReader(path);

                JSONObject updateJson = (JSONObject) parser.parse(fileReader);

                fileReader.close();

                // identifing if id is reppeted or not

                if (updateJson.containsKey(Tracker.toDoID)) {

                    Display.errorMessage();

                } else {
                    updateJson.putAll(object);
                    FileWriter fileWriter = new FileWriter(path);
                    String json = updateJson.toJSONString();
                    fileWriter.write(json);
                    fileWriter.close();

                    Display.correctMessage();
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
