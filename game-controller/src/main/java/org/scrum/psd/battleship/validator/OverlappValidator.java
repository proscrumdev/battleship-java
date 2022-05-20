package org.scrum.psd.battleship.validator;

import java.util.List;

import org.scrum.psd.battleship.controller.dto.Position;
import org.scrum.psd.battleship.controller.dto.Ship;

public class OverlappValidator implements FleetValidator {

    @Override
    public boolean validate(List<Ship> fleet, Ship ship, Position position) {
        // TODO Auto-generated method stub
        return true;
    }

}
