import java.util.List;
import java.util.ArrayList;

public class Knight {
    private int row;
    private int col;
    private Player player;

    public Knight(int row, int col, Player player){
        this.row = row;
        this.col = col;
        this.player = player;
    }

    public int getRow() { 
        return row; 
    }

    public int getCol() { 
        return col; 
    }

    public Player getOwner() { 
        return player; 
    }

    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    public List<int[]> possibleMoves(int boardSize){
        int[][] diff = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
        List<int[]> moves = new ArrayList<>();
        for(int[] d : diff){
            int newRow = this.row + d[0];
            int newCol = this.col + d[1];
            if(newRow >= 0 && newRow < boardSize && newCol>=0 && newCol < boardSize){
                moves.add(new int[] {newRow, newCol});
            }
        }

        return moves;
    }
}
