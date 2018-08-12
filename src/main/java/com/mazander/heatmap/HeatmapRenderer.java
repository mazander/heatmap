package com.mazander.heatmap;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class HeatmapRenderer {
	
	protected int width = 1000;
	
	protected int height = 1000;
	
	protected final Rectangle2D.Double bounds = new Rectangle2D.Double(-500.0, -500.0, 1000.0, 1000.0);

	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setBounds(double x, double y, double width, double height) {
		this.bounds.setRect(x, y, width, height);
	}

	public BufferedImage render(HeatSource heatSource, HeatmapColors heatmapColors) {

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				double x = i;
				double y = j;
				double heat = heatSource.getHeatAt(x, y);
				int argb = heatmapColors.getHeatARGBColor(heat);
				image.setRGB(i, j, argb);
			}
		}

		return image;
	}
	

}
