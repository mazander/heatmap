package com.mazander.heatmap;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ExampleImageRenderer {

	public static void main(String[] args) {

		List<HeatSource> heatSources = new ArrayList<>();
		for (int i = 0; i < 200; i++) {
			double x = Math.random() * 300;
			double y = Math.random() * 300;
			heatSources.add(new PointHeat(x, y, 1.0, 15.0));
		}
		Heatmap heatmap = new Heatmap();
		heatSources.forEach(hs -> heatmap.addHeatSource(hs));

		HeatmapRenderer rendeder = new HeatmapRenderer(300, 300);
		rendeder.setBounds(new Rectangle(0.0, 0.0, 300.0, 300.0));

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

		BufferedImage image = rendeder.render(heatmap, Colormaps.MAGMA);
		JLabel label = new JLabel(new ImageIcon(image));
		JFrame frame = new JFrame("test");
		frame.setSize(image.getWidth(), image.getHeight());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(label, BorderLayout.CENTER);
		frame.setVisible(true);
		System.out.println();
	}

}
