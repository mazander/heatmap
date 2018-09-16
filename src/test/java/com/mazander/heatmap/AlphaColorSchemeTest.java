package com.mazander.heatmap;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class AlphaColorSchemeTest {

	@Test
	public void testGetARGBColorNo() {
		AlphaColorScheme alphaColorSchemeA = new AlphaColorScheme(new SingleColorScheme(Color.RED), 0.5);
		assertEquals(0x80FF0000, alphaColorSchemeA.getARGBColor(0.0));
		assertEquals(0x80FF0000, alphaColorSchemeA.getARGBColor(0.5));
		assertEquals(0x80FF0000, alphaColorSchemeA.getARGBColor(1.0));

		AlphaColorScheme alphaColorSchemeB = new AlphaColorScheme(new SingleColorScheme(Color.GREEN), 0.3, 1.0,
				Attenuations.NO);
		assertEquals(0xFF00FF00, alphaColorSchemeB.getARGBColor(0.0));
		assertEquals(0xFF00FF00, alphaColorSchemeB.getARGBColor(0.5));
		assertEquals(0xFF00FF00, alphaColorSchemeB.getARGBColor(1.0));
	}

	@Test
	public void testGetARGBColorLinear() {
		AlphaColorScheme alphaColorSchemeA = new AlphaColorScheme(new SingleColorScheme(Color.RED), 0.0, 1.0,
				Attenuations.LINEAR);
		assertEquals(0xFFFF0000, alphaColorSchemeA.getARGBColor(0.0));
		assertEquals(0x80FF0000, alphaColorSchemeA.getARGBColor(0.5));
		assertEquals(0x00FF0000, alphaColorSchemeA.getARGBColor(1.0));

		AlphaColorScheme alphaColorSchemeB = new AlphaColorScheme(new SingleColorScheme(Color.GREEN), 0.25, 0.75,
				Attenuations.LINEAR);
		assertEquals(new Color(0f, 1f, 0f, 0.75f).getAlpha(),
				new Color(alphaColorSchemeB.getARGBColor(0.0), true).getAlpha());
		assertEquals(new Color(0f, 1f, 0f, 0.50f), new Color(alphaColorSchemeB.getARGBColor(0.5), true));
		assertEquals(new Color(0f, 1f, 0f, 0.25f), new Color(alphaColorSchemeB.getARGBColor(1.0), true));
	}

}
