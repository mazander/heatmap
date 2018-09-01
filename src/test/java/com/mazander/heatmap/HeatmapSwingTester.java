package com.mazander.heatmap;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HeatmapSwingTester {

	public static void main(String[] args) {
		List<HeatSource> heatSources = new ArrayList<>();
		for (int i = 0; i < 20000; i++) {
			double x = Math.random() * 1000.0;
			double y = Math.random() * 1000.0;
			heatSources.add(new PointHeat(x, y, 0.1, 15.0));
		}
		BinaryTreeHeatmap heatmap = new BinaryTreeHeatmap(heatSources);

		HeatmapRenderer rendeder = new HeatmapRenderer(1000, 1000);
		rendeder.setBounds(new Bounds(0.0, 0.0, 1000.0, 1000.0));

		BufferedImage image = rendeder.render(heatmap, Colormaps.SEVEN_COLORS);
		JPanel imagePanel = new JPanel() {
			private static final long serialVersionUID = 1L;

			protected void paintComponent(java.awt.Graphics g) {
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			};
		};
		
		JFrame frame = new JFrame("test");
		frame.setSize(image.getWidth(), image.getHeight());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(imagePanel, BorderLayout.CENTER);
		frame.setVisible(true);
		System.out.println();
	}

}
