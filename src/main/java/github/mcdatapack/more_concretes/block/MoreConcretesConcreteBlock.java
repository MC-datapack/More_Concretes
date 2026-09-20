package github.mcdatapack.more_concretes.block;

import github.mcdatapack.more_concretes.init.Colors;
import net.minecraft.world.level.block.Block;

import java.util.EnumMap;

public class MoreConcretesConcreteBlock extends Block {
    public final int r, g, b;
    public final Colors color;

    public MoreConcretesConcreteBlock(int r, int g, int b, Properties settings) {
        super(settings);
        this.r = r;
        this.g = g;
        this.b = b;
        this.color = getClosestColor(r, g, b);
    }

    private static Colors getClosestColor(int r, int g, int b) {
        EnumMap<Colors, int[]> colorMap = new EnumMap<>(Colors.class);

        colorMap.put(Colors.DARK_BLUE, new int[]{0, 0, 139});
        colorMap.put(Colors.BLUE, new int[]{0, 0, 255});
        colorMap.put(Colors.LIGHT_BLUE, new int[]{173, 216, 230});
        colorMap.put(Colors.BLACK, new int[]{0, 0, 0});
        colorMap.put(Colors.WHITE, new int[]{255, 255, 255});
        colorMap.put(Colors.LIGHT_GRAY, new int[]{211, 211, 211});
        colorMap.put(Colors.GRAY, new int[]{128, 128, 128});
        colorMap.put(Colors.DARK_GRAY, new int[]{64, 64, 64});
        colorMap.put(Colors.CYAN, new int[]{0, 255, 255});
        colorMap.put(Colors.LIME, new int[]{0, 255, 0});
        colorMap.put(Colors.GREEN, new int[]{0, 128, 0});
        colorMap.put(Colors.DARK_GREEN, new int[]{0, 100, 0});
        colorMap.put(Colors.PINK, new int[]{255, 192, 203});
        colorMap.put(Colors.MAGENTA, new int[]{255, 0, 255});
        colorMap.put(Colors.PURPLE, new int[]{128, 0, 128});
        colorMap.put(Colors.YELLOW, new int[]{255, 255, 0});
        colorMap.put(Colors.ORANGE, new int[]{255, 165, 0});
        colorMap.put(Colors.RED, new int[]{255, 0, 0});
        colorMap.put(Colors.DARK_RED, new int[]{139, 0, 0});

        Colors closestColor = null;
        double minDistance = Double.MAX_VALUE;

        for (var entry : colorMap.entrySet()) {
            int[] rgb = entry.getValue();
            double distance = Math.sqrt(
                    Math.pow(r - rgb[0], 2) +
                            Math.pow(g - rgb[1], 2) +
                            Math.pow(b - rgb[2], 2)
            );

            if (distance < minDistance) {
                minDistance = distance;
                closestColor = entry.getKey();
            }
        }
        return closestColor;
    }
}
