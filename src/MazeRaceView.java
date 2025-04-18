import javax.swing.*;
import java.awt.*;

public class MazeRaceView extends JFrame{

    public static int SCREEN_WIDTH = 1000;
    public static int SCREEN_HEIGHT = 800;

    private Square b;

    public MazeRaceView(Square b) {
        this.b = b;

        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setTitle("Key Listener Demo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void paint(Graphics g)
    {
        // Color the entire KeyListenerDemo window white
        // First set the Graphics Color "state" to WHITE
        g.setColor(Color.WHITE);

        // Because g.Color was set to WHITE, the rectangle will be WHITE
        g.fillRect(50,  50, SCREEN_WIDTH, SCREEN_HEIGHT);

        // Now have the ball draw itself on top of the White window.
        b.draw(g);
    }
}
