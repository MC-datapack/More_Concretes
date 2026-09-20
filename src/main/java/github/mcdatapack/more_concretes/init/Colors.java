package github.mcdatapack.more_concretes.init;

import github.mcdatapack.more_concretes.MoreConcretes;
import github.mcdatapack.more_concretes.datagen.VanillaColors;

@SuppressWarnings("unused")
public enum Colors {
    DARK_BLUE(VanillaColors.BLUE, "Dark Blue", "Dunkelblauer"),
    BLUE(VanillaColors.BLUE, "Blue", "Blauer"),
    LIGHT_BLUE(VanillaColors.LIGHT_BLUE, "Light Blue", "Hellblauer"),
    BLACK(VanillaColors.BLACK, "Black", "Schwarzer"),
    WHITE(VanillaColors.WHITE, "White", "Weißer"),
    LIGHT_GRAY(VanillaColors.LIGHT_GRAY, "Light Gray", "Hellgrauer"),
    GRAY(VanillaColors.GRAY, "Gray", "Grauer"),
    DARK_GRAY(VanillaColors.GRAY, "Dark Gray", "Dunkelgrauer"),
    CYAN(VanillaColors.CYAN, "Cyan", "Türkiser"),
    LIME(VanillaColors.LIME, "Lime", "Hellgrüner"),
    GREEN(VanillaColors.GREEN, "Green", "Grüner"),
    DARK_GREEN(VanillaColors.GREEN, "Dark Green", "Dunkelgrüner"),
    PINK(VanillaColors.PINK, "Pink", "Pink"),
    MAGENTA(VanillaColors.MAGENTA, "Magenta", "Magenta"),
    PURPLE(VanillaColors.PURPLE, "Purple", "Lila"),
    YELLOW(VanillaColors.YELLOW, "Yellow", "Gelb"),
    ORANGE(VanillaColors.ORANGE, "Orange", "Orange"),
    RED(VanillaColors.RED, "Red", "Rot"),
    DARK_RED(VanillaColors.RED, "Dark Red", "Dunkelrot");

    public final String en_us, de_de;
    public final VanillaColors vanillaColor;

    Colors(VanillaColors vanillaColor, String en_us, String de_de) {
        this.en_us = en_us;
        this.de_de = de_de;
        this.vanillaColor = vanillaColor;
    }

    public String getName(String lang) {
        switch (lang) {
            case "en_us", "en_gb", "en_ca", "en_au", "en_nz" -> {
                return en_us;
            }
            case "de_de" -> {
                return de_de;
            }
            default -> {
                MoreConcretes.logger.error("Error with the provided Language");
                return null;
            }
        }
    }
}
