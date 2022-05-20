package org.scrum.psd.battleship.controller.dto;

public class Position {
    private Letter column;
    private int row;

    private Boolean hitPosition = Boolean.FALSE;
    public Position() {
        super();
    }

    public Position(Letter column, int row) {
        this();

        this.column = column;
        this.row = row;
    }



    public Letter getColumn() {
        return column;
    }

    public void setColumn(Letter column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Boolean getHitPosition() {
        return hitPosition;
    }

    public void setHitPosition(Boolean hitPosition) {
        this.hitPosition = hitPosition;
    }

    @Override public boolean equals(Object o) {
        if(o instanceof Position) {
            Position position = (Position) o;

            if(position == null) {
                return false;
            }

            return position.column.equals(column) && position.row == row;
        }

        return false;
    }
}
