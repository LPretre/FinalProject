import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerGame implements KeyListener {
    public static final int BALL_START_RADIUS = 25,
            BALL_START_X = 100,
            BALL_START_Y = 100,
            STEP_SIZE = 10;
    // Instance variables
    private Square b;
    private MazeRaceView window;

    // Constructors
    public KeyListenerGame() {
        b = new Square(50,50, Color.BLUE);

        window = new MazeRaceView(b);

        // The addKeyListener method attaches to this KeyListener object
        // an object that implements the KeyListener interface (i.e. supplies the keyTyped, keyReleased, and keyPressed methods)
        // By passsing the parameter "this"
        // we are saying that this specific KeyListenerDemo object
        // supplies its own KeyListener functionality (contains the 3 required KeyListener methods).
        window.addKeyListener(this);               // #4 Required for KeyListener
    }

    public static void main(String[] args) {
        KeyListenerGame klDemo = new KeyListenerGame();
    }

    //////////////////////////////////////////////////////////////
    /*
     * Methods all KeyListeners must supply
     */
    //////////////////////////////////////////////////////////////
    @Override
    public void keyTyped(KeyEvent e) {
        // Nothing required for this program.
        // However, as a KeyListener, this class must supply this method
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Nothing required for this program.
        // However, as a KeyListener, this class must supply this method
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // The keyCode lets you know which key was pressed
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
                b.shiftXLeft();
                break;
            case KeyEvent.VK_RIGHT:
                b.shiftXRight();
                break;
            case KeyEvent.VK_UP:
                b.shiftYUp();
                break;
            case KeyEvent.VK_DOWN:
                b.shiftYDown();
                break;
        }
        window.repaint();
    }
}
