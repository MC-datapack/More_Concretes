package github.mcdatapack.more_concretes.init;

import github.mcdatapack.more_concretes.MoreConcretes;
import github.mcdatapack.more_concretes.block.MoreConcretesConcreteBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

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
        return Registry.register(BuiltInRegistries.BLOCK, MoreConcretes.id(name), new MoreConcretesConcreteBlock(r, g, b, BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.BASEDRUM)
                .requiresCorrectToolForDrops()
                .strength(1.8F)
                .isValidSpawn(Blocks::never)
                .setId(ResourceKey.create(Registries.BLOCK, MoreConcretes.id(name)))
        ));
    }

    public static MoreConcretesConcreteBlock block(int r, int g, int b) {
        MoreConcretesConcreteBlock registered = blockWithoutItem(r, g, b, "r" + r + "g" + g + "b" + b);
        Registry.register(BuiltInRegistries.ITEM, MoreConcretes.id("r" + r + "g" + g + "b" + b), new BlockItem(registered, new Item.Properties()
                .setId(ResourceKey.create(Registries.ITEM, MoreConcretes.id("r" + r + "g" + g + "b" + b)))
                .useBlockDescriptionPrefix()
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
