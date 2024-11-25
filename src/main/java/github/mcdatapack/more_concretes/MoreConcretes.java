package github.mcdatapack.more_concretes;

import github.mcdatapack.more_concretes.init.BlockInit;
import github.mcdatapack.more_concretes.init.ItemGroupInit;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreConcretes implements ModInitializer {
	public static final String MOD_ID = "more_concretes";
	public static final Logger logger = LoggerFactory.getLogger("More Concretes");

	@Override
	public void onInitialize() {
		logger.info("Loading More Concretes");
		logger.debug("Initializing Blocks");
		BlockInit.load();
		logger.debug("Initialized Blocks");
		logger.debug("Initializing Item Group");
		ItemGroupInit.load();
		logger.debug("Initialized Item Group");
		logger.info("Loaded More Concretes");
	}

	public static Identifier id(String name) {
		return Identifier.of(MOD_ID, name);
	}
}