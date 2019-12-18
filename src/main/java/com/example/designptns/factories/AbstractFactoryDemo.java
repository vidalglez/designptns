package com.example.designptns.factories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.javatuples.Pair;
import org.reflections.Reflections;

interface HotDrink {
	public void consume();
}

class Tea implements HotDrink {

	@Override
	public void consume() {
		System.out.println("This tea is delicious");
	}
}

class Coffee implements HotDrink {

	@Override
	public void consume() {
		System.out.println("This coffee is delicious");
	}
}

interface HotDrinkFactory {
	HotDrink prepare(int amount);
}

class TeaFactory implements HotDrinkFactory {

	@Override
	public HotDrink prepare(int amount) {
		System.out.println("Put in a tea bag, boil water, pour " + amount + "ml, add lemo, enjoy!");
		return new Tea();
	}
}

class CoffeeFactory implements HotDrinkFactory {

	@Override
	public HotDrink prepare(int amount) {
		System.out.println("Grind some beans, boil water, pour " + amount + "ml, add cream and sugar, enjoy!");
		return new Coffee();
	}

}

class HotDrinkMachine {
	private List<Pair<String, HotDrinkFactory>> namedFactories = new ArrayList<>();

	public HotDrinkMachine() throws Exception {
		Set<Class<? extends HotDrinkFactory>> types = new Reflections("").getSubTypesOf(HotDrinkFactory.class);
		for (Class<? extends HotDrinkFactory> type : types) {
			namedFactories.add(new Pair<>(type.getSimpleName().replace("Factory", ""),
					type.getDeclaredConstructor().newInstance()));
		}
	}
	
	public HotDrink makeDrink() throws NumberFormatException, IOException {
		System.out.println("Drinks available:");
		for(int i = 0; i < namedFactories.size(); i++) {
			Pair<String, HotDrinkFactory> item = namedFactories.get(i) ;
			System.out.println(String.format(" %d : %s", i, item.getValue0() ));
		}
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s;
			int i, amount;
			if((s = reader.readLine()) != null && (i = Integer.parseInt(s)) >= 0  && i < namedFactories.size()) {
				System.out.println("Specify amount: ");
				s = reader.readLine();
				if(s != null && (amount = Integer.parseInt(s)) > 0) {
					return namedFactories.get(i).getValue1().prepare(amount) ;
				}
				System.out.println("Incorrect input, try again");
			}
		}
	}
}

public class AbstractFactoryDemo {
	
	public static void main(String[] args) throws Exception {
		HotDrinkMachine machine = new HotDrinkMachine();
		HotDrink drink = machine.makeDrink();
		drink.consume();
		
	}

}
