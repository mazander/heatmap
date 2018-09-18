package com.mazander.heatmap;

import java.awt.geom.Line2D;

public class SegmentHeat implements HeatSource {

	private final double x1;
	private final double y1;
	private final double x2;
	private final double y2;

	private final double maximumHeat;
	private final double heatRadius;
	
	private Attenuation attenuation = Attenuations.QUADRATIC;

	public SegmentHeat(double x1, double y1, double x2, double y2, double maximumHeat, double heatRadius) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.maximumHeat = maximumHeat;
		this.heatRadius = heatRadius;
	}

	@Override
	public double getHeatAt(double x, double y) {
		double distanceSq = Line2D.ptSegDistSq(x1, y1, x2, y2, x, y);
		if (distanceSq < heatRadius * heatRadius) {
			return getAttenuation().getAttenuation(Math.sqrt(distanceSq), heatRadius) * maximumHeat;
		} else {
			return 0.0;
		}
	}

	@Override
	public Bounds getBounds() {
		Bounds bounds = new Bounds(x1, y1, heatRadius);
		bounds.add(new Bounds(x2, y2, heatRadius));
		return bounds;
	}
	
	public void setAttenuation(Attenuation attenuation) {
		this.attenuation = attenuation;
	}
	
	public Attenuation getAttenuation() {
		return attenuation;
	}
	
	public SegmentHeat withAttenuation(Attenuation attenuation) {
		setAttenuation(attenuation);
		return this;
	}
}
