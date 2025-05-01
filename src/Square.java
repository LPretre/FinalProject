import java.awt.*;

public class Square {

        // Instance Variables
        private int x;              // Center x
        private int y;              // Center y
        private int dx;             // delta x in one time unit
        private int dy;             // delta y in one time unit
        private int length;         // Radius of the ball
        private Color color;


        // Constructors

    public Square(int xIn, int yIn, Color colorIn) {
        x = xIn;
        y = yIn;

        length = 100;
        color = colorIn;
    }


        public void move() {
        x = x + dx;
        y = y + dy;
    }

    public void shiftXRight(){
        x += 100;
    }
    public void shiftXLeft(){
        x -= 100;
    }


        public boolean bounce(int xLow, int xHigh, int yLow, int yHigh) {
        // Check for an x bounce.  Note that we bounce if the x is too
        //  low or too high AND IS HEADING IN THE WRONG DIRECTION.
        if ((x - length <= xLow && dx < 0) || (x + length >= xHigh && dx > 0)) {
            dx = -dx;
            return true;
        }

        // Now check for a y bounce.
        if ((y - length <= yLow && dy < 0) || (y + length >= yHigh && dy > 0)) {
            dy = -dy;
            return true;
        }
        return false;
    }
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, length, length);
    }

    public void shiftYUp() {
        y -= 100;
    }
    public void shiftYDown() {
        y += 100;
    }
}
