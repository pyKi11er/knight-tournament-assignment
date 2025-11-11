import java.util.List;

public class Game {
    private Board board;
    private Player whitePlayer;
    private Player blackPlayer;
    private Player currentPlayer;
    private Knight selectedKnight;

    public Game(int boardSize){
        initGame(boardSize);
    }

    public void initGame(int boardSize){
        board = new Board(boardSize);
        whitePlayer = new Player(Color.WHITE);
        blackPlayer = new Player(Color.BLACK);

        Knight whiteKnight1 = new Knight(0, 0, whitePlayer);
        Knight whiteKnight2 = new Knight(boardSize - 1, boardSize - 1, whitePlayer);
        whitePlayer.addKnight(whiteKnight1);
        whitePlayer.addKnight(whiteKnight2);
        board.placeKnight(whiteKnight1, 0, 0);
        board.placeKnight(whiteKnight2, boardSize - 1, boardSize - 1);

        Knight blackKnight1 = new Knight(0, boardSize - 1, blackPlayer);
        Knight blackKnight2 = new Knight(boardSize - 1, 0, blackPlayer);
        blackPlayer.addKnight(blackKnight1);
        blackPlayer.addKnight(blackKnight2);
        board.placeKnight(blackKnight1, 0, boardSize - 1);
        board.placeKnight(blackKnight2, boardSize - 1, 0);

        currentPlayer = whitePlayer;
        selectedKnight = null;
    }

    public Board getBoard(){
        return board;
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    public Knight getSelectedKnight(){
        return selectedKnight;
    }

    public boolean selectKnight(int row, int col){
        Knight knight = board.getKnight(row, col);
        if(knight != null && knight.getOwner() == currentPlayer){
            selectedKnight = knight;
            return true;
        }
        return false;
    }

    public List<int[]> getPossibleMoves(){
        if(selectedKnight != null){
            return selectedKnight.possibleMoves(board.getSize());
        }
        return null;
    }

    public boolean moveSelectedKnight(int toRow, int toCol){
        if(selectedKnight == null){
            return false;
        }

        List<int[]> possibleMoves = getPossibleMoves();
        if(possibleMoves == null){
            return false;
        }

        for(int[] move : possibleMoves){
            if(move[0] == toRow && move[1] == toCol){
                board.moveKnight(selectedKnight, toRow, toCol);
                selectedKnight = null;
                switchPlayer();
                return true;
            }
        }
        return false;
    }

    private void switchPlayer(){
        currentPlayer = (currentPlayer == whitePlayer) ? blackPlayer : whitePlayer;
    }

    public Color checkGameOver(){
        Color winner = board.checkWinner();
        if(winner != null){
            return winner;
        }
        
        if(!board.hasGreyFields()){
            return null;
        }
        
        return null;
    }

    public boolean isGameEnded(){
        return board.checkWinner() != null || !board.hasGreyFields();
    }
}