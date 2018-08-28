package com.mazander.heatmap;

public interface HeatSource {
	
	double getHeatAt(double x, double y);
	
	Rectangle getBounds();
}
