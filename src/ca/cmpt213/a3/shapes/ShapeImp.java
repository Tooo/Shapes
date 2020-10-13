package ca.cmpt213.a3.shapes;

import ca.cmpt213.a3.UI.Canvas;

import java.awt.*;

/**
 * ShapeImp is a abstract class for Shape
 * It holds the common variables and functions needed to create shapes
 */
public abstract class ShapeImp implements Shape {
    private int locationX;
    private int locationY;
    private int width;
    private int height;
    private char borderChar = '*';
    private Color color = Color.blue;

    public ShapeImp(int locationX, int locationY, int width, int height) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.width = width;
        this.height = height;
    }

    public ShapeImp(int locationX, int locationY, int size) {
        this.locationX = locationX;
        this.locationY = locationY;
        width = size*2-1;
        height = size*2-1;
    }

    public ShapeImp(int locationX, int locationY, int width, int height, String message) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.width = width;
        this.height = height;
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setBorderChar(char borderChar) {
        this.borderChar = borderChar;
    }

    public char getBorderChar() {
        return borderChar;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    protected int getWidth() {
        return width;
    }

    protected int getHeight() {
        return height;
    }

    public void draw(Canvas canvas) {
        for (int y = locationY; y < locationY + height; y++) {
            for (int x = locationX; x < locationX + width; x++) {
                if (isBorder(x, y)) {
                    canvas.setCellText(x, y, borderChar);
                    canvas.setCellColor(x, y, color);
                } else if (isInside(x, y)) {
                    canvas.setCellText(x, y, ' ');
                    canvas.setCellColor(x, y, color);
                }
            }
        }
    }

    protected abstract boolean isBorder(int x, int y);

    protected abstract boolean isInside(int x, int y);
}
