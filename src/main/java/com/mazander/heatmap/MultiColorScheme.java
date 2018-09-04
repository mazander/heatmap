package com.mazander.heatmap;

import java.util.Arrays;

public class MultiColorScheme implements ColorScheme {
	
	private final HeatColor[] colors;
	
	public MultiColorScheme(HeatColor... colors) {
		if (colors.length < 2) {
			String message = "MultiColorScheme requires at least two " + HeatColor.class.getSimpleName()
					+ " instances.";
			throw new IllegalArgumentException(message);
		}
		this.colors = colors;
		Arrays.sort(this.colors);
	}

	@Override
	public int getHeatARGBColor(double heat) {
		if (heat <= colors[0].getHeat()) {
			return colors[0].getColor().getRGB();
		}
		for (int i = 1; i < colors.length; i++) {
			HeatColor current = colors[i];
			HeatColor previous = colors[i - 1];
			if (heat <= current.getHeat()) {
				double blending = ColorUtils.getBendingRatio(previous.getHeat(), current.getHeat(), heat);
				return ColorUtils.getBlendedARGBColor(previous.getColor(), current.getColor(), blending);
			}
		}
		return colors[colors.length - 1].getColor().getRGB();
	}
}
