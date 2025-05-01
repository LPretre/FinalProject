public class MazeCell {
    private boolean explored;
    private boolean isWall;
    private int row;
    private int col;
    private boolean isStartCell;
    private boolean isEndCell;

    public MazeCell(int row, int col) {
        this.row = row;
        this.col = col;
        this.isWall = false;
        this.explored = false;
    }

    /** Getters and Setters **/
    public boolean isExplored() {
        return this.explored;
    }

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

    public void setExplored(boolean explored) {
        this.explored = explored;
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