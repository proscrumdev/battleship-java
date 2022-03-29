package org.scrum.psd.battleship.ascii;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.scrum.psd.battleship.controller.dto.Letter;
import org.scrum.psd.battleship.controller.dto.Position;
import org.scrum.psd.battleship.controller.dto.Status;
import org.scrum.psd.battleship.controller.dto.Ship;

import java.util.Arrays;
import java.util.List;

@Execution(ExecutionMode.CONCURRENT)
public class MainTest {

    @Test
    public void testParsePosition() {
        Position actual = Main.parsePosition("A1");
        Position expected = new Position(Letter.A, 1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testParsePosition2() {
        //given
        Position expected = new Position(Letter.B, 1);
        //when
        Position actual = Main.parsePosition("B1");
        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCheckGameEndsMyFleetDestroyed() {
        List<Ship> myfleet = Arrays.asList(buildShip("s1", true), buildShip("s2", true));
        List<Ship> enemyfleet = Arrays.asList(buildShip("e1", false), buildShip("e2", false));
        Assertions.assertEquals(Status.LOST, Main.checkGameEnds(myfleet, enemyfleet));
    }

    @Test
    public void testCheckGameEndsMyEnemyDestroyed() {
        List<Ship> myfleet = Arrays.asList(buildShip("s1", false), buildShip("s2", false));
        List<Ship> enemyfleet = Arrays.asList(buildShip("e1", true), buildShip("e2", true));
        Assertions.assertEquals(Status.WIN, Main.checkGameEnds(myfleet, enemyfleet));
    }

    @Test
    public void testCheckGameEndsNotEnded() {
        List<Ship> myfleet = Arrays.asList(buildShip("s1", true), buildShip("s2", false));
        List<Ship> enemyfleet = Arrays.asList(buildShip("e1", true), buildShip("e2", false));
        Assertions.assertEquals(Status.RUNNING, Main.checkGameEnds(myfleet, enemyfleet));
    }

    private Ship buildShip(String name, boolean isDestroyed) {
        Ship s = new Ship();
        s.setDestroyed(isDestroyed);
        s.setName(name);

        return s;
    }
}