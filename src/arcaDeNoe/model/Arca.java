package arcaDeNoe.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Arca {

    public static void main(String[] args) throws Exception {

        Gson gson = new Gson();
        JsonReader jsonReader = new JsonReader(new FileReader("resources/animalsList.json"));

        List<Animal> animals = gson.fromJson(jsonReader, new TypeToken<List<Animal>>() {}.getType());

        List<Animal> arkAnimals = new ArrayList<>();

        for (int index = 0; index < animals.size(); index++) {

            if (!animals.get(index).getType().equals("Amphibians") &&
                    animals.get(index).getHabitats().contains("Terrestrial") &&
                    !animals.get(index).getMovements().contains("Fly")) {

                arkAnimals.add(animals.get(index));
            }
        }

        arkAnimals.forEach(StdOut::println);
    }
}
