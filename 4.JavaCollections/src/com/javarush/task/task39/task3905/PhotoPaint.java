package com.javarush.task.task39.task3905;

public class PhotoPaint {

    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        if (y < 0 || x < 0 || y >= image.length || x >= image[0].length) {
            return false;
        }

        if (image[y][x] == desiredColor) {
            return false;
        }

        Color color = image[y][x];

        fill(image, x, y, desiredColor, color);

        return true;
    }

    private void fill(Color[][] image, int x, int y, Color desiredColor, Color currentColor) {
        if (y < 0 || x < 0 || y >= image.length || x >= image[0].length) {
            return;
        }

        if (image[y][x] != currentColor) {
            return;
        } else {
            image[y][x] = desiredColor;
        }

        fill(image, x - 1, y, desiredColor, currentColor);
        fill(image, x + 1, y, desiredColor, currentColor);
        fill(image, x, y - 1, desiredColor, currentColor);
        fill(image, x, y + 1, desiredColor, currentColor);
    }
}
