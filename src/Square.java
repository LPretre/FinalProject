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



    public void shiftXRight(){
        x += sideLength;
    }
    public void shiftXLeft(){
        x -= sideLength;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, sideLength, sideLength);
    }

    public void shiftYUp() {
        y -= sideLength;
    }
    public void shiftYDown() {
        y += sideLength;
    }
}
