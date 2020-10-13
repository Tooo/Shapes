package ca.cmpt213.a3.shapes;

/**
 * Rhombus is a type of Shape
 * It used to draw a Rhombus, from the top-left corner of the coordinates
 */
public class Rhombus extends ShapeImp {
    private int leftX;
    private int topY;
    private int size;

    public Rhombus(int locationX, int locationY, int size) {
        super(locationX, locationY, size);
        leftX = locationX;
        topY = locationY;
        this.size = size;
    }

    @Override
    protected boolean isBorder(int x, int y) {
        if (x == leftX + size - 1 - (topY - y)) {
            return true;
        }

        if (x == leftX + size - 1 + (topY - y)) {
            return true;
        }

        if (x == leftX - size + 1 - (topY - y)) {
            return true;
        }

        if (x == leftX + 3*size - 3 + (topY - y)) {
            return true;
        }

        return false;
    }

    @Override
    protected boolean isInside(int x, int y) {
        if (x >= leftX + size - 1 - (topY - y)) {
            return false;
        }

        if (x <= leftX + size - 1 + (topY - y)) {
            return false;
        }

        if (x <= leftX - size + 1 - (topY - y)) {
            return false;
        }

        if (x >= leftX + 3*size - 3 + (topY - y)) {
            return false;
        }

        return true;
    }
}
