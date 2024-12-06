package github.mcdatapack.more_concretes.init;

import github.mcdatapack.more_concretes.MoreConcretes;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
//TODO 1.20.5
import net.minecraft.block.enums.Instrument;
//TODO 1.21+
//import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import static github.mcdatapack.more_concretes.init.Colors.*;

public class BlockInit {
    private static String lang;
    //TODO Do the registries here
    public static final Block[] CONCRETES = {
            block(0,13,57), block(2,0,8), block(7,40,109), block(7,49,167), block(11,63,175),
            block(14,36,96), block(14,53,158), block(15,65,186), block(18,106,255), block(27,75,186),
            block(27,112,254), block(43,118,243), block(52,153,255), block(66,154,252), block(80,198,244),
            block(89,179,255), block(206,244,255),
            block(0), block(25), block(50), block(75), block(100), block(140), block(160), block(200), block(220), block(240), block(255)
    };
    public static String[] CONCRETE_NAMES(String Lang) {
        lang = Lang;
            return new String[] {
                    name(DARK_BLUE, 0, 13, 57), name(BLACK, 2, 0, 8), name(DARK_BLUE, 7, 40, 109),
                    name(BLUE, 7, 49, 167), name(BLUE, 11, 63, 175),
                    name(DARK_BLUE, 14, 36, 96), name(BLUE, 14, 53, 158), name(BLUE, 15, 65, 186),
                    name(BLUE, 18, 106, 255), name(BLUE, 27, 75, 186),
                    name(LIGHT_BLUE, 27, 112, 254), name(LIGHT_BLUE, 43, 118, 243), name(LIGHT_BLUE, 52, 153, 255),
                    name(LIGHT_BLUE, 18, 106, 255), name(LIGHT_BLUE, 80, 198, 244),
                    name(LIGHT_BLUE, 89, 179, 255), name(WHITE, 206, 244, 255),
                    name(BLACK, 0), name(DARK_GRAY, 25), name(DARK_GRAY, 50), name(GRAY, 75),
                    name(GRAY, 100), name(LIGHT_GRAY, 140), name(LIGHT_GRAY, 160), name(LIGHT_GRAY, 200),
                    name(WHITE, 220), name(WHITE, 240), name(WHITE, 255)
            };
    }

    private static String name(Colors s, int r, int g, int b) {
        switch (lang) {
            case "en_us", "en_gb", "en_ca", "en_au", "en_nz" -> {
                return s.getName(lang) + " Concrete (r=" + r + " g=" + g + " b=" + b + ")";
            }
            case "de_de" -> {
                return s.getName(lang) + " Beton (r=" + r + " g=" + g + " b=" + b + ")";
            }
            default -> {
                MoreConcretes.logger.error("Error with the provided Language");
                return null;
            }
        }
    }

    private static String name(Colors s, int i) {
        return name(s, i, i, i);
    }

    public static Block blockWithoutItem(String name) {
        return Registry.register(Registries.BLOCK, MoreConcretes.id(name), new Block(AbstractBlock.Settings.create()
                .instrument(Instrument.BASEDRUM)
                .requiresTool()
                .strength(1.8F)
                .allowsSpawning(Blocks::never)
                //TODO 1.21.2
                //.registryKey(RegistryKey.of(RegistryKeys.BLOCK, MoreConcretes.id(name)))
        ));
    }

    public static Block block(int r, int g, int b) {
        Block registered = blockWithoutItem("r" + r + "g" + g + "b" + b);
        Registry.register(Registries.ITEM, MoreConcretes.id("r" + r + "g" + g + "b" + b), new BlockItem(registered, new Item.Settings()
                //TODO 1.21.2
                //.registryKey(RegistryKey.of(RegistryKeys.ITEM, MoreConcretes.id("r" + r + "g" + g + "b" + b)))
                //.useBlockPrefixedTranslationKey()
        ));
        return registered;
    }

    public static Block block (int i) {
        return block(i, i, i);
    }

    public static void load() {}
}
