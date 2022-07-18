package arcaDeNoe.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.UnaryOperator;

public class Ark {

    public static void main(String[] args) throws Exception {

        Ark ark = new Ark();
        Gson gson = new Gson();
        JsonReader jsonReader = new JsonReader(new FileReader("resources/animalsList.json"));

        List<Animal> animals = gson.fromJson(jsonReader, new TypeToken<List<Animal>>() {}.getType());
        List<Animal> arkAnimals = new ArrayList<>();
        List<Animal> cuples = new ArrayList<>();


        for (Animal animal : animals) {

            if (!ark.canFly(animal) && !ark.isAmphibian(animal) && ark.isTerrestrial(animal)) {
                arkAnimals.add(animal);
            }
        }

        for (int i = 0; i < arkAnimals.size()-1; i++) {
            for (int j = 1; j < arkAnimals.size(); j++) {
                if (arkAnimals.get(i).getType().equals(arkAnimals.get(j).getType()) &&
                    ark.isMale(arkAnimals.get(i)) && ark.isFemale(arkAnimals.get(j))) {
                    cuples.add(arkAnimals.get(i));
                    cuples.add(arkAnimals.get(j));
                }
            }
        }

//        cuples.forEach(StdOut::println);
        StdOut.println("Animais na arca: " + cuples.size());    //Valor correto: 38
        StdOut.println("Animais no total: " + animals.size());      //Valor correto: 69

        Type listType = new TypeToken<List<Animal>>() {}.getType();
        List<Animal> target = new LinkedList<Animal>();
        target.add(arkAnimals.get(0));
        StdOut.println(target);

        Gson objGson = new GsonBuilder().create();
        String json = objGson.toJson(animals);

        StdOut.println("json " + json);

        gson.toJson(json, new FileWriter("..\\ark-daniel\\resources\\arkList.json"));

    }
    //Verificação se o animal é anfíbio
    public boolean isAmphibian(Animal animal) {
        return animal.getType().equals("Amphibians");
    }
    //Verificando se o animal pode voar
    public boolean canFly(Animal animal) {
        for (Movement movement : animal.getMovements()) {
            if (movement.getMovement().toLowerCase().equals("fly"))
                return true;
        }
        return false;
    }
    //Verificando se o animal é terrestre
    public boolean isTerrestrial(Animal animal) {
        for (Habitat habitat : animal.getHabitats()) {
            if (habitat.getHabitat().toLowerCase().equals("terrestrial"))
                return true;
        }
        return false;
    }

    public boolean isMale(Animal animal) {
        return animal.getSex().toLowerCase().equals("male");
    }

    public boolean isFemale(Animal animal) {
        return animal.getSex().toLowerCase().equals("female");
    }

}
