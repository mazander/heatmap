package com.mazander.heatmap;

public enum Attenuations implements Attenuation {
	
	CONSTANT() {

		@Override
		public double getAttenuation(double distance, double maxDistance) {
			return 1.0;
		}

	},
	
	LINEAR() {

		@Override
		public double getAttenuation(double distance, double maxDistance) {
			return (maxDistance - distance) / maxDistance;
		}

	},
	
	EXPONENTIAL() {

		@Override
		public double getAttenuation(double distance, double maxDistance) {
			double linear = LINEAR.getAttenuation(distance, maxDistance);
			return linear * linear;
		}

	}
	;

}
