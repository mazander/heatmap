package com.mazander.heatmap;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointHeatTest {

	@Test
	public void testGetHeatAt() {
		assertEquals(100.0, new PointHeat(0.0, 0.0, 100.0, 10.0).getHeatAt(0.0, 0.0), 0.0);
		assertEquals(50.0, new PointHeat(0.0, 0.0, 100.0, 10.0).getHeatAt(0.0, 5.0), 0.0);
		assertEquals(0.0, new PointHeat(0.0, 0.0, 100.0, 10.0).getHeatAt(0.0, 10.0), 0.0);
		assertEquals(0.0, new PointHeat(0.0, 0.0, 100.0, 10.0).getHeatAt(0.0, 20.0), 0.0);
	}

}
