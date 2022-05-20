package org.scrum.psd.battleship.validator;

import java.util.List;

import org.scrum.psd.battleship.controller.dto.Position;
import org.scrum.psd.battleship.controller.dto.Ship;

public class OverlappValidator implements FleetValidator {

    @Override
    public boolean validate(List<Ship> fleet, Ship ship, Position position) {
        for (Ship sh: fleet) {
            for (Position pos: sh.getPositions()) {
                if (position.equals(pos)) {
                    System.out.println("Position is already taken by ship: " + sh.getName());
                    return false;
                }
            }
        }
        return true;
    }

}
