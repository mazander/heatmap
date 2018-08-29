package com.mazander.heatmap;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class ColorUtilsTest {

	@Test
	public void testGetBendingRatio() {
		assertEquals(0.0, ColorUtils.getBendingRatio(0.0, 10.0, 0.0), 0.0);
		assertEquals(1.0, ColorUtils.getBendingRatio(0.0, 10.0, 10.0), 0.0);
		assertEquals(0.3, ColorUtils.getBendingRatio(0.0, 10.0, 3.0), 0.0);
	}

	@Test
	public void testGetBlendedARGBColor() {
		assertEquals(Color.WHITE.getRGB(), ColorUtils.getBlendedARGBColor(Color.WHITE, Color.BLACK, 0.0));
		assertEquals(Color.BLACK.getRGB(), ColorUtils.getBlendedARGBColor(Color.WHITE, Color.BLACK, 1.0));
		assertEquals(Color.GRAY.getRGB(), ColorUtils.getBlendedARGBColor(Color.WHITE, Color.BLACK, 0.5));
	}

}
