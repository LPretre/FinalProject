public class MazeCell {
    private boolean isWall;
    private int row;
    private int col;
    private boolean isStartCell;
    private boolean isEndCell;

    // Constructor
    public MazeCell(int row, int col) {
        this.row = row;
        this.col = col;
        this.isWall = false;
    }

    /** Getters and Setters **/

    public boolean isWall() {
        return this.isWall;
    }

    public boolean isStartCell() {return this.isStartCell;}

    public boolean isEndCell() {return this.isEndCell;}


    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }


    public void setWall(boolean wall) {
        this.isWall = wall;
    }
    public void setStartCell(){
        this.isStartCell = true;
    }
    public void setEndCell(){
        this.isEndCell = true;
    }
}