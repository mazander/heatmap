package com.mazander.heatmap;

import java.awt.Color;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Default color maps.
 */
public final class DefaultColormaps {
	
	public static Map<String, Colormap> getAllColormaps() {
		Map<String, Colormap> map = new LinkedHashMap<>();
		for (Field field : DefaultColormaps.class.getFields()) {
			try {
				map.put(field.getName(), (Colormap) field.get(null));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	public static final Colormap SEVEN_COLORS = new ColorPalette(new HeatColor(0.0, Color.BLACK),
			new HeatColor(0.16666, Color.BLUE), new HeatColor(0.33333, Color.CYAN), new HeatColor(0.5, Color.GREEN),
			new HeatColor(0.66666, Color.YELLOW), new HeatColor(0.83333, Color.RED), new HeatColor(1.0, Color.WHITE));

	public static final Colormap FIVE_COLORS = new ColorPalette(new HeatColor(0.0, Color.BLUE),
			new HeatColor(0.25, Color.CYAN), new HeatColor(0.5, Color.GREEN), new HeatColor(0.75, Color.YELLOW),
			new HeatColor(1.0, Color.RED));

	public static final Colormap MONOCHROME = new ColorPalette(new HeatColor(0.0, Color.BLACK),
			new HeatColor(1.0, Color.WHITE));

	public static final Colormap JET = new ColorPalette(new HeatColor(0, new Color(0, 0, 131)),
			new HeatColor(0.125, new Color(0, 60, 170)), new HeatColor(0.375, new Color(5, 255, 255)),
			new HeatColor(0.625, new Color(255, 255, 0)), new HeatColor(0.875, new Color(250, 0, 0)),
			new HeatColor(1, new Color(128, 0, 0)));

	public static final Colormap HSV = new ColorPalette(new HeatColor(0, new Color(255, 0, 0)),
			new HeatColor(0.169, new Color(253, 255, 2)), new HeatColor(0.173, new Color(247, 255, 2)),
			new HeatColor(0.337, new Color(0, 252, 4)), new HeatColor(0.341, new Color(0, 252, 10)),
			new HeatColor(0.506, new Color(1, 249, 255)), new HeatColor(0.671, new Color(2, 0, 253)),
			new HeatColor(0.675, new Color(8, 0, 253)), new HeatColor(0.839, new Color(255, 0, 251)),
			new HeatColor(0.843, new Color(255, 0, 245)), new HeatColor(1, new Color(255, 0, 6)));

	public static final Colormap HOT = new ColorPalette(new HeatColor(0, new Color(0, 0, 0)),
			new HeatColor(0.3, new Color(230, 0, 0)), new HeatColor(0.6, new Color(255, 210, 0)),
			new HeatColor(1, new Color(255, 255, 255)));

	public static final Colormap COLD = new ColorPalette(new HeatColor(0, new Color(0, 255, 255)),
			new HeatColor(1, new Color(255, 0, 255)));

	public static final Colormap SPRING = new ColorPalette(new HeatColor(0, new Color(255, 0, 255)),
			new HeatColor(1, new Color(255, 255, 0)));

	public static final Colormap SUMMER = new ColorPalette(new HeatColor(0, new Color(0, 128, 102)),
			new HeatColor(1, new Color(255, 255, 102)));

	public static final Colormap AUTUMN = new ColorPalette(new HeatColor(0, new Color(255, 0, 0)),
			new HeatColor(1, new Color(255, 255, 0)));

	public static final Colormap WINTER = new ColorPalette(new HeatColor(0, new Color(0, 0, 255)),
			new HeatColor(1, new Color(0, 255, 128)));

	public static final Colormap BONE = new ColorPalette(new HeatColor(0, new Color(0, 0, 0)),
			new HeatColor(0.376, new Color(84, 84, 116)), new HeatColor(0.753, new Color(169, 200, 200)),
			new HeatColor(1, new Color(255, 255, 255)));

	public static final Colormap COPPER = new ColorPalette(new HeatColor(0, new Color(0, 0, 0)),
			new HeatColor(0.804, new Color(255, 160, 102)), new HeatColor(1, new Color(255, 199, 127)));

	public static final Colormap GREYS = new ColorPalette(new HeatColor(0, new Color(0, 0, 0)),
			new HeatColor(1, new Color(255, 255, 255)));

	public static final Colormap YIGNBU = new ColorPalette(new HeatColor(0, new Color(8, 29, 88)),
			new HeatColor(0.125, new Color(37, 52, 148)), new HeatColor(0.25, new Color(34, 94, 168)),
			new HeatColor(0.375, new Color(29, 145, 192)), new HeatColor(0.5, new Color(65, 182, 196)),
			new HeatColor(0.625, new Color(127, 205, 187)), new HeatColor(0.75, new Color(199, 233, 180)),
			new HeatColor(0.875, new Color(237, 248, 217)), new HeatColor(1, new Color(255, 255, 217)));

	public static final Colormap GREENS = new ColorPalette(new HeatColor(0, new Color(0, 68, 27)),
			new HeatColor(0.125, new Color(0, 109, 44)), new HeatColor(0.25, new Color(35, 139, 69)),
			new HeatColor(0.375, new Color(65, 171, 93)), new HeatColor(0.5, new Color(116, 196, 118)),
			new HeatColor(0.625, new Color(161, 217, 155)), new HeatColor(0.75, new Color(199, 233, 192)),
			new HeatColor(0.875, new Color(229, 245, 224)), new HeatColor(1, new Color(247, 252, 245)));

	public static final Colormap YIORRD = new ColorPalette(new HeatColor(0, new Color(128, 0, 38)),
			new HeatColor(0.125, new Color(189, 0, 38)), new HeatColor(0.25, new Color(227, 26, 28)),
			new HeatColor(0.375, new Color(252, 78, 42)), new HeatColor(0.5, new Color(253, 141, 60)),
			new HeatColor(0.625, new Color(254, 178, 76)), new HeatColor(0.75, new Color(254, 217, 118)),
			new HeatColor(0.875, new Color(255, 237, 160)), new HeatColor(1, new Color(255, 255, 204)));

	public static final Colormap BLUERED = new ColorPalette(new HeatColor(0, new Color(0, 0, 255)),
			new HeatColor(1, new Color(255, 0, 0)));

	public static final Colormap RDBU = new ColorPalette(new HeatColor(0, new Color(5, 10, 172)),
			new HeatColor(0.35, new Color(106, 137, 247)), new HeatColor(0.5, new Color(190, 190, 190)),
			new HeatColor(0.6, new Color(220, 170, 132)), new HeatColor(0.7, new Color(230, 145, 90)),
			new HeatColor(1, new Color(178, 10, 28)));

	public static final Colormap PICNIC = new ColorPalette(new HeatColor(0, new Color(0, 0, 255)),
			new HeatColor(0.1, new Color(51, 153, 255)), new HeatColor(0.2, new Color(102, 204, 255)),
			new HeatColor(0.3, new Color(153, 204, 255)), new HeatColor(0.4, new Color(204, 204, 255)),
			new HeatColor(0.5, new Color(255, 255, 255)), new HeatColor(0.6, new Color(255, 204, 255)),
			new HeatColor(0.7, new Color(255, 153, 255)), new HeatColor(0.8, new Color(255, 102, 204)),
			new HeatColor(0.9, new Color(255, 102, 102)), new HeatColor(1, new Color(255, 0, 0)));

	public static final Colormap RAINBOW = new ColorPalette(new HeatColor(0, new Color(150, 0, 90)),
			new HeatColor(0.125, new Color(0, 0, 200)), new HeatColor(0.25, new Color(0, 25, 255)),
			new HeatColor(0.375, new Color(0, 152, 255)), new HeatColor(0.5, new Color(44, 255, 150)),
			new HeatColor(0.625, new Color(151, 255, 0)), new HeatColor(0.75, new Color(255, 234, 0)),
			new HeatColor(0.875, new Color(255, 111, 0)), new HeatColor(1, new Color(255, 0, 0)));

	public static final Colormap PORTLAND = new ColorPalette(new HeatColor(0, new Color(12, 51, 131)),
			new HeatColor(0.25, new Color(10, 136, 186)), new HeatColor(0.5, new Color(242, 211, 56)),
			new HeatColor(0.75, new Color(242, 143, 56)), new HeatColor(1, new Color(217, 30, 30)));

	public static final Colormap BLACKBODY = new ColorPalette(new HeatColor(0, new Color(0, 0, 0)),
			new HeatColor(0.2, new Color(230, 0, 0)), new HeatColor(0.4, new Color(230, 210, 0)),
			new HeatColor(0.7, new Color(255, 255, 255)), new HeatColor(1, new Color(160, 200, 255)));

	public static final Colormap EARTH = new ColorPalette(new HeatColor(0, new Color(0, 0, 130)),
			new HeatColor(0.1, new Color(0, 180, 180)), new HeatColor(0.2, new Color(40, 210, 40)),
			new HeatColor(0.4, new Color(230, 230, 50)), new HeatColor(0.6, new Color(120, 70, 20)),
			new HeatColor(1, new Color(255, 255, 255)));

	public static final Colormap ELECTRIC = new ColorPalette(new HeatColor(0, new Color(0, 0, 0)),
			new HeatColor(0.15, new Color(30, 0, 100)), new HeatColor(0.4, new Color(120, 0, 100)),
			new HeatColor(0.6, new Color(160, 90, 0)), new HeatColor(0.8, new Color(230, 200, 0)),
			new HeatColor(1, new Color(255, 250, 220)));

	public static final Colormap ALPHA = new ColorPalette(new HeatColor(0, new Color(255, 255, 255, 0)),
			new HeatColor(1, new Color(255, 255, 255, 1)));

	public static final Colormap VIRIDIS = new ColorPalette(new HeatColor(0, new Color(68, 1, 84)),
			new HeatColor(0.13, new Color(71, 44, 122)), new HeatColor(0.25, new Color(59, 81, 139)),
			new HeatColor(0.38, new Color(44, 113, 142)), new HeatColor(0.5, new Color(33, 144, 141)),
			new HeatColor(0.63, new Color(39, 173, 129)), new HeatColor(0.75, new Color(92, 200, 99)),
			new HeatColor(0.88, new Color(170, 220, 50)), new HeatColor(1, new Color(253, 231, 37)));

	public static final Colormap INFERNO = new ColorPalette(new HeatColor(0, new Color(0, 0, 4)),
			new HeatColor(0.13, new Color(31, 12, 72)), new HeatColor(0.25, new Color(85, 15, 109)),
			new HeatColor(0.38, new Color(136, 34, 106)), new HeatColor(0.5, new Color(186, 54, 85)),
			new HeatColor(0.63, new Color(227, 89, 51)), new HeatColor(0.75, new Color(249, 140, 10)),
			new HeatColor(0.88, new Color(249, 201, 50)), new HeatColor(1, new Color(252, 255, 164)));

	public static final Colormap MAGMA = new ColorPalette(new HeatColor(0, new Color(0, 0, 4)),
			new HeatColor(0.13, new Color(28, 16, 68)), new HeatColor(0.25, new Color(79, 18, 123)),
			new HeatColor(0.38, new Color(129, 37, 129)), new HeatColor(0.5, new Color(181, 54, 122)),
			new HeatColor(0.63, new Color(229, 80, 100)), new HeatColor(0.75, new Color(251, 135, 97)),
			new HeatColor(0.88, new Color(254, 194, 135)), new HeatColor(1, new Color(252, 253, 191)));

	public static final Colormap PLASMA = new ColorPalette(new HeatColor(0, new Color(13, 8, 135)),
			new HeatColor(0.13, new Color(75, 3, 161)), new HeatColor(0.25, new Color(125, 3, 168)),
			new HeatColor(0.38, new Color(168, 34, 150)), new HeatColor(0.5, new Color(203, 70, 121)),
			new HeatColor(0.63, new Color(229, 107, 93)), new HeatColor(0.75, new Color(248, 148, 65)),
			new HeatColor(0.88, new Color(253, 195, 40)), new HeatColor(1, new Color(240, 249, 33)));

	public static final Colormap WARM = new ColorPalette(new HeatColor(0, new Color(125, 0, 179)),
			new HeatColor(0.13, new Color(172, 0, 187)), new HeatColor(0.25, new Color(219, 0, 170)),
			new HeatColor(0.38, new Color(255, 0, 130)), new HeatColor(0.5, new Color(255, 63, 74)),
			new HeatColor(0.63, new Color(255, 123, 0)), new HeatColor(0.75, new Color(234, 176, 0)),
			new HeatColor(0.88, new Color(190, 228, 0)), new HeatColor(1, new Color(147, 255, 0)));

	public static final Colormap COOL = new ColorPalette(new HeatColor(0, new Color(125, 0, 179)),
			new HeatColor(0.13, new Color(116, 0, 218)), new HeatColor(0.25, new Color(98, 74, 237)),
			new HeatColor(0.38, new Color(68, 146, 231)), new HeatColor(0.5, new Color(0, 204, 197)),
			new HeatColor(0.63, new Color(0, 247, 146)), new HeatColor(0.75, new Color(0, 255, 88)),
			new HeatColor(0.88, new Color(40, 255, 8)), new HeatColor(1, new Color(147, 255, 0)));

	public static final Colormap RAINBOW_SOFT = new ColorPalette(new HeatColor(0, new Color(125, 0, 179)),
			new HeatColor(0.1, new Color(199, 0, 180)), new HeatColor(0.2, new Color(255, 0, 121)),
			new HeatColor(0.3, new Color(255, 108, 0)), new HeatColor(0.4, new Color(222, 194, 0)),
			new HeatColor(0.5, new Color(150, 255, 0)), new HeatColor(0.6, new Color(0, 255, 55)),
			new HeatColor(0.7, new Color(0, 246, 150)), new HeatColor(0.8, new Color(50, 167, 222)),
			new HeatColor(0.9, new Color(103, 51, 235)), new HeatColor(1, new Color(124, 0, 186)));

	public static final Colormap BATHYMETRY = new ColorPalette(new HeatColor(0, new Color(40, 26, 44)),
			new HeatColor(0.13, new Color(59, 49, 90)), new HeatColor(0.25, new Color(64, 76, 139)),
			new HeatColor(0.38, new Color(63, 110, 151)), new HeatColor(0.5, new Color(72, 142, 158)),
			new HeatColor(0.63, new Color(85, 174, 163)), new HeatColor(0.75, new Color(120, 206, 163)),
			new HeatColor(0.88, new Color(187, 230, 172)), new HeatColor(1, new Color(253, 254, 204)));

	public static final Colormap CDOM = new ColorPalette(new HeatColor(0, new Color(47, 15, 62)),
			new HeatColor(0.13, new Color(87, 23, 86)), new HeatColor(0.25, new Color(130, 28, 99)),
			new HeatColor(0.38, new Color(171, 41, 96)), new HeatColor(0.5, new Color(206, 67, 86)),
			new HeatColor(0.63, new Color(230, 106, 84)), new HeatColor(0.75, new Color(242, 149, 103)),
			new HeatColor(0.88, new Color(249, 193, 135)), new HeatColor(1, new Color(254, 237, 176)));

	public static final Colormap CHLOROPHYLL = new ColorPalette(new HeatColor(0, new Color(18, 36, 20)),
			new HeatColor(0.13, new Color(25, 63, 41)), new HeatColor(0.25, new Color(24, 91, 59)),
			new HeatColor(0.38, new Color(13, 119, 72)), new HeatColor(0.5, new Color(18, 148, 80)),
			new HeatColor(0.63, new Color(80, 173, 89)), new HeatColor(0.75, new Color(132, 196, 122)),
			new HeatColor(0.88, new Color(175, 221, 162)), new HeatColor(1, new Color(215, 249, 208)));

	public static final Colormap DENSITY = new ColorPalette(new HeatColor(0, new Color(54, 14, 36)),
			new HeatColor(0.13, new Color(89, 23, 80)), new HeatColor(0.25, new Color(110, 45, 132)),
			new HeatColor(0.38, new Color(120, 77, 178)), new HeatColor(0.5, new Color(120, 113, 213)),
			new HeatColor(0.63, new Color(115, 151, 228)), new HeatColor(0.75, new Color(134, 185, 227)),
			new HeatColor(0.88, new Color(177, 214, 227)), new HeatColor(1, new Color(230, 241, 241)));

	public static final Colormap FREESURFACE_BLUE = new ColorPalette(new HeatColor(0, new Color(30, 4, 110)),
			new HeatColor(0.13, new Color(47, 14, 176)), new HeatColor(0.25, new Color(41, 45, 236)),
			new HeatColor(0.38, new Color(25, 99, 212)), new HeatColor(0.5, new Color(68, 131, 200)),
			new HeatColor(0.63, new Color(114, 156, 197)), new HeatColor(0.75, new Color(157, 181, 203)),
			new HeatColor(0.88, new Color(200, 208, 216)), new HeatColor(1, new Color(241, 237, 236)));

	public static final Colormap FREESURFACE_RED = new ColorPalette(new HeatColor(0, new Color(60, 9, 18)),
			new HeatColor(0.13, new Color(100, 17, 27)), new HeatColor(0.25, new Color(142, 20, 29)),
			new HeatColor(0.38, new Color(177, 43, 27)), new HeatColor(0.5, new Color(192, 87, 63)),
			new HeatColor(0.63, new Color(205, 125, 105)), new HeatColor(0.75, new Color(216, 162, 148)),
			new HeatColor(0.88, new Color(227, 199, 193)), new HeatColor(1, new Color(241, 237, 236)));

	public static final Colormap OXYGEN = new ColorPalette(new HeatColor(0, new Color(64, 5, 5)),
			new HeatColor(0.13, new Color(106, 6, 15)), new HeatColor(0.25, new Color(144, 26, 7)),
			new HeatColor(0.38, new Color(168, 64, 3)), new HeatColor(0.5, new Color(188, 100, 4)),
			new HeatColor(0.63, new Color(206, 136, 11)), new HeatColor(0.75, new Color(220, 174, 25)),
			new HeatColor(0.88, new Color(231, 215, 44)), new HeatColor(1, new Color(248, 254, 105)));

	public static final Colormap PAR = new ColorPalette(new HeatColor(0, new Color(51, 20, 24)),
			new HeatColor(0.13, new Color(90, 32, 35)), new HeatColor(0.25, new Color(129, 44, 34)),
			new HeatColor(0.38, new Color(159, 68, 25)), new HeatColor(0.5, new Color(182, 99, 19)),
			new HeatColor(0.63, new Color(199, 134, 22)), new HeatColor(0.75, new Color(212, 171, 35)),
			new HeatColor(0.88, new Color(221, 210, 54)), new HeatColor(1, new Color(225, 253, 75)));

	public static final Colormap PHASE = new ColorPalette(new HeatColor(0, new Color(145, 105, 18)),
			new HeatColor(0.13, new Color(184, 71, 38)), new HeatColor(0.25, new Color(186, 58, 115)),
			new HeatColor(0.38, new Color(160, 71, 185)), new HeatColor(0.5, new Color(110, 97, 218)),
			new HeatColor(0.63, new Color(50, 123, 164)), new HeatColor(0.75, new Color(31, 131, 110)),
			new HeatColor(0.88, new Color(77, 129, 34)), new HeatColor(1, new Color(145, 105, 18)));

	public static final Colormap SALINITY = new ColorPalette(new HeatColor(0, new Color(42, 24, 108)),
			new HeatColor(0.13, new Color(33, 50, 162)), new HeatColor(0.25, new Color(15, 90, 145)),
			new HeatColor(0.38, new Color(40, 118, 137)), new HeatColor(0.5, new Color(59, 146, 135)),
			new HeatColor(0.63, new Color(79, 175, 126)), new HeatColor(0.75, new Color(120, 203, 104)),
			new HeatColor(0.88, new Color(193, 221, 100)), new HeatColor(1, new Color(253, 239, 154)));

	public static final Colormap TEMPERATURE = new ColorPalette(new HeatColor(0, new Color(4, 35, 51)),
			new HeatColor(0.13, new Color(23, 51, 122)), new HeatColor(0.25, new Color(85, 59, 157)),
			new HeatColor(0.38, new Color(129, 79, 143)), new HeatColor(0.5, new Color(175, 95, 130)),
			new HeatColor(0.63, new Color(222, 112, 101)), new HeatColor(0.75, new Color(249, 146, 66)),
			new HeatColor(0.88, new Color(249, 196, 65)), new HeatColor(1, new Color(232, 250, 91)));

	public static final Colormap TURBIDITY = new ColorPalette(new HeatColor(0, new Color(34, 31, 27)),
			new HeatColor(0.13, new Color(65, 50, 41)), new HeatColor(0.25, new Color(98, 69, 52)),
			new HeatColor(0.38, new Color(131, 89, 57)), new HeatColor(0.5, new Color(161, 112, 59)),
			new HeatColor(0.63, new Color(185, 140, 66)), new HeatColor(0.75, new Color(202, 174, 88)),
			new HeatColor(0.88, new Color(216, 209, 126)), new HeatColor(1, new Color(233, 246, 171)));

	public static final Colormap VELOCITY_BLUE = new ColorPalette(new HeatColor(0, new Color(17, 32, 64)),
			new HeatColor(0.13, new Color(35, 52, 116)), new HeatColor(0.25, new Color(29, 81, 156)),
			new HeatColor(0.38, new Color(31, 113, 162)), new HeatColor(0.5, new Color(50, 144, 169)),
			new HeatColor(0.63, new Color(87, 173, 176)), new HeatColor(0.75, new Color(149, 196, 189)),
			new HeatColor(0.88, new Color(203, 221, 211)), new HeatColor(1, new Color(254, 251, 230)));

	public static final Colormap VELOCITY_GREEN = new ColorPalette(new HeatColor(0, new Color(23, 35, 19)),
			new HeatColor(0.13, new Color(24, 64, 38)), new HeatColor(0.25, new Color(11, 95, 45)),
			new HeatColor(0.38, new Color(39, 123, 35)), new HeatColor(0.5, new Color(95, 146, 12)),
			new HeatColor(0.63, new Color(152, 165, 18)), new HeatColor(0.75, new Color(201, 186, 69)),
			new HeatColor(0.88, new Color(233, 216, 137)), new HeatColor(1, new Color(255, 253, 205)));

	public static final Colormap CUBEHELIX = new ColorPalette(new HeatColor(0, new Color(0, 0, 0)),
			new HeatColor(0.07, new Color(22, 5, 59)), new HeatColor(0.13, new Color(60, 4, 105)),
			new HeatColor(0.2, new Color(109, 1, 135)), new HeatColor(0.27, new Color(161, 0, 147)),
			new HeatColor(0.33, new Color(210, 2, 142)), new HeatColor(0.4, new Color(251, 11, 123)),
			new HeatColor(0.47, new Color(255, 29, 97)), new HeatColor(0.53, new Color(255, 54, 69)),
			new HeatColor(0.6, new Color(255, 85, 46)), new HeatColor(0.67, new Color(255, 120, 34)),
			new HeatColor(0.73, new Color(255, 157, 37)), new HeatColor(0.8, new Color(241, 191, 57)),
			new HeatColor(0.87, new Color(224, 220, 93)), new HeatColor(0.93, new Color(218, 241, 142)),
			new HeatColor(1, new Color(227, 253, 198)));

}
