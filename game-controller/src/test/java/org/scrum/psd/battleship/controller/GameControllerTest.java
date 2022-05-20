package org.scrum.psd.battleship.controller;

import org.junit.Assert;
import org.junit.Test;
import org.scrum.psd.battleship.controller.dto.Color;
import org.scrum.psd.battleship.controller.dto.Letter;
import org.scrum.psd.battleship.controller.dto.Position;
import org.scrum.psd.battleship.controller.dto.Ship;
import org.scrum.psd.battleship.validator.FleetValidator;
import org.scrum.psd.battleship.validator.OverlappValidator;

import javax.xml.validation.ValidatorHandler;
import java.util.Arrays;
import java.util.List;

public class GameControllerTest {
    @Test
    public void testCheckIsHitTrue() {
        List<Ship> ships = GameController.initializeShips();
        int counter = 0;

        for (Ship ship : ships) {
            Letter letter = Letter.values()[counter];

            for (int i = 0; i < ship.getSize(); i++) {
                ship.getPositions().add(new Position(letter, i));
            }

            counter++;
        }

        boolean result = GameController.checkIsHit(ships, new Position(Letter.A, 1));

        Assert.assertTrue(result);
    }

    @Test
    public void testCheckIsHitFalse() {
        List<Ship> ships = GameController.initializeShips();
        int counter = 0;

        for (Ship ship : ships) {
            Letter letter = Letter.values()[counter];

            for (int i = 0; i < ship.getSize(); i++) {
                ship.getPositions().add(new Position(letter, i));
            }

            counter++;
        }

        boolean result = GameController.checkIsHit(ships, new Position(Letter.H, 1));

        Assert.assertFalse(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckIsHitPositstionIsNull() {
        GameController.checkIsHit(GameController.initializeShips(), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckIsHitShipIsNull() {
        GameController.checkIsHit(null, new Position(Letter.H, 1));
    }

    @Test
    public void testIsShipValidFalse() {
        Ship ship = new Ship("TestShip", 3);
        boolean result = GameController.isShipValid(ship);

        Assert.assertFalse(result);
    }

    @Test
    public void testIsShipValidTrue() {
        List<Position> positions = Arrays.asList(new Position(Letter.A, 1), new Position(Letter.A, 1), new Position(Letter.A, 1));
        Ship ship = new Ship("TestShip", 3, positions);

        boolean result = GameController.isShipValid(ship);

        Assert.assertTrue(result);
    }

    @Test
    public void testIsShipOverlappingFalse() {
        List<Position> positions1 = Arrays.asList(new Position(Letter.A, 1), new Position(Letter.A, 2), new Position(Letter.A, 3));
        Ship ship1 = new Ship("TestShip1", 3, positions1);

        List<Position> positions2 = Arrays.asList(new Position(Letter.B, 1), new Position(Letter.C, 1), new Position(Letter.D, 1));
        Ship ship2 = new Ship("TestShip2", 3, positions2);

        List<Ship> fleet = Arrays.asList(ship1, ship2);

        OverlappValidator validator = new OverlappValidator();
        boolean result = validator.validate(fleet, null, new Position(Letter.A, 1));

        Assert.assertFalse(result);
    }

}
