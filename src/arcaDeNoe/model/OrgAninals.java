package arcaDeNoe.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;

public class OrgAninals {

    public List<Animal> filterEspecie (List<Animal> animals){
        List<Animal> arkAnimals = new ArrayList<>();
        for (Animal animal : animals) {
            if (!canFly(animal) && !isAmphibian(animal) && isTerrestrial(animal)) {
                arkAnimals.add(animal);
            }
        }
        return arkAnimals;
    }

    public List<Animal> createCuple (List<Animal> arkAnimals){
        List<Animal> cuples = new ArrayList<>();
        for (int i = 0; i < arkAnimals.size()-1; i++) {
            for (int j = 1; j < arkAnimals.size(); j++) {
                if (areSameAnimal(arkAnimals.get(i), arkAnimals.get(j)) &&
                        isMale(arkAnimals.get(i)) && isFemale(arkAnimals.get(j))) {
                    cuples.add(arkAnimals.get(i));
                    cuples.add(arkAnimals.get(j));
                }
            }
        }
        return cuples;
    }
    
    public void createJsonListFile (List<Animal> listCuple, String nameFile)throws Exception {
    	JSONArray list = new JSONArray();
        list.add(listCuple);
    	try (FileWriter file = new FileWriter(".\\resources\\"+nameFile+".json")){
        	file.write(list.toJSONString());
        	file.flush();
        	System.out.println("Arquivo Criado com sucesso!");
        }catch(IOException e){
        	e.printStackTrace();
        }
    }

    //List<Animal> filterCuple
    
    public List<Animal> filterAnimalFemale (List<Animal> animalsArk){
        return animalsArk.stream().filter(female -> "female".equals(female.getSex())).toList();
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
    //Verificando se o animal é do sexo masculino
    public boolean isMale(Animal animal) {
        return animal.getSex().toLowerCase().equals("male");
    }
    //Verificando se o animal é do sexo feminino
    public boolean isFemale(Animal animal) {
        return animal.getSex().toLowerCase().equals("female");
    }
    //Verificando se é dois animais são da mesma espécie
    public boolean areSameAnimal(Animal animalOne, Animal animalTwo) {
        return animalOne.getAnimal().equals(animalTwo.getAnimal());
    }
}
