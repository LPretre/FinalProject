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
    private Maze m;
    private MazeRaceView window;
    private MazeCell currentCell;

    // Constructors
    public KeyListenerGame() {
        m = new Maze("mazes/maze1.txt");
        b = new Square(300,600, Color.BLUE);
        window = new MazeRaceView(b, m);
        currentCell = m.getStartCell();

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
//        switch(e.getKeyCode())
//        {
//            case KeyEvent.VK_LEFT:
//                b.shiftXLeft();
//                break;
//            case KeyEvent.VK_RIGHT:
//                b.shiftXRight();
//                break;
//            case KeyEvent.VK_UP:
//                b.shiftYUp();
//                break;
//            case KeyEvent.VK_DOWN:
//                b.shiftYDown();
//                break;
//        }
//        window.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Nothing required for this program.
        // However, as a KeyListener, this class must supply this method
        switch(e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if (m.isValidCell(currentCell.getRow() - 1, currentCell.getCol())) {
                    currentCell = m.getCell(currentCell.getRow() - 1, currentCell.getCol());
                    b.shiftXLeft();
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (m.isValidCell(currentCell.getRow(), currentCell.getCol() + 1)) {
                    currentCell = m.getCell(currentCell.getRow(), currentCell.getCol() + 1);
                    b.shiftXRight();
                }
                break;
            case KeyEvent.VK_UP:
                if (m.isValidCell(currentCell.getRow() + 1, currentCell.getCol())){
                    currentCell = m.getCell(currentCell.getRow() + 1, currentCell.getCol());
                    b.shiftYUp();
                }
                break;
            case KeyEvent.VK_DOWN:
                if (m.isValidCell(currentCell.getRow(), currentCell.getCol() + 1)) {
                    currentCell = m.getCell(currentCell.getRow(), currentCell.getCol() + 1);
                    b.shiftYDown();
                }
                break;
        }
        window.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // The keyCode lets you know which key was pressed
//        switch(e.getKeyCode())
//        {
//            case KeyEvent.VK_LEFT:
//                b.shiftXLeft();
//                break;
//            case KeyEvent.VK_RIGHT:
//                b.shiftXRight();
//                break;
//            case KeyEvent.VK_UP:
//                b.shiftYUp();
//                break;
//            case KeyEvent.VK_DOWN:
//                b.shiftYDown();
//                break;
//        }
//        window.repaint();
    }
}
