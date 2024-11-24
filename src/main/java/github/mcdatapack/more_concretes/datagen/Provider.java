package github.mcdatapack.more_concretes.datagen;

import github.mcdatapack.more_concretes.MoreConcretes;
import github.mcdatapack.more_concretes.init.BlockInit;
import github.mcdatapack.more_concretes.init.ItemGroupInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class Provider {
    public static class Models extends FabricModelProvider {
        public Models(FabricDataOutput output) {
            super(output);
        }

        @Override
        public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
            for (Block concrete : BlockInit.concretes) {
                blockStateModelGenerator.registerSimpleCubeAll(concrete);
            }
        }

        @Override
        public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        }
    }

    public static class LootTables extends FabricBlockLootTableProvider {
        public LootTables(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
            super(dataOutput, registryLookup);
        }

        @Override
        public void generate() {
            for (Block concrete : BlockInit.concretes) {
                addDrop(concrete);
            }
        }
    }

    public static class BlockTags extends FabricTagProvider.BlockTagProvider {
        public BlockTags(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
            getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.PICKAXE_MINEABLE).add(BlockInit.concretes);
        }
    }

    public static class Lang {
        public static class English extends FabricLanguageProvider {
            public English(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
                super(dataOutput, "en_us", registryLookup);
            }

            @Override
            public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder t) {
                addText(t, ItemGroupInit.MORE_CONCRETES_TITLE, "More Concretes");
                t.add(BlockInit.concretes[0], "");
            }


            private static void addText(@NotNull TranslationBuilder builder, @NotNull Text text, @NotNull String value) {
                if (text.getContent() instanceof TranslatableTextContent translatableTextContent) {
                    builder.add(translatableTextContent.getKey(), value);
                } else {
                    MoreConcretes.logger.warn("Failed to add translation for text: {}", text.getString());
                }
            }
        }
    }
}
