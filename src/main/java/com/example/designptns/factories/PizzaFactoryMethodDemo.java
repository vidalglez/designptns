package com.example.designptns.factories;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
abstract class Pizza {

	private String name;
	private String dough;
	private String sauce;
	List<String> toppings = new ArrayList<>();

	public void prepare() {
		System.out.println(String.format("Preparing %s", name));
	}

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

class CheesePizza extends Pizza {
	public CheesePizza() {
		this.setName("Cheese Pizza");
	}
}

class GreekPizza extends Pizza {
	public GreekPizza() {
		this.setName("Greeck Pizza");
	}
}

class PepperoniPizza extends Pizza {
	public PepperoniPizza() {
		this.setName("Peperonni Pizza");
	}
}
/*
class PizzaStore {

	private SimplePizzaFactory factory;

	public PizzaStore(SimplePizzaFactory factory) {
		this.factory = factory;
	}

	Pizza orderPizza(String type) {

		Pizza pizza = factory.createPizza(type);

//		Pizza pizza = null;
//		if (type.equals("cheese")) {
//			pizza = new CheesePizza();
//		} else if (type.equals("greek")) {
//			pizza = new GreekPizza();
//		} else if (type.equals("peperonni")) {
//			pizza = new PeperonniPizza();
//		}

		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}

}
*/

abstract class PizzaStore {

	//This method is considered the factory method (defines an interface for creating an object)
	abstract Pizza createPizza(String type);

	Pizza orderPizza(String type) {

		Pizza pizza = createPizza(type);

		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}

}

class NYPizzaStore extends PizzaStore {

	
	//In this method, sub-classes decide which class to instantiate.
	//Factory method lets a class defer instantiation to sub-classes
	@Override
	Pizza createPizza(String type) {
		Pizza pizza = null;
		if (type.equals("cheese")) {
			pizza = new NYStyleCheesePizza();
		} else if (type.equals("greek")) {
			pizza = new NYStyleGreekPizza();
		} else if (type.equals("peperonni")) {
			pizza = new NYStylePepperoniPizza();
		}
		return pizza;
	}
	
}

class NYStyleCheesePizza extends CheesePizza{
	public NYStyleCheesePizza() {
		this.setName("NY Cheese Pizza style");
	}
}

class NYStylePepperoniPizza extends PepperoniPizza{
	public NYStylePepperoniPizza() {
		this.setName("NY Pepperoni Pizza style");
	}
}

class NYStyleGreekPizza extends GreekPizza{
	public NYStyleGreekPizza() {
		this.setName("NY Greek Pizza style");
		this.setDough("Thin Curst Dough");
		this.setSauce("Marinara Sauce");
		
		toppings.add("Greated Reggiano Cheese");
		toppings.add("Sliced Pepperoni");
		toppings.add("Garlic");
		toppings.add("Onion");
		toppings.add("Mushrooms");
		toppings.add("Red Pepper");
	}
}

class SimplePizzaFactory {

	public Pizza createPizza(String type) {
		Pizza pizza = null;
		if (type.equals("cheese")) {
			pizza = new CheesePizza();
		} else if (type.equals("greek")) {
			pizza = new GreekPizza();
		} else if (type.equals("peperonni")) {
			pizza = new PepperoniPizza();
		}
		return pizza;
	}
}

public class PizzaFactoryMethodDemo {

	public static void main(String[] args) {
		//First approach (Bad design)
		// PizzaStore store = new PizzaStore();
		// store.orderPizza("cheese");

		/*
		//Second approach
		SimplePizzaFactory factory = new SimplePizzaFactory();
		PizzaStore store = new PizzaStore(factory);
		Pizza pizza = store.orderPizza("cheese");

		System.out.println(String.format("\nYou have ordered %s", pizza.getName()));

		System.out.println();

		pizza = store.orderPizza("greek");
		System.out.println(String.format("\nYou have ordered %s", pizza.getName()));
		System.out.println();
		*/
		
		
		//Third approach
		PizzaStore store = new NYPizzaStore();
		Pizza pizza = store.orderPizza("cheese");
		System.out.println(String.format("\nYou have ordered %s", pizza.getName()));

		System.out.println();

		pizza = store.orderPizza("greek");
		System.out.println(String.format("\nYou have ordered %s", pizza.getName()));
		

	}
}
