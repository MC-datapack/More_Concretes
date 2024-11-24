package github.mcdatapack.more_concretes.init;

import github.mcdatapack.more_concretes.MoreConcretes;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class BlockInit {
    //TODO Do the registries here
    public static final Block[] CONCRETES = {
            block("r0g13b57"), block("r2g0b8"), block("r7g40b109"), block("r7g49b167"), block("r11g63b175"),
            block("r14g36b96"), block("r14g53b158"), block("r15g65b186"), block("r18g106b255"), block("r27g75b186"),
            block("r27g112b254"), block("r43g118b243"), block("r52g153b255"), block("r66g154b252"), block("r80g198b244"),
            block("r89g179b255"), block("r206g244b255")
    };
    public static final String[] CONCRETE_NAMES = {
            name("Dark Blue", 0, 13, 57), name("Black", 2, 0, 8), name("Dark Blue", 7, 40, 109), name("Blue", 7, 49, 167),
            name("Blue", 11, 63, 175),
            name("Dark Blue", 14, 36, 96), name("Blue", 14, 53, 158), name("Blue", 15, 65, 186), name("Blue", 18, 106, 255),
            name("Blue", 27, 75, 186),
            name("Light Blue", 27, 112, 254), name("Light Blue", 43, 118, 243), name("Light Blue", 52, 153, 255),
            name("Light Blue", 18, 106, 255), name("Light Blue", 80, 198, 244),
            name("Light Blue", 89, 179, 255), name("White", 206, 244, 255)
    };

    private static String name(String s, int r, int g, int b) {
        return s + " Concrete (r=" + r + " g=" + g + " b=" + b + ")";
    }

    public static Block blockWithoutItem(String name) {
        RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, MoreConcretes.id(name));
        return Registry.register(Registries.BLOCK, MoreConcretes.id(name), new Block(AbstractBlock.Settings.create()
                .instrument(NoteBlockInstrument.BASEDRUM)
                .requiresTool()
                .strength(1.8F)
                .registryKey(registryKey)
        ));
    }

    public static Block block(String name) {
        RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, MoreConcretes.id(name));
        Block registered = blockWithoutItem(name);
        Registry.register(Registries.ITEM, MoreConcretes.id(name), new BlockItem(registered, new Item.Settings()
                .registryKey(registryKey)
                .useBlockPrefixedTranslationKey()));
        return registered;
    }

    public static void load() {}
}
