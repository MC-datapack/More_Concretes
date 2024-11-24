package github.mcdatapack.more_concretes.datagen;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

@SuppressWarnings("unused")
public enum VanillaColors {
    WHITE(Blocks.WHITE_CONCRETE), LIGHT_GRAY(Blocks.LIGHT_GRAY_CONCRETE), GRAY(Blocks.GRAY_CONCRETE), BLACK(Blocks.BLACK_CONCRETE),
    BROWN(Blocks.BROWN_CONCRETE), RED(Blocks.RED_CONCRETE), ORANGE(Blocks.ORANGE_CONCRETE), YELLOW(Blocks.YELLOW_CONCRETE),
    LIME(Blocks.LIME_CONCRETE), GREEN(Blocks.GREEN_CONCRETE), CYAN(Blocks.CYAN_CONCRETE), LIGHT_BLUE(Blocks.LIGHT_BLUE_CONCRETE),
    BLUE(Blocks.BLUE_CONCRETE), PURPLE(Blocks.PURPLE_CONCRETE), MAGENTA(Blocks.MAGENTA_CONCRETE), PINK(Blocks.PINK_CONCRETE);

    private final Block concrete;

    VanillaColors(Block concrete) {
        this.concrete = concrete;
    }

    public Block getConcrete() {return concrete;}
}
