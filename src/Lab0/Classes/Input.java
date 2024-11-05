package Lab0.Classes;

import java.util.List;

public class Input {

    int id;
    Boolean isHumanoid;
    String planet;
    Integer age;
    List<String> traits;

    Input(int id, Boolean isHumanoid, String planet, Integer age, List<String> traits) {
        this.id = id;
        this.isHumanoid = isHumanoid;
        this.planet = planet;
        this.age = age;
        this.traits = traits;
    }

    public int getId() {
        return id;
    }

    public Boolean isHumanoid() {
        return isHumanoid;
    }

    public String getPlanet() {
        return planet;
    }

    public Integer getAge() {
        return age;
    }

    public List<String> getTraits() {
        return traits;
    }
}
