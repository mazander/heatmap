package com.mazander.heatmap;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class HeatmapRenderer {

	private final int imageWidth;

	private final int imageHeight;

	private final Bounds bounds = new Bounds(-1.0, -1.0, 1.0, 1.0);

	private double minHeat = 0.0;

	private double maxHeat = 1.0;

	public HeatmapRenderer(int imageWidth, int imageHeight) {
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;
	}

	public BufferedImage render(HeatSource heatSource, ColorScheme colorScheme) {

		BufferedImage image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
		int[] pixelData = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

		for (int i = 0, p = 0; i < imageWidth; i++) {
			double x = bounds.getMinX() + bounds.getWidth() * i / imageWidth;

			for (int j = 0; j < imageHeight; j++) {

				double y = bounds.getMinX() + bounds.getHeigth() * j / imageHeight;
				double heat = heatSource.getHeatAt(x, y);
				
				pixelData[p++] = colorScheme.getHeatARGBColor(heat);
			}
		}

		return image;
	}

	public double getMinHeat() {
		return minHeat;
	}

	public void setMinHeat(double minHeat) {
		this.minHeat = minHeat;
	}

	public double getMaxHeat() {
		return maxHeat;
	}

	public void setMaxHeat(double maxHeat) {
		this.maxHeat = maxHeat;
	}

	public int getImageWidth() {
		return imageWidth;
	}

	public int getImageHeight() {
		return imageHeight;
	}

	public void setBounds(Bounds bounds) {
		this.bounds.set(bounds);
	}

	public Bounds getBounds() {
		return bounds;
	}

}
