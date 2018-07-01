package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {

    private static final int FIELD_WIDTH = 4;

    private Tile[][] gameTiles;

    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();

    private boolean isSaveNeeded = true;

    int score;
    int maxTile;

    public Model() {
        resetGameTiles();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public boolean canMove() {
        if (!getEmptyTiles().isEmpty()) {
            return true;
        }

        for (int i = 0; i < gameTiles.length - 1; i++) {
            for (int j = 0; j < gameTiles[i].length - 1; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j + 1].value
                        || gameTiles[i][j].value == gameTiles[i + 1][j].value
                        || gameTiles[i][j + 1].value == gameTiles[i + 1][j + 1].value) {
                    return true;
                }
            }
        }

        return false;
    }

    void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

        Arrays.stream(gameTiles).forEach(gameTile -> Arrays.setAll(gameTile, j -> new Tile()));

        addTile();
        addTile();

        score = 0;
        maxTile = 0;
    }

    public void rollback() {
        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public void randomMove() {
        int randomMove = ((int) (Math.random() * 100)) % 4;

        switch (randomMove) {
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
                break;
        }
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> priorityMoveQueue = new PriorityQueue<>(4, Collections.reverseOrder());

        priorityMoveQueue.add(getMoveEfficiency(this::left));
        priorityMoveQueue.add(getMoveEfficiency(this::right));
        priorityMoveQueue.add(getMoveEfficiency(this::up));
        priorityMoveQueue.add(getMoveEfficiency(this::down));

        Objects.requireNonNull(priorityMoveQueue.poll()).getMove().move();
    }

    public boolean hasBoardChanged() {
        Tile[][] previousTiles = previousStates.peek();

        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                if (gameTiles[i][j].value != previousTiles[i][j].value) {
                    return true;
                }
            }
        }

        return false;
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        move.move();

        MoveEfficiency moveEfficiency;

        if (hasBoardChanged()) {
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        } else {
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        }

        rollback();

        return moveEfficiency;
    }

    public void left() {
        boolean isChanged = false;

        if (isSaveNeeded) {
            saveState(gameTiles);
        }

        for (Tile[] gameTile : gameTiles) {
            if (compressTiles(gameTile) | mergeTiles(gameTile)) {
               isChanged = true;
            }
        }

        if (isChanged) {
            addTile();
        }

        isSaveNeeded = true;
    }

    public void up() {
        saveState(gameTiles);

        rotate();
        rotate();
        rotate();

        left();

        rotate();
    }

    public void right() {
        saveState(gameTiles);

        rotate();
        rotate();

        left();

        rotate();
        rotate();
    }

    public void down() {
        saveState(gameTiles);

        rotate();

        left();

        rotate();
        rotate();
        rotate();
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();

        if (!emptyTiles.isEmpty()) {
            Tile randomTile = emptyTiles.get((int) (Math.random() * emptyTiles.size()));
            randomTile.value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> tiles = new ArrayList<>();

        Arrays.stream(gameTiles).forEach(gameTiles -> {
            for (Tile gameTile : gameTiles) {
                if (gameTile.value == 0) {
                    tiles.add(gameTile);
                }
            }
        });

        return tiles;
    }

    private void rotate() {
        Tile[][] rotateArray = new Tile[FIELD_WIDTH][FIELD_WIDTH];

        for (int i = 0; i < rotateArray.length; i++) {
            for (int j = 0; j < rotateArray[i].length; j++) {
                rotateArray[i][j] = gameTiles[gameTiles.length - 1 - j][i];
            }
        }

        gameTiles = rotateArray;
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean isChanged = false;

        for (int i = 1; i < tiles.length; i++) {
            int indexOfThisTile = i;

            while (indexOfThisTile > 0 && tiles[indexOfThisTile - 1].isEmpty() && !tiles[indexOfThisTile].isEmpty()) {
                tiles[indexOfThisTile - 1].value = tiles[indexOfThisTile].value;
                tiles[indexOfThisTile].value = 0;

                indexOfThisTile--;

                isChanged = true;
            }
        }

        return isChanged;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean isChanged = false;

        for (int i = 1; i < tiles.length; i++) {
            if (!tiles[i].isEmpty() && tiles[i].value == tiles[i - 1].value) {
                tiles[i - 1].value *= 2;
                tiles[i].value = 0;

                score += tiles[i - 1].value;

                if (tiles[i - 1].value > maxTile) {
                    maxTile = tiles[i - 1].value;
                }

                compressTiles(tiles);

                isChanged = true;
            }
        }

        return isChanged;
    }

    private void saveState(Tile[][] tiles) {
        previousStates.push(getCopyOfTiles(tiles));
        previousScores.push(score);

        isSaveNeeded = false;
    }

    private Tile[][] getCopyOfTiles(Tile[][] tiles) {
        Tile[][] copyTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                copyTiles[i][j] = new Tile(tiles[i][j].value);
            }
        }

        return copyTiles;
    }
}
