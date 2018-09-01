# heatmap
Simple heatmap image generator for Java.

## Getting Started

```
double worldWidth = 1000.0;
double worldHeight = 1000.0;
int imageWidth = 400;
int imageHeight = 400;
double heatRadius = 50.0;
double maximumHeat = 0.2;

// random heat sources
Random random = new Random(1337);
List<HeatSource> heatSources = new ArrayList<>();
for (int i = 0; i < 1000; i++) {

	double x = (0.5 * random.nextGaussian() + 0.5) * worldWidth;
	double y = (0.5 * random.nextGaussian() + 0.5) * worldHeight;

	heatSources.add(new PointHeat(x, y, maximumHeat, heatRadius));
}

// heatmap
BinaryTreeHeatmap heatmap = new BinaryTreeHeatmap(heatSources);

// render image
HeatmapRenderer rendeder = new HeatmapRenderer(imageWidth, imageHeight);
rendeder.setBounds(new Bounds(0.0, 0.0, worldWidth, worldHeight));
BufferedImage image = rendeder.render(heatmap, Colormaps.CUBEHELIX);
```

| CUBEHELIX |
| --- |
| ![CUBEHELIX](images/CUBEHELIX.png) |

## Default Colormaps

| AUTUMN |
| --- |
| ![AUTUMN](images/AUTUMN.png) |

| BATHYMETRY |
| --- |
| ![BATHYMETRY](images/BATHYMETRY.png) |

| BLACKBODY |
| --- |
| ![BLACKBODY](images/BLACKBODY.png) |

| BLUERED |
| --- |
| ![BLUERED](images/BLUERED.png) |

| BONE |
| --- |
| ![BONE](images/BONE.png) |

| CDOM |
| --- |
| ![CDOM](images/CDOM.png) |

| CHLOROPHYLL |
| --- |
| ![CHLOROPHYLL](images/CHLOROPHYLL.png) |

| COLD |
| --- |
| ![COLD](images/COLD.png) |

| COOL |
| --- |
| ![COOL](images/COOL.png) |

| COPPER |
| --- |
| ![COPPER](images/COPPER.png) |

| CUBEHELIX |
| --- |
| ![CUBEHELIX](images/CUBEHELIX.png) |

| DENSITY |
| --- |
| ![DENSITY](images/DENSITY.png) |

| EARTH |
| --- |
| ![EARTH](images/EARTH.png) |

| ELECTRIC |
| --- |
| ![ELECTRIC](images/ELECTRIC.png) |

| FIVE_COLORS |
| --- |
| ![FIVE_COLORS](images/FIVE_COLORS.png) |

| FREESURFACE_BLUE |
| --- |
| ![FREESURFACE_BLUE](images/FREESURFACE_BLUE.png) |

| FREESURFACE_RED |
| --- |
| ![FREESURFACE_RED](images/FREESURFACE_RED.png) |

| GREENS |
| --- |
| ![GREENS](images/GREENS.png) |

| GREYS |
| --- |
| ![GREYS](images/GREYS.png) |

| HOT |
| --- |
| ![HOT](images/HOT.png) |

| HSV |
| --- |
| ![HSV](images/HSV.png) |

| INFERNO |
| --- |
| ![INFERNO](images/INFERNO.png) |

| JET |
| --- |
| ![JET](images/JET.png) |

| MAGMA |
| --- |
| ![MAGMA](images/MAGMA.png) |

| MONOCHROME |
| --- |
| ![MONOCHROME](images/MONOCHROME.png) |

| OXYGEN |
| --- |
| ![OXYGEN](images/OXYGEN.png) |

| PAR |
| --- |
| ![PAR](images/PAR.png) |

| PHASE |
| --- |
| ![PHASE](images/PHASE.png) |

| PICNIC |
| --- |
| ![PICNIC](images/PICNIC.png) |

| PLASMA |
| --- |
| ![PLASMA](images/PLASMA.png) |

| PORTLAND |
| --- |
| ![PORTLAND](images/PORTLAND.png) |

| RAINBOW |
| --- |
| ![RAINBOW](images/RAINBOW.png) |

| RAINBOW_SOFT |
| --- |
| ![RAINBOW_SOFT](images/RAINBOW_SOFT.png) |

| RDBU |
| --- |
| ![RDBU](images/RDBU.png) |

| SALINITY |
| --- |
| ![SALINITY](images/SALINITY.png) |

| SEVEN_COLORS |
| --- |
| ![SEVEN_COLORS](images/SEVEN_COLORS.png) |

| SPRING |
| --- |
| ![SPRING](images/SPRING.png) |

| SUMMER |
| --- |
| ![SUMMER](images/SUMMER.png) |

| TEMPERATURE |
| --- |
| ![TEMPERATURE](images/TEMPERATURE.png) |

| TURBIDITY |
| --- |
| ![TURBIDITY](images/TURBIDITY.png) |

| VELOCITY_BLUE |
| --- |
| ![VELOCITY_BLUE](images/VELOCITY_BLUE.png) |

| VELOCITY_GREEN |
| --- |
| ![VELOCITY_GREEN](images/VELOCITY_GREEN.png) |

| VIRIDIS |
| --- |
| ![VIRIDIS](images/VIRIDIS.png) |

| WARM |
| --- |
| ![WARM](images/WARM.png) |

| WINTER |
| --- |
| ![WINTER](images/WINTER.png) |

| YIGNBU |
| --- |
| ![YIGNBU](images/YIGNBU.png) |

| YIORRD |
| --- |
| ![YIORRD](images/YIORRD.png) |


