package github.mcdatapack.more_concretes.init;

import github.mcdatapack.more_concretes.MoreConcretes;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemStackSet;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

import java.util.Set;

public class ItemGroupInit {
    public static final Text MORE_CONCRETES_TITLE = Text.translatable("itemGroup.more_concretes");
    public static final ItemGroup MORE_CONCRETES_GROUP = register("more_concretes", FabricItemGroup.builder()
            .displayName(MORE_CONCRETES_TITLE)
            .icon(BlockInit.concretes[0].asItem()::getDefaultStack)
            .entries((displayContext, entries) -> {
                Set<ItemStack> set = ItemStackSet.create();

                for (Block concrete : BlockInit.concretes) {
                    set.add(concrete.asItem().getDefaultStack());
                }

                entries.addAll(set);
            }).build());


    public static <T extends ItemGroup> T register(String name, T itemGroup) {
        return Registry.register(Registries.ITEM_GROUP, MoreConcretes.id(name), itemGroup);
    }

    public static void load() {}
}
