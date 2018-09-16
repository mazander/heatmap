package com.mazander.heatmap;

import java.awt.Color;

final class Utils {

	static int getBlendedARGBColor(final Color c1, final Color c2, final double blending) {
	
		final double inverseBlending = 1.0 - blending;
	
		final int a = (int) (c1.getAlpha() * inverseBlending + c2.getAlpha() * blending + 0.5);
		final int r = (int) (c1.getRed() * inverseBlending + c2.getRed() * blending + 0.5);
		final int g = (int) (c1.getGreen() * inverseBlending + c2.getGreen() * blending + 0.5);
		final int b = (int) (c1.getBlue() * inverseBlending + c2.getBlue() * blending + 0.5);
	
		return ((a & 0xFF) << 24) | ((r & 0xFF) << 16) | ((g & 0xFF) << 8) | ((b & 0xFF) << 0);
	}

	static double getBendingRatio(final double smaller, final double bigger, final double between) {
		return (between - smaller) / (bigger - smaller);
	}
	
	static double interpolate(final double value1, final double value2, final double alpha) {
		return value1 * (1.0 - alpha) + value2 * alpha;
	}
	
	static double clampRatio(final double ratio) {
		if (ratio < 0.0) {
			return 0.0;
		} else if (ratio > 1.0) {
			return 1.0;
		}
		return ratio;
	}

}
