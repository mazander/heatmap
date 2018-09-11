package com.mazander.heatmap;

public class AlphaColorScheme implements ColorScheme {

	private final int alphaBits;

	private final ColorScheme colorScheme;

	public AlphaColorScheme(ColorScheme colorScheme, double alpha) {
		this(colorScheme, (int) (alpha * 255.0 + 0.5));
	}

	public AlphaColorScheme(ColorScheme colorScheme, int alpha) {
		this.colorScheme = colorScheme;
		this.alphaBits = (alpha & 0xFF) << 24;
	}

	@Override
	public int getARGBColor(double ratio) {
		int heatARGBColor = colorScheme.getARGBColor(ratio);
		return alphaBits | (0x00FFFFFF & heatARGBColor);
	}

}
