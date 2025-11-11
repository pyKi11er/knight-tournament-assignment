public class Board {
    private final int size;
    private Color[][] cells;
    private Knight[][] knights;

    public Board(int size){
        this.size = size;
        this.cells = new Color[size][size];
        this.knights = new Knight[size][size];
    }

    public int getSize(){
        return size;
    }
    public Color getCellColor(int row, int col){
            return cells[row][col];
        }

    public void setCellColor(int row, int col, Color color){
        cells[row][col] = color;
    }

    public Knight getKnight(int row, int col){
        return knights[row][col];
    }

    public void placeKnight(Knight knight, int row, int col){
        knights[row][col] = knight;
        cells[row][col] = knight.getOwner().getColor();
    }

    public void moveKnight(Knight knight, int row, int col){
        int fromRow = knight.getRow();
        int fromCol = knight.getCol();
        
        knights[fromRow][fromCol] = null;
        knights[row][col] = knight;
        
        knight.setPosition(row, col);
        cells[row][col] = knight.getOwner().getColor();
    }


    public boolean hasGreyFields(){
        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                if(cells[i][j]==null){
                    return true;
                }
            }
        }
        return false;
    }

    public Color checkWinner(){
        for(int row = 0; row < size; row++){
            for(int col = 0; col <= size - 4; col++){
                Color first = cells[row][col];
                if(first != null){
                    boolean match = true;
                    for(int k = 1; k < 4; k++){
                        if(cells[row][col + k] != first){
                            match = false;
                            break;
                        }
                    }
                    if(match){
                        return first;
                    }
                }
            }
        }

        for(int col = 0; col < size; col++){
            for(int row = 0; row <= size - 4; row++){
                Color first = cells[row][col];
                if(first != null){
                    boolean match = true;
                    for(int k = 1; k < 4; k++){
                        if(cells[row + k][col] != first){
                            match = false;
                            break;
                        }
                    }
                    if(match){
                        return first;
                    }
                }
            }
        }

        for(int row = 0; row <= size - 4; row++){
            for(int col = 0; col <= size - 4; col++){
                Color first = cells[row][col];
                if(first != null){
                    boolean match = true;
                    for(int k = 1; k < 4; k++){
                        if(cells[row + k][col + k] != first){
                            match = false;
                            break;
                        }
                    }
                    if(match){
                        return first;
                    }
                }
            }
        }

        for(int row = 0; row <= size - 4; row++){
            for(int col = 3; col < size; col++){
                Color first = cells[row][col];
                if(first != null){
                    boolean match = true;
                    for(int k = 1; k < 4; k++){
                        if(cells[row + k][col - k] != first){
                            match = false;
                            break;
                        }
                    }
                    if(match){
                        return first;
                    }
                }
            }
        }

        return null;
    }
}
