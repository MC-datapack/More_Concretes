package github.mcdatapack.more_concretes.datagen;

import github.mcdatapack.more_concretes.MoreConcretes;
import github.mcdatapack.more_concretes.block.MoreConcretesConcreteBlock;
import github.mcdatapack.more_concretes.init.BlockInit;
import github.mcdatapack.more_concretes.init.ItemGroupInit;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.*;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Provider {
    public static class Models extends FabricModelProvider {
        public Models(FabricPackOutput output) {
            super(output);
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

    public static class LootTables extends FabricBlockLootSubProvider {
        public LootTables(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
            super(packOutput, registriesFuture);
        }

        @Override
        public void generate() {
            for (Block concrete : BlockInit.CONCRETES) {
                dropSelf(concrete);
            }
        }
    }

    public static class BlockTags extends FabricTagsProvider.BlockTagsProvider {
        public BlockTags(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
            super(output, registryLookupFuture);
        }

        @Override
        protected void addTags(HolderLookup.Provider registries) {
            tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(key(BlockInit.CONCRETES));
        }

        private ResourceKey<Block>[] key(List<MoreConcretesConcreteBlock> blocks) {
            return blocks.stream().map(block -> BuiltInRegistries.BLOCK.getResourceKey(block).get()).toArray(ResourceKey[]::new);
        }
    }

    public static class Recipe extends FabricRecipeProvider {
        public Recipe(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new RecipeProvider(registries, output) {
                @Override
                public void buildRecipes() {
                    for (MoreConcretesConcreteBlock block : BlockInit.CONCRETES) {
                        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, block, block.color.vanillaColor.getConcrete());
                    }
                }
            };
        }

        @Override
        public String getName() {
            return "recipe";
        }
    }

    public static class Lang {
        public static class en_us extends FabricLanguageProvider {
            public en_us(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
                super(output, "en_us", registriesFuture);
            }

            @Override
            public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
                translate(translationBuilder, "en_us");
            }
        }
        public static class en_gb extends FabricLanguageProvider {
            public en_gb(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
                super(output, "en_gb", registriesFuture);
            }

            @Override
            public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
                translate(translationBuilder, "en_gb");
            }
        }
        public static class en_ca extends FabricLanguageProvider {
            public en_ca(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
                super(output, "en_ca", registriesFuture);
            }

            @Override
            public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
                translate(translationBuilder, "en_ca");
            }
        }
        public static class en_au extends FabricLanguageProvider {
            public en_au(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
                super(output, "en_au", registriesFuture);
            }

            @Override
            public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
                translate(translationBuilder, "en_au");
            }
        }
        public static class en_nz extends FabricLanguageProvider {
            public en_nz(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
                super(output, "en_nz", registriesFuture);
            }

            @Override
            public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
                translate(translationBuilder, "en_nz");
            }
        }
        public static class de_de extends FabricLanguageProvider {
            public de_de(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
                super(output, "de_de", registriesFuture);
            }

            @Override
            public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
                translate(translationBuilder, "de_de");
            }
        }

        private static void translate(FabricLanguageProvider.TranslationBuilder t, String lang) {
            addText(t, ItemGroupInit.MORE_CONCRETES_TITLE, "More Concretes");
            for (MoreConcretesConcreteBlock block : BlockInit.CONCRETES)
                t.add(block, BlockInit.name(lang, block.color, block.r, block.g, block.b));
        }

        private static void addText(@NotNull FabricLanguageProvider.TranslationBuilder builder, @NotNull Component text, @NotNull String value) {
            if (text.getContents() instanceof TranslatableContents translatableTextContent) {
                builder.add(translatableTextContent.getKey(), value);
            } else {
                MoreConcretes.logger.warn("Failed to add translation for text: {}", text.getString());
            }
        }
    }
}
