[![Build status](https://dev.azure.com/APS-SD-Stewards/APS-SD/_apis/build/status/proscrumdev.battleship-java-CI)](https://dev.azure.com/APS-SD-Stewards/APS-SD/_build/latest?definitionId=15)

# Battleship Java


A simple game of Battleship, written in Java.

# Getting started

This project requires a Java JDK 8 or higher. To prepare to work with it, pick one of these
options:

## Run locally

Run battleship with Gradle

```bash
./gradlew run
```

Execute tests with Gradle

```bash
./gradlew test
```

## Docker

If you don't want to install anything Java-related on your system, you can
run the game inside Docker instead.

### Run a Docker Container from the Image

```bash
docker run -it -v ${PWD}:/battleship -w /battleship openjdk:15 bash
```

This will run a Docker container with your battleship case study mounted into it. The container will run in interactive mode and you can execute Gradle commands from the shell (see examples below).

If you are using Docker for Windows you might run into issues and get a message like
```bash
env: ‘sh\r’: No such file or directory
```
The reason for this is that Windows uses CRLF while Linux (in the Docker Container) uses only CR
You can solve the issue by cloning the repository with a specific parameter:
```bash
git clone https://github.com/sharadgarg-roche/battleship-java.git  --config core.autocrlf=input
```

# Launching the game

```bash
./gradlew run
```

# Running the Tests

```
./gradlew test
```

# Battleship Game:
The game is played on a 10x10 grid and the individual squares in the grid are identified by letter and number. 
Before play begins, the player secretly arranges their ships on their grid and the opponent(Computer) arranges their ships randomly on the grid. 
Each ship occupies a number of consecutive squares on the grid, arranged either horizontally or vertically. 
The number of squares for each ship is determined by the type of ship. The ships cannot overlap (i.e., only one ship can occupy any given square in the grid). 
The ships are hidden from players sight and it's not allowed to see each other's pieces. 
The game is a discovery game which players need to discover their opponents ship positions.
After the ships have been positioned, the game proceeds in a series of rounds. In each round, each player takes a turn to record a target square in the opponent's grid which is to be shot at. 
The game displays whether or not the square is occupied by a ship.
When all of the squares of a ship have been hit, the game displays the sinking of the Aircraft Carrier, Battleship, Submarine, Destroyer and Patrol Boat. 
If all of a player's ships have been sunk, the game is over and their opponent(Computer) wins. 
If all ships of both players are sunk by the end of the round, the game is a draw.