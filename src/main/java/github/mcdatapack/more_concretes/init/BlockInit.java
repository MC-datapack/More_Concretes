package github.mcdatapack.more_concretes.init;

import github.mcdatapack.more_concretes.MoreConcretes;
import github.mcdatapack.more_concretes.block.MoreConcretesConcreteBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.material.Material;

import java.util.*;

public class BlockInit {
    private static boolean initialized = false;
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
        MoreConcretesConcreteBlock block = new MoreConcretesConcreteBlock(r, g, b, FabricBlockSettings.of(Material.STONE)
                .requiresCorrectToolForDrops()
                .strength(1.8F)
                .isValidSpawn(((blockState, blockGetter, blockPos, object) -> false)));
        return Registry.register(Registry.BLOCK, MoreConcretes.id(name), block);
    }

    public static MoreConcretesConcreteBlock block(int r, int g, int b) {
        String name = "r" + r + "g" + g + "b" + b;
        MoreConcretesConcreteBlock registered = blockWithoutItem(r, g, b, name);
        Registry.register(Registry.ITEM, MoreConcretes.id(name),
                new BlockItem(registered, new FabricItemSettings().tab(ItemGroupInit.MORE_CONCRETES_GROUP)));
        return registered;
    }

    public static void load() {
        if (initialized)
            return;
        CONCRETES.add(blockWithoutItem(0, 0, 0, "r0g0b0"));
        Registry.register(Registry.ITEM, MoreConcretes.id("r0g0b0"),
                new BlockItem(CONCRETES.get(0), new FabricItemSettings().tab(ItemGroupInit.MORE_CONCRETES_GROUP)));
        for (float r = 0; r < 255; r += 7.5F) {
            for (float g = 0; g < 255; g += 7.5F) {
                for (float b = 0; b < 255; b += 7.5F) {
                    if (r == 0 && g == 0 && b == 0)
                        continue;
                    try {
                        CONCRETES.add(block((int) r, (int) g, (int) b));
                    } catch (RuntimeException e) {
                        MoreConcretes.logger.error("Failed to register block: r={}, g={}, b={}", r, g, b);
                    }
                }
            }
        }
        initialized = true;
    }
}
