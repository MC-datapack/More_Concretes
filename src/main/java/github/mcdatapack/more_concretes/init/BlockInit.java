package github.mcdatapack.more_concretes.init;

import github.mcdatapack.more_concretes.MoreConcretes;
import github.mcdatapack.more_concretes.block.MoreConcretesConcreteBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import java.util.*;

public class BlockInit {
    public static final List<MoreConcretesConcreteBlock> CONCRETES = new ArrayList<>();

    public static String name(String lang, Colors s, int r, int g, int b) {
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

    public static MoreConcretesConcreteBlock blockWithoutItem(int r, int g, int b, String name) {
        return Registry.register(Registries.BLOCK, MoreConcretes.id(name), new MoreConcretesConcreteBlock(r, g, b, AbstractBlock.Settings.create()
                .instrument(NoteBlockInstrument.BASEDRUM)
                .requiresTool()
                .strength(1.8F)
                .allowsSpawning(Blocks::never)
                .registryKey(RegistryKey.of(RegistryKeys.BLOCK, MoreConcretes.id(name)))
        ));
    }

    public static MoreConcretesConcreteBlock block(int r, int g, int b) {
        MoreConcretesConcreteBlock registered = blockWithoutItem(r, g, b, "r" + r + "g" + g + "b" + b);
        Registry.register(Registries.ITEM, MoreConcretes.id("r" + r + "g" + g + "b" + b), new BlockItem(registered, new Item.Settings()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, MoreConcretes.id("r" + r + "g" + g + "b" + b)))
                .useBlockPrefixedTranslationKey()
        ));
        return registered;
    }

    public static Block block (int i) {
        return block(i, i, i);
    }

    public static void load() {
        for (float r = 0; r < 255; r += 7.5F) {
            for (float g = 0; g < 255; g += 7.5F) {
                for (float b = 0; b < 255; b += 7.5F) {
                    CONCRETES.add(block((int) r, (int) g, (int) b));
                }
            }
        }
    }
}
