package mp3.multiAspectInheritance;

import mp3.MyException;
import mp3.NullValidation;

public abstract class Tournament {
    private String tournamentName;
    private String participated;

    //Type
    private GameType gameType;

    //CSGO
    private String placeCSGO;
    private String priceType;

    //DBD
    private String placeDBD;
    private String gameMode;

    public Tournament(GameType gameTypes,String tournamentName, String participated,
                      String placeCSGO, String priceType,
                      String placeDBD,String gameMode) {
        setTournamentName(tournamentName);
        setParticipated(participated);

        setGameType(gameTypes);

        //CSGO
        if (gameTypes == GameType.CSGO){
            setPlaceCSGO(placeCSGO);
            setPriceType(priceType);
        }

        //DBD
        if (gameTypes == GameType.DBD){
            setPlaceDBD(placeDBD);
            setGameMode(gameMode);
        }
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        if (tournamentName == null || tournamentName.isBlank()) {
            throw new NullValidation("Name cannot be empty");
        }
        this.tournamentName = tournamentName;
    }

    public String getParticipated() {
        return participated;
    }

    public void setParticipated(String participated) {
        if (participated == null || participated.isBlank()) {
            throw new NullValidation("Participated cannot be empty");
        }
        this.participated = participated;
    }

    //DBD

    public String getPlaceDBD() {
        return placeDBD;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setPlaceDBD(String placeDBD) {
        if (gameType != GameType.DBD){
            throw new MyException("There is no tournament in this place for this game");
        }
        if (placeDBD == null || placeDBD.isBlank()) {
            throw new MyException("Place cannot be blank");
        }
        this.placeDBD = placeDBD;
    }

    public void setGameMode(String gameMode) {
        if (gameType != GameType.DBD){
            throw new MyException("There is no such mode in this game");
        }
        if (gameMode == null || gameMode.isBlank()) {
            throw new NullValidation("Can not be empty");
        }
        this.gameMode = gameMode;
    }

    //CSGO

    public String getPlaceCSGO() {
        return placeCSGO;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPlaceCSGO(String placeCSGO) {
        if (gameType != GameType.CSGO){
            throw new MyException("There is no tournament in this place for this game");
        }
        if (placeCSGO == null || placeCSGO.isBlank()) {
            throw new MyException("Place cannot be blank");
        }
        this.placeCSGO = placeCSGO;
    }

    public void setPriceType(String priceType) {
        if (gameType != GameType.CSGO) {
            throw new MyException("There is no tournament for this price type in the current game");
        }
        if (priceType == null || priceType.isBlank()) {
            throw new MyException("Price type cannot be empty");
        }
        this.priceType = priceType;
    }

    //Game type
    public GameType getGameType() {
        return gameType;
    }

    private void setGameType(GameType gameType) {
        if (gameType == null){
            throw new MyException("Game can not be null");
        }
        this.gameType = gameType;
    }

}