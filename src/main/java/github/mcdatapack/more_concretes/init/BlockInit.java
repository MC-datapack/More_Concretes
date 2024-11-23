package github.mcdatapack.more_concretes.init;

import github.mcdatapack.more_concretes.MoreConcretes;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class BlockInit {
    //TODO Do the registries here
    public static final Block[] concretes = {
        block("test")
    };

    public static Block blockWithoutItem(String name) {
        return Registry.register(Registries.BLOCK, MoreConcretes.id(name), new Block(AbstractBlock.Settings.create()
                .instrument(NoteBlockInstrument.BASEDRUM)
                .requiresTool()
                .strength(1.8F)
        ));
    }

    public static Block block(String name) {
        Block registered = blockWithoutItem(name);
        Registry.register(Registries.ITEM, MoreConcretes.id(name), new BlockItem(registered, new Item.Settings()));
        return registered;
    }

    public static void load() {}
}
