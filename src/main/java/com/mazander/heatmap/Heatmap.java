package com.mazander.heatmap;

import java.util.ArrayList;
import java.util.List;

public class Heatmap implements HeatSource {

	private static final int MAX_BINARY_TREE_LEVELS = 10;

	private static final int SPLIT_LIMIT = 10;

	protected final List<HeatSource> heatSources = new ArrayList<>();

	private final Rectangle bounds = new Rectangle();

	private final int level;

	private final boolean splitX;

	private Heatmap leftChild = null;

	private Heatmap rigthChild = null;

	public Heatmap() {
		this(MAX_BINARY_TREE_LEVELS);
	}

	public Heatmap(int level) {
		this.level = level;
		this.splitX = level % 2 == 0;
	}

	public void addHeatSource(HeatSource heatSource) {
		getBounds().add(heatSource.getBounds());
		heatSources.add(heatSource);
	}

	public void optimize() {
		if (level > 0 && heatSources.size() > SPLIT_LIMIT) {
			leftChild = new Heatmap(level - 1);
			rigthChild = new Heatmap(level - 1);
			for (HeatSource heatSource : heatSources) {
				addToLeft(heatSource);
				addToRigth(heatSource);
			}
			leftChild.optimize();
			rigthChild.optimize();
		}
	}

	private void addToRigth(HeatSource heatSource) {
		if (splitX && heatSource.getBounds().getMaxX() > getBounds().getCenterX()
				|| !splitX && heatSource.getBounds().getMaxY() > getBounds().getCenterY()) {
			rigthChild.addHeatSource(heatSource);
		}
	}

	private void addToLeft(HeatSource heatSource) {
		if (splitX && heatSource.getBounds().getMinX() < getBounds().getCenterX()
				|| !splitX && heatSource.getBounds().getMinY() < getBounds().getCenterY()) {
			leftChild.addHeatSource(heatSource);
		}
	}

	@Override
	public double getHeatAt(double x, double y) {
		double sum = 0.0;
		if (getBounds().intersects(x, y)) {
			for (HeatSource heatSource : heatSources) {
				sum += heatSource.getHeatAt(x, y);
			}
			if (leftChild != null) {
				sum += leftChild.getHeatAt(x, y);
			}
			if (rigthChild != null) {
				sum += rigthChild.getHeatAt(x, y);
			}
		}
		return sum;
	}

	@Override
	public Rectangle getBounds() {
		return bounds;
	}

}
