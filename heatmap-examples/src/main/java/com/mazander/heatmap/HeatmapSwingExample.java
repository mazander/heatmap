package com.mazander.heatmap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class HeatmapSwingExample {

	public static void main(String[] args) {
		List<HeatSource> heatSources = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			double x = Math.random() * 1000.0;
			double y = Math.random() * 1000.0;
			PointHeat pointHeat = new PointHeat(x, y, 50.0, 100.0);
			pointHeat.setAttenuation(Attenuations.QUADRATIC);
			heatSources.add(pointHeat);
		}
		BinaryTreeHeatmap heatmap = new BinaryTreeHeatmap(heatSources);

		HeatmapRenderer rendeder = new HeatmapRenderer(1000, 1000);
		rendeder.setMaxHeat(100.0);
		rendeder.setBounds(new Bounds(0.0, 0.0, 1000.0, 1000.0));

		AlphaColorScheme alphaColorScheme = new AlphaColorScheme(ColorSchemes.JET, 0.0, 1.0, Attenuations.QUADRATIC);
		BufferedImage mapImage;
		try {
			mapImage = ImageIO.read(HeatmapSwingExample.class.getResourceAsStream("/com/mazander/heatmap/helsinki.png"));
		} catch (IOException e) {
			mapImage = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_ARGB);
		}
		
		Graphics2D graphics = mapImage.createGraphics();
		
		rendeder.setColorScheme(alphaColorScheme);
		BufferedImage image = rendeder.render(heatmap);
		graphics.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
		graphics.dispose();
		
		JFrame frame = new JFrame("Heatmap");
		frame.setSize(image.getWidth(), image.getHeight());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(new JLabel(new ImageIcon(mapImage)), BorderLayout.CENTER);
		SwingUtilities.invokeLater(() -> frame.setVisible(true));
	}

}
