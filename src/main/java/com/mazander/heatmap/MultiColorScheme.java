package com.mazander.heatmap;

import java.util.Arrays;

public class MultiColorScheme implements ColorScheme {
	
	private final MCSColor[] colors;
	
	public MultiColorScheme(MCSColor... colors) {
		if (colors.length < 2) {
			String message = "MultiColorScheme requires at least two " + MCSColor.class.getSimpleName()
					+ " instances.";
			throw new IllegalArgumentException(message);
		}
		this.colors = colors;
		Arrays.sort(this.colors);
	}

	@Override
	public int getARGBColor(double ratio) {
		if (ratio <= colors[0].getValue()) {
			return colors[0].getColor().getRGB();
		}
		for (int i = 1; i < colors.length; i++) {
			MCSColor current = colors[i];
			MCSColor previous = colors[i - 1];
			if (ratio <= current.getValue()) {
				double blending = Utils.getBendingRatio(previous.getValue(), current.getValue(), ratio);
				return Utils.getBlendedARGBColor(previous.getColor(), current.getColor(), blending);
			}
		}
		return colors[colors.length - 1].getColor().getRGB();
	}
}
