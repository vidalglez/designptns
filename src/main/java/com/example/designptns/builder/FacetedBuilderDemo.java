package com.example.designptns.builder;

public class FacetedBuilderDemo {

	class Person {
		// private String name;
		private String streetAdddress, postCode, city;
		private String companyName, position;
		private int annualIncome;

		@Override
		public String toString() {
			return String.format(
					"Person{" 
							+ "\t\n streetAdddress: '%s', " 
							+ "\t\n postCode: '%s', " 
							+ "\t\n city: '%s', "
							+ "\t\n companyName: '%s', " 
							+ "\t\n position: '%s', " 
							+ "\t\n annualIncome: '%d'" 
						+ "\n}",
					streetAdddress, postCode, city, companyName, position, annualIncome);
		}
	}

	// build facade
	class PersonBuilder {
		protected Person person = new Person();
		
		public PersonAddressBuilder lives() {
			return new PersonAddressBuilder(person);
		}
		
		public PersonJobBuilder works() {
			return new PersonJobBuilder(person);
		}
		
		public Person build() {
			return person;
		}
	}
	
	class PersonAddressBuilder extends PersonBuilder {
		public PersonAddressBuilder(Person person) {
			this.person = person;
		}
		
		public PersonAddressBuilder at(String streetAddress) {
			person.streetAdddress = streetAddress;
			return this;
		}
		
		
		public PersonAddressBuilder withPostCode(String postCode) {
			person.postCode = postCode;
			return this;
		}
		
		public PersonAddressBuilder in(String city) {
			person.city = city;
			return this;
		}
		
	}
	
	class PersonJobBuilder extends PersonBuilder{
		
		public PersonJobBuilder(Person person) {
			this.person = person;
		}
		
		public PersonJobBuilder at(String companyName) {
			person.companyName = companyName;
			return this;
		}
		
		public PersonJobBuilder asA(String position) {
			person.position = position;
			return this;
		}
		
		public PersonJobBuilder earning(int annualIncome) {
			person.annualIncome = annualIncome;
			return this;
		}
	}

	public static void main(String[] args) {
		PersonBuilder pb = new FacetedBuilderDemo(). new PersonBuilder();
		Person person = pb
				.lives()
					.at("123  London Road")
					.in("London")
					.withPostCode("12345")
				.works()
					.at("Elektra")
					.asA("Seller")
					.earning(1200)
				.build();
		
		System.out.println(person);
	}
}
