package Lab0.Classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Main {
    public static void main(String[] args) {
        Map<String, JSONArray> classifiedByUniverse = new HashMap<>();
        String jsonText = Json.getJSONFromFile("./filesdoc/input.json");
        Container inputContainer = Json.parseJSONToInputContainer(jsonText);

        Map<String, List<Classifying>> allSpecies = Classifying.getAllSpecies();

        for (Input input : inputContainer.getAllInputs()) {
            String universe = classify(input, allSpecies);
            if (universe == null) {
                System.out.println("ID: " + input.getId() + " is uncategorized");
                continue;
            }
            classifiedByUniverse
                    .computeIfAbsent(universe, k -> new JSONArray())
                    .add(formatInput(input));
        }

        exportResults(classifiedByUniverse);
        System.out.println("Classification complete. Results exported to the 'Output' folder.");
    }

    private static String classify(Input input, Map<String, List<Classifying>> allSpecies) {
        for (Map.Entry<String, List<Classifying>> entry : allSpecies.entrySet()) {
            String universe = entry.getKey();
            List<Classifying> speciesFromUniverse = entry.getValue();

            for (Classifying species : speciesFromUniverse) {
                if (input.isHumanoid() != null && input.isHumanoid() != species.isHumanoid()) continue;

                if (input.getPlanet() != null && !input.getPlanet().equals(species.getPlanet())) continue;

                if (input.getAge() != null) {
                    if (species.getAgeMax() != null && input.getAge() > species.getAgeMax()) continue;
                    if (species.getAgeMin() != null && input.getAge() < species.getAgeMin()) continue;
                }

                if (input.getTraits() != null && !input.getTraits().isEmpty()) {
                    if (species.getTraits() == null || !species.getTraits().containsAll(input.getTraits())) continue;
                }

                return universe;
            }
        }
        return null;
    }



    private static JSONObject formatInput(Input input) {
        JSONObject inputObj = new JSONObject();
        inputObj.put("ID", input.getId());
        inputObj.put("Is Humanoid", input.isHumanoid());
        inputObj.put("Planet", input.getPlanet() != null ? input.getPlanet() : "null");
        inputObj.put("Age", input.getAge() != null ? input.getAge() : "null");
        inputObj.put("Traits", input.getTraits() != null ? input.getTraits() : "null");
        return inputObj;
    }

    private static void exportResults(Map<String, JSONArray> classifiedByUniverse) {
        File outputFolder = new File("Output");
        if (!outputFolder.exists()) {
            outputFolder.mkdir();
        }

        for (Map.Entry<String, JSONArray> entry : classifiedByUniverse.entrySet()) {
            String universe = entry.getKey();
            JSONArray classifiedEntries = entry.getValue();
            if (classifiedEntries != null && !classifiedEntries.isEmpty()) {
                try (FileWriter file = new FileWriter("Output/" + universe + "_classification.json")) {
                    file.write(classifiedEntries.toJSONString().replace("},", "},\n"));
                    file.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
