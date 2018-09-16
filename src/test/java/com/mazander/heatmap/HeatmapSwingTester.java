package com.mazander.heatmap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HeatmapSwingTester {

	public static void main(String[] args) {
		List<HeatSource> heatSources = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			double x = Math.random() * 1000.0;
			double y = Math.random() * 1000.0;
			PointHeat pointHeat = new PointHeat(x, y, 1.0, 100.0);
			pointHeat.setAttenuation(Attenuations.QUADRATIC);
			heatSources.add(pointHeat);
		}
		BinaryTreeHeatmap heatmap = new BinaryTreeHeatmap(heatSources);

		HeatmapRenderer rendeder = new HeatmapRenderer(1000, 1000);
		rendeder.setBounds(new Bounds(0.0, 0.0, 1000.0, 1000.0));

		AlphaColorScheme alphaColorScheme = new AlphaColorScheme(ColorSchemes.JET, 0.0, 1.0, Attenuations.QUADRATIC);
		BufferedImage image = rendeder.render(heatmap, alphaColorScheme);
		JPanel imagePanel = new JPanel() {
			private static final long serialVersionUID = 1L;

			protected void paintComponent(java.awt.Graphics g) {
				g.fillOval(getWidth() / 5, getHeight() / 5, getWidth() / 5 * 3, getHeight()  / 5 * 3);
				
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			};
		};
		
		JFrame frame = new JFrame("test");
		frame.setSize(image.getWidth(), image.getHeight());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(imagePanel, BorderLayout.CENTER);
		frame.setVisible(true);
		System.out.println();
	}

}
