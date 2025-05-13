import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class KeyListenerGame implements KeyListener, MouseListener {
    public static final int CELL_WIDTH = 15,
            BALL_START_X = 100,
            BALL_START_Y = 100,
            STEP_SIZE = 10;
    // Instance variables
    private Square b;
    private Maze m;
    private MazeRaceView window;
    private MazeCell currentCell;
    private Button easyButton;
    private Button mediumButton;
    private Button hardButton;
    private boolean isPlaying;
    private boolean isWon;

    // Constructors
    public KeyListenerGame() {
        m = new Maze("mazes/mediumMaze.txt", "Medium");
        b = new Square(100 + m.getStartCell().getCol() * m.getSideLength(),
                50 + m.getStartCell().getRow() * m.getSideLength(), Color.BLUE, m.getSideLength());
        easyButton = new Button(400, 200, "Easy", true);
        mediumButton = new Button(400, 400, "Medium", true);
        hardButton = new Button(400, 600, "Hard", true);
        window = new MazeRaceView(b, m, easyButton, mediumButton, hardButton, this);
        currentCell = m.getStartCell();
        isPlaying = false;
        isWon = false;

        // The addKeyListener method attaches to this KeyListener object
        // an object that implements the KeyListener interface (i.e. supplies the keyTyped, keyReleased, and keyPressed methods)
        // By passsing the parameter "this"
        // we are saying that this specific KeyListenerDemo object
        // supplies its own KeyListener functionality (contains the 3 required KeyListener methods).
        window.addKeyListener(this);               // #4 Required for KeyListener
        window.addMouseListener(this);

    }

    // Return true if a button is clicked and the game is not won
    public boolean isPlaying() {
        return isPlaying;
    }

    // Return true if the user reached the end square
    public boolean isWon(){
        return isWon;
    }

    public static void main(String[] args) {
        KeyListenerGame klGame = new KeyListenerGame();
    }

    //////////////////////////////////////////////////////////////
    /*
     * Methods all KeyListeners must supply
     */
    //////////////////////////////////////////////////////////////

    @Override
    public void keyTyped(KeyEvent e) {

    }

    // Used key method, control gameplay
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            // For each arrow key, check the corresponding box that would be moved into
            // Move the user square into that box if it is valid and not the end cell
            // If the intended cell is the end cell, set isWon to true
            case KeyEvent.VK_LEFT:
                if (m.getEndCell().equals(m.getCell(currentCell.getRow(), currentCell.getCol() - 1))){
                    isWon = true;
                    isPlaying = false;
                    window.repaint();
                }
                else if (m.isValidCell(currentCell.getRow(), currentCell.getCol() - 1)) {
                    currentCell = m.getCell(currentCell.getRow(), currentCell.getCol() - 1);
                    b.shiftXLeft();
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (m.getEndCell().equals(m.getCell(currentCell.getRow(), currentCell.getCol() + 1))){
                    isWon = true;
                    isPlaying = false;
                    window.repaint();
                }
                else if (m.isValidCell(currentCell.getRow(), currentCell.getCol() + 1)) {
                    currentCell = m.getCell(currentCell.getRow(), currentCell.getCol() + 1);
                    b.shiftXRight();
                }
                break;
            case KeyEvent.VK_UP:
                if (m.getEndCell().equals(m.getCell(currentCell.getRow() - 1, currentCell.getCol()))){
                    isWon = true;
                    isPlaying = false;
                    window.repaint();
                }
                else if (m.isValidCell(currentCell.getRow() - 1, currentCell.getCol())) {
                    currentCell = m.getCell(currentCell.getRow() - 1, currentCell.getCol());
                    b.shiftYUp();
                }
                break;
            case KeyEvent.VK_DOWN:
                if (m.getEndCell().equals(m.getCell(currentCell.getRow() + 1, currentCell.getCol()))){
                    isWon = true;
                    isPlaying = false;
                    window.repaint();
                }
                else if (m.isValidCell(currentCell.getRow() + 1, currentCell.getCol())) {
                    currentCell = m.getCell(currentCell.getRow() + 1, currentCell.getCol());
                    b.shiftYDown();
                }
                break;
        }
        window.repaint();
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }


    // Mouse mechanics for main menu screen
    @Override
    public void mousePressed(MouseEvent e) {
        // If any button is clicked, set each button's visibility to false and set is playing to true
        // Load in the right maze difficulty for the button and set the front end maze and user square to
        // correspond with the maze difficulty
        if (easyButton.isClicked(e.getX(), e.getY()) && easyButton.isShown()) {
            easyButton.setVisibility(false);
            mediumButton.setVisibility(false);
            hardButton.setVisibility(false);
            isPlaying = true;
            m = new Maze("mazes/easyMaze.txt", "Easy");
            b = new Square(100 + m.getStartCell().getCol() * m.getSideLength(),
                    50 + m.getStartCell().getRow() * m.getSideLength(), Color.BLUE, m.getSideLength());
            window.setMaze(m);
            window.setSquare(b);
            window.repaint();
        }
        else if (mediumButton.isClicked(e.getX(), e.getY()) && easyButton.isShown()) {
            easyButton.setVisibility(false);
            mediumButton.setVisibility(false);
            hardButton.setVisibility(false);
            isPlaying = true;
            m = new Maze("mazes/mediumMaze.txt", "Medium");
            b = new Square(100 + m.getStartCell().getCol() * m.getSideLength(),
                    50 + m.getStartCell().getRow() * m.getSideLength(), Color.BLUE, m.getSideLength());
            window.setMaze(m);
            window.setSquare(b);
            window.repaint();
        }
        else if (hardButton.isClicked(e.getX(), e.getY()) && easyButton.isShown()) {
            easyButton.setVisibility(false);
            mediumButton.setVisibility(false);
            hardButton.setVisibility(false);
            isPlaying = true;
            m = new Maze("mazes/hardMaze.txt", "Hard");
            b = new Square(100 + m.getStartCell().getCol() * m.getSideLength(),
                    50 + m.getStartCell().getRow() * m.getSideLength(), Color.BLUE, m.getSideLength());
            window.setMaze(m);
            window.setSquare(b);
            window.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
