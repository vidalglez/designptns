package com.example.designptns.solid.isp;

interface Printer {
	void print(Document d);
}

interface Scanner {
	void scan(Document d);
}


interface MultiFunctionDevice extends Printer, Scanner{
	
}

public class InterfaceSegregationPrinciple {
	
	public class MultiFunctionPrinter implements MultiFunctionDevice {
		
		Printer printer;
		Scanner scanner;
		
		public MultiFunctionPrinter(Printer p, Scanner s) {
			printer = p;
			scanner = s;
		}

		@Override
		public void print(Document d) {
			printer.print(d);
		}

		@Override
		public void scan(Document d) {
			scanner.scan(d);
		}
		
	}

}
