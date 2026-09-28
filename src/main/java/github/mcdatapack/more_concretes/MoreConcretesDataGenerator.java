package github.mcdatapack.more_concretes;

import github.mcdatapack.more_concretes.datagen.Provider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class MoreConcretesDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		new MoreConcretes().onInitialize();
		fabricDataGenerator.addProvider(Provider.LootTables::new);
		fabricDataGenerator.addProvider(Provider.Recipe::new);
		fabricDataGenerator.addProvider(Provider.BlockTags::new);
		fabricDataGenerator.addProvider(Provider.Models::new);
		//fabricDataGenerator.addProvider(Provider.Lang.en_au::new);
		//fabricDataGenerator.addProvider(Provider.Lang.en_ca::new);
		//fabricDataGenerator.addProvider(Provider.Lang.en_gb::new);
		//fabricDataGenerator.addProvider(Provider.Lang.en_nz::new);
		//fabricDataGenerator.addProvider(Provider.Lang.en_us::new);
		//fabricDataGenerator.addProvider(Provider.Lang.de_de::new);
	}
}
