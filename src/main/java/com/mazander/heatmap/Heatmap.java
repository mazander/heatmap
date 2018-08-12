package com.mazander.heatmap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Heatmap implements HeatSource {

	protected final List<HeatSource> heatSources = new ArrayList<>();

	private double maxY = -Double.MAX_VALUE;

	private double minY = Double.MAX_VALUE;

	private double maxX = -Double.MAX_VALUE;

	private double minX = Double.MAX_VALUE;
	
	private final double centerX;
	
	private final double centerY;
	
	public Heatmap(Collection<HeatSource> heatSources) {
		this(heatSources, true);
	}
	
	private Heatmap(Collection<HeatSource> heatSources, boolean splitX) {
		for (HeatSource heatSource : heatSources) {
			minX = Math.min(minX, heatSource.getMinX());
			maxX = Math.max(maxX, heatSource.getMaxX());
			minY = Math.min(minY, heatSource.getMinY());
			maxY = Math.max(maxY, heatSource.getMaxY());
		}
		centerX = 0.5 * (maxX + minX);
		centerY = 0.5 * (maxY + minY);
		
		this.heatSources.addAll(heatSources);
	}
	
	@Override
	public double getHeatAt(double x, double y) {
		double sum = 0.0;
		for (HeatSource heatSource : heatSources) {
			sum += heatSource.getHeatAt(x, y);
		}
		return sum;
	}

	@Override
	public double getMinX() {
		return minX;
	}

	@Override
	public double getMaxX() {
		return maxX;
	}

	@Override
	public double getMinY() {
		return minY;
	}

	@Override
	public double getMaxY() {
		return maxY;
	}
	
}
