package github.mcdatapack.more_concretes.init;

@SuppressWarnings("unused")
public enum Colors {
    //TODO expand
    DARK_BLUE("Dark Blue"), BLUE("Blue"), LIGHT_BLUE("Light Blue"), BLACK("Black"), WHITE("White"), LIGHT_GRAY("Light Gray"),
    GRAY("Gray"), DARK_GRAY("Dark Gray");

    private final String name;
    Colors(String name) {
        this.name = name;
    }

    public String getName() {return name;}
}
