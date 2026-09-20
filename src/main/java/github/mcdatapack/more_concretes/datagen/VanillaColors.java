package github.mcdatapack.more_concretes.datagen;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

@SuppressWarnings("unused")
public enum VanillaColors {
    WHITE(Blocks.CONCRETE.white()), LIGHT_GRAY(Blocks.CONCRETE.lightGray()), GRAY(Blocks.CONCRETE.gray()), BLACK(Blocks.CONCRETE.black()),
    BROWN(Blocks.CONCRETE.brown()), RED(Blocks.CONCRETE.red()), ORANGE(Blocks.CONCRETE.orange()), YELLOW(Blocks.CONCRETE.yellow()),
    LIME(Blocks.CONCRETE.lime()), GREEN(Blocks.CONCRETE.green()), CYAN(Blocks.CONCRETE.cyan()), LIGHT_BLUE(Blocks.CONCRETE.lightBlue()),
    BLUE(Blocks.CONCRETE.blue()), PURPLE(Blocks.CONCRETE.purple()), MAGENTA(Blocks.CONCRETE.magenta()), PINK(Blocks.CONCRETE.pink());

    private final Block concrete;

    VanillaColors(Block concrete) {
        this.concrete = concrete;
    }

    public Block getConcrete() {return concrete;}
}
