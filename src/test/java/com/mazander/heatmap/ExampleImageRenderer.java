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

		Random random = new Random(1337);
		List<HeatSource> heatSources = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			double x = random.nextGaussian() * 1000.0;
			double y = random.nextGaussian() * 1000.0;
			heatSources.add(new PointHeat(x, y, 0.5, 20.0));
		}
		BinaryTreeHeatmap heatmap = new BinaryTreeHeatmap(heatSources);

		HeatmapRenderer rendeder = new HeatmapRenderer(300, 300);
		rendeder.setBounds(new Bounds(0.0, 0.0, 300.0, 300.0));

		for (Colormap colormap : Colormaps.values()) {
			BufferedImage image = rendeder.render(heatmap, colormap);
			try {
				ImageIO.write(image, "png", new File("target/" + colormap + ".png"));
				System.out.println("![" + colormap + "](images/" + colormap + ".png)");
				System.out.println("**" + colormap + "**");
				System.out.println();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
