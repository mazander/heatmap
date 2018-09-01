package com.mazander.heatmap;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class HeatmapRenderer {
	
	private final int width;
	
	private final int height;
	
	private final Bounds bounds = new Bounds(-1.0, -1.0, 1.0, 1.0);

	public HeatmapRenderer(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public void setBounds(Bounds bounds) {
		this.bounds.set(bounds);
	}

	public BufferedImage render(HeatSource heatSource, Colormap heatmapColors) {

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		int[] pixelData=((DataBufferInt)image.getRaster().getDataBuffer()).getData();
		
		
		for (int i = 0, p = 0; i < width; i++) {
			double x = bounds.getMinX() + bounds.getWidth() * i / width;
			
			for (int j = 0; j < height; j++) {
			
				double y = bounds.getMinX() + bounds.getHeigth() * j / height;
				double heat = heatSource.getHeatAt(x, y);
				pixelData[p++] = heatmapColors.getHeatARGBColor(heat);
			}
		}

		return image;
	}
	

}
