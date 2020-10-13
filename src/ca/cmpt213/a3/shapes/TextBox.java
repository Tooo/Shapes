package ca.cmpt213.a3.shapes;

import ca.cmpt213.a3.UI.Canvas;

/**
 * TextBox is a type of Rectangle
 * It can hold a message inside the Rectangle when drawn
 */
public class TextBox extends Rectangle {
    private int textX;
    private int textY;
    private int textWidth;
    private int textHeight;
    private String message;

    public TextBox(int locationX, int locationY, int width, int height, String message) {
        super(locationX, locationY, width, height);
        textX = locationX + 1;
        textY = locationY + 1;
        textWidth = width - 2;
        textHeight = height - 2;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        int bottomY = textY + textHeight - 1;
        int y = textY;
        int totalChar = message.length();
        int letterPosition = 0;
        int lineLength;
        String line;

        // 1 Line text
        if (message.length() <= textWidth) {
            centreText(y, message, canvas);
            return;
        }

        while (letterPosition < totalChar && y <= bottomY) {
            if (y != textY) {
                //Remove leading space
                while (letterPosition < totalChar && message.charAt(letterPosition) == ' ') {
                    letterPosition++;
                }
                if (letterPosition >= totalChar) {
                    return;
                }
            }

            lineLength = getLineLength(letterPosition, totalChar);

            // Breaking line on space
            while (lineLength != 0 && letterPosition + lineLength < totalChar &&
                    message.charAt(letterPosition+lineLength-1) != ' '
                    && message.charAt(letterPosition+lineLength) != ' ') {
                lineLength--;
            }

            // Breaking line on word
            if (lineLength == 0) {
                lineLength = getLineLength(letterPosition, totalChar);
            }

            line = message.substring(letterPosition, letterPosition+lineLength);

            centreText(y, line, canvas);
            letterPosition += lineLength;
            y++;
        }

    }

    private int getLineLength(int letterPosition, int totalChar) {
        int lineLength = textWidth;
        if (letterPosition + lineLength > totalChar) {
            lineLength = totalChar - letterPosition;
        }
        return lineLength;
    }

    private void centreText(int y, String line, Canvas canvas) {
        line = line.stripTrailing();
        int x = textX + (textWidth-line.length()+1)/2;
        for (int i = 0; i < line.length(); i++) {
            canvas.setCellText(x, y, line.charAt(i));
            x++;
        }
    }

}
