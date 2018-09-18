package com.mazander.heatmap;

public interface HeatSource {
	
	HeatSource EMPTY = new HeatSource() {
		
		@Override
		public double getHeatAt(double x, double y) {
			return 0.0;
		}
		
		@Override
		public Bounds getBounds() {
			return new Bounds();
		}
	};
	
	double getHeatAt(double x, double y);
	
	Bounds getBounds();
}
