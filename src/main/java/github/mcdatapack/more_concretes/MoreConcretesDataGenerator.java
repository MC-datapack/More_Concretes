package github.mcdatapack.more_concretes;

import github.mcdatapack.more_concretes.datagen.Provider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class MoreConcretesDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(Provider.Models::new);
		pack.addProvider(Provider.LootTables::new);
		pack.addProvider(Provider.BlockTags::new);
		pack.addProvider(Provider.Lang.English::new);
		pack.addProvider(Provider.Recipe::new);
	}
}
