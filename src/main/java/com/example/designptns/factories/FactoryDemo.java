package com.example.designptns.factories;

class Point{
	private double x, y;
	
	private Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return String.format("{x: %f, y: %f}", x, y);
	}
	
	public static class PointFactory{
		public static Point newCartesianPoint(double x, double y) {
			return new Point(x, y);
		}
		
		public static Point newPolarPoint(double rho, double theta) {
			return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
		}
	}
}

public class FactoryDemo {

	public static void main(String[] args) {
		Point point = Point.PointFactory.newCartesianPoint(2, 3);
		Point point2 =Point.PointFactory.newPolarPoint(4, 3);
		System.out.println(String.format("Point: %s \n Point: %s", point, point2));
	}
	
	
}
