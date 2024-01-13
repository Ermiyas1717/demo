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

        JSONObject object = new JSONObject();

        JSONArray array = new JSONArray();

        Tracker tracer = new Tracker();

        JSONParser parser = new JSONParser();
        try {
            array.add(tracer.toDoName);
            array.add(tracer.toDoDate);
            object.put(tracer.toDoID, array);

            try {
                String path = "C:\\Users\\al\\Desktop\\projects\\maven\\demo\\src\\file.json";
                FileReader fileReader = new FileReader(path);

                JSONObject updateJson = (JSONObject) parser.parse(fileReader);

                fileReader.close();

                updateJson.putAll(object);

                // identifing if id is reppeted or not

                // if (updateJson.containsKey(path)) {
                // FileWriter fileWriter = new FileWriter(path);
                // String json = updateJson.toJSONString();
                // System.out.println("project ID is Already there try again");
                // System.exit(0);
                // fileWriter.write(json);
                // fileWriter.close();
                // } else {
                FileWriter fileWriter = new FileWriter(path);
                String json = updateJson.toJSONString();
                fileWriter.write(json);
                fileWriter.close();
                // }

            } catch (IOException io) {
                System.out.println("Error while writing to JSON.");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
