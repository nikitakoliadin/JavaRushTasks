package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import java.nio.file.Paths;

public class Model {

    public static final int FIELD_CELL_SIZE = 20;

    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("4.JavaCollections/src/com/javarush/task/task34/task3410/res/levels.txt"));

    private EventListener eventListener;

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level) {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        currentLevel++;
        restart();
    }

    public void move(Direction direction) {
        Player player = gameObjects.getPlayer();

        if (checkWallCollision(player, direction)) {
            return;
        }

        if (checkBoxCollisionAndMoveIfAvaliable(direction)) {
            return;
        }

        switch (direction) {
            case LEFT:
                player.move(-FIELD_CELL_SIZE, 0);
                break;
            case RIGHT:
                player.move(FIELD_CELL_SIZE, 0);
                break;
            case UP:
                player.move(0, -FIELD_CELL_SIZE);
                break;
            case DOWN:
                player.move(0, FIELD_CELL_SIZE);
                break;
        }

        checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        for (Wall wall : gameObjects.getWalls()) {
            if (gameObject.isCollision(wall, direction)) {
                return true;
            }
        }

        return false;
    }

    public boolean checkBoxCollisionAndMoveIfAvaliable(Direction direction) {
        Player player = gameObjects.getPlayer();

        GameObject stopped = null;

        for (GameObject gameObject : gameObjects.getAll()) {
            if (!(gameObject instanceof Player) && !(gameObject instanceof Home) && player.isCollision(gameObject, direction)) {
                stopped = gameObject;
            }
        }

        if (stopped == null) {
            return false;
        }

        if (stopped instanceof Box) {
            Box stoppedBox = (Box) stopped;

            if (checkWallCollision(stoppedBox, direction)) {
                return true;
            }

            for (Box box : gameObjects.getBoxes()) {
                if (stoppedBox.isCollision(box, direction)) {
                    return true;
                }
            }

            switch (direction) {
                case LEFT:
                    stoppedBox.move(-FIELD_CELL_SIZE, 0);
                    break;
                case RIGHT:
                    stoppedBox.move(FIELD_CELL_SIZE, 0);
                    break;
                case UP:
                    stoppedBox.move(0, -FIELD_CELL_SIZE);
                    break;
                case DOWN:
                    stoppedBox.move(0, FIELD_CELL_SIZE);
                    break;
            }
        }

        return false;
    }

    public void checkCompletion() {
        boolean isCompleted = false;

        for (Home home : gameObjects.getHomes()) {
            boolean current = false;

            for (Box box : gameObjects.getBoxes()) {
                if ((box.getX() == home.getX()) && (box.getY() == home.getY())) {
                    current = true;
                }
            }

            if (current) {
                isCompleted = true;
            }
        }

        if (isCompleted) {
            eventListener.levelCompleted(currentLevel);
        }
    }
}
