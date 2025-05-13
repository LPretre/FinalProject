import java.awt.*;

public class Square {

        // Instance Variables
        private int x;              // Starting x
        private int y;              // Starting y
        private int sideLength;         // Length of side of square
        private Color color;


        // Constructors

    public Square(int xIn, int yIn, Color colorIn, int sideLength) {
        x = xIn;
        y = yIn;
        this.sideLength = sideLength;
        color = colorIn;
    }


    // Move the square one cell to the right
    public void shiftXRight(){
        x += sideLength;
    }

    // Move the square one cell to the left
    public void shiftXLeft(){
        x -= sideLength;
    }

    // Draw the square as a blue cell
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, sideLength, sideLength);
    }

    // Move the square one cell up
    public void shiftYUp() {
        y -= sideLength;
    }

    // Move the square one cell down
    public void shiftYDown() {
        y += sideLength;
    }
}
