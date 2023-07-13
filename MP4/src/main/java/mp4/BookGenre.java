package mp4;

public enum BookGenre {
    _Horror_("horror"),
    _History_("history"),
    _Drama_("drama"),
    _Study_("study"),
    _Sexology_("sexology"),
    _Fantasy_("fantasy");

    private final String printValue;

    BookGenre(String value) {printValue = value;}

    @Override
    public String toString() {return printValue;};
}
