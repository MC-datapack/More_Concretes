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

import static github.mcdatapack.more_concretes.init.Colors.*;

public class BlockInit {
    //TODO Do the registries here
    public static final Block[] CONCRETES = {
            block(0,13,57), block(2,0,8), block(7,40,109), block(7,49,167), block(11,63,175),
            block(14,36,96), block(14,53,158), block(15,65,186), block(18,106,255), block(27,75,186),
            block(27,112,254), block(43,118,243), block(52,153,255), block(66,154,252), block(80,198,244),
            block(89,179,255), block(206,244,255),
            block(0), block(25), block(50), block(75), block(100), block(140), block(160), block(200), block(220), block(240), block(255)
    };
    public static String[] CONCRETE_NAMES(String lang) {
            return new String[] {
                    name(DARK_BLUE, 0, 13, 57, lang), name(BLACK, 2, 0, 8, lang), name(DARK_BLUE, 7, 40, 109, lang),
                    name(BLUE, 7, 49, 167, lang), name(BLUE, 11, 63, 175, lang),
                    name(DARK_BLUE, 14, 36, 96, lang), name(BLUE, 14, 53, 158, lang), name(BLUE, 15, 65, 186, lang),
                    name(BLUE, 18, 106, 255, lang), name(BLUE, 27, 75, 186, lang),
                    name(LIGHT_BLUE, 27, 112, 254, lang), name(LIGHT_BLUE, 43, 118, 243, lang), name(LIGHT_BLUE, 52, 153, 255, lang),
                    name(LIGHT_BLUE, 18, 106, 255, lang), name(LIGHT_BLUE, 80, 198, 244, lang),
                    name(LIGHT_BLUE, 89, 179, 255, lang), name(WHITE, 206, 244, 255, lang),
                    name(BLACK, 0, lang), name(DARK_GRAY, 25, lang), name(DARK_GRAY, 50, lang), name(GRAY, 75, lang),
                    name(GRAY, 100, lang), name(LIGHT_GRAY, 140, lang), name(LIGHT_GRAY, 160, lang), name(LIGHT_GRAY, 200, lang),
                    name(WHITE, 220, lang), name(WHITE, 240, lang), name(WHITE, 255, lang)
            };
    }

    private static String name(Colors s, int r, int g, int b, String l) {
        switch (l) {
            case "en_us", "en_gb", "en_ca", "en_au", "en_nz" -> {
                return s.getName(l) + " Concrete (r=" + r + " g=" + g + " b=" + b + ")";
            }
            case "de_de" -> {
                return s.getName(l) + " Beton (r=" + r + " g=" + g + " b=" + b + ")";
            }
            default -> {
                MoreConcretes.logger.error("Error with the provided Language");
                return null;
            }
        }
    }

    private static String name(Colors s, int i, String l) {
        return name(s, i, i, i, l);
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
        //RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, MoreConcretes.id("r" + r + "g" + g + "b" + b));
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
