
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Maze {
    private MazeCell[][] mazeGrid;
    private MazeCell startCell;
    private MazeCell endCell;
    private int numRows;
    private int numCols;
    private static final int STARTING_X = 300;
    private static final int STARTING_Y = 300;
    private static final int CELL_WIDTH = 100;
    private static final int CELL_HEIGHT = 100;

    public Maze(String filename) {
        createMaze(filename);
    }

    private void createMaze(String filename) {
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);

            // The row and col are specified in the first line of the file
            this.numRows = myReader.nextInt();
            this.numCols = myReader.nextInt();
            myReader.nextLine();

            this.mazeGrid = new MazeCell[this.numRows][this.numCols];

            for (int row=0; row<this.numRows; row++) {
                String line = myReader.nextLine();

                for (int col=0; col<this.numCols; col++) {
                    // Create a new MazeCell for each location
                    this.mazeGrid[row][col] = new MazeCell(row, col);

                    // Set if it is a wall or the start or end cell
                    if (line.charAt(col) == '#') {
                        this.mazeGrid[row][col].setWall(true);
                    } else if (line.charAt(col) == 'A') {
                        this.mazeGrid[row][col].setExplored(true);
                        this.startCell = this.mazeGrid[row][col];
                        mazeGrid[row][col].setStartCell();
                    } else if (line.charAt(col) == 'B') {
                        this.endCell = this.mazeGrid[row][col];
                        mazeGrid[row][col].setEndCell();
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void reset() {
        for (int row=0; row<this.numRows; row++) {
            for (int col=0; col<this.numCols; col++) {
                MazeCell mc = this.mazeGrid[row][col];


                // Set the start cell to be visited
                if (mc != this.startCell) {
                    mc.setExplored(false);
                }
            }
        }
    }


    public MazeCell getStartCell() {
        return this.startCell;
    }

    public MazeCell getEndCell() {
        return this.endCell;
    }

    public MazeCell getCell(int row, int col) {
        return this.mazeGrid[row][col];
    }

    public boolean isValidCell(int row, int col) {
        // As long as the cell is not out of bounds, is not a wall, and has not been explored
        // it is valid
        if(row >= numRows || col >= numCols || row < 0 || col < 0 || mazeGrid[row][col].isExplored() || mazeGrid[row][col].isWall()){
            return false;
        }
        return true;
    }

    public void draw(Graphics g){
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numCols; j++){
                if (this.mazeGrid[i][j].isWall()){
                    g.setColor(Color.BLACK);
                    g.fillRect(STARTING_X + i * CELL_WIDTH, STARTING_Y + j * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT);
                }
                else if (this.mazeGrid[i][j].isStartCell()){
                    g.setColor(Color.GREEN);
                    g.fillRect(STARTING_X + i * CELL_WIDTH, STARTING_Y + j * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT);
                }
                else if (this.mazeGrid[i][j].isEndCell()){
                    g.setColor(Color.RED);
                    g.fillRect(STARTING_X + i * CELL_WIDTH, STARTING_Y + j * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT);
                    }
                }
            }
        }
    }

