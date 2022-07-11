package arcaDenoe.controllerJSON;

import com.google.gson.Gson;

import arcaDenoe.model.Animal;
import arcaDenoe.model.Habitat;
import arcaDenoe.model.Movement;

public class ManipulaJSON {
	
	public Gson carregarJSON () {
		Gson g = new Gson();
		Animal a = new Animal();
		Habitat h = new Habitat("Agua");
		Movement m = new Movement("Terrestre");
		
		a.setAge("5");
		a.setAnimal("tartaruga");
		a.setSex("femea");
		a.setType("reptil");
		
		g.toJson(a);
		return g;
	}

}
