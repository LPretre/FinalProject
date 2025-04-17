
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
}
