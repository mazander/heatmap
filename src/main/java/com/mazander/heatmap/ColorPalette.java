package com.mazander.heatmap;

import java.awt.Color;
import java.util.Arrays;

public class ColorPalette implements HeatmapColors {
	
	public static final ColorPalette SEVEN_COLORS = new ColorPalette(
			new HeatColor(0.0, Color.BLACK),
			new HeatColor(0.16666, Color.BLUE),
			new HeatColor(0.33333, Color.CYAN),
			new HeatColor(0.5, Color.GREEN),
			new HeatColor(0.66666, Color.YELLOW),
			new HeatColor(0.83333, Color.RED),
			new HeatColor(1.0, Color.WHITE));
	
	public static final ColorPalette FIVE_COLORS = new ColorPalette(
			new HeatColor(0.0, Color.BLUE),
			new HeatColor(0.25, Color.CYAN),
			new HeatColor(0.5, Color.GREEN),
			new HeatColor(0.75, Color.YELLOW),
			new HeatColor(1.0, Color.RED));
	
	public static final ColorPalette MONOCHROME = new ColorPalette(
			new HeatColor(0.0, Color.BLACK),
			new HeatColor(1.0, Color.WHITE));

	private final HeatColor[] colors;
	
	public ColorPalette(HeatColor... colors) {
		if (colors.length < 2) {
			String message = ColorPalette.class.getSimpleName() + " requires at least two "
					+ HeatColor.class.getSimpleName() + " instances.";
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
				double blending = getBendingRatio(previous.getHeat(), current.getHeat(), heat);
				Color color1 = previous.getColor();
				Color color2 = current.getColor();
				return getBlendedARGBColor(color1, color2, blending);
			}
		}
		return colors[colors.length - 1].getColor().getRGB();
	}
	
	static double getBendingRatio(double smaller, double bigger, double between) {
		return (between - smaller) / (bigger - smaller);
	}

	static int getBlendedARGBColor(final Color c1, final Color c2, final double blending) {

		final double inverseBlending = 1.0 - blending;

		final int a = (int) (c1.getAlpha() * inverseBlending + c2.getAlpha() * blending + 0.5);
		final int r = (int) (c1.getRed() * inverseBlending + c2.getRed() * blending + 0.5);
		final int g = (int) (c1.getGreen() * inverseBlending + c2.getGreen() * blending + 0.5);
		final int b = (int) (c1.getBlue() * inverseBlending + c2.getBlue() * blending + 0.5);

		return ((a & 0xFF) << 24) | ((r & 0xFF) << 16) | ((g & 0xFF) << 8) | ((b & 0xFF) << 0);
	}

}

