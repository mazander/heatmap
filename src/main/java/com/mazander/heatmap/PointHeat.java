package com.mazander.heatmap;

import java.awt.Point;

public class PointHeat implements HeatSource {

	private final double x;
	private final double y;

	private final double maximumHeat;
	private final double heatRadius;

	public PointHeat(double x, double y, double maximumHeat, double heatRadius) {
		this.x = x;
		this.y = y;
		this.maximumHeat = maximumHeat;
		this.heatRadius = heatRadius;

	}

	@Override
	public double getHeatAt(double x, double y) {
		double distanceSq = Point.distanceSq(this.x, this.y, x, y);
		if (distanceSq < heatRadius * heatRadius) {
			return (heatRadius - Math.sqrt(distanceSq)) / heatRadius * maximumHeat;
		} else {
			return 0.0;
		}
	}

	@Override
	public Bounds getBounds() {
		return new Bounds(x, y, heatRadius);
	}
}
