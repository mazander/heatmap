package com.mazander.heatmap;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class UtilsTest {

	@Test
	public void testGetBendingRatio() {
		assertEquals(0.0, Utils.getBendingRatio(0.0, 10.0, 0.0), 0.0);
		assertEquals(1.0, Utils.getBendingRatio(0.0, 10.0, 10.0), 0.0);
		assertEquals(0.3, Utils.getBendingRatio(0.0, 10.0, 3.0), 0.0);
	}

	@Test
	public void testGetBlendedARGBColor() {
		assertEquals(Color.WHITE.getRGB(), Utils.getBlendedARGBColor(Color.WHITE, Color.BLACK, 0.0));
		assertEquals(Color.BLACK.getRGB(), Utils.getBlendedARGBColor(Color.WHITE, Color.BLACK, 1.0));
		assertEquals(Color.GRAY.getRGB(), Utils.getBlendedARGBColor(Color.WHITE, Color.BLACK, 0.5));
	}
	
	@Test
	public void testClampRatio() {
		assertEquals(0.0, Utils.clampRatio(-1.0), 0.0);
		assertEquals(0.0, Utils.clampRatio(0.0), 0.0);
		assertEquals(0.5, Utils.clampRatio(0.5), 0.0);
		assertEquals(1.0, Utils.clampRatio(1.0), 0.0);
		assertEquals(1.0, Utils.clampRatio(2.0), 0.0);
	}
	
	@Test
	public void testInterpolate() {
		assertEquals(0.0, Utils.interpolate(0.0, 0.0, 0.0), 0.0);
		assertEquals(0.0, Utils.interpolate(0.0, 100.0, 0.0), 0.0);
		assertEquals(50.0, Utils.interpolate(0.0, 100.0, 0.5), 0.0);
		assertEquals(100.0, Utils.interpolate(0.0, 100.0, 1.0), 0.0);
		assertEquals(-100.0, Utils.interpolate(0.0, 100.0, -1.0), 0.0);
		assertEquals(200.0, Utils.interpolate(0.0, 100.0, 2.0), 0.0);
	}

}
