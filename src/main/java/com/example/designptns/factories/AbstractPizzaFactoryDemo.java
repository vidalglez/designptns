package com.example.designptns.factories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Data;

abstract class Dough {

}

abstract class Sauce {

}

abstract class Cheese {

}

abstract class Veggie {

}

abstract class Pepperoni {

}

abstract class Clams {

}

class ThickCrushDough extends Dough {

}

class PlumTomatoSauce extends Sauce {

}

class MozarellaCheese extends Cheese {

}

class ItalianPepperoni extends Pepperoni {
	
}

class BlackOlives extends Veggie {

}

class Spinach extends Veggie {

}

class EggPlant extends Veggie {

}

class FrozenClams extends Clams {
	
}

interface PizzaIngredientFactory {

	public Dough createDough();

	public Sauce createSauce();

	public Cheese createCheese();

	public List<Veggie> createVeggies();

	public Pepperoni createPepperoni();

	public Clams createClams();
}

@Data
abstract class Pizza_ {

	private String name;
	private Dough dough;
	private Sauce sauce;
	private List<Veggie> veggies;
	private Cheese cheese;
	private Pepperoni pepperoni;
	private Clams clams;
	
	List<String> toppings = new ArrayList<>();

	abstract void prepare();

	public void bake() {
		System.out.println(String.format("Baking %s", name));
	}

	public void cut() {
		System.out.println(String.format("Cutting %s", name));
	}

	public void box() {
		System.out.println(String.format("Boxing %s", name));
	}
}

class Cheese_Pizza extends Pizza_ {
	
	PizzaIngredientFactory ingredientFactory;
	
	public Cheese_Pizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory  =ingredientFactory;
		this.setName("Cheese Pizza");
	}

	@Override
	void prepare() {
		System.out.println("Preparing " + this.getName());	
		this.setDough(ingredientFactory.createDough());
		this.setSauce(ingredientFactory.createSauce());
		this.setCheese(ingredientFactory.createCheese());
	}
}

class Greek_Pizza extends Pizza_ {
	
	PizzaIngredientFactory ingredientFactory;
	
	public Greek_Pizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory  =ingredientFactory;
		this.setName("Greeck Pizza");
	}
	
	@Override
	void prepare() {
		System.out.println("Preparing " + this.getName());	
		this.setDough(ingredientFactory.createDough());
		this.setSauce(ingredientFactory.createSauce());
		this.setCheese(ingredientFactory.createCheese());
	}
}

class Pepperoni_Pizza extends Pizza_ {
	
	PizzaIngredientFactory ingredientFactory;
	
	public Pepperoni_Pizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory  =ingredientFactory;
		this.setName("Peperonni Pizza");
	}
	
	@Override
	void prepare() {
		System.out.println("Preparing " + this.getName());	
		this.setDough(ingredientFactory.createDough());
		this.setSauce(ingredientFactory.createSauce());
		this.setCheese(ingredientFactory.createCheese());
	}
}

class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

	@Override
	public Dough createDough() {
		return new ThickCrushDough();
	}

	@Override
	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	@Override
	public Cheese createCheese() {
		return new MozarellaCheese();
	}

	@Override
	public List<Veggie> createVeggies() {
		return Arrays.asList(new Veggie[] {new BlackOlives(), new Spinach(), new EggPlant()});
	}

	@Override
	public Pepperoni createPepperoni() {
		return new ItalianPepperoni();
	}

	@Override
	public Clams createClams() {
		return new FrozenClams();
	}

}

public class AbstractPizzaFactoryDemo {

	public static void main(String[] args) {

	}
}
