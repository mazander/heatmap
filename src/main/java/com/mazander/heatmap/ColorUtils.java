package com.mazander.heatmap;

import java.awt.Color;

public final class ColorUtils {

	static int getBlendedARGBColor(final Color c1, final Color c2, final double blending) {
	
		final double inverseBlending = 1.0 - blending;
	
		final int a = (int) (c1.getAlpha() * inverseBlending + c2.getAlpha() * blending + 0.5);
		final int r = (int) (c1.getRed() * inverseBlending + c2.getRed() * blending + 0.5);
		final int g = (int) (c1.getGreen() * inverseBlending + c2.getGreen() * blending + 0.5);
		final int b = (int) (c1.getBlue() * inverseBlending + c2.getBlue() * blending + 0.5);
	
		return ((a & 0xFF) << 24) | ((r & 0xFF) << 16) | ((g & 0xFF) << 8) | ((b & 0xFF) << 0);
	}

	static double getBendingRatio(double smaller, double bigger, double between) {
		return (between - smaller) / (bigger - smaller);
	}



}
