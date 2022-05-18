package org.scrum.psd.battleship.ascii;

import com.diogonunes.jcolor.AnsiFormat;
import com.diogonunes.jcolor.Attribute;
import org.scrum.psd.battleship.controller.GameController;
import org.scrum.psd.battleship.controller.dto.Letter;
import org.scrum.psd.battleship.controller.dto.Position;
import org.scrum.psd.battleship.controller.dto.Ship;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public class Main {
    private static List<Ship> myFleet;
    private static List<Ship> enemyFleet;

    public static void main(String[] args) {
        System.out.println(colorize("                                     |__", MAGENTA_TEXT()));
        System.out.println(colorize("                                     |\\/", MAGENTA_TEXT()));
        System.out.println(colorize("                                     ---", MAGENTA_TEXT()));
        System.out.println(colorize("                                     / | [", MAGENTA_TEXT()));
        System.out.println(colorize("                              !      | |||", MAGENTA_TEXT()));
        System.out.println(colorize("                            _/|     _/|-++'", MAGENTA_TEXT()));
        System.out.println(colorize("                        +  +--|    |--|--|_ |-", MAGENTA_TEXT()));
        System.out.println(colorize("                     { /|__|  |/\\__|  |--- |||__/", MAGENTA_TEXT()));
        System.out.println(colorize("                    +---------------___[}-_===_.'____                 /\\", MAGENTA_TEXT()));
        System.out.println(colorize("                ____`-' ||___-{]_| _[}-  |     |_[___\\==--            \\/   _", MAGENTA_TEXT()));
        System.out.println(colorize(" __..._____--==/___]_|__|_____________________________[___\\==--____,------' .7", MAGENTA_TEXT()));
        System.out.println(colorize("|                        Welcome to Battleship                         BB-61/", MAGENTA_TEXT()));
        System.out.println(colorize(" \\_________________________________________________________________________|", MAGENTA_TEXT()));
        System.out.println("");

        InitializeGame();

        StartGame();
    }

    private static void StartGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\033[2J\033[;H");
        System.out.println("                  __");
        System.out.println("                 /  \\");
        System.out.println("           .-.  |    |");
        System.out.println("   *    _.-'  \\  \\__/");
        System.out.println("    \\.-'       \\");
        System.out.println("   /          _/");
        System.out.println("  |      _  /\" \"");
        System.out.println("  |     /_\'");
        System.out.println("   \\    \\_/");
        System.out.println("    \" \"\" \"\" \"\" \"");

        do {
            System.out.println("");
            System.out.println("Player, it's your turn");
            System.out.println("Enter coordinates for your shot:");
            String input = scanner.next();
            while (!Position.validatePosition(input)) {
                System.out.println("Enter coordinates for your shot :");
                input = scanner.next();
            }
            Position position = parsePosition(input);
            System.out.println(position);
            boolean isHit = GameController.checkIsHit(enemyFleet, position);
            if (isHit) {
                beep();
/*
                System.out.println("                \\         .  ./");
                System.out.println("              \\      .:\" \";'.:..\" \"   /");
                System.out.println("                  (M^^.^~~:.'\" \").");
                System.out.println("            -   (/  .    . . \\ \\)  -");
                System.out.println("               ((| :. ~ ^  :. .|))");
                System.out.println("            -   (\\- |  \\ /  |  /)  -");
                System.out.println("                 -\\  \\     /  /-");
                System.out.println("                   \\  \\   /  /");
*/
            }

            System.out.println(isHit ? colorize("Yeah ! Nice hit !", RED_TEXT()) : colorize("Miss!", BLUE_TEXT()));

            position = getRandomPosition();
            isHit = GameController.checkIsHit(myFleet, position);
            System.out.println("-------------------------------------------------------------------------");
            System.out.println(String.format("Computer shoot in %s%s and %s", position.getColumn(), position.getRow(), isHit ? colorize("hit your ship !", RED_TEXT()) : colorize("Miss!", BLUE_TEXT())));
            if (isHit) {
                beep();
/*
                System.out.println("                \\         .  ./");
                System.out.println("              \\      .:\" \";'.:..\" \"   /");
                System.out.println("                  (M^^.^~~:.'\" \").");
                System.out.println("            -   (/  .    . . \\ \\)  -");
                System.out.println("               ((| :. ~ ^  :. .|))");
                System.out.println("            -   (\\- |  \\ /  |  /)  -");
                System.out.println("                 -\\  \\     /  /-");
                System.out.println("                   \\  \\   /  /");
*/
            }
            System.out.println("-------------------------------------------------------------------------");
        } while (true);
    }

    private static void beep() {
        System.out.print("\007");
    }

    protected static Position parsePosition(String input) {
        Letter letter = Letter.valueOf(input.toUpperCase().substring(0, 1));
        int number = Integer.parseInt(input.substring(1));
        return new Position(letter, number);
    }

    private static Position getRandomPosition() {
        int rows = 8;
        int lines = 8;
        Random random = new Random();
        Letter letter = Letter.values()[random.nextInt(lines)];
        int number = random.nextInt(rows);
        Position position = new Position(letter, number);
        return position;
    }

    private static void InitializeGame() {
        InitializeMyFleet();

        InitializeEnemyFleet();
    }

    private static void InitializeMyFleet() {
        Scanner scanner = new Scanner(System.in);
        myFleet = GameController.initializeShips();

        System.out.println("Please position your fleet (Game board has size from A to H and 1 to 8) :");

        for (Ship ship : myFleet) {
            System.out.println("");
            System.out.println(String.format("Please enter the positions for the %s (size: %s)", ship.getName(), ship.getSize()));
            for (int i = 1; i <= ship.getSize(); i++) {
                System.out.println(String.format("Enter position %s of %s (i.e A3):", i, ship.getSize()));

                String positionInput = scanner.next();
                while (!Position.validatePosition(positionInput)) {
                    System.out.println(String.format("Enter position %s of %s (i.e A3):", i, ship.getSize()));
                    positionInput = scanner.next();
                }
                ship.addPosition(positionInput);
                System.out.println(positionInput);
            }
        }
    }

    private static void InitializeEnemyFleet() {
        enemyFleet = GameController.initializeShips();

        enemyFleet.get(0).getPositions().add(new Position(Letter.B, 4));
        enemyFleet.get(0).getPositions().add(new Position(Letter.B, 5));
        enemyFleet.get(0).getPositions().add(new Position(Letter.B, 6));
        enemyFleet.get(0).getPositions().add(new Position(Letter.B, 7));
        enemyFleet.get(0).getPositions().add(new Position(Letter.B, 8));

        enemyFleet.get(1).getPositions().add(new Position(Letter.E, 6));
        enemyFleet.get(1).getPositions().add(new Position(Letter.E, 7));
        enemyFleet.get(1).getPositions().add(new Position(Letter.E, 8));
        enemyFleet.get(1).getPositions().add(new Position(Letter.E, 9));

        enemyFleet.get(2).getPositions().add(new Position(Letter.A, 3));
        enemyFleet.get(2).getPositions().add(new Position(Letter.B, 3));
        enemyFleet.get(2).getPositions().add(new Position(Letter.C, 3));

        enemyFleet.get(3).getPositions().add(new Position(Letter.F, 8));
        enemyFleet.get(3).getPositions().add(new Position(Letter.G, 8));
        enemyFleet.get(3).getPositions().add(new Position(Letter.H, 8));

        enemyFleet.get(4).getPositions().add(new Position(Letter.C, 5));
        enemyFleet.get(4).getPositions().add(new Position(Letter.C, 6));
    }
}
