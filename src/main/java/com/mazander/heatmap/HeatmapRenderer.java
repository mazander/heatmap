package com.mazander.heatmap;

import java.awt.image.BufferedImage;

public class HeatmapRenderer {
	
	private final int width;
	
	private final int height;
	
	private final Rectangle bounds = new Rectangle(-1.0, -1.0, 1.0, 1.0);

	public HeatmapRenderer(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public void setBounds(Rectangle bounds) {
		this.bounds.set(bounds);
	}

	public BufferedImage render(HeatSource heatSource, Colormap heatmapColors) {

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		for (int i = 0; i < width; i++) {
			double x = bounds.getMinX() + bounds.getWidth() * i / width;
			
			for (int j = 0; j < height; j++) {
			
				double y = bounds.getMinX() + bounds.getHeigth() * j / height;
				double heat = heatSource.getHeatAt(x, y);
				int argb = heatmapColors.getHeatARGBColor(heat);
				image.setRGB(i, j, argb);
			}
		}

		return image;
	}
	

}
