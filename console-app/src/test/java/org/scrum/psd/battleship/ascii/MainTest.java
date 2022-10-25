package org.scrum.psd.battleship.ascii;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.scrum.psd.battleship.controller.dto.Letter;
import org.scrum.psd.battleship.controller.dto.Position;
import org.scrum.psd.battleship.controller.dto.Ship;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Execution(ExecutionMode.SAME_THREAD)
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
    public void testInitializeEnemyFleet_notCrossingShips() {
        Main.InitializeEnemyFleet();
        List<Ship> enemyFleet = Main.enemyFleet;
        Assertions.assertEquals(enemyFleet.size(), 5);
        List<Position> positions = enemyFleet.stream().flatMap(
                ship -> ship.getPositions().stream()
        ).collect(Collectors.toList());

        Set<String> stringPositions = positions.stream().map(Position::toString).collect(Collectors.toSet());
        System.out.println(stringPositions);
        System.out.println(positions);
        Assertions.assertEquals(stringPositions.size(), positions.size());
    }

    @Test
    public void testInitializeEnemyFleet_gamesDiffer() {
        String run1 = String.join("", getStringPositions());
        String run2 = String.join("", getStringPositions());
        Assertions.assertNotEquals(run1, run2);
    }

    private Set<String> getStringPositions() {
        Main.InitializeEnemyFleet();
        List<Ship> enemyFleet = Main.enemyFleet;
        List<Position> positions = enemyFleet.stream().flatMap(
                ship -> ship.getPositions().stream()
        ).collect(Collectors.toList());

        return positions.stream().map(Position::toString).collect(Collectors.toSet());
    }
}
