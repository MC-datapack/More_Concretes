package github.mcdatapack.more_concretes.datagen;

import github.mcdatapack.more_concretes.MoreConcretes;
import github.mcdatapack.more_concretes.init.BlockInit;
import github.mcdatapack.more_concretes.init.ItemGroupInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.*;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
//TODO 1.21.2
//import net.minecraft.data.server.recipe.RecipeGenerator;
//TODO 1.21
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static github.mcdatapack.more_concretes.datagen.VanillaColors.*;

public class Provider {
    public static class Models extends FabricModelProvider {
        public Models(FabricDataOutput output) {
            super(output);
        }

        @Override
        public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
            for (Block concrete : BlockInit.CONCRETES) {
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
            for (Block concrete : BlockInit.CONCRETES) {
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
            getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.PICKAXE_MINEABLE).add(BlockInit.CONCRETES);
        }
    }

    //TODO 1.21
    public static class Recipe extends FabricRecipeProvider {
        public Recipe(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        public void generate(RecipeExporter exporter) {
            recipe(exporter, BLUE, 0);
            recipe(exporter, BLACK, 1);
            for (int i = 2; i < 10; i++) recipe(exporter, BLUE, i);
            for (int i = 10; i < 16; i++) recipe(exporter, LIGHT_BLUE, i);
            recipe(exporter, WHITE, 16);
            recipe(exporter, BLACK, 17);
            for (int i = 18; i < 22; i++) recipe(exporter, GRAY, i);
            for (int i = 22; i < 25; i++) recipe(exporter, LIGHT_GRAY, i);
            for (int i = 25; i < 28; i++) recipe(exporter, WHITE, i);
        }

        public void recipe(RecipeExporter exporter, VanillaColors color, int output) {
            RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockInit.CONCRETES[output], color.getConcrete());
        }
    }
    //TODO 1.21.2
    /*public static class Recipe extends FabricRecipeProvider {
        public Recipe(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, registriesFuture);
        }

        protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
            return new RecipeGenerator(registries, exporter) {
                @Override
                public void generate() {
                    offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, BlockInit.CONCRETES[0], BLUE.getConcrete());
                    offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, BlockInit.CONCRETES[1], BLACK.getConcrete());
                    for (int i = 2; i < 10; i++) offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, BlockInit.CONCRETES[i], BLUE.getConcrete());
                    for (int i = 10; i < 16; i++) offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, BlockInit.CONCRETES[i], LIGHT_BLUE.getConcrete());
                    offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, BlockInit.CONCRETES[16], WHITE.getConcrete());
                    offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, BlockInit.CONCRETES[17], BLACK.getConcrete());
                    for (int i = 18; i < 22; i++) offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, BlockInit.CONCRETES[i], GRAY.getConcrete());
                    for (int i = 22; i < 25; i++) offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, BlockInit.CONCRETES[i], LIGHT_GRAY.getConcrete());
                    for (int i = 25; i < 28; i++) offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, BlockInit.CONCRETES[i], WHITE.getConcrete());
                }
            };
        }

        @Override
        public String getName() {
            return "recipe";
        }
    }*/

    public static class Lang {
        public static class en_us extends FabricLanguageProvider {
            public en_us(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
                super(dataOutput, "en_us", registryLookup);
            }
            @Override
            public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder t) {
                translate(t, "en_us");
            }
        }
        public static class en_gb extends FabricLanguageProvider {
            public en_gb(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
                super(dataOutput, "en_gb", registryLookup);
            }
            @Override
            public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder t) {
                translate(t, "en_gb");
            }
        }
        public static class en_ca extends FabricLanguageProvider {
            public en_ca(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
                super(dataOutput, "en_ca", registryLookup);
            }
            @Override
            public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder t) {
                translate(t, "en_ca");
            }
        }
        public static class en_au extends FabricLanguageProvider {
            public en_au(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
                super(dataOutput, "en_au", registryLookup);
            }
            @Override
            public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder t) {
                translate(t, "en_au");
            }
        }
        public static class en_nz extends FabricLanguageProvider {
            public en_nz(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
                super(dataOutput, "en_nz", registryLookup);
            }
            @Override
            public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder t) {
                translate(t, "en_nz");
            }
        }
        public static class de_de extends FabricLanguageProvider {
            public de_de(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
                super(dataOutput, "de_de", registryLookup);
            }
            @Override
            public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder t) {
                translate(t, "de_de");
            }
        }

        private static void translate(FabricLanguageProvider.TranslationBuilder t, String lang) {
            addText(t, ItemGroupInit.MORE_CONCRETES_TITLE, "More Concretes");
            for (int i = 0; i < BlockInit.CONCRETES.length; i++) {
                t.add(BlockInit.CONCRETES[i], BlockInit.CONCRETE_NAMES(lang)[i]);
            }
        }

        private static void addText(@NotNull FabricLanguageProvider.TranslationBuilder builder, @NotNull Text text, @NotNull String value) {
            if (text.getContent() instanceof TranslatableTextContent translatableTextContent) {
                builder.add(translatableTextContent.getKey(), value);
            } else {
                MoreConcretes.logger.warn("Failed to add translation for text: {}", text.getString());
            }
        }
    }
}
