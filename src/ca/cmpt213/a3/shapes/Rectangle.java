package ca.cmpt213.a3.shapes;

/**
 * Rectangle is a type of Shape
 * It used to draw a Rectangle, from the top-left corner of the coordinates
 */
public class Rectangle extends ShapeImp {
    private int leftX;
    private int rightX;
    private int topY;
    private int bottomY;

    public Rectangle(int locationX, int locationY, int width, int height) {
        super(locationX, locationY, width, height);
        leftX = locationX;
        rightX = locationX + width - 1;
        topY = locationY;
        bottomY = locationY + height - 1;
    }

    @Override
    protected boolean isBorder(int x, int y) {
        if (x == leftX || x == rightX) {
            return true;
        }

        if (y == topY || y == bottomY) {
            return true;
        }

        return false;
    }

    @Override
    protected boolean isInside(int x, int y) {
        if (x > leftX && x < rightX) {
            return true;
        }

        if (y > topY && y < bottomY) {
            return true;
        }

        return false;
    }
}
