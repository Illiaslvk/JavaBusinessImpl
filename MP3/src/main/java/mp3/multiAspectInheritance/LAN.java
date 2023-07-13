package mp3.multiAspectInheritance;

import mp3.NullValidation;

public class LAN extends Tournament {
    private String location;

    public LAN(GameType gameTypes, String tournamentName, String participated, String placeCSGO, String priceType, String placeDBD, String gameMode, String location) {
        super(gameTypes, tournamentName, participated, placeCSGO, priceType, placeDBD, gameMode);
        setLocation(location);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        if (location == null || location.isBlank()) {
            throw new NullValidation("Location cannot be empty");
        }
        this.location = location;
    }

}