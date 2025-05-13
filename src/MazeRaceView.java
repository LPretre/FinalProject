import javax.swing.*;
import java.awt.*;

public class MazeRaceView extends JFrame {

    public static int SCREEN_WIDTH = 1000;
    public static int SCREEN_HEIGHT = 800 ;

    private Button easy;
    private Button medium;
    private Button hard;
    private Square b;
    private Maze m;
    private KeyListenerGame k;

    //Constructor
    public MazeRaceView(Square b, Maze m, Button easy, Button medium, Button hard, KeyListenerGame k) {
        this.b = b;
        this.m = m;
        this.easy = easy;
        this.medium = medium;
        this.hard = hard;
        this.k = k;
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setTitle("Key Listener Demo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    // Set specific maze
    public void setMaze(Maze m){
        this.m = m;
    }

    // Set user square
    public void setSquare(Square b){
        this.b = b;
    }

    // Displays victory screen
    public void drawVictoryScreen(Graphics g){
        g.setColor(Color.GREEN);
        g.setFont(new Font("Arial", Font.BOLD, 100));
        g.drawString("You win!", 300, 300);
    }

    public void paint(Graphics g) {
        // Color the entire KeyListenerDemo window white
        // First set the Graphics Color "state" to WHITE
        g.setColor(Color.WHITE);


        // Because g.Color was set to WHITE, the rectangle will be WHITE
        g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        // After a button is clicked display the right maze and user square
        if (k.isPlaying()) {
            m.draw(g);
            b.draw(g);
        }
        // If the game is won display the victory screen
        else if(k.isWon()){
            drawVictoryScreen(g);
        }
        // Otherwise draw the buttons
        else {
            easy.draw(g);

            medium.draw(g);

            hard.draw(g);
        }
        }
}
