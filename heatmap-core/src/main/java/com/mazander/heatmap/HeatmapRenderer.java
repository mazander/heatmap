package com.mazander.heatmap;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HeatmapRenderer {

	private int subImageSize = 100;
	
	private int threadCount = Runtime.getRuntime().availableProcessors();

	private int imageWidth;

	private int imageHeight;

	private Bounds bounds = new Bounds(-1.0, -1.0, 1.0, 1.0);

	private double minHeat = 0.0;

	private double maxHeat = 1.0;
	
	private ColorScheme colorScheme = ColorSchemes.JET;

	public HeatmapRenderer(int imageWidth, int imageHeight) {
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;
	}

	public BufferedImage render(HeatSource heatSource) {

		BufferedImage image = new BufferedImage(getImageWidth(), getImageHeight(), BufferedImage.TYPE_INT_ARGB);
		int[] pixelData = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		
		ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
		
		ArrayList<CompletableFuture<Void>> futures = new ArrayList<>();
		for (int i = 0; i < getImageWidth(); i += getSubImageSize()) {
			for (int j = 0; j < getImageHeight(); j += getSubImageSize()) {
				final Rectangle rectangle = new Rectangle(i, j, getSubImageSize(), getSubImageSize());
				futures.add(CompletableFuture.runAsync(() -> renderSubImage(heatSource, rectangle, pixelData), executorService));
			}
		}
		CompletableFuture.allOf(futures.toArray(new CompletableFuture<?>[futures.size()])).join();
		
		executorService.shutdown();


		return image;
	}
	
	public void renderSubImage(final HeatSource heatSource, final Rectangle rectangle, final int[] pixelData) {

		int iMax = Math.min(rectangle.x + rectangle.width, getImageWidth());
		int jMax = Math.min(rectangle.y + rectangle.height, getImageHeight());

		for (int j = rectangle.y; j < jMax; j++) {

			double y = getBounds().getMinY() + getBounds().getHeigth() * j / getImageHeight();

			for (int i = rectangle.x; i < iMax; i++) {
				
				double x = getBounds().getMinX() + getBounds().getWidth() * i / getImageWidth();

				double heat = heatSource.getHeatAt(x, y);
				
				double ratio = Utils.clampRatio(Utils.getBendingRatio(getMinHeat(), getMaxHeat(), heat));
				
				int index = j * getImageWidth() + i;
				pixelData[index] = getColorScheme().getARGBColor(ratio);
			}
		}
	}

	public int getSubImageSize() {
		return subImageSize;
	}

	public void setSubImageSize(int subImageSize) {
		this.subImageSize = subImageSize;
	}

	public int getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}

	public int getImageHeight() {
		return imageHeight;
	}

	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}

	public double getMinHeat() {
		return minHeat;
	}

	public void setMinHeat(double minHeat) {
		this.minHeat = minHeat;
	}

	public double getMaxHeat() {
		return maxHeat;
	}

	public void setMaxHeat(double maxHeat) {
		this.maxHeat = maxHeat;
	}

	public ColorScheme getColorScheme() {
		return colorScheme;
	}

	public void setColorScheme(ColorScheme colorScheme) {
		this.colorScheme = colorScheme;
	}

	public Bounds getBounds() {
		return bounds;
	}
	
	public void setBounds(Bounds bounds) {
		this.bounds.set(bounds);
	}
	
	public void setThreadCount(int threadCount) {
		this.threadCount = threadCount;
	}
	
	public int getThreadCount() {
		return threadCount;
	}

}
