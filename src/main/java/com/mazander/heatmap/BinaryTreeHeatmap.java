package com.mazander.heatmap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BinaryTreeHeatmap implements HeatSource {

	private static final int MAX_BINARY_TREE_LEVELS = 10;

	private static final int SPLIT_LIMIT = 10;

	private final Collection<HeatSource> heatSources;

	private final Bounds bounds;

	private final HeatSource leftChild;

	private final HeatSource rigthChild;

	private final boolean splitX;
	
	private static Bounds getBounds(Collection<HeatSource> heatSources) {
		Bounds bounds = new Bounds();
		for (HeatSource heatSource : heatSources) {
			bounds.add(heatSource.getBounds());
		}
		return bounds;
	}

	public BinaryTreeHeatmap(Collection<HeatSource> heatSources) {
		this(heatSources, getBounds(heatSources), MAX_BINARY_TREE_LEVELS);
	}

	public BinaryTreeHeatmap(Collection<HeatSource> heatSources, Bounds bounds, int level) {
		this.splitX = level % 2 == 0;
		this.bounds = bounds;

		if (level > 0 && heatSources.size() > SPLIT_LIMIT) {
			Collection<HeatSource> left = new ArrayList<>();
			Collection<HeatSource> right = new ArrayList<>();
			for (HeatSource heatSource : heatSources) {
				if (isAtLeft(heatSource)) {
					left.add(heatSource);
				}
				if (isAtRigth(heatSource)) {
					right.add(heatSource);
				}
			}

			this.leftChild = left.isEmpty() ? HeatSource.EMPTY : new BinaryTreeHeatmap(left, getBounds().split(splitX, true), level - 1);
			this.rigthChild = right.isEmpty() ? HeatSource.EMPTY : new BinaryTreeHeatmap(right, getBounds().split(splitX, false), level - 1);
			this.heatSources = Collections.emptyList();

		} else {

			this.heatSources = heatSources;
			this.leftChild = HeatSource.EMPTY;
			this.rigthChild = HeatSource.EMPTY;
		}
	}

	private boolean isAtRigth(HeatSource heatSource) {
		return splitX && heatSource.getBounds().getMaxX() > getBounds().getCenterX()
				|| !splitX && heatSource.getBounds().getMaxY() > getBounds().getCenterY();
	}

	private boolean isAtLeft(HeatSource heatSource) {
		return splitX && heatSource.getBounds().getMinX() < getBounds().getCenterX()
				|| !splitX && heatSource.getBounds().getMinY() < getBounds().getCenterY();
	}

	@Override
	public double getHeatAt(double x, double y) {
		double sum = 0.0;
		if (getBounds().intersects(x, y)) {
			if (heatSources.isEmpty()) {
				sum += leftChild.getHeatAt(x, y);
				sum += rigthChild.getHeatAt(x, y);
			} else {
				for (HeatSource heatSource : heatSources) {
					sum += heatSource.getHeatAt(x, y);
				}
			}

		}
		return sum;
	}

	@Override
	public Bounds getBounds() {
		return bounds;
	}

}
