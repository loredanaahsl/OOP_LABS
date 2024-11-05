package Lab0.Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Json {
    public static String getJSONFromFile(String filename) {
        StringBuilder jsonText = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonText.append(line).append("\n");
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonText.toString();
    }

    public static Container parseJSONToInputContainer(String json) {
        JSONParser parser = new JSONParser();
        Container inputContainer = new Container();

        try {
            JSONObject jsonObject = (JSONObject) parser.parse(json);
            JSONArray inputArray = (JSONArray) jsonObject.get("input");

            for (Object obj : inputArray) {
                try {
                    JSONObject entry = (JSONObject) obj;

                    long id = (long) entry.get("id");
                    Boolean isHumanoid = null; // Change type to Boolean
                    if (entry.containsKey("isHumanoid")) {
                        isHumanoid = (boolean) entry.get("isHumanoid");
                    }
                    String planet = (String) entry.get("planet");

                    Integer age = null;
                    if (entry.containsKey("age")) {
                        Object ageValue = entry.get("age");
                        if (ageValue != null) {
                            age = ((Long) ageValue).intValue();
                        }
                    }

                    JSONArray traits = (JSONArray) entry.get("traits");

                    List<String> traitsList = new ArrayList<>();
                    if (traits != null) {
                        for (Object trait : traits) {
                            traitsList.add((String) trait);
                        }
                    }

                    Input input = new Input(
                            (int) id,
                            isHumanoid, // Keep it as Boolean
                            planet,
                            age,
                            traitsList
                    );
                    inputContainer.addInput(input);
                } catch (Exception e) {
                    System.out.println("Error processing entry: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return inputContainer;
    }

    public static void main(String[] args) {
        String filename = "./filesdoc/input.json";

        String json = getJSONFromFile(filename);

        Container inputContainer = parseJSONToInputContainer(json);

        inputContainer.displayInputs();
    }
}
