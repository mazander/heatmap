package com.mazander.heatmap;

public class LinearAlphaColorScheme implements ColorScheme {
	
	private final ColorScheme colorScheme;

	public LinearAlphaColorScheme(ColorScheme colorScheme) {
		this.colorScheme = colorScheme;
	}

	@Override
	public int getARGBColor(double ratio) {
		int heatARGBColor = colorScheme.getARGBColor(ratio);
		int alpha = (int) (ratio * 255.0 + 0.5);
		int alphaBits = (alpha & 0xFF) << 24;
		return alphaBits | (0x00FFFFFF & heatARGBColor);
	}

}
