package com.javarush.task.task34.task3410.model;

public abstract class CollisionObject extends GameObject {

    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction) {
        switch (direction) {
            case LEFT:
                if (getX() - Model.FIELD_CELL_SIZE == gameObject.getX() && getY() == gameObject.getY()) {
                    return true;
                }
                break;
            case RIGHT:
                if (getX() + Model.FIELD_CELL_SIZE == gameObject.getX() && getY() == gameObject.getY()) {
                    return true;
                }
                break;
            case UP:
                if (getX() == gameObject.getX() && getY() - Model.FIELD_CELL_SIZE == gameObject.getY()) {
                    return true;
                }
                break;
            case DOWN:
                if (getX() == gameObject.getX() && getY() + Model.FIELD_CELL_SIZE == gameObject.getY()) {
                    return true;
                }
                break;
        }

        return false;
    }
}
