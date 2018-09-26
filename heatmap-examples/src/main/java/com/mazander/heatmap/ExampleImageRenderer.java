package com.mazander.heatmap;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

public class ExampleImageRenderer {

	private static final double WORLD_WIDTH = 800.0;
	private static final double WORLD_HEIGHT = 800.0;
	private static final int IMAGE_WIDTH = 400;
	private static final int IMAGE_HEIGHT = 400;
	private static final double HEAT_RADIUS = 50.0;
	private static final double MAXIMUM_HEAT = 0.3;

	public static void main(String[] args) {

		Random random = new Random(1337);

		List<HeatSource> heatSources = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {

			double x = (0.5 * random.nextGaussian() + 0.5) * WORLD_WIDTH;
			double y = (0.5 * random.nextGaussian() + 0.5) * WORLD_HEIGHT;
			PointHeat pointHeat = new PointHeat(x, y, MAXIMUM_HEAT, HEAT_RADIUS);
			pointHeat.setAttenuation(Attenuations.QUADRATIC);
			heatSources.add(pointHeat);
		}
		BinaryTreeHeatmap heatmap = new BinaryTreeHeatmap(heatSources);

		HeatmapRenderer rendeder = new HeatmapRenderer(IMAGE_WIDTH, IMAGE_HEIGHT);
		rendeder.setBounds(new Bounds(0.0, 0.0, WORLD_WIDTH, WORLD_HEIGHT));

		try (PrintStream out = new PrintStream(new FileOutputStream("ColorSchemes.md"), true,
				StandardCharsets.UTF_8.name())) {

			for (ColorScheme colorScheme : ColorSchemes.values()) {
				rendeder.setColorScheme(colorScheme);
				BufferedImage image = rendeder.render(heatmap);
				ImageIO.write(image, "png", new File("../images/" + colorScheme + ".png"));

				out.println("| " + colorScheme + " |");
				out.println("| --- |");
				out.println("| ![" + colorScheme + "](images/" + colorScheme + ".png) |");
				out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
