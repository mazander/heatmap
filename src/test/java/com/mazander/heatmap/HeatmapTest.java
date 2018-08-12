package com.mazander.heatmap;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.junit.Test;

public class HeatmapTest {

	@Test
	public void testDraw() {
		List<HeatSource> heatSources = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			double x = Math.random() * 1000;
			double y = Math.random() * 1000;
			heatSources.add(new PointHeat(x, y, 1.0, 50.0));
		}
		Heatmap heatmap = new Heatmap(heatSources);
//		heatmap.addHeatSource(new PointHeat(200, 200, 1.0, 200.0));
//		heatmap.addHeatSource(new PointHeat(500, 500, 1.0, 200.0));
			
		HeatmapRenderer rendeder = new HeatmapRenderer();
		
		BufferedImage image = rendeder.render(heatmap, ColorPalette.FIVE_COLORS);
	
		
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
