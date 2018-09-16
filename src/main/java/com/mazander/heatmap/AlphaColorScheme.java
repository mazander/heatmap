package com.mazander.heatmap;

public class AlphaColorScheme implements ColorScheme {

	private final ColorScheme colorScheme;

	private final double minAlpha;

	private final double maxAlpha;

	private final Attenuation attenuation;

	public AlphaColorScheme(ColorScheme colorScheme, double alpha) {
		this(colorScheme, alpha, alpha, Attenuations.NO);
	}
	
	public AlphaColorScheme(ColorScheme colorScheme, double minAlpha, double maxAlpha, Attenuation attenuation) {
		this.colorScheme = colorScheme;
		this.minAlpha = minAlpha;
		this.maxAlpha = maxAlpha;
		this.attenuation = attenuation;
	}

	@Override
	public int getARGBColor(double ratio) {
		int heatARGBColor = colorScheme.getARGBColor(ratio);
		double attenuationValue = attenuation.getAttenuation(ratio, 1.0);
		double alpha = getMaxAlpha() > getMinAlpha() ? Utils.interpolate(getMinAlpha(), getMaxAlpha(), attenuationValue) : getMaxAlpha();
		int intAlpha = (int)( alpha * 255.0 + 0.5);
		int alphaBits = (intAlpha & 0xFF) << 24;
		return alphaBits | (0x00FFFFFF & heatARGBColor);
	}

	public ColorScheme getColorScheme() {
		return colorScheme;
	}

	public double getMinAlpha() {
		return minAlpha;
	}

	public double getMaxAlpha() {
		return maxAlpha;
	}

	public Attenuation getAttenuation() {
		return attenuation;
	}
	


}
