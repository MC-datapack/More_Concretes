package github.mcdatapack.more_concretes;

import github.mcdatapack.more_concretes.block.MoreConcretesConcreteBlock;
import github.mcdatapack.more_concretes.init.BlockInit;
import github.mcdatapack.more_concretes.init.ItemGroupInit;
import net.fabricmc.api.ModInitializer;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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
		//generateTextures();
	}

	private void generateTextures() {
		File directory = new File("M:/Mods/More Concretes/src/main/resources/assets/more_concretes/textures/block");

		for (MoreConcretesConcreteBlock block : BlockInit.CONCRETES) {
			try {
				Path path = Path.of("M:/Mods/More Concretes/src/main/resources/assets/more_concretes/textures/block/default.png");
				Path target = Path.of("M:/Mods/More Concretes/src/main/resources/assets/more_concretes/textures/block/" + BuiltInRegistries.BLOCK.getKey(block).getPath() + ".png");
				if (Files.exists(target)) {
					Files.delete(target);
				}
				Files.copy(path, target);
				File file = target.toFile();
				if (file.isFile()) {
					try {
						BufferedImage image = ImageIO.read(file);
						Graphics2D g = image.createGraphics();

						g.setColor(new Color(block.r, block.g, block.b));
						g.drawRect(0, 0, 1, 1);

						File output = new File(directory, file.getName());
						ImageIO.write(image, "png", output);
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
	}

	public static Identifier id(String name) {
		return Identifier.fromNamespaceAndPath(MOD_ID, name);
	}
}