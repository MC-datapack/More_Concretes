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
            block(0,13,57), block(2,0,8), block(7,40,109), block(7,49,167), block(11,63,175),
            block(14,36,96), block(14,53,158), block(15,65,186), block(18,106,255), block(27,75,186),
            block(27,112,254), block(43,118,243), block(52,153,255), block(66,154,252), block(80,198,244),
            block(89,179,255), block(206,244,255),
            block(0), block(25), block(50), block(75), block(100), block(140), block(160), block(200), block(220), block(240), block(255)
    };
    public static final String[] CONCRETE_NAMES = {
            name("Dark Blue", 0, 13, 57), name("Black", 2, 0, 8), name("Dark Blue", 7, 40, 109), name("Blue", 7, 49, 167),
            name("Blue", 11, 63, 175),
            name("Dark Blue", 14, 36, 96), name("Blue", 14, 53, 158), name("Blue", 15, 65, 186), name("Blue", 18, 106, 255),
            name("Blue", 27, 75, 186),
            name("Light Blue", 27, 112, 254), name("Light Blue", 43, 118, 243), name("Light Blue", 52, 153, 255),
            name("Light Blue", 18, 106, 255), name("Light Blue", 80, 198, 244),
            name("Light Blue", 89, 179, 255), name("White", 206, 244, 255),
            "", "", "", "", "",
            "", "", "", "", "",
            ""
    };

    private static String name(String s, int r, int g, int b) {
        return s + " Concrete (r=" + r + " g=" + g + " b=" + b + ")";
    }

    public static Block blockWithoutItem(String name) {
        //TODO 1.21.2
        //RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, MoreConcretes.id(name));
        return Registry.register(Registries.BLOCK, MoreConcretes.id(name), new Block(AbstractBlock.Settings.create()
                .instrument(NoteBlockInstrument.BASEDRUM)
                .requiresTool()
                .strength(1.8F)
                //TODO 1.21.2
                //.registryKey(registryKey)
        ));
    }

    public static Block block(int r, int g, int b) {
        //TODO 1.21.2
        //RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, MoreConcretes.id(name));
        Block registered = blockWithoutItem("r" + r + "g" + g + "b" + b);
        Registry.register(Registries.ITEM, MoreConcretes.id("r" + r + "g" + g + "b" + b), new BlockItem(registered, new Item.Settings()
                //TODO 1.21.2
                //.registryKey(registryKey)
                //.useBlockPrefixedTranslationKey()
        ));
        return registered;
    }

    public static Block block (int i) {
        return block(i, i, i);
    }

    public static void load() {}
}
