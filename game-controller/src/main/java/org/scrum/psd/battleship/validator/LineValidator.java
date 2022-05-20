package org.scrum.psd.battleship.validator;

import java.util.List;

import org.scrum.psd.battleship.controller.dto.Letter;
import org.scrum.psd.battleship.controller.dto.Position;
import org.scrum.psd.battleship.controller.dto.Ship;

public class LineValidator implements FleetValidator {

    @Override
    public boolean validate(List<Ship> fleet, Ship ship, Position pos) {
        List<Position> positions = ship.getPositions();
        if (positions == null || positions.isEmpty()) {
            return true;
        }
        
       
        Position last = positions.get(positions.size() - 1);
        Letter lastColumn = last.getColumn();
        int lastRow = last.getRow();
        
        
        boolean columnValid = pos.getColumn() == lastColumn;
        boolean rowValid = Math.abs(pos.getRow() - lastRow) == 1;

        if (!columnValid || !rowValid) {
            System.out.print("Provided position is not in one line");
            if (!columnValid) {
                System.out.print(", wrong column");
            }
            
            if (!rowValid) {
                System.out.print(", wrong row");
            }
            System.out.println("!");
            
            return false;
        }
        
        return true;
    }

}
