package com.mazander.heatmap;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

public class GettingStarted {

	public static void main(String[] args) {
		double worldWidth = 800.0;
		double worldHeight = 800.0;
		int imageWidth = 400;
		int imageHeight = 400;
		double heatRadius = 50.0;
		double maximumHeat = 0.3;

		// random heat sources
		Random random = new Random(1337);
		List<HeatSource> heatSources = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {

			double x = (0.5 * random.nextGaussian() + 0.5) * worldWidth;
			double y = (0.5 * random.nextGaussian() + 0.5) * worldHeight;

			heatSources.add(new PointHeat(x, y, maximumHeat, heatRadius));
		}

		// heatmap
		BinaryTreeHeatmap heatmap = new BinaryTreeHeatmap(heatSources);

		// render image
		HeatmapRenderer rendeder = new HeatmapRenderer(imageWidth, imageHeight);
		rendeder.setBounds(new Bounds(0.0, 0.0, worldWidth, worldHeight));
		ColorSchemes colorScheme = ColorSchemes.JET;
		BufferedImage image = rendeder.render(heatmap, colorScheme);

		// write image to file
		try {
			ImageIO.write(image, "png", new File("images/getting-started.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
