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
		double distance = Point.distance(this.x, this.y, x, y);
		if (distance > heatRadius) {
			return 0.0;
		} else {
			return (heatRadius - distance) / heatRadius * maximumHeat;
		}
	}

	@Override
	public double getMinX() {
		return x - heatRadius;
	}

	@Override
	public double getMaxX() {
		return x + heatRadius;
	}

	@Override
	public double getMinY() {
		return y - heatRadius;
	}

	@Override
	public double getMaxY() {
		return y + heatRadius;
	}
}
