package com.mazander.heatmap;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

public class ExampleImageRenderer {

	public static void main(String[] args) {

		double worldWidth = 800.0;
		double worldHeight = 800.0;
		int imageWidth = 400;
		int imageHeight = 400;
		double heatRadius = 50.0;
		double maximumHeat = 0.3;
		
		Random random = new Random(1337);
		
		List<HeatSource> heatSources = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {

			double x = (0.5 * random.nextGaussian() + 0.5) * worldWidth;
			double y = (0.5 * random.nextGaussian() + 0.5) * worldHeight;
			PointHeat pointHeat = new PointHeat(x, y, maximumHeat, heatRadius);
			pointHeat.setAttenuation(Attenuations.EXPONENTIAL);
			heatSources.add(pointHeat);
		}
		BinaryTreeHeatmap heatmap = new BinaryTreeHeatmap(heatSources);

		HeatmapRenderer rendeder = new HeatmapRenderer(imageWidth, imageHeight);
		rendeder.setBounds(new Bounds(0.0, 0.0, worldWidth, worldHeight));

		for (Colormap colormap : Colormaps.values()) {
			BufferedImage image = rendeder.render(heatmap, colormap);
			try {
				
				ImageIO.write(image, "png", new File("target/" + colormap + ".png"));
				System.out.println("| " + colormap + " |");
				System.out.println("| --- |");
				System.out.println("| ![" + colormap + "](images/" + colormap + ".png) |");


				System.out.println();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
