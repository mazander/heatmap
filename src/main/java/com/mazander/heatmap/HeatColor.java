package com.mazander.heatmap;

import java.awt.Color;

public class HeatColor implements Comparable<HeatColor> {

	private final Color color;

	private final double heat;

	public HeatColor(double heat, Color color) {
		this.heat = heat;
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public double getHeat() {
		return heat;
	}
	
	@Override
	public int compareTo(HeatColor other) {
		return Double.compare(getHeat(), other.getHeat());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		long temp;
		temp = Double.doubleToLongBits(heat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HeatColor other = (HeatColor) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (Double.doubleToLongBits(heat) != Double.doubleToLongBits(other.heat))
			return false;
		return true;
	}
}