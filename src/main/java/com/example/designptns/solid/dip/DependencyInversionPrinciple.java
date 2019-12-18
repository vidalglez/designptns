package com.example.designptns.solid.dip;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.javatuples.Triplet;

//A. High Level modules should not depend on low-level modules
//Both should be depend on abstractions

enum Relationship {
	PARENT, CHILD, SIBLING
}

class Person {
	String name;

	public Person(String name) {
		this.name = name;
	}
}

//This is the abstraction for the low level module
interface RelationshipBrowser {
	List<Person> findAllChildrenOf(String name);
}

//class Relationships { // low-level
class Relationships implements RelationshipBrowser {
	private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();

	public List<Triplet<Person, Relationship, Person>> getRelations() {
		return relations;
	}

	public void addParentAndChild(Person parent, Person child) {
		relations.add(new Triplet<>(parent, Relationship.PARENT, child));
		relations.add(new Triplet<>(child, Relationship.CHILD, parent));
	}

	@Override
	public List<Person> findAllChildrenOf(String name) {
		return relations.stream()
				.filter(x -> Objects.equals(x.getValue0().name, name) && x.getValue1() == Relationship.PARENT)
				.map(Triplet::getValue2).collect(Collectors.toList());
	}
}

class Research { // high-level

	//This is not the way we should do it 
	public Research(Relationships relationships) {
		List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();

		relations.stream().filter(x -> x.getValue0().name.equals("John") && x.getValue1() == Relationship.PARENT)
				.forEach(ch -> System.out.println(String.format("John as a child called %s", ch.getValue2().name)));
	}
	
	
	//This is the way we should do it, not with previous constructor 
	public Research(RelationshipBrowser browser) {
		List<Person> children = browser.findAllChildrenOf("John");
		children.stream().forEach(ch -> System.out.println(String.format("John as a child called %s", ch.name)));
	}
}



//abstractions -> Interfaces or Abstract classes

//B. Abstractions should not depend on details
//Details should depend on abstractions

public class DependencyInversionPrinciple {

	public static void main(String[] args) {
		Person parent = new Person("John");
		Person child1 = new Person("Chris");
		Person child2 = new Person("Matt");

		Relationships relationships = new Relationships();

		relationships.addParentAndChild(parent, child1);
		relationships.addParentAndChild(parent, child2);

		new Research(relationships);
	}

}
