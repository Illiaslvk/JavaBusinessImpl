package mp3.multiAspectInheritance;

import mp3.MyException;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class mAspect {

    @Test
    public void test() {

        Tournament tournamentCSGO = new LAN(GameType.CSGO,"Major","yes","Paris","1.000.000$ and Trophy",null,null,"Stadium");
        Tournament tournamentDBD = new Online(GameType.DBD,"Annihilator CUP","yes",null,null,"Home","Survivor","Twitch");

        assertEquals("Major", tournamentCSGO.getTournamentName());
        assertEquals("yes", tournamentCSGO.getParticipated());
        assertEquals(GameType.CSGO, tournamentCSGO.getGameType());
        assertEquals("Paris", tournamentCSGO.getPlaceCSGO());
        assertEquals("1.000.000$ and Trophy", tournamentCSGO.getPriceType());

        assertEquals("Annihilator CUP", tournamentDBD.getTournamentName());
        assertEquals(GameType.DBD, tournamentDBD.getGameType());
        assertEquals("Survivor", tournamentDBD.getGameMode());

        tournamentDBD.setPlaceDBD("Hoho");
        assertEquals("Hoho", tournamentDBD.getPlaceDBD());

    }
}