package com.mazander.heatmap;

import java.awt.Color;

public class SingleColorScheme implements ColorScheme {
	
	private final int rgba;

	public SingleColorScheme(Color color) {
		rgba = color.getRGB();
	}

	@Override
	public int getHeatARGBColor(double heat) {
		return rgba;
	}

}
