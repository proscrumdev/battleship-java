package org.scrum.psd.battleship.ascii;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.NoSuchElementException;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class MainEndToEndTest {
    @ClassRule
    public static final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    @ClassRule
    public static final TextFromStandardInputStream gameInput = emptyStandardInputStream();

    @Test
    public void testPlayGameShotHits() {
        try {
            //initiate
            gameInput.provideLines("a1", "a2", "a3", "a4", "a5", "b1", "b2", "b3", "b4", "c1", "c2", "c3", "d1", "d2", "d3", "e1", "e2",

                    //gameplay
                    "b4");

            Main.main(new String[]{});
        } catch(NoSuchElementException e) {
            Assert.assertTrue(systemOutRule.getLog().contains("Welcome to Battleship"));
            Assert.assertTrue(systemOutRule.getLog().contains("Yeah ! Nice hit !"));
        }
    }

    @Test
    public void testPlayGameShotMisses() {
        try {
            //initiate
            gameInput.provideLines("a1", "a2", "a3", "a4", "a5", "b1", "b2", "b3", "b4", "c1", "c2", "c3", "d1", "d2", "d3", "e1", "e2",

                    //gameplay
                    "e4");

            Main.main(new String[]{});
        } catch(NoSuchElementException e) {
            Assert.assertTrue(systemOutRule.getLog().contains("Welcome to Battleship"));
            Assert.assertTrue(systemOutRule.getLog().contains("Miss"));
        }
    }

    @Test
    public void testPlayGameShowSunkShip() {
        try {
            //initiate
            gameInput.provideLines("a1", "a2", "a3", "a4", "a5", "b1", "b2", "b3", "b4", "c1", "c2", "c3", "d1", "d2", "d3", "e1", "e2",

                    //gameplay
                    "c5", "c6", "S");

            Main.main(new String[]{});
        } catch(NoSuchElementException e) {
            Assert.assertTrue(systemOutRule.getLog().contains("Welcome to Battleship"));
            Assert.assertTrue(systemOutRule.getLog().contains("Yeah ! Nice hit !"));
        }
    }

    @Test
    public void testPlayGameShowLeftOverShips() {
        try {
            //initiate
            gameInput.provideLines("a1", "a2", "a3", "a4", "a5", "b1", "b2", "b3", "b4", "c1", "c2", "c3", "d1", "d2", "d3", "e1", "e2",

                    //gameplay
                    "c5", "c6", "L", "S");

            Main.main(new String[]{});
        } catch(NoSuchElementException e) {
            Assert.assertTrue(systemOutRule.getLog().contains("Welcome to Battleship"));
            Assert.assertTrue(systemOutRule.getLog().contains("Yeah ! Nice hit !"));
        }
    }

    @Test
    public void testPlayGamePlanningPhaseWrongInput() {
        try {
            gameInput.provideLines("0A");

            Main.main(new String[]{});
        } catch(NoSuchElementException e) {
            Assert.assertTrue(systemOutRule.getLog().contains("Welcome to Battleship"));
            Assert.assertTrue(systemOutRule.getLog().contains("Invalid position, please enter a valid position (i.e A3):"));
        }
    }

    @Test
    public void testPlayGamePlanningPhaseWrongInput_2() {
        try {
            gameInput.provideLines(";+ěšě+");

            Main.main(new String[]{});
        } catch(NoSuchElementException e) {
            Assert.assertTrue(systemOutRule.getLog().contains("Welcome to Battleship"));
            Assert.assertTrue(systemOutRule.getLog().contains("Invalid position, please enter a valid position (i.e A3):"));
        }
    }

    @Test
    public void testPlayGamePlanningPhaseWrongInput_3() {
        try {
            gameInput.provideLines("A20");

            Main.main(new String[]{});
        } catch(NoSuchElementException e) {
            Assert.assertTrue(systemOutRule.getLog().contains("Welcome to Battleship"));
            Assert.assertTrue(systemOutRule.getLog().contains("Invalid position, please enter a valid position (i.e A3):"));
        }
    }

    @Test
    public void testPlayGameGamingPhaseWrongInput() {
        try {
            gameInput.provideLines("a1", "a2", "a3", "a4", "a5", "b1", "b2", "b3", "b4", "c1", "c2", "c3", "d1", "d2", "d3", "e1", "e2", "0A");

            Main.main(new String[]{});
        } catch(NoSuchElementException e) {
            Assert.assertTrue(systemOutRule.getLog().contains("Welcome to Battleship"));
            Assert.assertTrue(systemOutRule.getLog().contains("Invalid position, please enter a valid position (i.e A3):"));
        }
    }

    @Test
    public void testPlayGameGamingPhaseWrongInput_2() {
        try {
            gameInput.provideLines("a1", "a2", "a3", "a4", "a5", "b1", "b2", "b3", "b4", "c1", "c2", "c3", "d1", "d2", "d3", "e1", "e2", "+?.");

            Main.main(new String[]{});
        } catch(NoSuchElementException e) {
            Assert.assertTrue(systemOutRule.getLog().contains("Welcome to Battleship"));
            Assert.assertTrue(systemOutRule.getLog().contains("Invalid position, please enter a valid position (i.e A3):"));
        }
    }

    @Test
    public void testPlayGameGamingPhaseOutsideField() {
        try {
            gameInput.provideLines("a1", "a2", "a3", "a4", "a5", "b1", "b2", "b3", "b4", "c1", "c2", "c3", "d1", "d2", "d3", "e1", "e2", "A20");

            Main.main(new String[]{});
        } catch(NoSuchElementException e) {
            Assert.assertTrue(systemOutRule.getLog().contains("Welcome to Battleship"));
            Assert.assertTrue(systemOutRule.getLog().contains("Miss. Position is outside of field. Try again."));
        }
    }


}
