package Lab0.Classes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Classifying {
    private boolean isHumanoid;
    private String planet;
    private Integer ageMin;
    private Integer ageMax;
    private List<String> traits;

    public Classifying(boolean isHumanoid, String planet, Integer ageMin, Integer ageMax, List<String> traits) {
        this.isHumanoid = isHumanoid;
        this.planet = planet;
        this.ageMin = ageMin;
        this.ageMax = ageMax;
        this.traits = traits;
    }

    public boolean isHumanoid() {
        return isHumanoid;
    }

    public void setHumanoid(boolean humanoid) {
        isHumanoid = humanoid;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public Integer getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(Integer ageMin) {
        this.ageMin = ageMin;
    }

    public Integer getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(Integer ageMax) {
        this.ageMax = ageMax;
    }

    public List<String> getTraits() {
        return traits;
    }

    public void setTraits(List<String> traits) {
        this.traits = traits;
    }

    public static Map<String, List<Classifying>> getAllSpecies() {
        Map<String, List<Classifying>> speciesMap = new HashMap<>();

        speciesMap.put("Star Wars", List.of(
                new Classifying(false, "Kashyyyk", 0, 400, List.of("HAIRY", "TALL")),
                new Classifying(false, "Endor", 0, 60, List.of("SHORT", "HAIRY"))
        ));

        speciesMap.put("Marvel", List.of(
                new Classifying(true, "Asgard", 0, 5000, List.of("BLONDE", "TALL"))
        ));

        speciesMap.put("Hitchhiker", List.of(
                new Classifying(true, "Betelgeuse", 0, 100, List.of("EXTRA_ARMS", "EXTRA_HEAD")),
                new Classifying(false, "Vogsphere", 0, 200, List.of("GREEN", "BULKY"))
        ));

        speciesMap.put("LOTR", List.of(
                new Classifying(true, "Earth", null, null, List.of("BLONDE", "POINTY_EARS")),
                new Classifying(true, "Earth", 0, 200, List.of("SHORT", "BULKY"))
        ));

        return speciesMap;
    }
}
