package ca.cmpt213.a3.shapes;

import ca.cmpt213.a3.UI.Canvas;

import java.awt.*;

/**
 * Shape is a interface for ShapeImp
 */
public interface Shape {
    int getLocationX();
    int getLocationY();

    void setBorderChar(char character);
    char getBorderChar();

    void setColor(Color color);
    Color getColor();

    void draw(Canvas canvas);
}
