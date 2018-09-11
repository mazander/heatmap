package com.mazander.heatmap;

import java.awt.Color;

public class MCSColor implements Comparable<MCSColor> {

	private final Color color;

	private final double value;

	public MCSColor(double value, Color color) {
		this.value = value;
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public double getValue() {
		return value;
	}
	
	@Override
	public int compareTo(MCSColor other) {
		return Double.compare(getValue(), other.getValue());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		long temp;
		temp = Double.doubleToLongBits(value);
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
		MCSColor other = (MCSColor) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
			return false;
		return true;
	}
}