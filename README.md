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
docker run -it -v ${PWD}:/battleship -w /battleship java
```

# Launching the game

```bash
./gradlew run
```

# Running the Tests

```
./gradlew test
```
