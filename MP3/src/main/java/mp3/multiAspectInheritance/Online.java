package mp3.multiAspectInheritance;

import mp3.NullValidation;

public class Online extends Tournament{
    private String platform;

    public Online(GameType gameTypes, String tournamentName, String participated, String placeCSGO, String priceType, String placeDBD, String gameMode, String platform) {
        super(gameTypes, tournamentName, participated, placeCSGO, priceType, placeDBD, gameMode);
        setPlatform(platform);
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        if (platform == null || platform.isBlank()) {
            throw new NullValidation("Platform cannot be empty");
        }
        this.platform = platform;
    }
}
