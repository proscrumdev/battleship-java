package org.scrum.psd.battleship.validator;

import java.util.List;

import org.scrum.psd.battleship.controller.dto.Position;
import org.scrum.psd.battleship.controller.dto.Ship;

public interface FleetValidator {
    boolean validate(List<Ship> fleet, Ship ship, Position position);
}
