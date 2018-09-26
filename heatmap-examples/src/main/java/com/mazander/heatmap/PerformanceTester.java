package com.mazander.heatmap;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

public class PerformanceTester {

	public static void main(String[] args) {
		double worldSize = 1000.0;
		int imageSize = 4000;
		double heatRadius = 50.0;
		double maximumHeat = 0.3;
		int heatCount = 2000;
		
		System.out.println("***** Performance Test *****");
		System.out.println("Image Size: " + imageSize + "x" + imageSize);
		System.out.println("Number of Point Heats: " + heatCount);

		// random heat sources
		Random random = new Random(1337);
		List<HeatSource> heatSources = new ArrayList<>();

		for (int i = 0; i < heatCount; i++) {

			double x = (0.5 * random.nextGaussian() + 0.5) * worldSize;
			double y = (0.5 * random.nextGaussian() + 0.5) * worldSize;

			heatSources.add(new PointHeat(x, y, maximumHeat, heatRadius));
		}

		// heatmap
		BinaryTreeHeatmap heatmap = new BinaryTreeHeatmap(heatSources);

		// render image
		HeatmapRenderer rendeder = new HeatmapRenderer(imageSize, imageSize);
		rendeder.setBounds(new Bounds(0.0, 0.0, worldSize, worldSize));
		
		long time = System.currentTimeMillis();
		BufferedImage image = rendeder.render(heatmap);
		time = System.currentTimeMillis() - time;
		System.out.println("Render time: " + time + " ms");
	
		// write image to file
		try {
			ImageIO.write(image, "png", new File("target/performance.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
