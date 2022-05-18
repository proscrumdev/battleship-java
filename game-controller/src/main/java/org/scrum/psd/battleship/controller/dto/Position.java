package org.scrum.psd.battleship.controller.dto;

public class Position {
    public static final int MINIMAL = 1;
    public static final int MAXIMAL = 8;
    
    
    private Letter column;
    private int row;

    public Position() {
        super();
    }

    public Position(Letter column, int row) {
        this();

        this.column = column;
        this.row = row;
    }
    
    
    public static boolean validatePosition(String input) {
        String letterStr = input.toUpperCase().substring(0, 1);
        boolean validNumber = false;
        try { 
            int number = Integer.valueOf(input.substring(1));
            validNumber = MINIMAL <= number && number <= MAXIMAL;
        } catch (NumberFormatException e) {
            
        }
        
        boolean valid = validNumber && Letter.isValid(letterStr);

        if (!valid) {
            System.out.println("Wrong input!");
        }
        
        return valid;
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

    @Override public String toString() { return getColumn().toString() + String.valueOf(getRow()); } 
}
