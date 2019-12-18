package com.example.designptns.builder;

public class FluentBuilderDemo {

	class Person {
		private String name, position;

		@Override
		public String toString() {
			return String.format("Person{" + "\t\n name: '%s', " + "\t\n position: '%s'" + "\n}", name, position);
		}
	}

	class PersonBuilder<SELF extends PersonBuilder<SELF>> {
		protected Person person = new Person();

		public SELF withName(String name) {
			person.name = name;
			// return this;
			// return (SELF) this;
			return self();
		}

		public Person build() {
			return person;
		}

		@SuppressWarnings("unchecked")
		public SELF self() {
			return (SELF) this;
		}

	}

	class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {

		public EmployeeBuilder worksAt(String position) {
			person.position = position;
			return self();
		}

		@Override
		public EmployeeBuilder self() {
			return this;
		}
	}

	public static void main(String[] args) {
		PersonBuilder<?> pb = new FluentBuilderDemo().new PersonBuilder<>();
		Person bunbury = pb.withName("Bunbury").build();
		System.out.println(bunbury);

		EmployeeBuilder eb = new FluentBuilderDemo().new EmployeeBuilder();
		Person cerati = eb.withName("Cerati").worksAt("Guitar Player").build();
		System.out.println(cerati);
	}

}
