
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
    private MazeCell[][] mazeGrid;
    private MazeCell startCell;
    private MazeCell endCell;
    private int numRows;
    private int numCols;
    private String difficulty;
    private static final int STARTING_X = 100;
    private static final int STARTING_Y = 50;
    private int sideLength;

    // Constructor
    public Maze(String filename, String difficulty) {
        // Set cell lengths depending on difficulty
        if (difficulty.equals("Easy")){
            sideLength = 50;
        }
        else if(difficulty.equals("Medium")){
            sideLength = 35;
        }
        else if(difficulty.equals("Hard")){
            sideLength = 20;
        }
        createMaze(filename);
    }

    public int getSideLength(){
        return sideLength;
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


    // More getters and setters

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
        // As long as the cell is not out of bounds, and is not a wall
        // it is valid
        if(row >= numRows || col >= numCols || row < 0 || col < 0 || mazeGrid[row][col].isWall()){
            return false;
        }
        return true;
    }

    public void draw(Graphics g){
        // Draw each maze cell, filling it black if it is a wall, green if it is the start cell, and red if
        // it is the end cell
        // Do not fill in empty cells
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numCols; j++){
                if (this.mazeGrid[i][j].isWall()){
                    g.setColor(Color.BLACK);
                    g.fillRect(STARTING_X + j * sideLength, STARTING_Y + i * sideLength, sideLength, sideLength);
                }
                else if (this.mazeGrid[i][j].isStartCell()){
                    g.setColor(Color.GREEN);
                    g.fillRect(STARTING_X + j * sideLength, STARTING_Y + i * sideLength, sideLength, sideLength);
                }
                else if (this.mazeGrid[i][j].isEndCell()){
                    g.setColor(Color.RED);
                    g.fillRect(STARTING_X + j * sideLength, STARTING_Y + i * sideLength, sideLength, sideLength);
                    }
                }
            }
        }
    }

