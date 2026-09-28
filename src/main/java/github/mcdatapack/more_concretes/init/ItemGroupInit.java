package github.mcdatapack.more_concretes.init;

import github.mcdatapack.more_concretes.MoreConcretes;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.world.item.CreativeModeTab;

public class ItemGroupInit {
    public static final CreativeModeTab MORE_CONCRETES_GROUP = FabricItemGroupBuilder.build(MoreConcretes.id("more_concretes"),
            () -> BlockInit.CONCRETES.get(0).asItem().getDefaultInstance());

    public static void load() {}
}
