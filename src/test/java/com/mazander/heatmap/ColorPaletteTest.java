package com.mazander.heatmap;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class ColorPaletteTest {

	@Test
	public void testGetHeatARGBColor() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBendingRatio() {
		assertEquals(0.0, ColorPalette.getBendingRatio(0.0, 10.0, 0.0), 0.0);
		assertEquals(1.0, ColorPalette.getBendingRatio(0.0, 10.0, 10.0), 0.0);
		assertEquals(0.3, ColorPalette.getBendingRatio(0.0, 10.0, 3.0), 0.0);
	}

	@Test
	public void testGetBlendedARGBColor() {
		assertEquals(Color.WHITE.getRGB(), ColorPalette.getBlendedARGBColor(Color.WHITE, Color.BLACK, 0.0));
		assertEquals(Color.BLACK.getRGB(), ColorPalette.getBlendedARGBColor(Color.WHITE, Color.BLACK, 1.0));
		assertEquals(Color.GRAY.getRGB(), ColorPalette.getBlendedARGBColor(Color.WHITE, Color.BLACK, 0.5));
		//assertEquals(Color.LIGHT_GRAY.getRGB(), ColorRamp.getBlendedARGBColor(Color.WHITE, Color.BLACK, 192.0 / 255.0));
		//assertEquals(Color.DARK_GRAY.getRGB(), ColorRamp.getBlendedARGBColor(Color.WHITE, Color.BLACK, 0.75));
	}

}
