package com.mazander.heatmap;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class HeatmapTest {

	private static final double HEAT = 10.0;

	@Test
	public void testGetHeatAt1() {
		List<HeatSource> heatSources = new ArrayList<>();
		for (int x = 0; x <= 1000; x += 100) {
			for (int y = 0; y <= 1000; y += 100) {
				heatSources.add(new PointHeat(x, y, HEAT, 50.0));
			}
		}
		
		BinaryTreeHeatmap heatmap = new BinaryTreeHeatmap(heatSources);
		for (int x = 0; x <= 1000; x++) {
			for (int y = 0; y <= 1000; y++) {
				double heat = heatmap.getHeatAt(x, y);
				assertTrue(heat >= 0.0);
				assertTrue(heat <= 10.0);
			}
		}
		
		assertEquals(10.0, heatmap.getHeatAt(0.0, 0.0), 0.0);
		assertEquals(0.0, heatmap.getHeatAt(50.0, 50.0), 0.0);
	}
	
	@Test
	public void testGetHeatAtSum() {
		List<HeatSource> heatSources = new ArrayList<>();
		heatSources.add(new PointHeat(100.0, 100.0, HEAT, 50.0));
		heatSources.add(new PointHeat(100.0, 100.0, HEAT, 50.0));
		BinaryTreeHeatmap heatmap = new BinaryTreeHeatmap(heatSources);
		assertEquals(2.0 * HEAT, heatmap.getHeatAt(100.0, 100), 0.0);
		assertEquals(00.0, heatmap.getHeatAt(0.0, 0.0), 0.0);
	}

	@Test
	public void testGetBounds() {
		List<HeatSource> heatSources = new ArrayList<>();
		heatSources.add(new PointHeat(100.0, 100.0, HEAT, 50.0));
		heatSources.add(new PointHeat(100.0, 100.0, HEAT, 50.0));
		BinaryTreeHeatmap heatmap = new BinaryTreeHeatmap(heatSources);
		assertEquals(50.0, heatmap.getBounds().getMinX(), 0.0);
		assertEquals(50.0, heatmap.getBounds().getMinY(), 0.0);
		assertEquals(150.0, heatmap.getBounds().getMaxX(), 0.0);
		assertEquals(150.0, heatmap.getBounds().getMaxY(), 0.0);
	}

}
