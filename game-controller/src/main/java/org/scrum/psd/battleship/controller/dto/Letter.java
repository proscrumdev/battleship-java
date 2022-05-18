package org.scrum.psd.battleship.controller.dto;

public enum Letter {
    A, B, C, D, E, F, G, H;

    private static final char MINIMAL = 'A';
    private static final int MAXIMAL = 'H';
    
    public static boolean isValid(String letterStr) {
        char letter = letterStr.charAt(0);
        return MINIMAL <= letter && letter <= MAXIMAL;
    }
    
}
