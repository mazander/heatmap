package com.mazander.heatmap;

public interface HeatSource {
	
	double getHeatAt(double x, double y);
	
	double getMinX();
	
	double getMaxX();
	
	double getMinY();
	
	double getMaxY();
}
