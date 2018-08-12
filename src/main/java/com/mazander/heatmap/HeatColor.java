package com.mazander.heatmap;

import java.awt.Color;

public class HeatColor implements Comparable<HeatColor> {
	
	private final double heat;
	
	private final Color color;

	public HeatColor(double heat, Color color) {
		this.heat = heat;
		this.color = color;
	}

	@Override
	public int compareTo(HeatColor other) {
		return Double.compare(getHeat(), other.getHeat());
	}
	
	public double getHeat() {
		return heat;
	}
	
	public Color getColor() {
		return color;
	}
}