package com.mazander.heatmap;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.junit.Test;

public class HeatmapTest {

	@Test
	public void testDraw() {
		List<HeatSource> heatSources = new ArrayList<>();
		for (int i = 0; i < 200; i++) {
			double x = Math.random() * 300;
			double y = Math.random() * 300;
			heatSources.add(new PointHeat(x, y, 1.0, 15.0));
		}
		Heatmap heatmap = new Heatmap();
		heatSources.forEach(hs -> heatmap.addHeatSource(hs));
			
		HeatmapRenderer rendeder = new HeatmapRenderer();
		
		Map<String, Colormap> map = DefaultColormaps.getAllColormaps();
		for (String name : map.keySet()) {
			BufferedImage image = rendeder.render(heatmap, map.get(name));
			try {
				ImageIO.write(image, "png", new File("target/" + name + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	
		BufferedImage image = rendeder.render(heatmap, DefaultColormaps.MAGMA);
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
