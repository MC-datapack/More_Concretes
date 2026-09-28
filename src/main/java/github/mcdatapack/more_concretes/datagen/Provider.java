package github.mcdatapack.more_concretes.datagen;

import github.mcdatapack.more_concretes.block.MoreConcretesConcreteBlock;
import github.mcdatapack.more_concretes.init.BlockInit;
import github.mcdatapack.more_concretes.init.ItemGroupInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.*;
import net.minecraft.core.Registry;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Provider {
    public static class Models extends FabricBlockStateDefinitionProvider {
        public Models(FabricDataGenerator dataGenerator) {
            super(dataGenerator);
        }

        @Override
        public void generateBlockStateModels(BlockModelGenerators generator) {
            for (Block concrete : BlockInit.CONCRETES) {
                generator.createTrivialCube(concrete);
            }
        }

        @Override
        public void generateItemModels(ItemModelGenerators generator) {}
    }

    public static class LootTables extends FabricBlockLootTablesProvider {
        public LootTables(FabricDataGenerator packOutput) {
            super(packOutput);
        }

        @Override
        protected void generateBlockLootTables() {
            for (Block concrete : BlockInit.CONCRETES) {
                dropSelf(concrete);
            }
        }

        @Override
        public void accept(BiConsumer<ResourceLocation, LootTable.Builder> resourceLocationBuilderBiConsumer) {
            for (Block concrete : BlockInit.CONCRETES) {
                ResourceLocation location = Registry.BLOCK.getKey(concrete);
                resourceLocationBuilderBiConsumer.accept(new ResourceLocation(location.getNamespace(), "blocks/" + location.getPath()), createSingleItemTable(concrete));
            }
        }
    }

    public static class BlockTags extends FabricTagProvider.BlockTagProvider {
        public BlockTags(FabricDataGenerator output) {
            super(output);
        }

        @Override
        protected void generateTags() {
            getOrCreateTagBuilder(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockInit.CONCRETES.toArray(new Block[0]));
        }
    }

    public static class Recipe extends FabricRecipesProvider {
        public Recipe(FabricDataGenerator output) {
            super(output);
        }

        @Override
        protected void generateRecipes(Consumer<FinishedRecipe> exporter) {
            for (MoreConcretesConcreteBlock block : BlockInit.CONCRETES) {
                stonecutterResultFromBase(exporter, block, block.color.vanillaColor.getConcrete());
            }
        }

        @Override
        public String getName() {
            return "recipe";
        }
    }

    /*public static class Lang {
        public static class en_us extends FabricLanguageProvider {
            public en_us(FabricDataGenerator output) {
                super(output, "en_us");
            }

            @Override
            public void generateTranslations(TranslationBuilder translationBuilder) {
                translate(translationBuilder, "en_us");
            }
        }
        public static class en_gb extends FabricLanguageProvider {
            public en_gb(FabricDataGenerator output) {
                super(output, "en_gb");
            }

            @Override
            public void generateTranslations(TranslationBuilder translationBuilder) {
                translate(translationBuilder, "en_gb");
            }
        }
        public static class en_ca extends FabricLanguageProvider {
            public en_ca(FabricDataGenerator output) {
                super(output, "en_ca");
            }

            @Override
            public void generateTranslations(TranslationBuilder translationBuilder) {
                translate(translationBuilder, "en_ca");
            }
        }
        public static class en_au extends FabricLanguageProvider {
            public en_au(FabricDataGenerator output) {
                super(output, "en_au");
            }

            @Override
            public void generateTranslations(TranslationBuilder translationBuilder) {
                translate(translationBuilder, "en_au");
            }
        }
        public static class en_nz extends FabricLanguageProvider {
            public en_nz(FabricDataGenerator output) {
                super(output, "en_nz");
            }

            @Override
            public void generateTranslations(TranslationBuilder translationBuilder) {
                translate(translationBuilder, "en_nz");
            }
        }
        public static class de_de extends FabricLanguageProvider {
            public de_de(FabricDataGenerator output) {
                super(output, "de_de");
            }

            @Override
            public void generateTranslations(TranslationBuilder translationBuilder) {
                translate(translationBuilder, "de_de");
            }
        }

        private static void translate(FabricLanguageProvider.TranslationBuilder t, String lang) {
            t.add(ItemGroupInit.MORE_CONCRETES_GROUP, "More Concretes");
            for (MoreConcretesConcreteBlock block : BlockInit.CONCRETES)
                t.add(block, BlockInit.name(lang, block.color, block.r, block.g, block.b));
        }
    }*/
}
