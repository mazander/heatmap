package com.mazander.heatmap;

public class Rectangle {

	private double maxY = -Double.MAX_VALUE;

	private double minY = Double.MAX_VALUE;

	private double maxX = -Double.MAX_VALUE;

	private double minX = Double.MAX_VALUE;
	
	public Rectangle() {
		
	}
	
	public Rectangle(double minX, double minY, double maxX, double maxY) {
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
	}
	
	public Rectangle(double x, double y, double size) {
		minX = x - size;
		maxX = x + size;
		minY = y - size;
		maxY = y + size;
	}
	
	public void set(Rectangle other) {
		this.minX = other.minX;
		this.minY = other.minY;
		this.maxX = other.maxX;
		this.maxY = other.maxY;
	}
	
	public void add(double x, double y) {
		minX = Math.min(minX, x);
		maxX = Math.max(maxX, x);
		minY = Math.min(minY, y);
		maxY = Math.max(maxY, y);
	}

	public void add(Rectangle bounds) {
		minX = Math.min(minX, bounds.minX);
		maxX = Math.max(maxX, bounds.maxX);
		minY = Math.min(minY, bounds.minY);
		maxY = Math.max(maxY, bounds.maxY);
	}
	
	public boolean intersects(double x, double y ) {
		return x >= minX && x <= maxX && y >= minY && y <= maxY;
	}

	public double getMaxY() {
		return maxY;
	}

	public double getMinY() {
		return minY;
	}

	public double getMaxX() {
		return maxX;
	}

	public double getMinX() {
		return minX;
	}
	
	public double getCenterX() {
		return 0.5 * getWidth();
	}
	
	public double getCenterY() {
		return 0.5 * getHeigth();
	}
	
	public double getWidth() {
		return minX + maxX;
	}

	public double getHeigth() {
		return minY + maxY;
	}
}
