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

        OrgAninals ark = new OrgAninals();
        Gson gson = new Gson();
        JsonReader jsonReader = new JsonReader(new FileReader("resources/animalsList.json"));

        List<Animal> animals = gson.fromJson(jsonReader, new TypeToken<List<Animal>>() {}.getType());
        List<Animal> arkAnimals = ark.filterEspecie(animals);
        List<Animal> arkCupleAnimals = ark.createCuple(arkAnimals);

        ark.filterCuple(arkCupleAnimals);

        //arkCupleAnimals.forEach(StdOut::println);


        //List<Animal> cuples = ark.filterCuple(arkAnimals);



//        for (Animal animal : animals) {
//
//            if (!ark.canFly(animal) && !ark.isAmphibian(animal) && ark.isTerrestrial(animal)) {
//                arkAnimals.add(animal);
//            }
//        }

//        for (int i = 0; i < arkAnimals.size()-1; i++) {
//            for (int j = 1; j < arkAnimals.size(); j++) {
//                if (ark.areSameAnimal(arkAnimals.get(i), arkAnimals.get(j)) &&
//                    ark.isMale(arkAnimals.get(i)) && ark.isFemale(arkAnimals.get(j))) {
//                    cuples.add(arkAnimals.get(i));
//                    cuples.add(arkAnimals.get(j));
//                }
//            }
//        }

//        for (int i = 0; i < cuples.size()-1; i++) {
//            if (ark.areSameAnimal(cuples.get(i), cuples.get(i+1))) &&
//                cuples.get(i).getAge() + cuples.get(i+1)
//        }

//        cuples.forEach(StdOut::println);
//        StdOut.println("Numero de casais possíveis: " + cuples.size());    //Valor correto: 38
//        StdOut.println("Animais no total: " + animals.size());      //Valor correto: 69
//
//        Gson objGson = new GsonBuilder().create();
//        String json = objGson.toJson(arkAnimals);
//
//        StdOut.println("json " + json);
//        StdOut.println("n de animais " + arkAnimals.size());
//
//        gson.toJson(json, new FileWriter("..\\ark-daniel\\resources\\arkList.json"));

    }

}
