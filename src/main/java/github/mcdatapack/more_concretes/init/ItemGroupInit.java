package github.mcdatapack.more_concretes.init;

import github.mcdatapack.more_concretes.MoreConcretes;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackLinkedSet;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ItemGroupInit {
    public static final Component MORE_CONCRETES_TITLE = Component.translatable("itemGroup.more_concretes");
    public static final CreativeModeTab MORE_CONCRETES_GROUP = register("more_concretes", FabricCreativeModeTab.builder()
            .title(MORE_CONCRETES_TITLE)
            .icon(BlockInit.CONCRETES.getFirst().asItem()::getDefaultInstance)
            .displayItems((displayContext, entries) -> {
                Set<ItemStack> set = ItemStackLinkedSet.createTypeAndComponentsSet();

                for (Block concrete : BlockInit.CONCRETES) {
                    set.add(concrete.asItem().getDefaultInstance());
                }

                entries.acceptAll(set);
            }).build());


    public static <T extends CreativeModeTab> T register(String name, T itemGroup) {
        return Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, MoreConcretes.id(name), itemGroup);
    }

    public static void load() {}
}
