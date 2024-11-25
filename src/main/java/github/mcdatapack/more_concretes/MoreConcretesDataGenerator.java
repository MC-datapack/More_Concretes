package github.mcdatapack.more_concretes;

import github.mcdatapack.more_concretes.datagen.Provider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class MoreConcretesDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(Provider.LootTables::new);
		pack.addProvider(Provider.Recipe::new);
		pack.addProvider(Provider.BlockTags::new);
		pack.addProvider(Provider.Models::new);
		pack.addProvider(Provider.Lang.en_au::new);
		pack.addProvider(Provider.Lang.en_ca::new);
		pack.addProvider(Provider.Lang.en_gb::new);
		pack.addProvider(Provider.Lang.en_nz::new);
		pack.addProvider(Provider.Lang.en_us::new);
		pack.addProvider(Provider.Lang.de_de::new);
	}
}
