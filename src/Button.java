import java.awt.*;

public class Button {

    private int x;
    private int y;
    public static final int WIDTH = 200;
    public static final int HEIGHT = 100;
    private String text;
    private boolean isShown;

    // Constructor
    public Button(int x, int y, String text, boolean isShown) {
        this.x = x;
        this.y = y;
        this.text = text;
        this.isShown = isShown;
    }

    // If the user clicks within the boundaries of the button rectangle return true
    public boolean isClicked(int mouseX, int mouseY) {
        return (mouseX >= x && mouseX <= x + WIDTH) && (mouseY >= y && mouseY <= y + HEIGHT);
    }

    // Set whether the button can be seen
    public void setVisibility(Boolean isShown){
        this.isShown = isShown;
    }

    // Return whether the button is showing or not
    public boolean isShown(){
        return isShown;
    }

    // Draw the button
    public void draw(Graphics g) {
            g.setColor(Color.GRAY);
            g.fillRect(x, y, WIDTH, HEIGHT);
            g.setColor(Color.BLACK);
            g.setFont(new Font("ARIAL", Font.BOLD, 50));
            g.drawString(text, x + 10, y + 60);
    }
}
