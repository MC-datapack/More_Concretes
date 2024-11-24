package github.mcdatapack.more_concretes.init;

import github.mcdatapack.more_concretes.MoreConcretes;

@SuppressWarnings("unused")
public enum Colors {
    //TODO expand
    DARK_BLUE("Dark Blue", "Dunkelblauer"), BLUE("Blue", "Blauer"), LIGHT_BLUE("Light Blue", "Hellblauer"),
    BLACK("Black", "Schwarzer"), WHITE("White", "Weißer"), LIGHT_GRAY("Light Gray", "Hellgrauer"),
    GRAY("Gray", "Grauer"), DARK_GRAY("Dark Gray", "Dunkelgrauer");

    private final String en_us, de_de;
    Colors(String en_us, String de_de) {
        this.en_us = en_us;
        this.de_de = de_de;
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
